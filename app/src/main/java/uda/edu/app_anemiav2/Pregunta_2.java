package uda.edu.app_anemiav2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Pregunta_2 extends AppCompatActivity {

    private String val, val_cel, val_genero, val_lat, val_long, valp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2);

        //recuperar información de las actividades anteriores
        Intent intent = getIntent() ;
        val = intent.getStringExtra("edad");
        val_cel = intent.getStringExtra("celular");
        val_genero = intent.getStringExtra("genero");
        val_lat = intent.getStringExtra("latitud");
        val_long = intent.getStringExtra("longitud");
        valp1 = intent.getStringExtra("Pregunta_1");
    }
    public void Sig (View view){
        String Resp_p2 = "";

        RadioGroup grupo = findViewById(R.id.editP2);
        if (grupo.getCheckedRadioButtonId() == R.id.radio_p2_si) {
            Resp_p2 = "Si";}
        if (grupo.getCheckedRadioButtonId() == R.id.radio_p2_no) {
            Resp_p2 = "No";}

        Intent i = new Intent( this, Pregunta_3.class);
        i.putExtra("edad",val);
        i.putExtra("celular",val_cel);
        i.putExtra("genero",val_genero);
        i.putExtra("latitud",val_lat);
        i.putExtra("longitud", val_long);
        i.putExtra("Pregunta_1", valp1);
        i.putExtra("Pregunta_2", Resp_p2);
        startActivity(i);
    }
}