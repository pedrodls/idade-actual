package com.example.anoactual;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void calcularIdade(View view) {

        EditText ano_nasc = (EditText) findViewById(R.id.edtxAno);

        Integer anoActual = LocalDateTime.now().getYear();

        if(!ano_nasc.getText().toString().equals("")){

            AlertDialog.Builder a = new AlertDialog.Builder(this);

            a.setTitle("Reultado obtido");

            Integer idadeActual = anoActual - Integer.parseInt(ano_nasc.getText()+"");

            Integer idadeFutura = 2050 - Integer.parseInt(ano_nasc.getText()+"");

            a.setMessage("Ano actual: "+anoActual+" Idade: "+idadeActual+
                         "\nAno futuro: 2050 " + " Idade: "+idadeFutura
                    );

            a.create().show();
        }else {
            Toast.makeText(this,"Insira o ano de nascimento", Toast.LENGTH_SHORT)
                 .show();
        }
    }
}