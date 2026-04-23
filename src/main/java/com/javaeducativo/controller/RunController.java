package com.javaeducativo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class RunController {

    @PostMapping("/run")
    public ResponseEntity<Map<String, String>> run(@RequestBody Map<String, String> body) {
        String code = body.getOrDefault("code", "").trim();
        if (code.isEmpty()) {
            return ResponseEntity.badRequest()
                .body(Map.of("error", "El código está vacío."));
        }

        String safeCode = renameToMain(code);
        Path tempDir = null;

        try {
            tempDir = Files.createTempDirectory("jrun-");
            Path sourceFile = tempDir.resolve("Main.java");
            Files.writeString(sourceFile, safeCode, StandardCharsets.UTF_8);

            // Compilar
            ProcessBuilder cpb = new ProcessBuilder(
                javaExe("javac"), "-encoding", "UTF-8", "Main.java"
            );
            cpb.directory(tempDir.toFile());
            cpb.redirectErrorStream(true);

            Process cp = cpb.start();
            String compileOut = readStream(cp.getInputStream());
            boolean compiled = cp.waitFor(15, TimeUnit.SECONDS) && cp.exitValue() == 0;

            if (!compiled) {
                String msg = compileOut.replace(tempDir.toString() + File.separator, "");
                return ResponseEntity.ok(Map.of("error", msg.isEmpty() ? "Error de compilación." : msg));
            }

            // Ejecutar forzando UTF-8
            ProcessBuilder rpb = new ProcessBuilder(
                javaExe("java"),
                "-Dfile.encoding=UTF-8",
                "-Dstdout.encoding=UTF-8",
                "-Dstderr.encoding=UTF-8",
                "-cp", ".", "Main"
            );
            rpb.directory(tempDir.toFile());

            Process rp = rpb.start();
            String stdout = readStream(rp.getInputStream());
            String stderr  = readStream(rp.getErrorStream());

            if (!rp.waitFor(10, TimeUnit.SECONDS)) {
                rp.destroyForcibly();
                return ResponseEntity.ok(Map.of("error", "Tiempo agotado (10s)."));
            }

            return ResponseEntity.ok(Map.of("stdout", stdout, "stderr", stderr));

        } catch (Exception e) {
            return ResponseEntity.ok(Map.of("error", "Error interno: " + e.getMessage()));
        } finally {
            deleteDir(tempDir);
        }
    }

    /**
     * Renombra la clase pública y TODAS sus referencias (constructor incluido) a "Main".
     * Sin esto, "public class Persona" se renombra a Main pero el constructor
     * "public Persona(...)" queda mal y javac lanza "return type required".
     */
    private String renameToMain(String code) {
        // 1. Encontrar el nombre de la clase pública
        Pattern classPattern = Pattern.compile(
            "public\\s+class\\s+([\\p{L}\\p{N}_]+)"
        );
        Matcher m = classPattern.matcher(code);
        if (!m.find()) return code;

        String originalName = m.group(1);
        if (originalName.equals("Main")) return code;

        // 2. Reemplazar TODAS las apariciones del nombre como token completo
        //    \\b no funciona con Unicode, usamos lookahead/lookbehind de no-palabra
        String safePattern = "(?<![\\p{L}\\p{N}_])"
            + Pattern.quote(originalName)
            + "(?![\\p{L}\\p{N}_])";

        return code.replaceAll(safePattern, "Main");
    }

    private String javaExe(String tool) {
        String home = System.getProperty("java.home");
        return (home != null && !home.isBlank())
            ? home + File.separator + "bin" + File.separator + tool
            : tool;
    }

    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader r = new BufferedReader(
                new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String line;
            int n = 0;
            while ((line = r.readLine()) != null && n++ < 200) sb.append(line).append("\n");
        }
        return sb.toString().trim();
    }

    private void deleteDir(Path dir) {
        if (dir == null) return;
        try {
            Files.walk(dir)
                .sorted(java.util.Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        } catch (IOException ignored) {}
    }
}
