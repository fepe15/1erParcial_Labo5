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

    public MyThread(Handler handler , String url){
        this.handler = handler;
        this.url = url;
    }

    @Override
    public void run() {
        try {
            HttpConnection connection = new HttpConnection("GET");
            Message msg = new Message();
            String resConexion = connection.getStringData(url);
            msg.obj = XmlParser.obtenerProductos(resConexion);
            this.handler.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
