package com.example.core.firebasechat.Presentador.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import com.example.core.firebasechat.Modelo.Entidades.Logica.LMensaje;
import com.example.core.firebasechat.Modelo.Entidades.Logica.LUsuario;
import com.example.core.firebasechat.Presentador.Holders.MensajeViewHolder;
import com.example.core.firebasechat.Presentador.Persistencia.UsuarioDAO;
import com.example.core.firebasechat.R;

/**
 * Created by user on 04/09/2017. 04
 */

public class MensajeAdaptador extends RecyclerView.Adapter<MensajeViewHolder> {

    private List<LMensaje> listMensaje = new ArrayList<>();
    private Context c;

    public MensajeAdaptador(Context c) {
        this.c = c;
    }

    public int añadirMensaje(LMensaje lMensaje){
        listMensaje.add(lMensaje);
        int posicion = listMensaje.size()-1;
        notifyItemInserted(listMensaje.size());
        return posicion;
    }

    public void actualizarMensaje(int posicion,LMensaje lMensaje){
        listMensaje.set(posicion,lMensaje);
        notifyItemChanged(posicion);
    }

    @Override
    public MensajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if(viewType==1){
            view = LayoutInflater.from(c).
                    inflate(R.layout.card_view_mensajes_emisor,parent,false);
        }else{
            view = LayoutInflater.from(c).
                    inflate(R.layout.card_view_mensajes_receptor,parent,false);
        }
        return new MensajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MensajeViewHolder holder, int position) {

        LMensaje lMensaje = listMensaje.get(position);

        LUsuario lUsuario = lMensaje.getlUsuario();

        if(lUsuario!=null){
            Glide.with(c).load(
                    lUsuario.getUsuario().getFotoPerfilURL()).into(holder.getFotoMensajePerfil());
        }

        holder.getMensaje().setText(lMensaje.getMensaje().getMensaje());
        try{
            holder.getFotoMensaje().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.VISIBLE);
            Glide.with(c).load(lMensaje.getMensaje().getUrlFoto()).into(holder.getFotoMensaje());
        }catch (Exception e){
            holder.getFotoMensaje().setVisibility(View.GONE);
            holder.getMensaje().setVisibility(View.VISIBLE);
        }
        holder.getHora().setText(lMensaje.fechaDeCreacionDelMensaje());
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(listMensaje.get(position).getlUsuario()!=null){
            if(listMensaje.get(position).getlUsuario().getId().
                    equals(UsuarioDAO.getInstancia().getIdUsuario())){
                return 1;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
}
