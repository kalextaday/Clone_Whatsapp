package com.example.core.firebasechat.Modelo.Entidades.Logica;

import com.example.core.firebasechat.Modelo.Entidades.Firebase.Usuario;

<<<<<<< HEAD
/**
 * Clase LUsuario
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
public class LUsuario {

    private String id;
    private Usuario usuario;

    public LUsuario(String id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
