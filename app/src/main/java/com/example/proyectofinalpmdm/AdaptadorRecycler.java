package com.example.proyectofinalpmdm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolder> {


    List<Coche>misFilas;
    private OnRecyclerViewLongItemClickListener itemLongClickListener;

    public void setOnItemLongClickListener
            (OnRecyclerViewLongItemClickListener listener){
        itemLongClickListener = listener;
    }

    public AdaptadorRecycler(List<Coche> datosEnviados){

        misFilas = datosEnviados;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View v = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.fila,parent,false);
        final ViewHolder viewHolder = new ViewHolder(v);

        v.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (itemLongClickListener!=null){
                    itemLongClickListener.onItemLongClick(
                            v,viewHolder.getAdapterPosition());;
                }
                return true;
            }
        });



        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        final int pos = position;
        holder.marca.setText(misFilas.get(position).getMarca());
        holder.modelo.setText(misFilas.get(position).getModelo());
        holder.tipoCoche.setText(misFilas.get(position).getTipoCoche());



    }

    @Override
    public int getItemCount() {
        return misFilas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView marca;
        TextView modelo;
        TextView tipoCoche;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            marca = itemView.findViewById(R.id.textViewMarca);
            modelo = itemView.findViewById(R.id.textViewModelo);
            tipoCoche = itemView.findViewById(R.id.textViewTipoCoche);
        }
    }
}



