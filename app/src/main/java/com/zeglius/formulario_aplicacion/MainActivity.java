package com.zeglius.formulario_aplicacion;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zeglius.formulario_aplicacion.activities.DNI_mostrar;
import com.zeglius.formulario_aplicacion.model.Dni;
import com.zeglius.formulario_aplicacion.utils.Utils;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_DNI = "com.zeglius.formulario_aplicacion.extra.DNI";


    /**
     * @noinspection unused
     */
    private static final String TAG = MainActivity.class.getSimpleName();

    //<editor-fold desc="Views">
    private EditText apellidoEditText;
    private EditText apellido2EditText;
    private EditText nombreEditText;
    private RadioGroup sexoRadioGroup;
    private EditText fechaNaciEditText;
    private Button crearDNIButton;
    //</editor-fold>

    //<editor-fold desc="Variables">
    private String apellido;
    private String apellido2;
    private String nombre;
    private String sexo;
    private String fechaNaci;
    //</editor-fold>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bindear vistas
        setupViewsRefs();

        // Bindear variables a vistas
        Utils.bindVarToEditText(apellidoEditText, s -> apellido = s);
        Utils.bindVarToEditText(apellido2EditText, s -> apellido2 = s);
        Utils.bindVarToEditText(nombreEditText, s -> nombre = s);
        Utils.bindVarToEditText(fechaNaciEditText, s -> fechaNaci = s);
        sexoRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.hombreRadioButton) sexo = "H";
            if (checkedId == R.id.mujerRadioButton) sexo = "M";
        });


        Utils.setupDatePicker(this, fechaNaciEditText, fechaNaciEditText, "dd MM yyyy");
        crearDNIButton.setOnClickListener(v -> {
            // Obten el dni
            Dni dni = buildDni();
            if (dni == null) return;

            startDniMostrarActivity(this, dni);
        });
    }

    public static void startDniMostrarActivity(Context context, Dni dni) {
        Intent intent = new Intent(context, DNI_mostrar.class);
        intent.putExtra(MainActivity.EXTRA_DNI, dni);

        context.startActivity(intent);
    }


    //<editor-fold desc="Utils">
    private void setupViewsRefs() {
        apellidoEditText = findViewById(R.id.apellidoTextEdit);
        apellido2EditText = findViewById(R.id.apellido2TextEdit);
        nombreEditText = findViewById(R.id.nombreTextEdit);
        sexoRadioGroup = findViewById(R.id.sexoRadioGroup);
        fechaNaciEditText = findViewById(R.id.fechaNaciTextEdit);
        crearDNIButton = findViewById(R.id.crearDNIButton);
    }
    //</editor-fold>

    private Dni buildDni() {
        Dni dni = null;
        build:
        {
            // Comprueba valores
            boolean isValid = true;
            if (apellido == null) {
                Toast.makeText(this, "apellido es invalido", Toast.LENGTH_SHORT).show();
                break build;
            }
            if (apellido2 == null) {
                Toast.makeText(this, "apellido2 es invalido", Toast.LENGTH_SHORT).show();
                break build;
            }
            if (nombre == null) {
                Toast.makeText(this, "nombre es invalido", Toast.LENGTH_SHORT).show();
                break build;
            }

            if (sexo == null) {
                Toast.makeText(this, "sexo es invalido", Toast.LENGTH_SHORT).show();
                break build;
            }

            if (fechaNaci == null) {
                Toast.makeText(this, "fecha de nacimiento es invalida", Toast.LENGTH_SHORT).show();
                break build;
            }

            dni = new Dni(
                    apellido,
                    apellido2,
                    nombre,
                    sexo,
                    fechaNaci
            );
        }

        return dni;
    }

}