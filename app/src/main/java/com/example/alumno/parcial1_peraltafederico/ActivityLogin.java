package com.example.alumno.parcial1_peraltafederico;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class ActivityLogin extends AppCompatActivity implements Handler.Callback {

    Activity miActivity;
    Handler handler;
    MyThread myThreadLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button b = (Button) findViewById(R.id.btnIngresar);
        this.miActivity = this;
            this.handler = new Handler(this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtUser = (EditText) miActivity.findViewById(R.id.txtMail);
                String usuario = txtUser.getText().toString();
                EditText txtPass = (EditText) miActivity.findViewById(R.id.txtClave);
                String contraseña = txtPass.getText().toString();

                String ruta = "http://192.168.2.128:3000/login/" + usuario + "/" + contraseña;
                Log.d("ruta", ruta);

                myThreadLogin = new MyThread(handler,ruta,"JSON");
                myThreadLogin.start();
            }
        });

    }

    @Override
    public boolean handleMessage(Message msg) {
        Log.d("Mensaje", msg.obj.toString());
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(msg.obj.toString());
            String tipo = jsonObject.getString("type");
            Log.d("El TIPO es", tipo);
            if (tipo.equals("Admin")){
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("tipo","admin");
                this.startActivity(i);
                finish();
            }
            else if (tipo.equals("User")){
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("tipo","user");
                this.startActivity(i);
                finish();
            }
            else{

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
