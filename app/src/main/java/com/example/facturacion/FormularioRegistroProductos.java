package com.example.facturacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FormularioRegistroProductos extends AppCompatActivity {

    Button btnRegistrar, btnListarProductos;
    EditText edtxIdProducto, edtxPrecioUnidad;
    FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_registro_productos);

        edtxIdProducto = findViewById(R.id.edtxIdProducto);
        edtxPrecioUnidad = findViewById(R.id.edtxPrecioUnidad);

        btnRegistrar = findViewById(R.id.btnRegistrarProducto);
        btnListarProductos = findViewById(R.id.btnListarProductos);

        mfirestore = FirebaseFirestore.getInstance();



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrar();
                limpiar();
            }
        });

         btnListarProductos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(getApplicationContext(), ListarProductos.class);
                 startActivity(i);


             }
         });
    }

    public void limpiar(){
        edtxIdProducto.setText("");
        edtxPrecioUnidad.setText("");

    }

    public void registrar(){
        Map<String, Object> producto = new HashMap<>();
        producto.put("identificacion", edtxIdProducto.getText().toString());
        producto.put("precio", edtxPrecioUnidad.getText().toString());

        mfirestore.collection("Productos").document(edtxIdProducto.getText().toString()).set(producto);

        Toast.makeText(this,"Registrado", Toast.LENGTH_SHORT).show();


    }
}