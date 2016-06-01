package com.microsft.t_adswar.tictactoe_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by t-adswar on 5/30/2016.
 */
public class enter_name  extends AppCompatActivity{
    EditText t1;
    EditText t2;
    Button b1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_name);
        t1=(EditText)findViewById(R.id.text1);
        t2=(EditText)findViewById(R.id.text2);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchGame1 = new Intent(getApplicationContext(),game_screen.class);
                launchGame1.putExtra("first_player",t1.getText().toString());
                launchGame1.putExtra("second_player",t2.getText().toString());
                startActivity(launchGame1);
                finish();
            }
        });
    }
}
