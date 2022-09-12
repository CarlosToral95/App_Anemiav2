package uda.edu.app_anemiav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int tiempoTranscurrir = 2000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), Hoja_Datos.class);
                startActivity(intent);
                handler.removeCallbacks(null);
            }
        }, tiempoTranscurrir );

    }

    /*public void Sig (View view){
        Intent i = new Intent( this, Hoja_Datos.class);
        startActivity(i);
    }*/
}