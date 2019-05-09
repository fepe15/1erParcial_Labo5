package com.example.alumno.parcial1_peraltafederico;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumno on 09/05/2019.
 */

public class XmlParser {


    public static List<Producto> obtenerProductos(String xml){

        List<Producto> productos = new ArrayList<>();

        XmlPullParser xmlPullParser = Xml.newPullParser();
        try {
            xmlPullParser.setInput(new StringReader(xml));
            int event = xmlPullParser.getEventType();

            while (event != XmlPullParser.END_DOCUMENT){
                if (event == XmlPullParser.START_TAG){
                    if ("producto".equals(xmlPullParser.getName())){
                        Producto p = new Producto();
                        if ("id".equals(xmlPullParser.getName())){
                        p.setId(xmlPullParser.getText());
                        }
                        if ("nombre".equals(xmlPullParser.getName())){
                            p.setNombre(xmlPullParser.getText());
                        }
                        if ("precio".equals(xmlPullParser.getName())){
                            p.setPrecio(xmlPullParser.getText());
                        }
                        if ("cantidad".equals(xmlPullParser.getName())){
                            p.setCantidad(xmlPullParser.getText());
                        }
                        productos.add(p);
                        p.toString();
                    }
                }
                event = xmlPullParser.next();
            }
            return productos;
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
