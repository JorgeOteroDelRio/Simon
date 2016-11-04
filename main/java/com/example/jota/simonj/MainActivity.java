package com.example.jota.simonj;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button iniciar;
    Handler manejador1 = new Handler();
    Handler manejador2 = new Handler();
    int botonesPulsados = 0;
    Button[] colores;
    boolean enabledPlay = false;
    int[] ordenBotones;
    int[] ordenJugador;
    private int tiempoEncendido=1000;
    private int tiempoApagar=1500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ordenBotones = new int[5];
        colores=new Button[5];
        ordenJugador=new int[5];
        iniciar = (Button) findViewById(R.id.iniciar);
        colores[0] = (Button) findViewById(R.id.rojo_btn);
        colores[1] = (Button) findViewById(R.id.amarillo_btn);
        colores[2] = (Button) findViewById(R.id.azul_btn);
        colores[3] = (Button) findViewById(R.id.rosa_btn);
        colores[4] = (Button) findViewById(R.id.verde_btn);

    }


    void empezar(View v) {
        enabledPlay=true;
        for (int i = 0; i < ordenBotones.length; i++) {
            ordenBotones[i] = (int) (Math.random() * 5);
            final Button b = colores[ordenBotones[i]];
            System.out.println(ordenBotones[i]);
            if(b.getId()==R.id.rojo_btn){
                manejador1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.rojoEncendido);
                    }
                },tiempoEncendido);

            }else if(b.getId()==R.id.verde_btn){
                manejador1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.verdeEncendido);
                    }
                },tiempoEncendido);
            }else if(b.getId()==R.id.azul_btn){
                manejador1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.azulEncendido);
                    }
                },tiempoEncendido);
            }else if(b.getId()==R.id.amarillo_btn){
                manejador1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.amarilloEncendido);
                    }
                },tiempoEncendido);
            }else{
                manejador1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b.setBackgroundResource(R.color.rosaEncendido);
                    }
                },tiempoEncendido);
            }

            final Button boton = b;


            manejador2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    colorReset(boton.getId());
                }
            },tiempoApagar);

            tiempoEncendido+=1500;
            tiempoApagar+=1500;
        }

        tiempoEncendido=1000;
        tiempoApagar=1500;


    }

    void colorReset(int id){
        if(id==R.id.rojo_btn){
            colores[0].setBackgroundResource(R.color.rojoApagado);
        }else if(id==R.id.verde_btn){
            colores[4].setBackgroundResource(R.color.verdeApagado);
        }else if(id==R.id.azul_btn){
            colores[2].setBackgroundResource(R.color.azulApagado);
        }else if(id==R.id.amarillo_btn){
            colores[1].setBackgroundResource(R.color.amarilloApagado);
        }else{
            colores[3].setBackgroundResource(R.color.rosaApagado);
        }
    }

    void colorClick(View v){
        int id = v.getId();
        int indice;
        final Button b = (Button)v;
        if(id==R.id.rojo_btn){
            v.setBackgroundResource(R.color.rojoEncendido);
            indice=0;
        }else if(id==R.id.verde_btn){
            v.setBackgroundResource(R.color.verdeEncendido);
            indice=4;
        }else if(id==R.id.azul_btn){
            v.setBackgroundResource(R.color.azulEncendido);
            indice=2;
        }else if(id==R.id.amarillo_btn){
            v.setBackgroundResource(R.color.amarilloEncendido);
            indice=1;
        }else{
            v.setBackgroundResource(R.color.rosaEncendido);
            indice=3;
        }


        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                colorReset(b.getId());
            }
        },500);

        if(enabledPlay){
            ordenJugador[botonesPulsados]=indice;
            botonesPulsados++;
            if(botonesPulsados==5){
                comprobar();
            }
        }

    }

    void comprobar(){
        int nacertados=0;
        for(int i=0;i<ordenBotones.length;i++){
            if(ordenBotones[i] != ordenJugador[i]){
                Toast.makeText(this, "Has perdido", Toast.LENGTH_SHORT).show();
            }else{
                nacertados++;
            }
        }

        if(nacertados==5){
            Toast.makeText(this, "Has ganado", Toast.LENGTH_SHORT).show();
        }
        enabledPlay=false;
        botonesPulsados=0;
        ordenBotones=new int[5];
        ordenJugador=new int[5];
    }





}





