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

public class InicioSesionModelo {

    InicioSesionPresentador inicioSesionPresentador;

    public InicioSesionModelo(InicioSesionPresentador inicioSesionPresentador){
        this.inicioSesionPresentador=inicioSesionPresentador;
    }

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

    public void registrarUsuario(InicioSesionActivity inicioSesionActivity){
        inicioSesionActivity.startActivity(new Intent(inicioSesionActivity,
                RegistroActivity.class));
    }

    public void nextActivity(InicioSesionActivity inicioSesionActivity){
        inicioSesionActivity.startActivity(new Intent(inicioSesionActivity, MenuActivity.class));
        inicioSesionActivity.finish();
    }
}
