package com.example.core.firebasechat.Vista;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.core.firebasechat.Presentador.RegistroPresentador;
import com.google.firebase.auth.FirebaseAuth;
import com.kbeanie.multipicker.api.Picker;
import de.hdodenhof.circleimageview.CircleImageView;
import com.example.core.firebasechat.R;
import com.example.core.firebasechat.Modelo.Constantes.Constantes;

/**
 * Clase RegistroActivity para el registro de un usuario
 * @version 1.0, 23/07/2020
 * @author Carrera,Taday
 */
public class RegistroActivity extends AppCompatActivity {

    /**
     * Variables para obtener datos de la vista
     */
    private CircleImageView fotoPerfil;
    private EditText txtNombre;
    private EditText txtCorreo;
    private EditText txtContraseña;
    private EditText txtContraseñaRepetida;
    private Button btnRegistrar;

    /**
     * Metodos para acceder a la base de datos
     */
    private FirebaseAuth mAuth;

    private RegistroPresentador registroPresentador;

    /**
     * Metodo para crear la instancia del activity por primera vez.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        fotoPerfil = findViewById(R.id.fotoPerfil);
        txtNombre = findViewById(R.id.idRegistroNombre);
        txtCorreo = findViewById(R.id.idRegistroCorreo);
        txtContraseña = findViewById(R.id.idRegistroContraseña);
        txtContraseñaRepetida = findViewById(R.id.idRegistroContraseñaRepetida);
        btnRegistrar = findViewById(R.id.idRegistroRegistrar);

        mAuth = FirebaseAuth.getInstance();
        btnRegistrar.setOnClickListener(listenerRegistrarUsuario);
        fotoPerfil.setOnClickListener(listenerSeleccionarFoto);
        registroPresentador=new RegistroPresentador(this,fotoPerfil);

        Glide.with(this).load(Constantes.urlFotoPorDefecto).into(fotoPerfil);

    }

    /** Escucha el botón para registrar un usuario en la app. */
    private View.OnClickListener listenerRegistrarUsuario = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            registroPresentador.registrarUsuario(txtCorreo.getText().toString(),
                    txtContraseña.getText().toString(),txtContraseñaRepetida.getText().toString(),
                    txtNombre.getText().toString(),mAuth);
        }
    };

    /** Escucha el botón para seleccionar la foto de perfil para un usuario en la app. */
    private View.OnClickListener listenerSeleccionarFoto = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            registroPresentador.seleccionarFoto();
        }
    };

    /** Muestra el mensaje "Revise campos del registro" */
    public void mostrarMensajeRevisarCampos() {
        Toast.makeText(RegistroActivity.this,
                "Revise campos del registro.", Toast.LENGTH_SHORT).show();
    }

    /** Muestra el mensaje "Error al registrarse" */
    public void mostrarMensajeError() {
        Toast.makeText(RegistroActivity.this,"Error al registrarse.",
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodo para mostrar los mensajes
     * @param requestCode es el codigo de solivitud
     * @param resultCode es el codigo resultado
     * @param data los datos o mensajes
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Picker.PICK_IMAGE_DEVICE && resultCode == RESULT_OK){
            registroPresentador.submitImagePicker(data);
        }else if(requestCode == Picker.PICK_IMAGE_CAMERA && resultCode == RESULT_OK){
            registroPresentador.submitCamaraPicker(data);
        }
    }

    /**
     * Metodo guardar el estado  del instancia
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // You have to save path in case your activity is killed.
        // In such a scenario, you will need to re-initialize the CameraImagePicker
        registroPresentador.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    /**
     * Metodo para restaurar el estado de la instancia
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // After Activity recreate, you need to re-intialize these
        // two values to be able to re-intialize CameraImagePicker
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("picker_path")) {
                registroPresentador.onRestoreInstanceState(savedInstanceState);
            }
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

}
