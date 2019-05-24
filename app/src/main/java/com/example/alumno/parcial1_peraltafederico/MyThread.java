package com.example.alumno.parcial1_peraltafederico;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.MalformedURLException;

public class MyThread extends Thread{

    private Handler handler;
    private String url;
    private int posicion;
    String tipo;

    public MyThread(Handler handler , String url, String tipo){
        this.handler = handler;
        this.url = url;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            HttpConnection connection = new HttpConnection("GET");
            Message msg = new Message();
            String resConexion = connection.getStringData(url);
            if (this.tipo.equals("XML")) {
                msg.obj = XmlParser.obtenerProductos(resConexion);
                this.handler.sendMessage(msg);
            }
            else if (this.tipo.equals("JSON")) {
                Log.d("Estro","JSON") ;
                msg.obj = resConexion;
                this.handler.sendMessage(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
