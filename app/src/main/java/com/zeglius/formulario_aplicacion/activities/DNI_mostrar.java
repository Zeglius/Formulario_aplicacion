package com.zeglius.formulario_aplicacion.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.zeglius.formulario_aplicacion.MainActivity;
import com.zeglius.formulario_aplicacion.R;
import com.zeglius.formulario_aplicacion.model.Dni;

public class DNI_mostrar extends AppCompatActivity {

    private static final String TAG = DNI_mostrar.class.getSimpleName();

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dni_mostrar);

        Intent intent = getIntent();
        Dni dni;
        Bundle extras;
        extras = intent.getBundleExtra(MainActivity.EXTRA_DNI);
        dni = extras != null ? (Dni) extras.getSerializable(MainActivity.EXTRA_DNI) : null;
        Log.d(TAG, "onCreate: " + "dni == null = " + (dni == null));


        if (dni != null) {
            ((TextView) findViewById(R.id.dniApellidoTextView)).setText(dni.getApellido());
            ((TextView) findViewById(R.id.dniApellido2TextView)).setText(dni.getApellido2());
            ((TextView) findViewById(R.id.dniNombreTextView)).setText(dni.getNombre());
            ((TextView) findViewById(R.id.dniSexoTextView)).setText(dni.getSexo());
        }
    }
}