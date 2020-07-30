package com.example.core.firebasechat.Presentador;

import com.example.core.firebasechat.Modelo.InicioSesionModelo;
import com.example.core.firebasechat.Vista.InicioSesionActivity;
import com.google.firebase.auth.FirebaseAuth;

public class InicioSesionPresentador {

    InicioSesionActivity inicioSesionActivity;

    InicioSesionModelo inicioSesionModelo;

    public InicioSesionPresentador(InicioSesionActivity inicioSesionActivity){
        this.inicioSesionActivity=inicioSesionActivity;
        inicioSesionModelo=new InicioSesionModelo(this);
    }

    public void iniciarSesion(FirebaseAuth mAuth, String correo, String contraseña,
                              InicioSesionActivity inicioSesionActivity){
        inicioSesionModelo.iniciarSesion(mAuth,correo,contraseña,inicioSesionActivity);
    }

    public void registrarUsuario(InicioSesionActivity inicioSesionActivity){
        inicioSesionModelo.registrarUsuario(inicioSesionActivity);
    }

    public void nextActivity(InicioSesionActivity inicioSesionActivity){
        inicioSesionModelo.nextActivity(inicioSesionActivity);
    }

    /** Muestra el mensaje "Bienvenido" el inicio de sesion ha sido correcto */
    public void mostrarMensajeBienvenido() {
        inicioSesionActivity.mostrarMensajeBienvenido();
    }

    /** Muestra el mensaje "Error, credenciales incorrectas" cuando estan incorrectas */
    public void mostrarMensajeCredencialesIncorrectas() {
        inicioSesionActivity.mostrarMensajeCredencialesIncorrectas();
    }

    /** Muestra el mensaje "Revise campos ingresados" cuando estan incorrectos */
    public void mostrarMensajeCamposIncorrectos() {
        inicioSesionActivity.mostrarMensajeCamposIncorrectos();
    }
}
