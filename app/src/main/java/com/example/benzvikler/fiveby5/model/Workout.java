package com.example.benzvikler.fiveby5.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benzvikler on 2016-01-22.
 */
public class Workout {

    private List<ExerciseSet> workoutSets;

    public Workout(){
        workoutSets = new ArrayList<>();
    }

    /**
     * creates a workout plan, of 5 different sets, each containing 5 exercises
     */
    public void makeWorkout(int j) throws Exception {
        for(int i=0; i< 5; i++){
            ExerciseSet exerciseSet = new ExerciseSet();
            exerciseSet.makeSet(j);
            workoutSets.add(exerciseSet);
        }
    }

    public List<ExerciseSet> getWorkout(){
        return workoutSets;
    }
}
