package com.example.pc.siscomp.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import com.example.pc.siscomp.R;

import java.util.Calendar;

public class WholesaleOrderActivity extends AppCompatActivity {

    Button btnDate;
    Button btnQty;
    Calendar calendar;
    String cero = "0";
    String slash = "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wholesale_order);
        btnDate = (Button) findViewById(R.id.btnDate);
        btnDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        btnQty = (Button)findViewById(R.id.btnQty);
        btnQty.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                showNumberPicker();
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        calendar = Calendar.getInstance();
        String _date = calendar.get(Calendar.DAY_OF_MONTH) + slash + calendar.get(Calendar.MONTH) + slash + calendar.get(Calendar.YEAR);
        btnDate.setText(_date);
    }

    private void showNumberPicker() {
        final Dialog dialogUI = new Dialog(WholesaleOrderActivity.this);
        dialogUI.setTitle("NumberPicker");
        dialogUI.setContentView(R.layout.dialog_number_picker);
        Button b1 = (Button) dialogUI.findViewById(R.id.button1);
        Button b2 = (Button) dialogUI.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) dialogUI.findViewById(R.id.numberPicker1);
        np.setMaxValue(100);
        np.setMinValue(0);
        np.setWrapSelectorWheel(false);
//        np.setOnValueChangedListener(d);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                btnQty.setText(String.valueOf(np.getValue()));
                dialogUI.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                dialogUI.dismiss();
            }
        });
        dialogUI.show();
    }

    private void showDatePicker() {
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? cero + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? cero + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                btnDate.setText(diaFormateado + slash + mesFormateado + slash + year);


            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        //Muestro el widget
        recogerFecha.show();
    }
}
