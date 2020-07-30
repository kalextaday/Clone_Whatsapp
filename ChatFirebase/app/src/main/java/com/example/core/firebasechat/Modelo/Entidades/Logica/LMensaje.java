package com.example.core.firebasechat.Modelo.Entidades.Logica;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;
import java.util.Locale;

import com.example.core.firebasechat.Modelo.Entidades.Firebase.Mensaje;

public class LMensaje {

    private String id;
    private Mensaje mensaje;
    private LUsuario lUsuario;

    public LMensaje(String id, Mensaje mensaje) {
        this.id = id;
        this.mensaje = mensaje;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    public long getCreatedTimestampLong(){
        return (long) mensaje.getFechaCreacion();
    }

    public LUsuario getlUsuario() {
        return lUsuario;
    }

    public void setlUsuario(LUsuario lUsuario) {
        this.lUsuario = lUsuario;
    }

    public String fechaDeCreacionDelMensaje(){
        Date date = new Date(getCreatedTimestampLong());
        PrettyTime prettyTime = new PrettyTime(new Date(),Locale.getDefault());
        return prettyTime.format(date);
    }

}
