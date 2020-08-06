package com.example.core.firebasechat.Presentador;
import android.widget.TextView;

import com.example.core.firebasechat.Modelo.MenuModelo;
import com.example.core.firebasechat.Vista.MenuActivity;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Clase ListaUsuariosPresentador para listar usuarios
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class MenuPresentador {
    MenuActivity menuActivity;

    MenuModelo menuModelo;

    /**
     * Metodo para mostrar el menu
     * @param menuActivity la actividad del menu
     * @param txtNombreUsuario el nombre de su usuario que va a mostrar la actividad
     * @param fotoPerfil el componente CircleImageView para mostrar la foto
     */
    public MenuPresentador(MenuActivity menuActivity, TextView txtNombreUsuario,
                           CircleImageView fotoPerfil){
        this.menuActivity=menuActivity;
        menuModelo=new MenuModelo(this,menuActivity,txtNombreUsuario,fotoPerfil);
    }

    /**
     * Metodo para mostrar la actividad
     * @param menuActivity
     */
    public void verUsuarios(MenuActivity menuActivity){
        menuModelo.verUsuarios(menuActivity);
    }

    /**
     * Metodo para cerrar sesion
     * @param menuActivity
     */
    public void cerrarSesion(MenuActivity menuActivity){
        menuModelo.cerrarSesion(menuActivity);
    }
}
