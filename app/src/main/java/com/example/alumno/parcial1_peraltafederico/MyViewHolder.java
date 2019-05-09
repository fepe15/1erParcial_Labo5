package com.example.alumno.parcial1_peraltafederico;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView txtNombre;
    TextView txtPrecio;
    TextView txtCantidad;

    public MyViewHolder(View itemView) {
        super(itemView);
        txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
        txtPrecio = (TextView) itemView.findViewById(R.id.txtPrecio);
        txtCantidad = (TextView) itemView.findViewById(R.id.txtCantidad);
    }
}
