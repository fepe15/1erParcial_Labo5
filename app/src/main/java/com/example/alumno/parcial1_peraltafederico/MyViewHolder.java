package com.example.alumno.parcial1_peraltafederico;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
    TextView txtNombre;
    TextView txtPrecio;
    TextView txtCantidad;
    private int posicion;
    ImageView sumar;
    ImageView restar;
    MyOnClickListener myOnClickListener;



    public MyViewHolder(View itemView, MyOnClickListener listener) {
        super(itemView);
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        txtPrecio = (TextView) itemView.findViewById(R.id.txtPrecio);
        txtCantidad = (TextView) itemView.findViewById(R.id.txtCantidad);
        sumar = (ImageView) itemView.findViewById(R.id.btnSumar);
        restar = (ImageView) itemView.findViewById(R.id.btnRestar);
        sumar.setOnClickListener(this);
        restar.setOnClickListener(this);
        myOnClickListener = listener;
        itemView.setOnClickListener(this);
    }


    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }



    @Override
    public void onClick(View v) {
        this.myOnClickListener.onItemClick(v,posicion);
    }
}
