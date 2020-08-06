package com.example.core.firebasechat.Vista;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.core.firebasechat.Presentador.ListaUsuariosPresentador;
import com.example.core.firebasechat.R;

/**
 * Clase ListaUsuariosActivity para ver los usuarios con quien existe una conversacion
 * @version 1.0, 23/07/2020
 * @author Carrera,Taday
 */
public class ListaUsuariosActivity extends AppCompatActivity {

    private RecyclerView rvUsuarios;
    private ListaUsuariosPresentador listaUsuariosPresentador;

    /**
     * Metodo para crear la instancia del activity por primera vez.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_usuarios);
        rvUsuarios = findViewById(R.id.rvUsuarios);
        listaUsuariosPresentador = new ListaUsuariosPresentador(this,rvUsuarios);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvUsuarios.setLayoutManager(linearLayoutManager);
    }

    /**
     * Metodo para iniciar el activity por primera vez o por enesima vez
     * que el usuario pueda ver la actividad mientras la app se prepara
     * para que esta entre en primer plano y se convierta en interactiva
     */
    @Override
    protected void onStart() {
        super.onStart();
        listaUsuariosPresentador.iniciarAdaptador();
    }

    /**
     * Metodo para cuando haya terminado la actividad y esté a punto de finalizar
     * y liberar los recursos que haya consumido
     */
    @Override
    protected void onStop() {
        super.onStop();
        listaUsuariosPresentador.detenerAdaptador();
    }

}
