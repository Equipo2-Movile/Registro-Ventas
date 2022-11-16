package com.example.facturacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividades extends AppCompatActivity {

    Button btnAgregar, btnFacturar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        btnAgregar = findViewById(R.id.btnAgregar);
        btnFacturar = findViewById(R.id.btnFacturacion);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), FormularioRegistroProductos.class);
                startActivity(i);
            }
        });

        btnFacturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i =new Intent(getApplicationContext(), Facturacion.class);
                startActivity(i);
            }
        });



    }
}