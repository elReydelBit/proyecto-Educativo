package com.javaeducativo.model;

public class Exercise {

    public enum Nivel { LEER, MODIFICAR, ESCRIBIR }

    private final Nivel nivel;
    private final String instruccion;
    private final String codigoBase;
    private final String salidaEsperada;
    private final String pista;

    public Exercise(Nivel nivel, String instruccion, String codigoBase,
                    String salidaEsperada, String pista) {
        this.nivel = nivel;
        this.instruccion = instruccion;
        this.codigoBase = codigoBase;
        this.salidaEsperada = salidaEsperada;
        this.pista = pista;
    }

    public Nivel getNivel() { return nivel; }
    public String getNivelLabel() {
        return switch (nivel) {
            case LEER     -> "Nivel 1 — Lee y predice";
            case MODIFICAR -> "Nivel 2 — Modifica";
            case ESCRIBIR  -> "Nivel 3 — Escribe desde cero";
        };
    }
    public String getNivelCss() {
        return switch (nivel) {
            case LEER     -> "ejercicio-leer";
            case MODIFICAR -> "ejercicio-modificar";
            case ESCRIBIR  -> "ejercicio-escribir";
        };
    }
    public String getInstruccion()   { return instruccion; }
    public String getCodigoBase()    { return codigoBase; }
    public String getSalidaEsperada(){ return salidaEsperada; }
    public String getPista()         { return pista; }
}
