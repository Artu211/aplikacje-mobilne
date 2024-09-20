package com.example.myapplication;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity{
    private Button buttonDisable;
    private Button buttonEnable;
    private Button buttonReset;
    TextView txtCount;

    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //wczytanie counta po wznowieniu aplikacji
        if (savedInstanceState != null){
            count = savedInstanceState.getInt("count");
        }

        //ustawienie napisu
        txtCount = (TextView)findViewById(R.id.textView);
        txtCount.setText("Kliknięto przycisk "+String.valueOf(count)+" razy");

        //guzik do wyłączenia
        buttonDisable = findViewById(R.id.buttonDisable);
        buttonDisable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                buttonDisable.setEnabled(false);
                count ++;
                txtCount.setText("Kliknięto przycisk "+String.valueOf(count)+" razy");
                Toast.makeText(MainActivity.this, "Przycisk został wyłączony",Toast.LENGTH_SHORT).show();
            }


        });

        //guzik do włączenia
        buttonEnable = findViewById(R.id.buttonEnable);
        buttonEnable.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                buttonDisable.setEnabled(true);
            }
        });

        //guzik do resetowania licznika
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count = 0;
                txtCount.setText("Kliknięto przycisk "+String.valueOf(count)+" razy");
            }
        });




    }


    //zapisania ilosci kliknięć do instancji
    @Override
    protected  void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("count",count);
    }


} 