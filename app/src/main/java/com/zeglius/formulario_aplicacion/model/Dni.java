package com.zeglius.formulario_aplicacion.model;

import com.zeglius.formulario_aplicacion.utils.Utils;

import java.io.Serializable;

/**
 * @noinspection unused
 */
public class Dni implements Serializable {
    //<editor-fold desc="En constructor">
    private String apellido;
    private String apellido2;
    private String nombre;
    private String sexo;
    private String fechaNaci;
    //</editor-fold>

    //<editor-fold desc="Generados en runtime">
    private String validoFech;
    private String desp;
    private String dniNumero;
    //</editor-fold>

    public Dni(String apellido, String apellido2, String nombre, String sexo, String fechaNaci) {
        this.apellido = apellido;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNaci = fechaNaci;
        this.dniNumero = randomDniNumber();
        this.desp = randomDniDesp();
        this.validoFech = fechaNaci;
    }


    public Dni(Dni dni) {
        this.apellido = dni.apellido;
        this.apellido2 = dni.apellido2;
        this.nombre = dni.nombre;
        this.sexo = dni.sexo;
        this.fechaNaci = dni.fechaNaci;
        this.dniNumero = randomDniNumber();
        this.desp = randomDniDesp();
        this.validoFech = dni.validoFech;
    }

    public static String randomDniNumber() {
        return String.join("", Utils.randomChoice(Utils.abcStrings(), 8));
    }

    public static String randomDniDesp() {
        return String.join("", Utils.randomChoice(Utils.abcStrings(), 8));
    }

    @Override
    public String toString() {
        return "Dni{" +
                "apellido='" + apellido + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", nombre='" + nombre + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fechaNaci='" + fechaNaci + '\'' +
                ", validoFech='" + validoFech + '\'' +
                ", desp='" + desp + '\'' +
                ", dniNumero='" + dniNumero + '\'' +
                '}';
    }

    public String getValidoFech() {
        return validoFech;
    }

    public String getDesp() {
        return desp;
    }

    public void setValidoFech(String validoFech) {
        this.validoFech = validoFech;
    }

    public String getDniNumero() {
        return dniNumero;
    }

    public void setDniNumero(String dniNumero) {
        this.dniNumero = dniNumero;
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


    public void setDesp(String desp) {
        this.desp = desp;
    }
}
