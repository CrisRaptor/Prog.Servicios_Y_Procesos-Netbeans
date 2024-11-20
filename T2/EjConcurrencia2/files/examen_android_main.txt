package com.example.examentema3cristiangc;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity2);

        actividad1();

        //actividad2();

        //actividad3();
    }

    private void actividad1() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText user = findViewById(R.id.userEt);
        EditText passwd = findViewById(R.id.passwordEt);
        Button accessBtn = findViewById(R.id.accessBtn);

        //Muestra tras 3 segundos
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                user.setVisibility(View.VISIBLE);
                passwd.setVisibility(View.VISIBLE);
                accessBtn.setVisibility(View.VISIBLE);
            }
        }, 3000);

        //Boton de acceso
        accessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "";
                if (user.getText().length() > 0 && passwd.getText().length() > 0) {
                    message = "Hola " + user.getText() + ". Accediendo a la app";
                } else {
                    message = "Introduce usuario y clave";
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void actividad2() {
        setContentView(R.layout.activity2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Botones que cambian de color
        Button btn1 = findViewById(R.id.loseWeightBtn);//#f3e6f8
        Button btn2 = findViewById(R.id.getStrongerBtn);
        Button btn3 = findViewById(R.id.getFitBtn);

        //Colores
        String unselected = "#f7c1ea";
        String selected = "#f3e6f8";


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor(selected));
                btn2.setBackgroundColor(Color.parseColor(unselected));
                btn3.setBackgroundColor(Color.parseColor(unselected));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor(unselected));
                btn2.setBackgroundColor(Color.parseColor(selected));
                btn3.setBackgroundColor(Color.parseColor(unselected));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setBackgroundColor(Color.parseColor(unselected));
                btn2.setBackgroundColor(Color.parseColor(unselected));
                btn3.setBackgroundColor(Color.parseColor(selected));
            }
        });

        //Boton siguiente
        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Accediendo a la siguiente pantalla", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void actividad3() {
        setContentView(R.layout.activity3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView spinnerText = findViewById(R.id.spinnerLbl);
        Spinner spinner = findViewById(R.id.daySpinner);
        //Cambia el Texto debajo de spinner al texto seleccionado en el spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerText.setText(spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}