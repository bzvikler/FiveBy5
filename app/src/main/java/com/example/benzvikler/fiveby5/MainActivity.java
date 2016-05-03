package com.example.benzvikler.fiveby5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.benzvikler.fiveby5.model.Exercise;
import com.example.benzvikler.fiveby5.model.ExerciseSet;
import com.example.benzvikler.fiveby5.model.Workout;

public class MainActivity extends AppCompatActivity {

    private Workout theWorkout = new Workout();
    private int counter = 1;
    private boolean canClick = true;
    private TextSwitcher eSwitcher;
    private TextSwitcher rSwitcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eSwitcher = (TextSwitcher) findViewById(R.id.exerciseTextSwitcher);
        eSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // create new textView and set the properties like color, size etc
                TextView myText = new TextView(MainActivity.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(24);
                myText.setTextColor(Color.parseColor("#37474f"));
                return myText;
            }
        });

        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        eSwitcher.setInAnimation(in);
        eSwitcher.setOutAnimation(out);

        rSwitcher = (TextSwitcher) findViewById(R.id.repsTextSwitcher);
        rSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView myText = new TextView(MainActivity.this);
                myText.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                myText.setTextSize(16);
                myText.setTextColor(Color.parseColor("#37474f"));
                return myText;
            }
        });

        rSwitcher.setInAnimation(in);
        rSwitcher.setOutAnimation(out);

        handleMakeWorkout();
        handleInitializeText();

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);

            }
        });


        final ImageView bigButton = (ImageView) findViewById(R.id.centreButton);
        bigButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(canClick){
                    handleWorkoutRunning(counter);
                    counter++;
                }
            }

        });
    }

    private void handleInitializeText() {
        rSwitcher.setText("" );
        eSwitcher.setText("");

        eSwitcher.setText("Get Ready!");
        rSwitcher.setText("Tap To Start First Set!");

        ExerciseSet currentSet = theWorkout.getWorkout().get(0);

        Exercise currentExercise = currentSet.getSet().get(0);

        TextView repetitions = (TextView) findViewById(R.id.textView2);
        repetitions.setText(currentExercise.getRepetitions());
    }

    private void handleMakeWorkout() {
        Bundle bundle = getIntent().getExtras();
        boolean myBooleanVariable = bundle.getBoolean("weightsOrBody");
        if(myBooleanVariable){
            try {
                theWorkout.makeWorkout(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                theWorkout.makeWorkout(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void handleWorkoutRunning(int counter){
        int nextSetCount = 1;

        // first set
        if(counter <= 4){
            handleSetText(0);
        }
        // first rest
        if(counter == 5){
            canClick = false;
            handleSetText(5);
            nextSetCount++;
            handleRestTimer(15, nextSetCount);
        }
        // second set
        if(counter >= 6 && counter <= 10){
            handleSetText(6);
        }
        // second rest
        if(counter == 11){
            handleSetText(11);
            nextSetCount++;
            handleRestTimer(15, nextSetCount);
            canClick = false;

        }
        // third set
        if(counter >=12 && counter <= 16){
            handleSetText(12);
        }
        // third rest
        if(counter == 17){
            handleSetText(17);
            nextSetCount++;
            handleRestTimer(15, nextSetCount);
            canClick = false;
        }
        // fourth set
        if(counter >= 18 && counter <= 22){
            handleSetText(18);
        }
        // fourth rest
        if(counter == 23){
            handleSetText(23);
            nextSetCount++;
            handleRestTimer(15, nextSetCount);
            canClick = false;
        }
        // fifth set
        if(counter >= 24 && counter <= 28){
            handleSetText(24);
        }
        // finish
        if(counter == 29){
            handleSetText(29);
        }
    }

    public void handleSetText(int offset){
        ExerciseSet currentSet = theWorkout.getWorkout().get(0);
        Exercise currentExercise = currentSet.getSet().get(counter - offset);

        switch (offset){
            case 5:
                eSwitcher.setText("Rest");
                rSwitcher.setText("Grab Some Water!");
                break;
            case 11:
                eSwitcher.setText("Rest");
                rSwitcher.setText("You Got This!");
                break;
            case 17:
                eSwitcher.setText("Rest");
                rSwitcher.setText("Over Half Way!");
                break;
            case 23:
                eSwitcher.setText("Rest");
                rSwitcher.setText("Just One More Set!");
                break;
            case 29:
                eSwitcher.setText("Done!");
                rSwitcher.setText("Good Work!");
                break;
            default:
                eSwitcher.setText(currentExercise.getName());
                rSwitcher.setText(currentExercise.getRepetitions()+ " reps");
        }
    }

    public void handleRestTimer(final int secondi, final int nextSetCount){

        CountDownTimer countDownTimer = new CountDownTimer(secondi * 1000, 500) {
            ProgressBar barTimer = (ProgressBar) findViewById(R.id.barTimer);
            TextView timerText = (TextView) findViewById(R.id.textTimer);
            boolean once0 = true;
            boolean once1 = true;

            @Override
            public void onTick(long leftTimeInMilliseconds) {

                long seconds = leftTimeInMilliseconds / 1000;

                if((int) seconds== 5){
                    if(once0){
                        once0 = false;
                        eSwitcher.setText("Ready?");
                        rSwitcher.setText("5 More Seconds");
                    }
                }
                if((int) seconds == 2){
                    if(once1){
                        once1 = false;
                        String nextSetAsString = Integer.toString(nextSetCount);
                        eSwitcher.setText("Lets Go!");
                        rSwitcher.setText("Starting Set " + nextSetAsString);
                    }
                }
                int barVal= (int) seconds* (120/15);
                barTimer.setProgress(barVal);
                timerText.setVisibility(View.VISIBLE);
                timerText.setText(String.format("%02d", seconds / 60) + ":" + String.format("%02d", seconds % 60));
            }

            @Override
            public void onFinish() {
                if(timerText.getText().equals("00:00")){
                    barTimer.setVisibility(View.INVISIBLE);
                    timerText.setVisibility(View.INVISIBLE);
                    canClick = true;
                    handleWorkoutRunning(counter);
                    counter++;
                }
                else{
                    timerText.setText("2:00");
                }
            }
        }.start();
    }
}
