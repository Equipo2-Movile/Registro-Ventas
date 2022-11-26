package com.example.facturacion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facturacion.modelo.Producto;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class ProductoAdapter extends FirestoreRecyclerAdapter<Producto, ProductoAdapter.ViewHolder> {

    FirebaseFirestore conexion = FirebaseFirestore.getInstance();
    public ProductoAdapter(@NonNull FirestoreRecyclerOptions<Producto> options){
        super(options);
    }
    @Override
    protected void onBindViewHolder(@NonNull ProductoAdapter.ViewHolder holder, int position, @NonNull Producto model) {
        DocumentSnapshot productoId = getSnapshots().getSnapshot(holder.getAdapterPosition());

        String id = productoId.getId();
        holder.txvCodigoProducto.setText(id+"");
        holder.txvPrecioUnidad.setText(model.getPrecio());

        holder.btnEliminarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conexion.collection("Productos").document(id).delete();



            }

        });
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos,parent,false);
        return new ViewHolder(vista);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txvCodigoProducto,txvPrecioUnidad;
        Button btnEliminarProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txvCodigoProducto = itemView.findViewById(R.id.txvCodigoProducto);
            txvPrecioUnidad = itemView.findViewById(R.id.txvPrecioUnidad);
            btnEliminarProducto = itemView.findViewById(R.id.btnEliminarProducto);
        }
    }
}
