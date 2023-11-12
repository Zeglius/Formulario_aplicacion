package com.zeglius.formulario_aplicacion.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeglius.formulario_aplicacion.R;
import com.zeglius.formulario_aplicacion.model.Dni;

import java.util.List;

public class DniViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = Dni.class.getSimpleName();
    private final TextView dniNumberTextView;
    private final TextView despTextview;
    private Context context;
    private List<Dni> dniList;

    public DniViewHolder(@NonNull View itemView, Context context, List<Dni> dniList) {
        super(itemView);
        dniNumberTextView = itemView.findViewById(R.id.dniItemNumTextView);
        despTextview = itemView.findViewById(R.id.dniItemDespTextView);
        this.context = context;
        Log.d(TAG, "DniViewHolder: " + dniList);
    }


    public TextView getDniNumberTextView() {
        return dniNumberTextView;
    }

    public TextView getDespTextview() {
        return despTextview;
    }
}
