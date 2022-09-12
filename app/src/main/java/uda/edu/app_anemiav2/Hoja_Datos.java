package uda.edu.app_anemiav2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import static java.lang.Math.abs;
import java.util.Calendar;

public class Hoja_Datos extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_FINE_LOCATION = 2;
    final long LOCATION_REFRESH_TIME = 5000;
    final float LOCATION_REFRESH_DISTANCE = 5;
    LocationManager mLocationManager = null;

    private final LocationListener mLocationListener = new
            LocationListener() {
                @Override
                public void onLocationChanged(final Location location) {
                    String coordenadas = "Lat:" +
                            String.valueOf(location.getLatitude()) + " Long:" +
                            String.valueOf(location.getLongitude());
                    Log.d("gps", coordenadas);
                   // TextView txtubicacion = findViewById(R.id.coordenadas);
                   // txtubicacion.setText(coordenadas);
                   // txtubicacion.setTextColor(Color.BLACK);
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                }

                @Override
                public void onProviderEnabled(String provider) {
                }

                @Override
                public void onProviderDisabled(String provider) {
                }
    };

    private String latitud, longitud;
    TextView tvDate;
    DatePickerDialog.OnDateSetListener setListener;

    private int year1, month1, day1, year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoja_datos);
        final AlertDialog.Builder dialogopermisos = null;
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        final AlertDialog.Builder dialogopermisos1 = new AlertDialog.Builder(this);

        TextView cel = findViewById(R.id.editCelular);
        cel.setTextColor(0xff000000);

        if (getBaseContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            dialogopermisos1.setTitle("Se requieren permisos para obtener localización precisa");
            dialogopermisos1.setMessage("Por favor ingrese los permisos");
            dialogopermisos1.setPositiveButton(android.R.string.ok, null);
            dialogopermisos1.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_FINE_LOCATION);
                }
            });
            dialogopermisos1.show();
        }

        if (getBaseContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "No se tienen los permisos.  Reinicie la aplicación", Toast.LENGTH_SHORT).show();
//            TextView txtmsg = findViewById(R.id.defecto);
//            txtmsg.setText("Reiniciar aplicacion");
        } else {
            //mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,LOCATION_REFRESH_TIME, LOCATION_REFRESH_DISTANCE, mLocationListener);
        }

        //FECHA DE NACIMIENTO
        tvDate = findViewById(R.id.editEdad);

        Calendar calendar = Calendar.getInstance();
        //final int year = calendar.get(Calendar.YEAR);
        //final int month = calendar.get(Calendar.MONTH);
        //final int day = calendar.get(Calendar.DAY_OF_MONTH);

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Hoja_Datos.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day){
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);

                year1 = year;
                month1 = month;
                day1 = day;
            }
        };
    }

    public void llamar (View view) {

        if (year1 <= (year - 2) && year1 >= (year - 5)) {

            String pgenero = "";

            Intent i = new Intent(this, Pregunta_1.class);

            int year_act = year - year1;
            int month_act = abs(month - month1 + 1);
            int day_act = abs(day - day1);

            while (year_act != 0) {
                if (year_act != 0) {
                    month_act = month_act + 12;
                    year_act--;
                }
            }

            if (day_act != 0) {
                month_act--;
            }

            TextView intEdad = findViewById(R.id.editEdad);

            EditText intCelular = findViewById(R.id.editCelular);

            RadioGroup grupo = findViewById(R.id.editGenero);
            if (grupo.getCheckedRadioButtonId() == R.id.radio_masculino) {
                pgenero = "Masculino";
            }
            if (grupo.getCheckedRadioButtonId() == R.id.radio_femenino) {
                pgenero = "Femenino";
            }

            if (getBaseContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                {
                    Location inicial = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (inicial != null) {
                        //String coordenadas = "String.valueOf(Math.round(inicial.getLatitude()*100/100)) + "Long:" + String.valueOf(inicial.getLongitude());
                        latitud = String.format("%.4f", inicial.getLatitude());
                        longitud = String.format("%.4f", inicial.getLongitude());
                        String coordenadas = latitud + "; " + longitud;
                        Log.d("gps.click", coordenadas);
                        //   TextView txtubicacion = findViewById(R.id.coordenadas);
                        //    txtubicacion.setText(coordenadas);
                    }
                }
            }

            //i.putExtra("edad", intEdad.getText().toString());
            i.putExtra("edad", String.valueOf(month_act));
            i.putExtra("celular", intCelular.getText().toString());
            i.putExtra("genero", pgenero);
            i.putExtra("latitud", latitud);
            i.putExtra("longitud", longitud);
            startActivity(i);
        } else {
           /* Calendar calendar = Calendar.getInstance();
            int d_i = day, m_i = month - 4, y_i = year - 5;
            int d_f = day, m_f = month - 1, y_f = year - 2;

            int d = d_i - d_f, m = m_i - m_f, y = y_i - y_f;

            String date_i = String.valueOf(d_i)+"/"+String.valueOf(m_i)+"/"+String.valueOf(y_i);
            String date_f = String.valueOf(d_f)+"/"+String.valueOf(m_f)+"/"+String.valueOf(y_f);
            //String d_i = (String) String.valueOf(year), m_i;
            String mensaje_Error = "Debe asignar una edad entre 2 y 5 años.\n" + "Puede escoger entre " + date_i + " y " + date_f;*/

            //String mensaje_Error = "Debe asignar una edad entre 2 y 5 años.\n";
            String mensaje_Error = "La aplicacicón es para niños entre 2 y 5 años.\n";
            Toast toast = Toast.makeText(this, mensaje_Error, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void recuperarcoordenadas(View view) {
      /*  if (getBaseContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            {
                Location inicial = mLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (inicial != null) {
                    //String coordenadas = "String.valueOf(Math.round(inicial.getLatitude()*100/100)) + "Long:" + String.valueOf(inicial.getLongitude());
                    latitud = String.format("%.2f", inicial.getLatitude());
                    longitud = String.format("%.2f", inicial.getLongitude());
                    String coordenadas = latitud + "; "+longitud;
                    Log.d("gps.click", coordenadas);
                    TextView txtubicacion = findViewById(R.id.coordenadas);
                    txtubicacion.setText(coordenadas);
                }
            }
        }*/
        /*RadioGroup grupo = findViewById(R.id.editGenero);
        if (grupo.getCheckedRadioButtonId() == R.id.radio_masculino) {
            Toast.makeText(this, "Masculino", Toast.LENGTH_LONG).show();}
        if (grupo.getCheckedRadioButtonId() == R.id.radio_femenino) {
            Toast.makeText(this, "Feminino", Toast.LENGTH_LONG).show();}*/
    }


}