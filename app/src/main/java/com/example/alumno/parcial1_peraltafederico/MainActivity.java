package com.example.alumno.parcial1_peraltafederico;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    MyAdapter adapter;
    List<Producto> listProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProductos = new ArrayList<>();
        Handler handler = new Handler(this);

        RecyclerView rvProductos = (RecyclerView) findViewById(R.id.rvProductos);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvProductos.setLayoutManager(layoutManager);

        adapter = new MyAdapter(listProductos);
        rvProductos.setAdapter(adapter);

        MyThread myThread = new MyThread(handler,"http://192.168.2.187/Productos.xml", 0);
        myThread.start();

        //lo ideal es crear los hilos e iniciarlos en onStart() y luego hay que detenerlos en onStop()

    }

    @Override
    public boolean handleMessage(Message msg) {

        this.listProductos = this.adapter.setProductos((List<Producto>)msg.obj);
        adapter.notifyDataSetChanged();
        return false;
    }
}
