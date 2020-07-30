package com.example.core.firebasechat.Modelo.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.core.firebasechat.Vista.MensajesActivity;
import com.example.core.firebasechat.Modelo.Entidades.Firebase.Usuario;
import com.example.core.firebasechat.Modelo.Entidades.Logica.LUsuario;
import com.example.core.firebasechat.Modelo.Holders.UsuarioViewHolder;
import com.example.core.firebasechat.Modelo.Persistencia.MensajeDAO;
import com.example.core.firebasechat.Modelo.Persistencia.UsuarioDAO;
import com.example.core.firebasechat.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class UsuarioAdaptador extends FirebaseRecyclerAdapter<Usuario,UsuarioViewHolder> {
    Context c;
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public UsuarioAdaptador(@NonNull FirebaseRecyclerOptions<Usuario> options, Context c) {
        super(options);
        this.c=c;
    }

    @Override
    protected void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position, @NonNull Usuario model) {
        final LUsuario lUsuario = new LUsuario(
                getSnapshots().getSnapshot(position).getKey(), model);
        Glide.with(c).load(model.getFotoPerfilURL()).
                into(holder.getCivFotoPerfil());
        if(UsuarioDAO.getInstancia().getIdUsuario().equals(lUsuario.getId())){
            holder.getLayoutPrincipal().setVisibility(View.GONE);
            holder.getLayoutPrincipal().setLayoutParams(
                    new LinearLayout.LayoutParams(0,0));
        }else{
            holder.getTxtNombreUsuario().setText(model.getNombre());
        }
        MensajeDAO.getInstancia().obtenerUltimoMensaje(
                UsuarioDAO.getInstancia().getIdUsuario(),
                lUsuario.getId(),
                holder.getTxtUltimoMensaje(),
                holder.getTxtHoraUltimoMensaje());

        holder.getLayoutPrincipal().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(c,
                        MensajesActivity.class);
                intent.putExtra("key_receptor", lUsuario.getId());
                intent.putExtra("nombre_receptor",
                        lUsuario.getUsuario().getNombre());
                intent.putExtra("foto_receptor",
                        lUsuario.getUsuario().getFotoPerfilURL());
                c.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.card_view_usuario, parent, false);
            return new UsuarioViewHolder(view);
    }
}
