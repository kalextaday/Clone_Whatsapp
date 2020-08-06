package com.example.core.firebasechat.Modelo.Persistencia;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.core.firebasechat.Modelo.Adaptadores.MensajeAdaptador;
import com.example.core.firebasechat.Modelo.Entidades.Logica.LMensaje;
import com.example.core.firebasechat.Modelo.Entidades.Logica.LUsuario;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.core.firebasechat.Modelo.Entidades.Firebase.Mensaje;
import com.example.core.firebasechat.Modelo.Constantes.Constantes;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase MensajeDAO para manejar con acceso a los datos
 * @version 1.0, 30/07/2020
 * @author Carrera,Taday
 */
public class MensajeDAO {

    private static MensajeDAO mensajeDAO;

    private FirebaseDatabase database;
    private DatabaseReference referenceMensajeria;

    public static MensajeDAO getInstancia(){
        if(mensajeDAO ==null) mensajeDAO = new MensajeDAO();
        return mensajeDAO;
    }

    /**
     * Metodo constructor
     */
    private MensajeDAO(){
        database = FirebaseDatabase.getInstance();
        referenceMensajeria = database.getReference(Constantes.nodoMensajes);
    }

    /**
     * Metodo para almacenar un mensaje en la bases
     * @param idEmisor del usuario que envia
     * @param idReceptor del usuario que recibe
     * @param mensaje el contenido del mensaje
     */
    public void crearNuevoMensaje(String idEmisor, String idReceptor, Mensaje mensaje){
        if(idEmisor.equals(idReceptor)){
            DatabaseReference referenceEmisor =
                    referenceMensajeria.child(idEmisor).child(idReceptor);
            referenceEmisor.push().setValue(mensaje);

        }else{
            DatabaseReference referenceEmisor =
                    referenceMensajeria.child(idEmisor).child(idReceptor);
            DatabaseReference referenceReceptor =
                    referenceMensajeria.child(idReceptor).child(idEmisor);
            referenceEmisor.push().setValue(mensaje);
            referenceReceptor.push().setValue(mensaje);
        }
    }

    /**
     * Metodo para obtener los mensajes de la base de datos
     * @param c
     * @param adapter
     * @param KEY_RECEPTOR
     */
    public void obtenerMensajes(final Context c, final MensajeAdaptador adapter
            , String KEY_RECEPTOR){
        FirebaseDatabase.
                getInstance().
                getReference(Constantes.nodoMensajes).
                child(UsuarioDAO.getInstancia().getIdUsuario()).
                child(KEY_RECEPTOR).addChildEventListener(new ChildEventListener() {

            //traer la informacion del usuario
            //guardamos la informacion del usuario en una lista temporal
            //obtenemos la informacion guardada  por la llave
            Map<String, LUsuario> mapUsuariosTemporales = new HashMap<>();

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                final Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);
                final LMensaje lMensaje = new LMensaje(dataSnapshot.getKey(),mensaje);
                final int posicion = adapter.añadirMensaje(lMensaje);

                if(mapUsuariosTemporales.get(mensaje.getIdEmisor())!=null){
                    lMensaje.setlUsuario(mapUsuariosTemporales.get(mensaje.getIdEmisor()));
                    adapter.actualizarMensaje(posicion,lMensaje);
                }else{
                    UsuarioDAO.getInstancia().obtenerInformacionDeUsuarioPorId(
                            mensaje.getIdEmisor(), new UsuarioDAO.IDevolverUsuario() {
                                @Override
                                public void devolverUsuario(LUsuario lUsuario) {
                                    mapUsuariosTemporales.put(mensaje.getIdEmisor(),lUsuario);
                                    lMensaje.setlUsuario(lUsuario);
                                    adapter.actualizarMensaje(posicion,lMensaje);
                                }

                                @Override
                                public void devolverError(String error) {
                                    Toast.makeText(c, "Error: "+error,
                                            Toast.LENGTH_SHORT).show();
                                }
                            });
                }

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * Metodo para obtener el ultimo mensaje de la base de datos
     * @param idEmisor
     * @param idReceptor
     * @param ultimoMensaje
     * @param horaUltimoMensaje
     */
    public void obtenerUltimoMensaje(final String idEmisor,
                                     String idReceptor,
                                     final TextView ultimoMensaje,
                                     final TextView horaUltimoMensaje){
        referenceMensajeria.
                child(idEmisor).
                child(idReceptor).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    Mensaje mensaje;
                    LMensaje lMensaje = null;
                    for (DataSnapshot childDataSnapShot : dataSnapshot.getChildren()) {
                        mensaje = childDataSnapShot.getValue(Mensaje.class);
                        lMensaje = new LMensaje(childDataSnapShot.getKey(), mensaje);
                    }
                    if(idEmisor.equals(lMensaje.getMensaje().getIdEmisor())){
                        ultimoMensaje.setText("Tú: "+lMensaje.getMensaje().getMensaje());
                    }else{
                        ultimoMensaje.setText(lMensaje.getMensaje().getMensaje());
                    }
                    ultimoMensaje.setTypeface(null, Typeface.NORMAL);
                    horaUltimoMensaje.setText(lMensaje.fechaDeCreacionDelMensaje());
                }catch (Exception e){

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
