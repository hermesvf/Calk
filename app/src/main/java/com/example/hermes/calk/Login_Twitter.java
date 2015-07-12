package com.example.hermes.calk;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import io.fabric.sdk.android.Fabric;


public class Login_Twitter extends ActionBarActivity {

    private static final String TWITTER_KEY = "TZ1eW3gFvnykNSSpvM2SfYaZR";
    private static final String TWITTER_SECRET = "9k7iidqRlEAmHm3vXgTOd7qB8xQqR3gTvRop56h9okS0k14L5M";

    private TwitterLoginButton loginButton;

    public static boolean dentro;
    EditText name, password;

    public static String usuari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        if (sp.getBoolean("dentro",false)) {
            Intent intent = new Intent(this, Selecciona.class);
            startActivity(intent);
        }
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_login__twitter);
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);
        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                dentro = true;
                SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("dentro", dentro);
                editor.apply();
                Intent intent = new Intent(getApplicationContext(), Selecciona.class);
                startActivity(intent);

            }

            @Override
            public void failure(TwitterException exception) {
                Toast.makeText(getApplicationContext(), "El inicio de sesion ha fallado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    public void holabebe(View v) {
        name = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);

        if (!name.getText().toString().equals("") && !password.getText().toString().equals("")) {
            SharedPreferences sp = getSharedPreferences("myData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("name", name.getText().toString());
            editor.putString("password", password.getText().toString());
            editor.putBoolean("dentro", dentro);
            editor.apply();
            usuari = name.getText().toString();
            Login_Twitter.dentro = true;
            Intent intent = new Intent(getApplicationContext(), Selecciona.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "Please, fill all the fields", Toast.LENGTH_LONG).show();
        }
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
        if (id == R.id.Comprueba) {
            if (Login_Twitter.dentro) {
                Toast.makeText(getApplicationContext(),"Estas dentro", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(),"Estas fuera", Toast.LENGTH_LONG).show();
            }
        }

        return super.onOptionsItemSelected(item);
    }

}
