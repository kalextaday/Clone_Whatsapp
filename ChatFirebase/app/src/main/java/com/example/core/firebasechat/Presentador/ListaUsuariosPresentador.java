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
