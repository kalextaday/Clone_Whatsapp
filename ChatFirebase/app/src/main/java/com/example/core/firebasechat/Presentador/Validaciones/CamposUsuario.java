package com.example.core.firebasechat.Presentador.Validaciones;

import android.text.TextUtils;

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
