package com.example.hermes.calk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Memory extends ActionBarActivity {

    public Integer intentos = 0;
    public TextView points;
    public ImageView one_one;
    public ImageView one_two;
    public ImageView one_three;
    public ImageView one_four;
    public ImageView two_one;
    public ImageView two_two;
    public ImageView two_three;
    public ImageView two_four;
    public ImageView three_one;
    public ImageView three_two;
    public ImageView three_three;
    public ImageView three_four;
    public ImageView four_one;
    public ImageView four_two;
    public ImageView four_three;
    public ImageView four_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        points = (TextView) findViewById(R.id.textView10);
        points.setText("0");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_memory, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Reiniciar) {
            int card = R.drawable.card;

            one_one = (ImageView) findViewById(R.id.uno_uno);
            one_one.setImageResource(card);
            one_two = (ImageView) findViewById(R.id.uno_dos);
            one_two.setImageResource(card);
            one_three = (ImageView) findViewById(R.id.uno_tres);
            one_three.setImageResource(card);
            one_four = (ImageView) findViewById(R.id.uno_cuatro);
            one_four.setImageResource(card);

            two_one = (ImageView) findViewById(R.id.dos_uno);
            two_one.setImageResource(card);
            two_two = (ImageView) findViewById(R.id.dos_dos);
            two_two.setImageResource(card);
            two_three = (ImageView) findViewById(R.id.dos_tres);
            two_three.setImageResource(card);
            two_four = (ImageView) findViewById(R.id.dos_cuatro);
            two_four.setImageResource(card);

            three_one = (ImageView) findViewById(R.id.tres_uno);
            three_one.setImageResource(card);
            three_two = (ImageView) findViewById(R.id.tres_dos);
            three_two.setImageResource(card);
            three_three = (ImageView) findViewById(R.id.tres_tres);
            three_three.setImageResource(card);
            three_four = (ImageView) findViewById(R.id.tres_cuatro);
            three_four.setImageResource(card);

            four_one = (ImageView) findViewById(R.id.cuatro_uno);
            four_one.setImageResource(card);
            four_two = (ImageView) findViewById(R.id.cuatro_dos);
            four_two.setImageResource(card);
            four_three = (ImageView) findViewById(R.id.cuatro_tres);
            four_three.setImageResource(card);
            four_four = (ImageView) findViewById(R.id.cuatro_cuatro);
            four_four.setImageResource(card);

            intentos = 0;
            points.setText("0");

        }

        else if (id == R.id.Ranking) {
            Intent i = new Intent(Memory.this, Ranking.class);
            startActivity(i);
        }
        else if (id == R.id.logout) {
            Login_Twitter.dentro = false;
            SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("dentro", false);
            editor.apply();
            Intent i = new Intent(getApplicationContext(), Login_Twitter.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    public void ClicUnoTres(View v) {
        ImageView im = (ImageView) findViewById(v.getId());
        MiTareaAsincronaUnoTres tar = new MiTareaAsincronaUnoTres();
        tar.execute();
    }


    public void Clic(View v) {
        int id = v.getId();
        ImageView im;
        if (id == R.id.uno_uno) {
            im = (ImageView) findViewById(v.getId());
            MiTareaAsincronaUnoUno tar = new MiTareaAsincronaUnoUno();
            tar.execute();
        } else if (id == R.id.uno_dos) {
            im = (ImageView) findViewById(v.getId());
            MiTareaAsincronaUnoDos tar = new MiTareaAsincronaUnoDos();
            tar.execute();
        }
        ++intentos;
        if (intentos % 2 == 0) {
            Integer publish;
            publish = intentos / 2;
            points.setText(publish.toString());
        }
    }

    private class MiTareaAsincronaUnoUno extends AsyncTask<Void, Void, Void> {

        ImageView im = (ImageView) findViewById(R.id.uno_uno);

        @Override
        protected void onPreExecute() {
            im.setImageResource(R.drawable.uno);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            im.setImageResource(R.drawable.card);
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class MiTareaAsincronaUnoDos extends AsyncTask<Void, Void, Void> {

        ImageView im = (ImageView) findViewById(R.id.uno_dos);

        @Override
        protected void onPreExecute() {
            im.setImageResource(R.drawable.dos);
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            im.setImageResource(R.drawable.card);
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

        private class MiTareaAsincronaUnoTres extends AsyncTask<Void, Void, Void> {

            ImageView im = (ImageView) findViewById(R.id.uno_tres);

            @Override
            protected void onPreExecute() {
                im.setImageResource(R.drawable.tres);
                ++intentos;
                if (intentos % 2 == 0) {
                    Integer publish;
                    publish = intentos / 2;
                    points.setText(publish.toString());
                }
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                im.setImageResource(R.drawable.card);
                super.onPostExecute(aVoid);
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
    }

