package com.example.core.firebasechat.Presentador;

import android.net.Uri;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.example.core.firebasechat.Modelo.MensajesModelo;
import com.example.core.firebasechat.Vista.MensajesActivity;

public class MensajesPresentador {

    MensajesActivity mensajesActivity;

    MensajesModelo mensajesModelo;

    RecyclerView rvMensajes;

    public MensajesPresentador(MensajesActivity mensajesActivity, RecyclerView rvMensajes,
                               String idReceptor){
        this.mensajesActivity = mensajesActivity;
        mensajesModelo =new MensajesModelo(this,rvMensajes,this.mensajesActivity,
                idReceptor);
        this.rvMensajes=rvMensajes;
    }

    public void enviarMensaje(EditText txtMensaje,String idReceptor){
        mensajesModelo.enviarMensaje(txtMensaje,idReceptor);
    }

    public void llamarActividadEnviarFoto(MensajesActivity mensajesActivity, int enviarFoto){
        mensajesModelo.llamarActividadEnviarFoto(mensajesActivity,enviarFoto);
    }

    public void enviarFoto(Uri u, String idReceptor){
        mensajesModelo.enviarFoto(u,idReceptor);
    }
}
