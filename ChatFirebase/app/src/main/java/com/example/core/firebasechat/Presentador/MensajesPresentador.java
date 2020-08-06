<<<<<<< HEAD
package com.example.core.firebasechat.Presentador;

import android.net.Uri;
import android.widget.EditText;

import androidx.recyclerview.widget.RecyclerView;

import com.example.core.firebasechat.Modelo.MensajesModelo;
import com.example.core.firebasechat.Vista.MensajesActivity;

/**
 * Clase MensajesPresentador para mostrar los mensajes
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class MensajesPresentador {

    MensajesActivity mensajesActivity;

    MensajesModelo mensajesModelo;

    RecyclerView rvMensajes;

    /**
     * Método constructor
     * @param mensajesActivity es la actividad para mostrar los mensajes
     * @param rvMensajes el componente recycler view para mostrar los mensajes
     * @param idReceptor el id del receptor del mensaje
     */
    public MensajesPresentador(MensajesActivity mensajesActivity, RecyclerView rvMensajes,
                               String idReceptor){
        this.mensajesActivity = mensajesActivity;
        mensajesModelo =new MensajesModelo(this,rvMensajes,this.mensajesActivity,
                idReceptor);
        this.rvMensajes=rvMensajes;
    }

    /**
     * Metodo para enviar un mensaje
     * @param txtMensaje
     * @param idReceptor
     */
    public void enviarMensaje(EditText txtMensaje,String idReceptor){
        mensajesModelo.enviarMensaje(txtMensaje,idReceptor);
    }

    /**
     * Metodo para llamar a la actividad que envia imagenes
     * @param mensajesActivity la actividad de mensajes
     * @param enviarFoto el id de la imagen
     */
    public void llamarActividadEnviarFoto(MensajesActivity mensajesActivity, int enviarFoto){
        mensajesModelo.llamarActividadEnviarFoto(mensajesActivity,enviarFoto);
    }

    /**
     * Metodo para enviar una imagen
     * @param u la direccion de la imagen
     * @param idReceptor el id del receptor de la imagen
     */
    public void enviarFoto(Uri u, String idReceptor){
        mensajesModelo.enviarFoto(u,idReceptor);
    }
}
=======
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
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
