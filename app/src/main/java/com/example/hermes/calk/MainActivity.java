package com.example.hermes.calk;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class MainActivity extends ActionBarActivity {
    TextView T;
    Integer primerOperando = new Integer(0);
    Integer segundoOperando = new Integer(0);
    ArrayList<Integer> A = new ArrayList<>();
    Integer ANS;
    int codeNot;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SharedPreferences sharedP = getSharedPreferences("myData",Context.MODE_PRIVATE);
        codeNot = sharedP.getInt("codeNot",1);
        ANS = sharedP.getInt("ANS",0);

        T = (TextView) findViewById(R.id.textView2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Esta calculadora solo acepta operaciones entre dos operandos. Tambien debe saberse" +
                " que para que funcione bien, despues de cada operacion es preciso presionar la tecla C para asi " +
                "poder efectuar una nueva. Disculpen las molestias.\n \n" +
                "Atentamente: Un baby-developer.")
                .setTitle("Manual de uso")
                .setPositiveButton("ACEPTO LAS CONDICIONES DE USO", null)
                .setIcon(R.drawable.calk)
                .show();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        int ID = getIntent().getIntExtra("ID",8);
        nm.cancel(ID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.toast) {
            codeNot = 1;
            SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("codeNot", codeNot);
            editor.apply();
        }

        else if (id == R.id.state) {
            codeNot = 2;
            SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("codeNot", codeNot);
            editor.apply();
        }


        return super.onOptionsItemSelected(item);
    }

    public void igual(View b) {
        char Operador = '*';
        Integer resultado = new Integer(0);
        String result = "";
        int i = 0;
        while (A.get(i) < 10) {
            primerOperando = primerOperando*10;
            primerOperando = primerOperando + A.get(i);
            ++i;
        }
        if (A.get(i) >= 10) {
            if (A.get(i) == 10) Operador = '+';
            else if (A.get(i) == 11) Operador = '-';
            else if (A.get(i) == 12) Operador = 'x';
            else Operador = '/';
        }
        ++i;
        while (i < A.size()) {
            segundoOperando = segundoOperando * 10;
            segundoOperando = segundoOperando + A.get(i);
            ++i;
        }

        if (Operador == '+') {
            resultado = primerOperando + segundoOperando;
            result = resultado.toString();
            T.setText(result);
        }
        else if (Operador == '-') {
            resultado = primerOperando - segundoOperando;
            result = resultado.toString();
            T.setText(result);
        }
        else if (Operador == 'x') {
            resultado = primerOperando * segundoOperando;
            result = resultado.toString();
            T.setText(result);
        }
        else if (Operador == '/') {
            if (segundoOperando == 0) {
                if (codeNot == 1) {
                    Toast.makeText(getApplicationContext(), "No puedes dividir por cero", Toast.LENGTH_SHORT).show();
                }
                else if (codeNot == 2){
                    notificationAlert();
                }
                T.setText("ERROR");
            }
            else {
                resultado = primerOperando / segundoOperando;

                result = resultado.toString();
                T.setText(result);
            }
        }

        Log.i("HOLA", "PrimerOperando = " + primerOperando.toString());
        Log.i("HOLA", "SegundoOperando = " + segundoOperando.toString());
        Log.i("HOLA", "Operador = " + Operador);
        ANS = resultado;
        SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("ANS", ANS);
        editor.apply();

    }

    public void ansjeje(View v) {
        T.setText(T.getText().toString() + "ANS");
        A.add(ANS);
        Toast.makeText(getApplicationContext(),"ANS: "+ ANS.toString(),Toast.LENGTH_SHORT).show();
    }




    public void calcula(View b) {
        if (b.getId() == R.id.uno) {
            T.setText(T.getText().toString() + '1');
            A.add(1);
        }
        if (b.getId() == R.id.dos) {
            T.setText(T.getText().toString() + '2');
            A.add(2);
        }
        if (b.getId() == R.id.tres) {
            T.setText(T.getText().toString() + '3');
            A.add(3);
        }
        if (b.getId() == R.id.cuatro) {
            T.setText(T.getText().toString() + '4');
            A.add(4);
        }
        if (b.getId() == R.id.cinco) {
            T.setText(T.getText().toString() + '5');
            A.add(5);
        }
        if (b.getId() == R.id.seis) {
            T.setText(T.getText().toString() + '6');
            A.add(6);
        }
        if (b.getId() == R.id.siete) {
            T.setText(T.getText().toString() + '7');
            A.add(7);
        }
        if (b.getId() == R.id.ocho) {
            T.setText(T.getText().toString() + '8');
            A.add(8);
        }
        if (b.getId() == R.id.nueve) {
            T.setText(T.getText().toString() + '9');
            A.add(9);
        }
        if (b.getId() == R.id.cero) {
            T.setText(T.getText().toString() + '0');
            A.add(0);
        }
        if (b.getId() == R.id.mas) {
            T.setText(T.getText().toString() + '+');
            A.add(10);
        }
        if (b.getId() == R.id.menos) {
            T.setText(T.getText().toString() + '-');
            A.add(11);
        }
        if (b.getId() == R.id.por) {
            T.setText(T.getText().toString() + 'x');
            A.add(12);
        }
        if (b.getId() == R.id.entre) {
            T.setText(T.getText().toString() + '/');
            A.add(13);
        }

    }

        public void reset(View b) {
            T.setText("");
            A.clear();
            primerOperando = 0;
            segundoOperando = 0;
        }

    public void llama(View v) {
        Log.i("INTENTOS", "ENTRO POR EL LLAMA");
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+T.getText().toString()));
            startActivity(intent);
        }

        public void web (View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.google.com"));
            startActivity(intent);
        }

        public void ans (View v) {
            T.setText(T.getText().toString() + "ANS");
        }

    public void notificationAlert() {
        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(getApplicationContext());
        notificacion.setSmallIcon(R.drawable.error);
        notificacion.setWhen(System.currentTimeMillis());
        notificacion.setContentTitle("Error matematico");
        notificacion.setContentText("No puedes dividir entre 0");


        Uri sonido = RingtoneManager.getDefaultUri(Notification.DEFAULT_SOUND);
        notificacion.setSound(sonido);


        Bitmap icono = BitmapFactory.decodeResource(getResources(),R.drawable.calk);
        notificacion.setLargeIcon(icono);

        PendingIntent myPendingIntent;
        Intent myIntent = new Intent();
        Context myContext = getApplicationContext();

        myIntent.setClass(myContext, MainActivity.class);

        myIntent.putExtra("ID", 1);


        myPendingIntent = PendingIntent.getActivity(myContext,0,myIntent,0);
        notificacion.setContentIntent(myPendingIntent);

        Notification n = notificacion.build();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1,n);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        T = (TextView) findViewById(R.id.textView2);
        String J = T.getText().toString();
        outState.putString("pantalla",J);
        Toast.makeText(getApplicationContext(),"save: " + J + " or " +T.getText().toString(), Toast.LENGTH_SHORT).show();
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        T = (TextView) findViewById(R.id.textView2);
        super.onRestoreInstanceState(savedInstanceState);
        String A = savedInstanceState.getString("pantalla");
        Toast.makeText(getApplicationContext(),"restore: " + A + " or " + savedInstanceState.getString("pantalla"), Toast.LENGTH_SHORT).show();
        T.setText(A);
    }
}