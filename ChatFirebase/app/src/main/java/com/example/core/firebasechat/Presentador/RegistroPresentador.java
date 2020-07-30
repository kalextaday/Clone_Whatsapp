package com.example.core.firebasechat.Presentador;

import android.content.Intent;
import android.os.Bundle;

import com.example.core.firebasechat.Modelo.RegistroModelo;
import com.example.core.firebasechat.Vista.RegistroActivity;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegistroPresentador {
    RegistroActivity registroActivity;

    RegistroModelo registroModelo;

    public RegistroPresentador(RegistroActivity registroActivity, CircleImageView fotoPerfil){
        this.registroActivity=registroActivity;
        registroModelo=new RegistroModelo(this,this.registroActivity,fotoPerfil);
    }

    public void registrarUsuario(String correo, String contraseña, String contraseñaRepetida,
                                 String nombre, FirebaseAuth mAuth){
        registroModelo.registrarUsuario(correo,contraseña,contraseñaRepetida,nombre,mAuth,
                registroActivity);
    }

    public void seleccionarFoto(){
        registroModelo.seleccionarFoto(registroActivity);
    }

    /** Muestra el mensaje "Revise campos del registro" */
    public void mostrarMensajeRevisarCampos() {
        registroActivity.mostrarMensajeRevisarCampos();
    }

    /** Muestra el mensaje "Error al registrarse" */
    public void mostrarMensajeError() {
        registroActivity.mostrarMensajeError();
    }

    public void submitImagePicker(Intent data){
        registroModelo.submitImagePicker(data);
    }

    public void submitCamaraPicker(Intent data){
        registroModelo.submitCamaraPicker(data);
    }

    public void onSaveInstanceState(Bundle outState) {
       registroModelo.onSaveInstanceState(outState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        registroModelo.onRestoreInstanceState(savedInstanceState);
    }
}
