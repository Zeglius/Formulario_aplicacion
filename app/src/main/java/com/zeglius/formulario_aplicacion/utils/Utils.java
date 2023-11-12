package com.zeglius.formulario_aplicacion.utils;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public final class Utils {
    private Utils() {
        // no instance
    }

    /**
     * Bind the value of a {@link EditText} to a lambda. Can be used to bind EditText text to a
     * String variable like this:
     * <p>
     * <pre>
     * bindVarToEditText(myEditText, s -> myString = s);
     * </pre>
     *
     * @param editText view that the consumer is tied to
     * @param consumer lambda to execute in {@link TextView#addTextChangedListener(TextWatcher)}
     */
    public static void bindVarToEditText(EditText editText, Consumer<String> consumer) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                consumer.accept(s.toString());
            }
        });
    }


    /**
     * Generate a {@link DatePickerDialog} and bind it to a trigger a receiver
     *
     * @param context            Context of the activity
     * @param clickedViewTrigger View that, when clicked, will open the date picker
     * @param textViewReceiver   {@link TextView} that will receive the date text
     * @param dateFormat         Date pattern passed to
     *                           {@link SimpleDateFormat#applyPattern(String)}
     */
    public static void setupDatePicker(Context context,
                                       View clickedViewTrigger,
                                       TextView textViewReceiver,
                                       String dateFormat) {
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

    /**
     * Generate a {@link TimePickerDialog} and bind it to a trigger a receiver
     *
     * @param context            Context of the activity
     * @param clickedViewTrigger View that, when clicked, will open the date picker
     * @param textViewReceiver   {@link TextView} that will receive the date text
     * @param timeFormat         Time pattern passed to
     *                           {@link SimpleDateFormat#applyPattern(String)}
     * @param is24HourView       Is 24 hour view
     * @noinspection unused
     */
    public static void setupTimePicker(Context context,
                                       View clickedViewTrigger,
                                       TextView textViewReceiver,
                                       String timeFormat,
                                       boolean is24HourView) {
        final Calendar myCalendar = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener onTimeSetListener = (view, hourOfDay, minute) -> {
            myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            myCalendar.set(Calendar.MINUTE, minute);
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sd = new SimpleDateFormat();
            sd.applyPattern(timeFormat);
            textViewReceiver.setText(sd.format(myCalendar.getTime()));
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(context,
                onTimeSetListener,
                myCalendar.get(Calendar.HOUR_OF_DAY),
                myCalendar.get(Calendar.MINUTE),
                is24HourView
        );

        clickedViewTrigger.setOnClickListener(v -> timePickerDialog.show());
    }

    public static ArrayList<Character> abcChars() {
        ArrayList<Character> list = new ArrayList<>();

        // Populate list
        for (int i = 65; i <= 90; i++) {
            list.add((char) i);
        }
        return list;
    }

    /**
     * @noinspection unused
     */
    public static ArrayList<String> abcStrings() {
        ArrayList<String> list = new ArrayList<>();

        // Populate list
        for (int i = 65; i <= 90; i++) {
            list.add(String.valueOf((char) i));
        }
        return list;
    }

    /**
     * Return a random selection of elements from a list.
     *
     * @param list List from which we pick the elements
     * @noinspection unused
     */
    public static <T> List<T> randomChoice(List<T> list) {
        return randomChoice(list, list.size());
    }

    /**
     * Return a random selection of elements from a list.
     *
     * @param list List from which we pick the elements
     * @param size Size of the selection.
     * @noinspection unused
     */
    public static <T> List<T> randomChoice(List<T> list, int size) {
        List<T> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int idx = (int) (Math.random() * 10 % list.size());
            res.add(list.get(idx));
        }
        return res;
    }

    public static void repeat(int number, Consumer<Integer> action) {
        IntStream.range(0, number).forEach(action::accept);
    }
}
