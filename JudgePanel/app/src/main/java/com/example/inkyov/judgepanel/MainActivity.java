package com.example.inkyov.judgepanel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button red1;
    private Button red2;
    private Button red3;
    private Button red4;
    private Button red5;
    private Button blue1;
    private Button blue2;
    private Button blue3;
    private Button blue4;
    private Button blue5;
    private Socket client;
    private int point;
    DataOutputStream dataOutputStream = null;
    SharedPreferences sharedPreferences;
    String IP;
    String port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red1 = (Button)findViewById(R.id.red1);
        red2 = (Button)findViewById(R.id.red2);
        red3 = (Button)findViewById(R.id.red3);
        red4 = (Button)findViewById(R.id.red4);
        red5 = (Button)findViewById(R.id.red5);
        blue1 = (Button)findViewById(R.id.blue1);
        blue2 = (Button)findViewById(R.id.blue2);
        blue3 = (Button)findViewById(R.id.blue3);
        blue4 = (Button)findViewById(R.id.blue4);
        blue5 = (Button)findViewById(R.id.blue5);



        red1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("red", 1);
                    }
                }){
            }.start();}
        });

        red2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("red", 2);
                    }
                }){
                }.start();}
        });

        red3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 3;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("red", 3);
                    }
                }){
                }.start();}
        });

        red4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 4;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("red", 4);
                    }
                }){
                }.start();}
        });

        red5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 5;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("red", 5);
                    }
                }){
                }.start();}
        });

        blue1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 1;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("blue", 1);
                    }
                }){
                }.start();}
        });

        blue2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 2;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("blue", 2);
                    }
                }) {
                }.start();
            }
        });

        blue3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 3;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("blue", 3);
                    }
                }) {
                }.start();
            }
        });

        blue4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 4;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("blue", 4);
                    }
                }){
                }.start();}
        });

        blue5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                point = 5;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendPoint("blue", 5);
                    }
                }) {
                }.start();
            }
        });
    }

    protected void onResume(){
        super.onResume();

        sharedPreferences = getSharedPreferences("judge", MODE_PRIVATE);
        if(!sharedPreferences.contains("IP") || !sharedPreferences.contains("PORT")){
            Intent intent = new Intent(this, Register.class);
            try{
                startActivity(intent);
            }catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(), "Your activity could not be run", Toast.LENGTH_SHORT).show();
            }
        }else{
            IP = sharedPreferences.getString("IP", "127.0.0.1");
            port = sharedPreferences.getString("PORT", "8080");
        }
    }


    private void sendPoint(String player, int point){
        try {
            client = new Socket(IP, Integer.parseInt(port));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
            objectOutputStream.writeObject(new Point(player, point, Integer.parseInt(port)));
            objectOutputStream.flush();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            Intent intent = new Intent(this, Register.class);
            try{
                startActivity(intent);
            }catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(), "Your activity could not be run", Toast.LENGTH_SHORT).show();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
