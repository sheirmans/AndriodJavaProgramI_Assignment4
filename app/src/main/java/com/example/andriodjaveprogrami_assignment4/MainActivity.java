/*
 * CSE41246 - Android Java Fundamentals
 * Fall 2019
 * Assignment #4
 * Szeto, Sheirman
 */


package com.example.andriodjaveprogrami_assignment4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button firstButton = null;
    LinearLayout scrollViewLayout = null;
    private int buttonCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TO-DO:
        // 1. Create a reference to the main layout.
        // 2. Create a reference to the start button and make the callback.
        scrollViewLayout = (LinearLayout)findViewById(R.id.scrollViewLayout);

        firstButton = (Button)findViewById(R.id.buttonSubmit);
        firstButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                generateNewButton();
                firstButton.setEnabled(false);
            }
        });
    }

    private void generateNewButton() {
        // TO-DO:
        // 1. Create a new Button widget (HINT: Pass in MainActivity.this);
        // 2. Create a layout prams for the new button. Layout params takes in the height and the width.
        // 3. Set the text and text color (use getRandomColor()) for the button. You can also set the background, but it might look weird.
        // 4. Create the callback for the new Button.
        // 5. Add the Button to the current view.

        final Button newButton = new Button(MainActivity.this); //step 1

        //LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        //another option to set parameters
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width,height);

        newButton.setLayoutParams(layoutParams);


        newButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                generateNewButton();
                newButton.setEnabled(false);
            }
        });



        newButton.setText("PRESS ME: " + Integer.toString(++buttonCount));
        newButton.setTextColor(getRandomColor());

        scrollViewLayout.addView(newButton);
    }

    private int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
