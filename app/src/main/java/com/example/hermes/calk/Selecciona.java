package com.example.hermes.calk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Selecciona extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getSharedPreferences("myData",Context.MODE_PRIVATE);
        if(!sharedPreferences.getBoolean("dentro",false)) {
            Intent i = new Intent(Selecciona.this, Login_Twitter.class);
            startActivity(i);
        }
            super.onCreate(savedInstanceState);


            setContentView(R.layout.activity_selecciona);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selecciona, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
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

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.Profile) {
            Intent i = new Intent(this, Profile.class);
            startActivity(i);
        }
        else if (id == R.id.Calk) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if (id == R.id.Musik) {
            Intent i = new Intent(this,Musik.class);
            startActivity(i);
        }
        else {
            Intent i = new Intent(this,Memory.class);
            startActivity(i);
        }

    }
}
