package com.zeglius.formulario_aplicacion.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeglius.formulario_aplicacion.R;
import com.zeglius.formulario_aplicacion.model.Dni;

import java.util.List;

public class DniAdapter extends RecyclerView.Adapter<DniViewHolder> {

    private List<Dni> dniList;
    private Context context;


    public DniAdapter(Context context, List<Dni> dniList) {
        this.dniList = dniList;
        this.context = context;
    }


    @NonNull
    @Override
    // Create new views (invoked by the layout manager)
    public DniViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dni_item, parent, false);
        return new DniViewHolder(view, context, dniList);
    }

    @Override
    // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(@NonNull DniViewHolder viewHolder, int position) {
        viewHolder.getDniNumberTextView().setText(dniList.get(position).getDniNumero());
        viewHolder.getDespTextview().setText(dniList.get(position).getDesp());
    }

    @Override
    public int getItemCount() {
        return dniList.size();
    }


}
