package com.example.benzvikler.fiveby5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.benzvikler.fiveby5.model.AllExercises;
import com.example.benzvikler.fiveby5.model.Exercise;
import com.example.benzvikler.fiveby5.model.Workout;

public class Main2Activity extends AppCompatActivity {

    private Workout theWorkout = new Workout();
    private AllExercises allExercises = AllExercises.getInstance();     // all Exercises implements iterable
    private Boolean weightsOrBody = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Exercise pushUps = new Exercise("Push-Ups", "chest", "", false);
        Exercise curls = new Exercise("Bicep Curls", "bicep", "", true);
        Exercise squats = new Exercise("Squats", "leg", "", true);
        Exercise shoulderPress = new Exercise("Shoulder Press", "shoulder", "", true);
        Exercise sitUps = new Exercise("Sit-Ups", "abdominal", "", false);
        Exercise militaryPushUps = new Exercise("Military Push-Ups", "chest", "", false);
        Exercise widePushUps = new Exercise("Wide Push-Ups", "chest", "", false);
        Exercise hammerCurls = new Exercise("Hammer Curls", "bicep1", "", true);
        Exercise lunges = new Exercise("Lunges", "leg1", "", true);
        Exercise backFlys = new Exercise("Bent Over Back Flys", "back", "", true);
        Exercise concentrationCurls = new Exercise("Concentration Curls", "bicep", "", true);
        Exercise tricepKickBack = new Exercise("Tricep Kickbacks", "tricep", "", true);
        Exercise pullUps = new Exercise("Pull-Ups", "back", "", false);


        allExercises.addExercise(pushUps);
        allExercises.addExercise(curls);
        allExercises.addExercise(squats);
        allExercises.addExercise(shoulderPress);
        allExercises.addExercise(sitUps);
        allExercises.addExercise(militaryPushUps);
        allExercises.addExercise(widePushUps);
        allExercises.addExercise(hammerCurls);
        allExercises.addExercise(lunges);
        allExercises.addExercise(backFlys);
        allExercises.addExercise(pullUps);
        allExercises.addExercise(concentrationCurls);
        allExercises.addExercise(tricepKickBack);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("Customize");

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(Main2Activity.this, MainActivity.class);
//                startActivity(i);
//            }
//        });

        final RadioButton strength = (RadioButton) findViewById(R.id.strength);
        final RadioButton endurance = (RadioButton) findViewById(R.id.endurance);
        final RadioButton weights = (RadioButton) findViewById(R.id.weights);
        final RadioButton body = (RadioButton) findViewById(R.id.body);
        final Button start_workout = (Button) findViewById(R.id.start_workout_button);

        endurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    endurance.setChecked(true);
                    strength.setChecked(false);
                    AllExercises.getInstance().setEndurance();
            }
        });

        strength.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    strength.setChecked(true);
                    endurance.setChecked(false);
                    AllExercises.getInstance().setStrength();
            }
        });

        weights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weights.setChecked(true);
                body.setChecked(false);
                AllExercises.getInstance().filterWeightsOrBody(1);
                weightsOrBody = true;
            }
        });

        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                body.setChecked(true);
                weights.setChecked(false);
                AllExercises.getInstance().filterWeightsOrBody(0);
                weightsOrBody = false;
            }
        });

        start_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((body.isChecked() || weights.isChecked()) && (endurance.isChecked()) || strength.isChecked()){
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    i.putExtra("weightsOrBody", weightsOrBody);
                    startActivity(i);
                }
                else{
                    Snackbar.make(v, "Please Select One of the Above Options", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }


}
