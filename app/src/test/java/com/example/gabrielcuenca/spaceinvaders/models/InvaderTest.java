package com.example.gabrielcuenca.spaceinvaders.models;

import android.graphics.Bitmap;
import android.content.Context;
import android.graphics.RectF;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvaderTest {

    Context context;
    Invader invader;

    int columna;
    int fila;
    int pantallaY;
    int pantallaX;


    @Before
    public void setUp() throws Exception {
        context = null;
        columna = 1;
        fila = 1;
        pantallaY = 1000;
        pantallaX = 100;

        invader = new Invader(context, columna, fila, pantallaY, pantallaX);
    }

    @Test
    public void automaticMove() {
        int yup = 1000;
        double delta = 0.1;
        float outputDireccion;
        float outputYup;
        float expectedDireccion;
        float expectedYup;


            for (int y =1000; y >= 0; y-- ){
                expectedYup = yup - y;
                yup -= y;
                invader.setYup(yup);
                outputYup = invader.getY();
                assertEquals(expectedYup, outputYup, delta);

                for (int direccion=1; direccion<=2; direccion++){
                    invader.setDireccion(direccion);
                    if (direccion == 1){
                        expectedDireccion = 2;
                    }else{
                        expectedDireccion = 1;
                    }
                    outputDireccion = invader.getDireccion();
                    assertEquals(expectedDireccion, outputDireccion, delta);
                }
            }

    }
}