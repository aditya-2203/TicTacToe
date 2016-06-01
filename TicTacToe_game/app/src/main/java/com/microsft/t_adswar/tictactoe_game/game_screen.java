package com.microsft.t_adswar.tictactoe_game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created by t-adswar on 5/27/2016.
 */
public class game_screen  extends AppCompatActivity {
    board myboard;
    String first_player;
    String second_player;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        Log.d("here i am ","all ok");
        Intent i = getIntent();
        first_player=i.getStringExtra("first_player");
        Log.d("here i am ","all ok1");
        second_player=i.getStringExtra("second_player");
        Log.d("here i am ","all ok2");
        Log.d("first player ", first_player);
        Log.d("second player",second_player);
        setupboard();
        update_text();
        setUpOnclickListeners();
        clear_buttons();
    }
    private void update_text()
    {
        int turn;
        String temp;
        turn=myboard.get_turn();
        if(turn==1)
            temp=second_player;
        else
            temp=first_player;
        TextView t1=(TextView) findViewById(R.id.editText1);
        t1.setText(temp+"    turn");
    }
    private void setupboard()
    {
        myboard=new board();
    }
    private void clear_buttons()
    {
        TableLayout my_table=(TableLayout)findViewById(R.id.tableLayout1);
        for(int i=0;i<my_table.getChildCount();i++)
        {
            TableRow myrow= (TableRow) my_table.getChildAt(i);
            for(int j=0;j<myrow.getChildCount();j++)
            {
                Button eachbutton=(Button)myrow.getChildAt(j);
                eachbutton.setText("");
                eachbutton.setEnabled(true);

            }
        }
    }
    private void setUpOnclickListeners()
    {
        TableLayout my_table=(TableLayout)findViewById(R.id.tableLayout1);
        for(int i=0;i<my_table.getChildCount();i++)
        {
            TableRow myrow= (TableRow) my_table.getChildAt(i);
            for(int j=0;j<myrow.getChildCount();j++)
            {
                View eachbutton=(View)myrow.getChildAt(j);
                eachbutton.setOnClickListener(new doOnClick(i,j));
            }
        }
    }
    private class doOnClick implements View.OnClickListener
    {
        private int x;
        private int y;
        doOnClick(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
        @Override
        public void onClick(View view)
        {
            int turn=myboard.get_turn();
            Button b=(Button)view;
            String temp="0";
            if(turn==1)
                temp="X";
            b.setText(temp);
            b.setEnabled(false);
            myboard.update_board(x,y);
            int ans=myboard.check_winner(turn);
            String temp2;
            if(ans==1)
                temp2=second_player;
            else
                temp2=first_player;
            myboard.update_turn();
            turn=myboard.get_turn();
            if(turn==1)
                temp=second_player;
            else
                temp=first_player;
            TextView t1=(TextView) findViewById(R.id.editText1);
            t1.setText(temp+"    turn");
            if(ans!=-1) {
                LayoutInflater myInflater=LayoutInflater.from(getApplicationContext());
                View view1=myInflater.inflate(R.layout.popup_winner,null);
                TextView ttt1=(TextView)view1.findViewById(R.id.tt1);
                ttt1.setText(temp2+"  is winner");
                Toast mytoast=new Toast(getApplicationContext());
                mytoast.setView(view1);
                mytoast.setDuration(Toast.LENGTH_LONG);
                mytoast.show();
                finish();
            }


        }

    }
}
