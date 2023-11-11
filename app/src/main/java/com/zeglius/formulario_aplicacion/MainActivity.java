package com.zeglius.formulario_aplicacion;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.zeglius.formulario_aplicacion.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    /**
     * @noinspection unused
     */
    private static final String TAG = MainActivity.class.getName();

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
        bindViews();

        // Bindear variables a vistas
        Utils.bindVarToEditText(apellidoEditText, s -> apellido = s);
        Utils.bindVarToEditText(apellido2EditText, s -> apellido2 = s);
        Utils.bindVarToEditText(nombreEditText, s -> nombre = s);
        sexoRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.hombreRadioButton) sexo = "H";
            if (checkedId == R.id.mujerRadioButton) sexo = "M";
        });

        setupDatePicker(this, fechaNaciEditText, fechaNaciEditText, "dd MM yyyy");
    }

    private void setupDatePicker(Context context, View clickedViewTrigger, TextView textViewReceiver, String dateFormat) {
        final Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sd = new SimpleDateFormat();
            sd.applyPattern(dateFormat);
            textViewReceiver.setText(sd.format(myCalendar.getTime()));
        };

        DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                dateSetListener,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)
        );

        clickedViewTrigger.setOnClickListener(v -> datePickerDialog.show());
    }


    private void bindViews() {
        apellidoEditText = findViewById(R.id.apellidoTextEdit);
        apellido2EditText = findViewById(R.id.apellido2TextEdit);
        nombreEditText = findViewById(R.id.nombreTextEdit);
        sexoRadioGroup = findViewById(R.id.sexoRadioGroup);
        fechaNaciEditText = findViewById(R.id.fechaNaciTextEdit);
    }
    //</editor-fold>


}