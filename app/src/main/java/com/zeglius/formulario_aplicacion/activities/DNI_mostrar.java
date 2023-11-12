package com.zeglius.formulario_aplicacion.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zeglius.formulario_aplicacion.MainActivity;
import com.zeglius.formulario_aplicacion.R;
import com.zeglius.formulario_aplicacion.adapter.DniAdapter;
import com.zeglius.formulario_aplicacion.model.Dni;

import java.util.ArrayList;
import java.util.List;

public class DNI_mostrar extends AppCompatActivity {

    private static final String TAG = DNI_mostrar.class.getSimpleName();

    /** @noinspection FieldCanBeLocal*/
    private RecyclerView recyclerView;

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dni_mostrar);

        Intent intent = getIntent();
        Dni dni;
        dni = (Dni) intent.getSerializableExtra(MainActivity.EXTRA_DNI);
        Log.d(TAG, "onCreate: " + "dni: " + dni);


        if (dni != null) {
            ((TextView) findViewById(R.id.dniApellidoTextView)).setText(getString(R.string.apellido) + ": " + dni.getApellido());
            ((TextView) findViewById(R.id.dniApellido2TextView)).setText(getString(R.string.apellido2) + ": " + dni.getApellido2());
            ((TextView) findViewById(R.id.dniNombreTextView)).setText(getString(R.string.nombre) + ": " + dni.getNombre());
            ((TextView) findViewById(R.id.dniSexoTextView)).setText(getString(R.string.sexo) + ": " + dni.getSexo());
            ((TextView) findViewById(R.id.dniDespTextView)).setText(getString(R.string.desp) + ": " + dni.getDesp());
            ((TextView) findViewById(R.id.dniNacimientoTextView)).setText(getString(R.string.fecha_nacimiento) + ": " + dni.getDesp());
            ((TextView) findViewById(R.id.dniNumeroTextView)).setText(getString(R.string.numero_dni) + ": " + dni.getDniNumero());
            ((TextView) findViewById(R.id.dniValidoFechTextView)).setText(getString(R.string.valido_hasta) + ": " + dni.getValidoFech());

            List<Dni> dniList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Dni d = new Dni(dni);
                d.setDesp(Dni.randomDniDesp());
                d.setDniNumero(Dni.randomDniNumber());
                dniList.add(d);
            }
            DniAdapter dniAdapter = new DniAdapter(this, dniList);

            recyclerView = findViewById(R.id.dnisRecycleView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(dniAdapter);
        }
    }
}