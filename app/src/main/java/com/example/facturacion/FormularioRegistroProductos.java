package com.example.facturacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormularioRegistroProductos extends AppCompatActivity {

    Button btnListarProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro_productos);

        btnListarProductos = findViewById(R.id.btnListarProductos);
         btnListarProductos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(getApplicationContext(), ListarProductos.class);
                 startActivity(i);

             }
         });
    }
}