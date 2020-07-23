package com.example.core.firebasechat.Modelo.Entidades.Logica;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.core.firebasechat.Modelo.Entidades.Firebase.Usuario;
import com.example.core.firebasechat.Presentador.Persistencia.UsuarioDAO;

/**
 * Created by user on 28/08/2018. 28
 */
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
