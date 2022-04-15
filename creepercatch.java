package com.matador.catchcreeper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;




public class MainActivity extends AppCompatActivity {
    int a = 1;
    ImageView creeper;
    TextView usertime;
    TextView userscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usertime = findViewById(R.id.time);
        userscore = findViewById(R.id.userscore);
        creeper = findViewById(R.id.imageCreeper);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Start Game");
        alert.setMessage("Start The Game");



        new CountDownTimer(10000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                usertime.setText("Time:" + millisUntilFinished / 1000);
              
            }

            @Override
            public void onFinish() {
                alert.setPositiveButton("Start", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        startActivity(getIntent());
                    }
                });
                alert.setCancelable(false);
                alert.show();
            }
        }.start();


        new CountDownTimer(10000, 400) {


            @Override
            public void onTick(long millisUntilFinished) {
                movecreeper();

            }

            @Override
            public void onFinish() {

                }


        }.start();
    }






    public void sum(View view) {

        userscore.setText("Score:"+a);
        a++;
    }
    public void movecreeper(){

            Random rand = new Random();

            int randx = rand.nextInt(700);
            int randy = rand.nextInt(900);

            creeper.setX(randx);
            creeper.setY(randy);


    }
}
