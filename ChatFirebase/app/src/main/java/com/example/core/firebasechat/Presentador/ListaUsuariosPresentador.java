<<<<<<< HEAD
package com.example.core.firebasechat.Presentador;

import androidx.recyclerview.widget.RecyclerView;

import com.example.core.firebasechat.Modelo.ListaUsuariosModelo;
import com.example.core.firebasechat.Vista.ListaUsuariosActivity;

/**
 * Clase ListaUsuariosPresentador para listar usuarios
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class ListaUsuariosPresentador {

    ListaUsuariosActivity listaUsuariosActivity;

    ListaUsuariosModelo listaUsuariosModelo;

    /**
     * Método constructor
     * @param listaUsuariosActivity la actividad para mostrar los usuarios
     * @param rvUsuarios el componente para mostrar usuarios
     */
    public ListaUsuariosPresentador(ListaUsuariosActivity listaUsuariosActivity, RecyclerView rvUsuarios){
        this.listaUsuariosActivity = listaUsuariosActivity;
        listaUsuariosModelo =new ListaUsuariosModelo(this, listaUsuariosActivity,
                rvUsuarios);
    }

    /**
     * Método para iniciar el adaptador
     */
    public void iniciarAdaptador(){
        listaUsuariosModelo.iniciarAdaptador();
    }

    /**
     * Método para detener el adaptador
     */
    public void detenerAdaptador(){
        listaUsuariosModelo.detenerAdaptador();
    }
}
=======
package com.example.core.firebasechat.Presentador;

import androidx.recyclerview.widget.RecyclerView;

import com.example.core.firebasechat.Modelo.ListaUsuariosModelo;
import com.example.core.firebasechat.Vista.ListaUsuariosActivity;

public class ListaUsuariosPresentador {

    ListaUsuariosActivity listaUsuariosActivity;

    ListaUsuariosModelo listaUsuariosModelo;

    public ListaUsuariosPresentador(ListaUsuariosActivity listaUsuariosActivity, RecyclerView rvUsuarios){
        this.listaUsuariosActivity = listaUsuariosActivity;
        listaUsuariosModelo =new ListaUsuariosModelo(this, listaUsuariosActivity,
                rvUsuarios);
    }

    public void iniciarAdaptador(){
        listaUsuariosModelo.iniciarAdaptador();
    }

    public void detenerAdaptador(){
        listaUsuariosModelo.detenerAdaptador();
    }
}
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
