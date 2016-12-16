package com.example.jota.simonj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MensajePartida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje_partida);
        TextView mensaje = (TextView)findViewById(R.id.mensaje);
        Bundle extras = getIntent().getExtras();
        mensaje.setText(extras.getString("VICTORIA_DERROTA"));
    }
}
