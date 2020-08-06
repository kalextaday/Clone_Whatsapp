package com.example.core.firebasechat.Modelo.Holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import de.hdodenhof.circleimageview.CircleImageView;
import com.example.core.firebasechat.R;

/**
 * Clase MensajeViewHolder para manejar los componentes
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class MensajeViewHolder extends RecyclerView.ViewHolder {

    private TextView mensaje;
    private TextView hora;
    private CircleImageView fotoMensajePerfil;
    private ImageView fotoMensaje;

    /**
     * Metodo contructor
     * @param itemView
     */
    public MensajeViewHolder(View itemView) {
        super(itemView);
        mensaje =itemView.findViewById(R.id.mensajeMensaje);
        hora = itemView.findViewById(R.id.horaMensaje);
        fotoMensajePerfil =  itemView.findViewById(R.id.fotoPerfilMensaje);
        fotoMensaje =itemView.findViewById(R.id.mensajeFoto);
    }

    /**
     * Metodo para regresar el mensaje al recyclerview
     * @return TextView
     */
    public TextView getMensaje() {
        return mensaje;
    }

    /**
     * Metodo modificar el mensaje en el recycler view
     * @param mensaje
     */
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
