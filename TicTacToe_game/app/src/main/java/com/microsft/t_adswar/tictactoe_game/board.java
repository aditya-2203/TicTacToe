package com.microsft.t_adswar.tictactoe_game;

import android.util.Log;

import java.util.Arrays;

/**
 * Created by t-adswar on 5/27/2016.
 */
public class board {
    private int[][] board = new int[3][3];
    private int turn;
    board()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                board[i][j]=-1;
        }
        turn=0;
    }
    public int get_turn()
    {
        return turn;
    }
    public void update_turn()
    {
        turn=(turn+1)%2;
    }
    //just update board with the last player who has upadte and update whopse turn is next
    public void update_board(int row_number,int column_number)
    {
        board[row_number][column_number]=turn;
        Log.d("this is my deep array", "deep arr: " + Arrays.deepToString(board));


    }
    //take the one who has play last move and check if he/she has won
    //return player id if he has won else -1
    public int check_winner(int last_person)
    {
        //checking all rows
        for(int i=0;i<3;i++)
        {
            boolean all_mine=true;
            for(int j=0;j<3;j++)
            {
                if(board[i][j]!=last_person)
                {
                    all_mine=false;
                    break;
                }
            }
            if(all_mine==true)
                return last_person;
        }
        //checking column
        for(int i=0;i<3;i++)
        {
            boolean all_mine=true;
            for(int j=0;j<3;j++)
            {
                if(board[j][i]!=last_person)
                {
                    all_mine=false;
                    break;
                }
            }
            if(all_mine==true)
                return last_person;
        }
        //checking diagonal
        boolean all_mine=true;
        for(int i=0;i<3;i++)
        {
            if(board[i][i]!=last_person)
            {
                all_mine=false;
                break;
            }
        }
        if(all_mine==true)
            return last_person;
        all_mine=true;
        int i,j;
        i=0;
        j=2;
        for(i=0;i<3;i++,j--)
        {
            if(board[i][i]!=last_person)
            {
                all_mine=false;
                break;
            }
        }
        if(all_mine==true)
            return last_person;
        return -1;
    }
}
