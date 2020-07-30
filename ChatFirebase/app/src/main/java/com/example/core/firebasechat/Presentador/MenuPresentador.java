package com.example.core.firebasechat.Presentador;
import android.widget.TextView;

import com.example.core.firebasechat.Modelo.MenuModelo;
import com.example.core.firebasechat.Vista.MenuActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MenuPresentador {
    MenuActivity menuActivity;

    MenuModelo menuModelo;

    public MenuPresentador(MenuActivity menuActivity, TextView txtNombreUsuario,
                           CircleImageView fotoPerfil){
        this.menuActivity=menuActivity;
        menuModelo=new MenuModelo(this,menuActivity,txtNombreUsuario,fotoPerfil);
    }

    public void verUsuarios(MenuActivity menuActivity){
        menuModelo.verUsuarios(menuActivity);
    }

    public void cerrarSesion(MenuActivity menuActivity){
        menuModelo.cerrarSesion(menuActivity);
    }
}
