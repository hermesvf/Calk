package com.example.hermes.calk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;


public class Musik extends ActionBarActivity {

    private MediaPlayer mp;
    private ImageView botonPlay;
    boolean iniciado = false;
    boolean pausado = true;
    int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musik);

        botonPlay = (ImageView) findViewById(R.id.imgbt);
        botonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!iniciado) {
                    mp = MediaPlayer.create(Musik.this, R.raw.cancion);
                    mp.start();
                    iniciado = true;
                    pausado = false;
                    botonPlay.setImageResource(R.drawable.pause);
                } else if (pausado) {
                    mp.start();
                    mp.seekTo(length);
                    botonPlay.setImageResource(R.drawable.pause);
                    pausado = false;
                } else {
                    botonPlay.setImageResource(R.drawable.dale);
                    mp.pause();
                    length = mp.getCurrentPosition();
                    pausado = true;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_musik, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {
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


}
