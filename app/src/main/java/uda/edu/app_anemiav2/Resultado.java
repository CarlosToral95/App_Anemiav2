package uda.edu.app_anemiav2;

import static uda.edu.app_anemiav2.R.color.black;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedInputStream;
import java.io.IOException;

public class Resultado extends AppCompatActivity {

    //private String val;
    String presultado;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        //recuperar información de las actividades anteriores
        TextView txt_edad = findViewById(R.id.txt_edad);
        Intent intent = getIntent() ;
        txt_edad.setText(intent.getStringExtra("edad"));
        TextView txt_celular = findViewById(R.id.txt_celular);
        txt_celular.setText(intent.getStringExtra("celular"));
        TextView txt_genero = findViewById(R.id.txt_sexo);
        txt_genero.setText(intent.getStringExtra("genero"));
        TextView txt_latitud = findViewById(R.id.txt_lat);
        txt_latitud.setText(intent.getStringExtra("latitud"));
        TextView txt_longitud = findViewById(R.id.txt_long);
        txt_longitud.setText(intent.getStringExtra("longitud"));
        TextView txt_preg1 = findViewById(R.id.txt_p1);
        txt_preg1.setText(intent.getStringExtra("Pregunta_1"));
        TextView txt_preg2 = findViewById(R.id.txt_p2);
        txt_preg2.setText(intent.getStringExtra("Pregunta_2"));
        TextView txt_preg3 = findViewById(R.id.txt_p3);
        txt_preg3.setText(intent.getStringExtra("Pregunta_3"));

        String mensaje_M = " ", mensaje_2_M= " ", mensaje_F = " ", mensaje_2_F= " ";
        //txt_mensaje = (TextView) findViewById(R.id.txt_msj);
        TextView txt_mensaje = findViewById(R.id.txt_msj);
        //txt_mensaje.setText(intent.getStringExtra("Pregunta_3"));
        mensaje_M = new String ("Su hijo tiene sospecha de anemia, acuda al centro de salud.");
        mensaje_2_M = new String("Su hijo no tiene sospecha de anemia");
        mensaje_F = new String ("Su hija tiene sospecha de anemia, acuda al centro de salud.");
        mensaje_2_F = new String("Su hija no tiene sospecha de anemia");
        //val helloWorldText: TextView = findViewById(R.id.hello_world_text);
        //helloWorldText.text = "Nuevo texto";


        ImageView ninoa_img = (ImageView) findViewById(R.id.imageView8);
        ninoa_img.setVisibility(View.INVISIBLE);
        ImageView ninob_img = (ImageView) findViewById(R.id.imageView9);
        ninob_img.setVisibility(View.INVISIBLE);
        ImageView ninaa_img = (ImageView) findViewById(R.id.imageView10);
        ninaa_img.setVisibility(View.INVISIBLE);
        ImageView ninab_img = (ImageView) findViewById(R.id.imageView11);
        ninab_img.setVisibility(View.INVISIBLE);


        TextView txt_msj = (TextView) findViewById(R.id.txt_msj);
        
        if (txt_preg1.getText().equals("Si") && txt_preg2.getText().equals("Si")) {
            if(txt_genero.getText().equals("Masculino")){
                txt_msj.setText(mensaje_M);
                //agregar resultado
                presultado = "S";

                txt_msj.setTextColor(0xffff0000);
                ninoa_img.setVisibility(View.VISIBLE);
            }else if(txt_genero.getText().equals("Femenino")){
                txt_msj.setText(mensaje_F);
                txt_msj.setTextColor(0xffff0000);
                ninaa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";


            }
//            txt_msj.setText(mensaje);
//            txt_msj.setTextColor(0xffff0000);
//            txt_msj.setTextColor(0xffb90f00);
        }else if (txt_preg1.getText().equals("Si") && txt_preg3.getText().equals("Si")){
            if(txt_genero.getText().equals("Masculino")){
                txt_msj.setText(mensaje_M);
                txt_msj.setTextColor(0xffff0000);
                ninoa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }else if(txt_genero.getText().equals("Femenino")){
                txt_msj.setText(mensaje_F);
                txt_msj.setTextColor(0xffff0000);
                ninaa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }
//            txt_msj.setText(mensaje);
//            txt_msj.setTextColor(0xffff0000);
//            txt_msj.setTextColor(0xffb90f00);
        }else if (txt_preg1.getText().equals("Si") && txt_preg2.getText().equals("Si") && txt_preg3.getText().equals("Si")){
            if(txt_genero.getText().equals("Masculino")){
                txt_msj.setText(mensaje_M);
                txt_msj.setTextColor(0xffff0000);
                ninoa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }else if(txt_genero.getText().equals("Femenino")){
                txt_msj.setText(mensaje_F);
                txt_msj.setTextColor(0xffff0000);
                ninaa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }
//            txt_msj.setText(mensaje);
//            txt_msj.setTextColor(0xffff0000);
//            txt_msj.setTextColor(0xffb90f00);
        }else if (txt_preg1.getText().equals("Si")){
            if(txt_genero.getText().equals("Masculino")){
                txt_msj.setText(mensaje_M);
                txt_msj.setTextColor(0xffff0000);
                ninoa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }else if(txt_genero.getText().equals("Femenino")){
                txt_msj.setText(mensaje_F);
                txt_msj.setTextColor(0xffff0000);
                ninaa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }
//            txt_msj.setText(mensaje);
//            txt_msj.setTextColor(0xffff0000);
//            txt_msj.setTextColor(0xffb90f00);
        }else if (txt_preg2.getText().equals("Si") && txt_preg3.getText().equals("Si")){
            if(txt_genero.getText().equals("Masculino")){
                txt_msj.setText(mensaje_M);
                txt_msj.setTextColor(0xffff0000);
                ninoa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }else if(txt_genero.getText().equals("Femenino")){
                txt_msj.setText(mensaje_F);
                txt_msj.setTextColor(0xffff0000);
                ninaa_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "S";

            }
//            txt_msj.setText(mensaje);
//            txt_msj.setTextColor(0xffff0000);
//            txt_msj.setTextColor(0xffb90f00);
        } else {
            if(txt_genero.getText().equals("Masculino")){
                txt_msj.setText(mensaje_2_M);
                txt_msj.setTextColor(0xff00ff00);
                ninob_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "N";

            }else if(txt_genero.getText().equals("Femenino")){
                txt_msj.setText(mensaje_2_F);
                txt_msj.setTextColor(0xff00ff00);
                ninab_img.setVisibility(View.VISIBLE);
                //agregar resultado
                presultado = "N";

            }
//            txt_msj.setText(mensaje_2);
//            txt_msj.setTextColor(0xff00ff00);
            //txt_msj.setBackgroundColor(0xff00ff00);
        }
    }


    public void grabar(View view) {

        TextView tedad = findViewById(R.id.txt_edad);
        TextView tsexo = findViewById(R.id.txt_sexo);
        TextView tlong = findViewById(R.id.txt_long);
        TextView tlat = findViewById(R.id.txt_lat);
        TextView tcel = findViewById(R.id.txt_celular);
        TextView tp1 = findViewById(R.id.txt_p1);
        TextView tp2 = findViewById(R.id.txt_p2);
        TextView tp3 = findViewById(R.id.txt_p3);

        String pedad = tedad.getText().toString();
        String psexo = tsexo.getText().toString();
        String plongitud = tlong.getText().toString();
        String platitud = tlat.getText().toString();
        String ptelefono = tcel.getText().toString();
        String pregunta1 = tp1.getText().toString();
        String pregunta2 = tp2.getText().toString();
        String pregunta3 = tp3.getText().toString();

        /*
        psexo = intent.getStringExtra("sexo");
        ptelefono = intent.getStringExtra("telefono");
        platitud = intent.getStringExtra("latitud");
        plongitud = intent.getStringExtra("longitud");
        pregunta1 = intent.getStringExtra("pregunta1");
        pregunta2 = intent.getStringExtra("pregunta2");
        pregunta3 = intent.getStringExtra("pregunta3");
        */

        RequestQueue queue = Volley.newRequestQueue(this);
        //String url = "https://www.google.com";
        //String url = "http://10.0.2.2:8090/pruebasmed/procedimientos/wslecturas.php?latitud=" + platitud + "&";
        String url = "http://172.16.1.60:8090/pruebasmed/procedimientos/wslecturas.php?latitud=" + platitud + "&";
        url += "longitud="+plongitud+"&";
        url += "edad="+pedad+"&";
        url += "sexo="+psexo+"&";
        url += "telefono="+ptelefono+"&";
        url += "p1="+pregunta1+"&";
        url += "p2="+pregunta2+"&";
        url += "p3="+pregunta3+"&";
        url += "resultado="+presultado;

        Log.d("urlws",url);

        //http://localhost:8090/pruebasmed/procedimientos/wslecturas.php?latitud=10&longitud=20&
        // edad=10&sexo=F&telefono=9999&p1=S&p2=N&p3=N&resultado=N

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        String respuesta = "Estado grabación: " + response.substring(0, 2);
                        Toast.makeText(getBaseContext(),respuesta,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(),"Error "+error.toString(),Toast.LENGTH_LONG).show();
                Log.d("errorws",error.toString());
                //com.android.volley.NoConnectionError: java.io.IOException: Cleartext HTTP traffic to 10.0.2.2 not permitted
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }


}