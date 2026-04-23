package com.javaeducativo.model;

import java.util.List;

public class JavaLesson {

    private final String id;
    private final String modulo;
    private final String title;
    private final String description;
    private final String code;
    private final String output;
    private final String notaAvanzada;
    private final List<String> recursos;
    private final List<Exercise> ejercicios;

    public JavaLesson(String id, String modulo, String title, String description,
                      String code, String output, String notaAvanzada,
                      List<String> recursos, List<Exercise> ejercicios) {
        this.id = id;
        this.modulo = modulo;
        this.title = title;
        this.description = description;
        this.code = code;
        this.output = output;
        this.notaAvanzada = notaAvanzada;
        this.recursos = recursos;
        this.ejercicios = ejercicios;
    }

    public String getId()            { return id; }
    public String getModulo()        { return modulo; }
    public String getTitle()         { return title; }
    public String getDescription()   { return description; }
    public String getCode()          { return code; }
    public String getOutput()        { return output; }
    public String getNotaAvanzada()  { return notaAvanzada; }
    public List<String> getRecursos(){ return recursos; }
    public List<Exercise> getEjercicios() { return ejercicios; }
}
