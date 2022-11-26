package com.example.facturacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facturacion.modelo.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class ListarProductos extends AppCompatActivity {
    RecyclerView rcvListadoProdcutos;
    ProductoAdapter adapter;
    FirebaseFirestore conexion = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_productos);

        rcvListadoProdcutos = findViewById(R.id.rcvListadoProductos);
        rcvListadoProdcutos.setLayoutManager(new LinearLayoutManager(this));

        Query q = conexion.collection("Productos");

        FirestoreRecyclerOptions<Producto> fro = new FirestoreRecyclerOptions.Builder<Producto>().setQuery(q,Producto.class).build();

        adapter = new ProductoAdapter(fro);
        adapter.notifyDataSetChanged();
        rcvListadoProdcutos.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}