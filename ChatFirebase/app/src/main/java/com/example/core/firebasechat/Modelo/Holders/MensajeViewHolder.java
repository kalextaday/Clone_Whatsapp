package com.example.core.firebasechat.Modelo.Holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import com.example.core.firebasechat.R;

<<<<<<< HEAD
/**
 * Clase MensajeViewHolder para manejar los componentes
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
public class MensajeViewHolder extends RecyclerView.ViewHolder {

    private TextView mensaje;
    private TextView hora;
    private CircleImageView fotoMensajePerfil;
    private ImageView fotoMensaje;

<<<<<<< HEAD
    /**
     * Metodo contructor
     * @param itemView
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public MensajeViewHolder(View itemView) {
        super(itemView);
        mensaje =itemView.findViewById(R.id.mensajeMensaje);
        hora = itemView.findViewById(R.id.horaMensaje);
        fotoMensajePerfil =  itemView.findViewById(R.id.fotoPerfilMensaje);
        fotoMensaje =itemView.findViewById(R.id.mensajeFoto);
    }

<<<<<<< HEAD
    /**
     * Metodo para regresar el mensaje al recyclerview
     * @return TextView
     */
=======

>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public TextView getMensaje() {
        return mensaje;
    }

<<<<<<< HEAD
    /**
     * Metodo modificar el mensaje en el recycler view
     * @param mensaje
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public void setMensaje(TextView mensaje) {
        this.mensaje = mensaje;
    }

    public TextView getHora() {
        return hora;
    }

    public void setHora(TextView hora) {
        this.hora = hora;
    }

    public CircleImageView getFotoMensajePerfil() {
        return fotoMensajePerfil;
    }

    public void setFotoMensajePerfil(CircleImageView fotoMensajePerfil) {
        this.fotoMensajePerfil = fotoMensajePerfil;
    }

    public ImageView getFotoMensaje() {
        return fotoMensaje;
    }

    public void setFotoMensaje(ImageView fotoMensaje) {
        this.fotoMensaje = fotoMensaje;
    }
}
