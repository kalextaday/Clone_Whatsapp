<<<<<<< HEAD
package com.example.core.firebasechat.Presentador;

import com.example.core.firebasechat.Modelo.InicioSesionModelo;
import com.example.core.firebasechat.Vista.InicioSesionActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Clase InicioSesionPresentador para el inicio de Sesion
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class InicioSesionPresentador {

    InicioSesionActivity inicioSesionActivity;

    InicioSesionModelo inicioSesionModelo;

    /**
     * Metodo constructor
     * @param inicioSesionActivity para inicializar la actividad
     */
    public InicioSesionPresentador(InicioSesionActivity inicioSesionActivity){
        this.inicioSesionActivity=inicioSesionActivity;
        inicioSesionModelo=new InicioSesionModelo(this);
    }

    /**
     * Método para autenticarse en firebase
     * @param mAuth objeto autorizacion a firebase
     * @param correo el nombre de usuario en firebase
     * @param contraseña la contraseña del usuario
     * @param inicioSesionActivity la actividad que se va a iniciar
     */
    public void iniciarSesion(FirebaseAuth mAuth, String correo, String contraseña,
                              InicioSesionActivity inicioSesionActivity){
        inicioSesionModelo.iniciarSesion(mAuth,correo,contraseña,inicioSesionActivity);
    }

    /**
     * Método para resgistrar un usuario en Firebase
     * @param inicioSesionActivity para iniciar la actividad
     */
    public void registrarUsuario(InicioSesionActivity inicioSesionActivity){
        inicioSesionModelo.registrarUsuario(inicioSesionActivity);
    }

    /**
     * Método para pasar a la otra actividad
     * @param inicioSesionActivity
     */
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
=======
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
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
