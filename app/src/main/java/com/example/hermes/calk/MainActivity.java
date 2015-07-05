package com.example.hermes.calk;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class MainActivity extends ActionBarActivity {

    TextView T;
    ArrayList<Integer> A;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T = (TextView) findViewById(R.id.tv);
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
        if (id == R.id.about) {
            gotoAbout();
            return true;
        }

        if (id == R.id.exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void igual(View b) {
        char Operador = '*';
        Integer primerOperando = new Integer(0);
        Integer segundoOperando = new Integer(0);
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
                Toast.makeText(getApplicationContext(),"No puedes dividir por cero", Toast.LENGTH_SHORT).show();
                T.setText("ERROR");
            }
            else {
                resultado = primerOperando / segundoOperando;
                result = resultado.toString();
            }
        }

        Log.i("HOLA", "PrimerOperando = " + primerOperando.toString());
        Log.i("HOLA", "SegundoOperando = " + segundoOperando.toString());
        Log.i("HOLA", "Operador = " + Operador);
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

        public void gotoAbout() {
            Intent intent = new Intent(this,About.class);
            startActivity(intent);
        }




}
