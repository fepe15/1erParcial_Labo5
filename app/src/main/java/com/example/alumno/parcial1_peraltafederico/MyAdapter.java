package com.example.alumno.parcial1_peraltafederico;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    List<Producto> productos;

    public MyAdapter(List<Producto> productos){
        this.productos = productos;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =null;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recy,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.txtNombre.setText(productos.get(position).getNombre());
        holder.txtPrecio.setText(productos.get(position).getPrecio());
        holder.txtCantidad.setText(productos.get(position).getCantidad());

    }

    @Override
    public int getItemCount() {
        return this.productos.size();
    }

    public void setProductos(List<Producto> p){
        this.productos=p;
    }
}
