package com.example.core.firebasechat.Vista;

import android.content.Intent;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.core.firebasechat.Presentador.MensajesPresentador;

import de.hdodenhof.circleimageview.CircleImageView;
import com.example.core.firebasechat.R;

/**
 * Clase MensajeActivity para mostrar los mensajes
 * @version 1.0, 23/07/2020
 * @author Carrera,Taday
 */
public class MensajesActivity extends AppCompatActivity {

    /**
     * Variables para manejar la foto de perfil, nombre de usuario
     */
    private CircleImageView fotoPerfil;
    private TextView nombre;
    private RecyclerView rvMensajes;
    private EditText txtMensaje;
    private Button btnEnviar;
    private ImageButton btnEnviarFoto;
    private static final int EnviarFoto = 1;

    /**
     * Variable para almacenar el nombre del receptor del mensaje
     */
    private String nombreReceptor;

    /**
     * Variable para almacenar el id del receptor del mensaje
     */
    private String idReceptor;

    /**
     * Variable para almacenar la direccion de la imagen del receptor
     */
    private String fotoReceptor;

    private MensajesPresentador mensajesPresentador;

    /**
     * Metodo para crear la instancia del activity por primera vez.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajeria);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            idReceptor = bundle.getString("key_receptor");
            nombreReceptor =bundle.getString("nombre_receptor");
            fotoReceptor =bundle.getString("foto_receptor");
        }else{
            finish();
        }

        fotoPerfil = findViewById(R.id.fotoPerfil);
        nombre = findViewById(R.id.nombre);
        rvMensajes =findViewById(R.id.rvMensajes);
        txtMensaje = findViewById(R.id.txtMensaje);
        btnEnviar =  findViewById(R.id.btnEnviar);
        btnEnviarFoto = findViewById(R.id.btnEnviarFoto);
        Glide.with(this).load(fotoReceptor).into(fotoPerfil);
        nombre.setText(nombreReceptor);

        LinearLayoutManager l = new LinearLayoutManager(this);
        rvMensajes.setLayoutManager(l);

        btnEnviar.setOnClickListener(listenerEnviarMensaje);

        btnEnviarFoto.setOnClickListener(listenerEnviarFoto);

        mensajesPresentador = new MensajesPresentador(this,rvMensajes,idReceptor);
    }

    /** Escucha el botón para enviar un mensaje. */
    private View.OnClickListener listenerEnviarMensaje = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mensajesPresentador.enviarMensaje(txtMensaje,idReceptor);
        }
    };

    /** Escucha el botón para enviar una foto. */
    private View.OnClickListener listenerEnviarFoto = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mensajesPresentador.llamarActividadEnviarFoto(MensajesActivity.this,
                    EnviarFoto);
        }
    };

    /**
     * Metodo para mostrar los mensajes
     * @param requestCode es el codigo de solivitud
     * @param resultCode es el codigo resultado
     * @param data los datos o mensajes
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EnviarFoto && resultCode == RESULT_OK){
            Uri u = data.getData();
            mensajesPresentador.enviarFoto(u,idReceptor);
        }
    }

}
