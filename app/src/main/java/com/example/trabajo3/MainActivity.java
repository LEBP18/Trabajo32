package com.example.trabajo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView monedaUno, monedaDos, tvResultado;
    private EditText monedaDolar, monedaEuro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monedaUno = findViewById(R.id.tvMoneda1);
        monedaDos = findViewById(R.id.tvMoneda2);
        tvResultado = findViewById(R.id.tvResultado);
        monedaDolar = findViewById(R.id.etValorDolares);
        monedaEuro = findViewById(R.id.etValorEuros);
        monedaDolar.setEnabled(false);
        monedaEuro.setEnabled(false);
    }

    public void rbClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButtonD:
                if (checked)
                monedaDolar.setEnabled(true);
                monedaEuro.setEnabled(false);
                break;
            case R.id.radioButtonE:
                if (checked)
                monedaEuro.setEnabled(true);
                monedaDolar.setEnabled(false);
                break;
        }
    }

    public void convertir(View v) {
        double valor;
        double resultado;
        String signo;
        DecimalFormat format = new DecimalFormat("#.00");

        if (monedaDolar.isEnabled()) {
                valor = Double.parseDouble(monedaDolar.getText().toString());
                resultado = valor * 0.85;
                signo = "€";
                String resString = signo + format.format(resultado);
                tvResultado.setText(resString);
        } else {
            if (monedaEuro.isEnabled()){
                valor = Double.parseDouble(monedaEuro.getText().toString());
                resultado = valor * 1.18;
                signo = "u$s";
                String resString = signo + format.format(resultado);
                tvResultado.setText(resString);}
            }
        }
    }
