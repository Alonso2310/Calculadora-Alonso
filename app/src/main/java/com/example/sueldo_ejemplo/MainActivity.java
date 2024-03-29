package com.example.sueldo_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtHoras, txtDias, txtpago, txtdcto, txtsueldo;
    private CheckBox chbxPago, chbxDcto;
    private RadioGroup rgRedondeo;
    private RadioButton rbRedondeo, rbNoRedondeo;
    private Button btnLimpiar, btnCalcular;
    private TextView lbl_pago, lbl_dcto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtsueldo = (EditText)findViewById(R.id.txtsueldo);
        txtpago = (EditText)findViewById(R.id.txtpago);
        txtdcto = (EditText)findViewById(R.id.txtdcto);
        txtHoras = (EditText)findViewById(R.id.txtHoras);
        txtDias = (EditText)findViewById(R.id.txtDias);
        chbxPago = (CheckBox)findViewById(R.id.chbxPago);
        chbxDcto = (CheckBox)findViewById(R.id.chbxDcto);
        rgRedondeo = (RadioGroup)findViewById(R.id.rgRedondeo);
        rbNoRedondeo = (RadioButton)findViewById(R.id.rbNoRedondeo);
        btnLimpiar = (Button)findViewById(R.id.btnLimpiar);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);
        lbl_dcto = (TextView)findViewById(R.id.lbl_dcto);
        lbl_pago = (TextView)findViewById(R.id.lbl_pagofinal);

    }

    public void calcular (View view){

        int horas = Integer.parseInt(txtHoras.getText().toString());
        int dias = Integer.parseInt(txtDias.getText().toString());
        int horas_mensuales = horas*dias;
        int pago_por_horas = Integer.parseInt(txtpago.getText().toString());
        int sbase = Integer.parseInt(txtsueldo.getText().toString());


        double pago = horas_mensuales * pago_por_horas;
        double desc = Double.parseDouble(txtdcto.getText().toString());
        double desc2;




        if(chbxPago.isChecked() == true){
            lbl_pago.setText(String.valueOf(pago));
        }


        if(chbxDcto.isChecked() == true && pago > sbase){
            desc = (desc/100)* pago;

            lbl_dcto.setText(String.valueOf(desc));
            pago = pago - desc;
            lbl_pago.setText(String.valueOf(pago));


        }



        else if(chbxDcto.isChecked() == true && pago < sbase){
            desc = 0;
            lbl_dcto.setText(String.valueOf(desc));
            pago = pago;
            lbl_pago.setText(String.valueOf(pago));

        }




        if (rgRedondeo.getCheckedRadioButtonId() == R.id.rbRedondeo) {
            int pago_redondeo = (int)Math.round(pago);
            lbl_pago.setText(String.valueOf(pago_redondeo));
            int dcto_redondeo = (int)Math.round((desc));
            lbl_dcto.setText(String.valueOf(dcto_redondeo));
        }


    }

    public void limpiar(View view){

        txtHoras.setText(String.valueOf(""));
        txtDias.setText(String.valueOf(""));
        txtpago.setText(String.valueOf(""));
        txtdcto.setText(String.valueOf(""));
        txtsueldo.setText(String.valueOf(""));
        lbl_pago.setText(String.valueOf(""));
        lbl_dcto.setText(String.valueOf(""));


        if(chbxPago.isChecked()==true){
            chbxPago.setChecked(false);
        }

        if(chbxDcto.isChecked()==true) {
            chbxDcto.setChecked(false);
        }

        if(rgRedondeo.getCheckedRadioButtonId()==R.id.rbRedondeo){
            rbRedondeo.setChecked(false);

        }

        if(rgRedondeo.getCheckedRadioButtonId()==R.id.rbNoRedondeo){
            rbNoRedondeo.setChecked(false);
        }


    }
}
