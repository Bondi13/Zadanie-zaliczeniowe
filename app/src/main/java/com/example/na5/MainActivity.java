package com.example.na5;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<TextView> tab = new ArrayList();
    int array[] = new int[10];
    int zmiennaA = 0;
    int zmiennaB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab.add((TextView)findViewById(R.id.textView1));
        tab.add((TextView)findViewById(R.id.textView2));
        tab.add((TextView)findViewById(R.id.textView3));
        tab.add((TextView)findViewById(R.id.textView4));
        tab.add((TextView)findViewById(R.id.textView5));
        tab.add((TextView)findViewById(R.id.textView6));
        tab.add((TextView)findViewById(R.id.textView7));
        tab.add((TextView)findViewById(R.id.textView8));
        tab.add((TextView)findViewById(R.id.textView9));
        tab.add((TextView)findViewById(R.id.textView10));

        for(int i = 0; i < 10; i++){
            Random rand = new Random();
            int n = rand.nextInt(10);
            array[i] = n;
            tab.get(i).setText(Integer.toString(n));
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if(zmiennaA < 10) {
                for (zmiennaB = 0; zmiennaB < 10-zmiennaA-1; zmiennaB++){
                    if (array[zmiennaB] > array[zmiennaB + 1]) {
                        int temp = array[zmiennaB];
                        array[zmiennaB] = array[zmiennaB + 1];
                        array[zmiennaB + 1] = temp;
                    }
                }
                zmiennaA++;
            }else{
                zmiennaA = 0;
            }
            for(int i = 0; i < 10; i++){
                tab.get(i).setText(Integer.toString(array[i]));
            }
        }
    }

}
