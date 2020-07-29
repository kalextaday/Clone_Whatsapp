package com.example.core.firebasechat.Modelo.Entidades.Firebase;

import com.google.firebase.database.ServerValue;

/**
 * Created by user on 04/09/2017. 04
 */

public class Mensaje {

    private String mensaje;
    private String urlFoto;
    private String idEmisor;
    private Object fechaCreacion;

    public Mensaje() {
        fechaCreacion = ServerValue.TIMESTAMP;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(String idEmisor) {
        this.idEmisor = idEmisor;
    }

    public Object getFechaCreacion() {
        return fechaCreacion;
    }
}
