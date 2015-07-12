package com.example.hermes.calk;

import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

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
}
