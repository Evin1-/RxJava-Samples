package com.example.rxjavasamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("username", "password".toCharArray());
            }
        });

        URL url = null;
        try {
            url = new URL("http://www.oracle.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        assert url != null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
