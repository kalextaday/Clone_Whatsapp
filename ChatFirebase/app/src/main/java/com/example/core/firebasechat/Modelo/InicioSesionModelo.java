package com.example.core.firebasechat.Modelo;

import android.content.Intent;
import androidx.annotation.NonNull;

import com.example.core.firebasechat.Modelo.Validaciones.CamposUsuario;
import com.example.core.firebasechat.Presentador.InicioSesionPresentador;
import com.example.core.firebasechat.Vista.InicioSesionActivity;
import com.example.core.firebasechat.Vista.MenuActivity;
import com.example.core.firebasechat.Vista.RegistroActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

<<<<<<< HEAD
/**
 * Clase InicioSesionModelo para iniciar
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
public class InicioSesionModelo {

    InicioSesionPresentador inicioSesionPresentador;

<<<<<<< HEAD
    /**
     * Metodo constructor
     * @param inicioSesionPresentador
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public InicioSesionModelo(InicioSesionPresentador inicioSesionPresentador){
        this.inicioSesionPresentador=inicioSesionPresentador;
    }

<<<<<<< HEAD
    /**
     * Metodo para iniciar sesion
     * @param mAuth objeto para autorizar el inicio en firebase
     * @param correo del usuario
     * @param contraseña del usuario
     * @param inicioSesionActivity la actividad que inicia sesion
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public void iniciarSesion(FirebaseAuth mAuth, String correo, String contraseña,
                              final InicioSesionActivity inicioSesionActivity){
        if(CamposUsuario.getInstancia().validarCorreo(correo) &&
                CamposUsuario.getInstancia().validarContraseña(contraseña)){
            mAuth.signInWithEmailAndPassword(correo, contraseña)
                    .addOnCompleteListener(inicioSesionActivity,
                            new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                inicioSesionPresentador.mostrarMensajeBienvenido();
                                nextActivity(inicioSesionActivity);
                            } else {
                                inicioSesionPresentador.mostrarMensajeCredencialesIncorrectas();
                            }

                        }
                    });
        }else{
            inicioSesionPresentador.mostrarMensajeCamposIncorrectos();
        }
    }

<<<<<<< HEAD
    /**
     * Metodo para registrar usuario
     * @param inicioSesionActivity
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public void registrarUsuario(InicioSesionActivity inicioSesionActivity){
        inicioSesionActivity.startActivity(new Intent(inicioSesionActivity,
                RegistroActivity.class));
    }

<<<<<<< HEAD
    /**
     * Metodo para pasar a la siguiente actividad
     * @param inicioSesionActivity
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public void nextActivity(InicioSesionActivity inicioSesionActivity){
        inicioSesionActivity.startActivity(new Intent(inicioSesionActivity, MenuActivity.class));
        inicioSesionActivity.finish();
    }
}
