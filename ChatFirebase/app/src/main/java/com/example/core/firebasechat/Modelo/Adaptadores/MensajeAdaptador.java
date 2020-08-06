package com.example.core.firebasechat.Modelo.Adaptadores;

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
import com.example.core.firebasechat.Modelo.Holders.MensajeViewHolder;
import com.example.core.firebasechat.Modelo.Persistencia.UsuarioDAO;
import com.example.core.firebasechat.R;

<<<<<<< HEAD
/**
 * Clase MensajeAdaptador para heredar de la clase FirebaseRecyclerAdapter
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
public class MensajeAdaptador extends RecyclerView.Adapter<MensajeViewHolder> {

    private List<LMensaje> listMensaje = new ArrayList<>();
    private Context c;

    public MensajeAdaptador(Context c) {
        this.c = c;
    }

<<<<<<< HEAD
    /**
     * Metodo que añade un mensaje
     * @param lMensaje
     * @return
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public int añadirMensaje(LMensaje lMensaje){
        listMensaje.add(lMensaje);
        int posicion = listMensaje.size()-1;
        notifyItemInserted(listMensaje.size());
        return posicion;
    }

<<<<<<< HEAD
    /**
     * Metodo para actualizar un mensaje
     * @param posicion
     * @param lMensaje
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    public void actualizarMensaje(int posicion,LMensaje lMensaje){
        listMensaje.set(posicion,lMensaje);
        notifyItemChanged(posicion);
    }

<<<<<<< HEAD
    /**
     * Metodo para crear la vista de mensaje
     * @param parent
     * @param viewType
     * @return
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
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

<<<<<<< HEAD
    /**
     * Metodo para contruir el componente
     * @param holder
     * @param position
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
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

<<<<<<< HEAD
    /**
     * Metodo para obtener el numero de mensajes
     * @return
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
    @Override
    public int getItemCount() {
        return listMensaje.size();
    }

<<<<<<< HEAD
    /**
     * Metodo para obtener el tipo de de vista
     * @param position
     * @return
     */
=======
>>>>>>> 1fa891d32283ce8e20e52be6afe065f2288053aa
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
