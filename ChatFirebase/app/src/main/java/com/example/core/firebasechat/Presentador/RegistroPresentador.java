<<<<<<< HEAD
package com.example.core.firebasechat.Presentador;

import android.content.Intent;
import android.os.Bundle;

import com.example.core.firebasechat.Modelo.RegistroModelo;
import com.example.core.firebasechat.Vista.RegistroActivity;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Clase RegistroPresentador para registrar usuarios
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class RegistroPresentador {
    RegistroActivity registroActivity;

    RegistroModelo registroModelo;

    /**
     * Metodo constructor
     * @param registroActivity inicializa la actividad de registro
     * @param fotoPerfil componente de la foto del usuario
     */
    public RegistroPresentador(RegistroActivity registroActivity, CircleImageView fotoPerfil){
        this.registroActivity=registroActivity;
        registroModelo=new RegistroModelo(this,this.registroActivity,fotoPerfil);
    }

    /**
     * Metodo que se comunica con el modelo para registar
     * @param correo del usuario
     * @param contraseña del usuario
     * @param contraseñaRepetida del usuario para verificar
     * @param nombre el nombre del usuario
     * @param mAuth al autenticacion de firebase
     */
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

    /** Envia la imagen seleccionada*/
    public void submitImagePicker(Intent data){
        registroModelo.submitImagePicker(data);
    }

    /** Envia la imagen de la camara seleccionada*/
    public void submitCamaraPicker(Intent data){
        registroModelo.submitCamaraPicker(data);
    }

    /** Almacena la imagen seleccionada*/
    public void onSaveInstanceState(Bundle outState) {
       registroModelo.onSaveInstanceState(outState);
    }

    /** Restaura la imagen */
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        registroModelo.onRestoreInstanceState(savedInstanceState);
    }
}
=======
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
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
