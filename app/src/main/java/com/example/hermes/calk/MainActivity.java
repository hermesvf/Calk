package com.example.hermes.calk;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    TextView T;
    Integer primerOper;
    Integer segundoOper;
    String s = null;
    char operator;



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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void operadorMas (View b) {
            T.setText("");
            primerOper = Integer.parseInt(s);
            s = "";
            operator = '+';
        }

    };



    public void calcula (View b) {

        if (b.getId() == R.id.uno) {
            String s = T.getText().toString();
            T.setText(s + '1');
        }
        if (b.getId() == R.id.dos) {
            String s = T.getText().toString();
            T.setText(s + '2');
        }
        if (b.getId() == R.id.tres) {
            String s = T.getText().toString();
            T.setText(s + '3');
        }
        if (b.getId() == R.id.cuatro) {
            String s = T.getText().toString();
            T.setText(s + '4');
        }
        if (b.getId() == R.id.cinco) {
            String s = T.getText().toString();
            T.setText(s + '5');
        }
        if (b.getId() == R.id.seis) {
            String s = T.getText().toString();
            T.setText(s + '6');
        }
        if (b.getId() == R.id.siete) {
            String s = T.getText().toString();
            T.setText(s + '7');
        }
        if (b.getId() == R.id.ocho) {
            String s = T.getText().toString();
            T.setText(s + '8');
        }
        if (b.getId() == R.id.nueve) {
            String s = T.getText().toString();
            T.setText(s + '9');
        }
        if (b.getId() == R.id.cero) {
            String s = T.getText().toString();
            T.setText(s + '0');
        }


    }

}
