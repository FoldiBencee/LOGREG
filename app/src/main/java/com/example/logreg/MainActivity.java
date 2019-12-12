package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private adatbazissegito adatbazissegito;
    private EditText edtxtFelhasz, edtxtPassword;
    private Button bttnBejelentkezes, bttnRegisztracio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bttnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_adatbazissegito);

                adatRogzites();
                finish();
            }
        });
        bttnBejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_logged_in);
            }
        });
    }

    public void init()
    {
        adatbazissegito = new adatbazissegito(this);
        edtxtFelhasz = findViewById(R.id.edtxtFelhasz);
        edtxtPassword = findViewById(R.id.edtxtPassword);
        bttnBejelentkezes = findViewById(R.id.bttnBejelentkezes);
        bttnRegisztracio = findViewById(R.id.bttnRegisztracio);
    }

    public  void adatRogzites()
    {
        String felhasznalonev = edtxtFelhasz.getText().toString();
        String jelszo = edtxtPassword.getText().toString();
        Boolean eredmeny = adatbazissegito.adatRogzites(felhasznalonev,jelszo);
        if (eredmeny)
            Toast.makeText(this, "Adatrogzites sikeres", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Adatrogzites sikertelen", Toast.LENGTH_SHORT).show();



    }




}
