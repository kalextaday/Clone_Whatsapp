package com.example.core.firebasechat.Modelo.Entidades.Firebase;

/**
 * Clase Usuario
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class Usuario {

    private String fotoPerfilURL;
    private String nombre;
    private String correo;

    public Usuario() {
    }

    public String getFotoPerfilURL() {
        return fotoPerfilURL;
    }

    public void setFotoPerfilURL(String fotoPerfilURL) {
        this.fotoPerfilURL = fotoPerfilURL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
