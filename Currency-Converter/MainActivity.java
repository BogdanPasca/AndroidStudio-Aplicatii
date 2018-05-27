package com.example.user.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClick(View view) {
        //Campul pentru euro
        EditText valoareTextField = (EditText) findViewById(R.id.valoareTextField);
        //Campul rezultat pentru lei
        EditText valoareaRezultataField = (EditText) findViewById(R.id.valoareaRezultataField);
        String primaValoare = valoareTextField.getText().toString();
        //Variabila valoareaFinala este initializata cu valoarea in lei a euro
        Double valoareaFinala = Double.valueOf(primaValoare) * 4.62;
        //Se transforma Double in String si se afiseaza valoarea finala in al doilea TextField din aplicatie.
        valoareaRezultataField.setText(Double.toString(valoareaFinala) + " lei");
        // Afiseaza un "Toast" cu valoarea finala in lei.
        Toast.makeText(MainActivity.this, primaValoare + " euro: " + Double.valueOf(primaValoare) * 4.62 + " lei. ", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
