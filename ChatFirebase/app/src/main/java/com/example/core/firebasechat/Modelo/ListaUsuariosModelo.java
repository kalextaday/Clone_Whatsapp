package com.example.core.firebasechat.Modelo;

import androidx.recyclerview.widget.RecyclerView;

import com.example.core.firebasechat.Modelo.Adaptadores.UsuarioAdaptador;
import com.example.core.firebasechat.Modelo.Constantes.Constantes;
import com.example.core.firebasechat.Modelo.Entidades.Firebase.Usuario;
import com.example.core.firebasechat.Presentador.ListaUsuariosPresentador;
import com.example.core.firebasechat.Vista.ListaUsuariosActivity;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class ListaUsuariosModelo {
    ListaUsuariosPresentador listaUsuariosPresentador;

    private UsuarioAdaptador usuarioAdaptador;

    public ListaUsuariosModelo(ListaUsuariosPresentador listaUsuariosPresentador,
                               ListaUsuariosActivity listaUsuariosActivity,
                               RecyclerView rvUsuarios){
        this.listaUsuariosPresentador = listaUsuariosPresentador;
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child(Constantes.nodoUsuarios);

        final FirebaseRecyclerOptions<Usuario> options =
                new FirebaseRecyclerOptions.Builder<Usuario>()
                        .setQuery(query, Usuario.class)
                        .build();

        usuarioAdaptador = new UsuarioAdaptador(options, listaUsuariosActivity);
        rvUsuarios.setAdapter(usuarioAdaptador);
    }

    public void iniciarAdaptador(){
        usuarioAdaptador.startListening();
    }

    public void detenerAdaptador(){
        usuarioAdaptador.stopListening();
    }
}
