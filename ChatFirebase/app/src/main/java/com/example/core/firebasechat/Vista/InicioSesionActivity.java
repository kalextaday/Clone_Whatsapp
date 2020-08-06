package com.example.core.firebasechat.Vista;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.core.firebasechat.Presentador.InicioSesionPresentador;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.core.firebasechat.R;

/**
 * Clase InicioSesionActivity para el inicio de Sesion en la aplicacion
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class InicioSesionActivity extends AppCompatActivity {

    /**
     * Variables txtCorreo, txtContraseña para obtener los datos de la vista
     * Variable mAuth para acceder al contexto de la base
     */
    private EditText txtCorreo;
    private EditText txtContraseña;
    private Button btnIniciarSesion;
    private Button btnRegistro;
    private FirebaseAuth mAuth;

    private InicioSesionPresentador inicioSesionPresentador;

    /**
     * Metodo para crear la instancia del activity por primera vez.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtCorreo = findViewById(R.id.idCorreoLogin);
        txtContraseña = findViewById(R.id.idContraseñaLogin);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
        btnRegistro = findViewById(R.id.btnRegistrar);
        btnIniciarSesion.setOnClickListener(listenerIniciarSesion);
        btnRegistro.setOnClickListener(listenerRegistrarUsuario);
        mAuth = FirebaseAuth.getInstance();

        inicioSesionPresentador = new InicioSesionPresentador(this);
    }

    /** Escucha el botón para inicio de sesion de la aplicación. */
    private View.OnClickListener listenerIniciarSesion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            inicioSesionPresentador.iniciarSesion(mAuth,txtCorreo.getText().toString(),
                    txtContraseña.getText().toString(),InicioSesionActivity.this);
        }
    };

    /** Escucha el botón para cambiar a vista para registrar un usuario. */
    private View.OnClickListener listenerRegistrarUsuario = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            inicioSesionPresentador.registrarUsuario(InicioSesionActivity.this);
        }
    };

    /**
     * Metodo para reanudar la actividad en primer plano
     */
    @Override
    protected void onResume() {
        super.onResume();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null){
            mostrarMensajeBienvenido();
            inicioSesionPresentador.nextActivity(InicioSesionActivity.this);
        }
    }

    /** Muestra el mensaje "Bienvenido" el inicio de sesion ha sido correcto */
    public void mostrarMensajeBienvenido() {
        Toast.makeText(InicioSesionActivity.this,
                "Bienvenido.",Toast.LENGTH_SHORT).show();
    }

    /** Muestra el mensaje "Error, credenciales incorrectas" cuando estan incorrectas */
    public void mostrarMensajeCredencialesIncorrectas() {
        Toast.makeText(InicioSesionActivity.this,
                "Error, credenciales incorrectas.",Toast.LENGTH_SHORT).show();
    }

    /** Muestra el mensaje "Revise campos ingresados" cuando estan incorrectos */
    public void mostrarMensajeCamposIncorrectos() {
        Toast.makeText(InicioSesionActivity.this,
                "Revise campos ingresados.", Toast.LENGTH_SHORT).show();
    }
}
