package com.zeglius.formulario_aplicacion.model;

public class Dni {
    //<editor-fold desc="En constructor">
    private String apellido;
    private String apellido2;
    private String nombre;
    private String sexo;
    private String fechaNaci;
    //</editor-fold>

    //<editor-fold desc="Generados en runtime">
    private String validoFech;
    private String numDni;
    //</editor-fold>


    public String getValidoFech() {
        return validoFech;
    }

    public void setValidoFech(String validoFech) {
        this.validoFech = validoFech;
    }

    public String getNumDni() {
        return numDni;
    }

    public void setNumDni(String numDni) {
        this.numDni = numDni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(String fechaNaci) {
        this.fechaNaci = fechaNaci;
    }


}
