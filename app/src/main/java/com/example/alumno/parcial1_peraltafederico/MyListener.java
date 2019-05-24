package com.example.alumno.parcial1_peraltafederico;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class MyListener implements View.OnClickListener {

    Activity miActivity;

    public MyListener(Activity miActivity){
        this.miActivity = miActivity;
    }

    @Override
    public void onClick(View v) {

        EditText txtUser = (EditText) miActivity.findViewById(R.id.txtMail);
        String usuario = txtUser.getText().toString();
        EditText txtPass = (EditText) miActivity.findViewById(R.id.txtClave);
        String contraseña = txtPass.getText().toString();
        String ruta = "http://localhost:3000/login/" + usuario + "/" + contraseña;

        Log.d("ruta:::", ruta);
        try {
            HttpConnection connection = new HttpConnection("GET");
            String resConexion = connection.getStringData(ruta);
            Log.d("Respuesta", resConexion);
        } catch (IOException e) {
            e.printStackTrace();
        }
       /*
        if (txtUser.equals("Admin") && txtPass.equals("1234"))
        Log.d("mi User", userString);
        Log.d("mi pass", passString);*/

    }
}
