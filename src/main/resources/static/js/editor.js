require.config({
    paths: { vs: 'https://cdn.jsdelivr.net/npm/monaco-editor@0.44.0/min/vs' }
});

var editors = {};

require(['vs/editor/editor.main'], function () {

    document.querySelectorAll('.monaco-container').forEach(function (container) {
        var idx   = container.id.replace('editor-', '');
        var srcEl = document.getElementById('code-src-' + idx);
        var code  = srcEl ? srcEl.value.trim() : '';

        editors[idx] = monaco.editor.create(container, {
            value:                code,
            language:             'java',
            theme:                'vs-dark',
            fontSize:             14,
            fontFamily:           "'Cascadia Code', 'Fira Code', Consolas, monospace",
            minimap:              { enabled: false },
            scrollBeyondLastLine: false,
            lineNumbers:          'on',
            automaticLayout:      true,
            padding:              { top: 12, bottom: 12 },
            renderLineHighlight:  'line',
            smoothScrolling:      true
        });
    });

    document.querySelectorAll('.btn-run').forEach(function (btn) {
        btn.addEventListener('click', function () {
            var idx        = btn.getAttribute('data-idx');
            var editor     = editors[idx];
            var outputArea = document.getElementById('output-' + idx);
            if (!editor || !outputArea) return;

            btn.disabled    = true;
            btn.textContent = '⟳ Compilando...';
            outputArea.innerHTML = '<span class="output-placeholder">Compilando y ejecutando...</span>';

            fetch('/api/run', {
                method:  'POST',
                headers: { 'Content-Type': 'application/json' },
                body:    JSON.stringify({ code: editor.getValue() })
            })
            .then(function (r) { return r.json(); })
            .then(function (data) {
                if (data.error) {
                    outputArea.innerHTML = '<span class="output-error">' + esc(data.error) + '</span>';
                    return;
                }
                var salida = (data.stdout || '').trim();
                var error  = (data.stderr  || '').trim();

                if (salida) {
                    outputArea.innerHTML = '<span class="output-success">' + esc(salida) + '</span>';
                    if (error) {
                        outputArea.innerHTML += '<br><span class="output-error">' + esc(error) + '</span>';
                    }
                } else if (error) {
                    outputArea.innerHTML = '<span class="output-error">' + esc(error) + '</span>';
                } else {
                    outputArea.innerHTML = '<span class="output-placeholder">El programa no produjo salida.</span>';
                }
            })
            .catch(function (err) {
                outputArea.innerHTML = '<span class="output-error">Error de conexión: ' + esc(err.message) + '</span>';
            })
            .finally(function () {
                btn.disabled  = false;
                btn.innerHTML = '&#9654; Ejecutar';
            });
        });
    });
});

function esc(str) {
    return String(str)
        .replace(/&/g, '&amp;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;')
        .replace(/\n/g, '<br>');
}
