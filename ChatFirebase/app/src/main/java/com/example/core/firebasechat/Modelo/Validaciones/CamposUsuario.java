package com.example.core.firebasechat.Modelo.Validaciones;

import android.text.TextUtils;

<<<<<<< HEAD
/**
 * Clase CamposUsuario para validar los campos de usuario
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
public class CamposUsuario {
    private static CamposUsuario camposUsuario;

    public static CamposUsuario getInstancia(){
        if(camposUsuario ==null) camposUsuario = new CamposUsuario();
        return camposUsuario;
    }
    public boolean validarContraseña(String contraseña){
        if(contraseña.length()>=6 && contraseña.length()<=16){
            return true;
        }else return false;
    }

    public boolean validarContraseña(String contraseña, String contraseñaRepetida){
        if(contraseña.equals(contraseñaRepetida)){
            return validarContraseña(contraseña);
        }else return false;
    }

    public boolean validarNombre(String nombre){
        if(nombre.length()>=1&&nombre.length()<=16){
            return true;
        }else{
            return false;
        }
    }
    public boolean validarCorreo(CharSequence target) {
        return !TextUtils.isEmpty(target) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
