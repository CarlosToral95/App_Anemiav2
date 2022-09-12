package uda.edu.app_anemiav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class Pregunta_1 extends AppCompatActivity {
    private String val, val_cel, val_genero, val_lat, val_long;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1);
        //recuperar información de las actividades anteriores

        Intent intent = getIntent() ;
        val = intent.getStringExtra("edad");
        val_cel = intent.getStringExtra("celular");
        val_genero = intent.getStringExtra("genero");
        val_lat = intent.getStringExtra("latitud");
        val_long = intent.getStringExtra("longitud");

//        EditText intEdad = findViewById() ;


    }

    public void Sig (View view){
        String Resp_p1 = "";

        RadioGroup grupo = findViewById(R.id.editP1);
        if (grupo.getCheckedRadioButtonId() == R.id.radio_p1_si) {
            Resp_p1 = "Si";}
        if (grupo.getCheckedRadioButtonId() == R.id.radio_p1_no) {
            Resp_p1 = "No";}

        Intent i = new Intent( this, Pregunta_2.class);
        //Intent i = new Intent( this, Resultado.class);
        i.putExtra("edad",val);
        i.putExtra("celular",val_cel);
        i.putExtra("genero",val_genero);
        i.putExtra("latitud",val_lat);
        i.putExtra("longitud", val_long);
        i.putExtra("Pregunta_1",Resp_p1);
        startActivity(i);
    }
}