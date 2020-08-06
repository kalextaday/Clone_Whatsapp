package com.example.core.firebasechat.Vista;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.core.firebasechat.Presentador.MenuPresentador;
import com.example.core.firebasechat.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Clase MenuActivity para el menu
 * @version 1.0, 23/07/2020
 * @author Carrera,Taday
 */
public class MenuActivity extends AppCompatActivity {

    /**
     * Variables para obtener lod datos de la vista
     */
    private Button btnVerUsuarios;
    private Button btnCerrarSesion;
    private TextView txtNombreUsuario;
    private CircleImageView fotoPerfil;

    private MenuPresentador menuPresentador;


    /**
     * Metodo para crear la instancia del activity por primera vez.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        fotoPerfil=(CircleImageView)findViewById(R.id.fotoPerfilUsuario);
        txtNombreUsuario=findViewById(R.id.nombreUsuario);
        btnVerUsuarios = findViewById(R.id.btnVerUsuarios);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);
        menuPresentador=new MenuPresentador(this,txtNombreUsuario,fotoPerfil);
        btnVerUsuarios.setOnClickListener(listenerVerUsuarios);
        btnCerrarSesion.setOnClickListener(listenerCerrarSesion);

    }

    /** Escucha el botón para ver usuarios registrados en la app. */
    private View.OnClickListener listenerVerUsuarios = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            menuPresentador.verUsuarios(MenuActivity.this);
        }
    };

    /** Escucha el botón para cerrar sesion en la app. */
    private View.OnClickListener listenerCerrarSesion = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            menuPresentador.cerrarSesion(MenuActivity.this);
        }
    };


}
