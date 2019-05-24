package com.example.alumno.parcial1_peraltafederico;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, MyOnClickListener {

    MyAdapter adapter;
    List<Producto> listProductos;
    MyOnClickListener myListener;
    String tipo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProductos = new ArrayList<>();
        Handler handler = new Handler(this);

        Intent i = getIntent();

        this.tipo = (String) i.getStringExtra("tipo");
        Log.d("Tipooo", this.tipo);

        RecyclerView rvProductos = (RecyclerView) findViewById(R.id.rvProductos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvProductos.setLayoutManager(layoutManager);

        adapter = new MyAdapter(listProductos, this);
        rvProductos.setAdapter(adapter);

        MyThread myThread = new MyThread(handler,"http://192.168.2.180:8080/Productos.xml", "XML");
        myThread.start();


        //lo ideal es crear los hilos e iniciarlos en onStart() y luego hay que detenerlos en onStop()

    }

    @Override
    public boolean handleMessage(Message msg) {

        Log.d("Lista PRoductos",listProductos.toString());
        this.listProductos = this.adapter.setProductos((List<Producto>)msg.obj);
        adapter.notifyDataSetChanged();
        return false;
    }

    @Override
    public void onItemClick(View v, int position) {

        if (this.tipo.equals("admin")) {
            int i;
            if (v.getId() == R.id.btnSumar) {
                this.listProductos.get(position).sumarCantidad();
                adapter.notifyDataSetChanged();
                Log.d("Producto precionado", this.listProductos.get(position).toString());
            }
            if (v.getId() == R.id.btnRestar) {
                i = Integer.parseInt(this.listProductos.get(position).getCantidad());

                if (i > 0) {
                    this.listProductos.get(position).restarCantidad();
                }
                adapter.notifyDataSetChanged();
                Log.d("Producto precionado", this.listProductos.get(position).toString());
            }
        }
    }
}
