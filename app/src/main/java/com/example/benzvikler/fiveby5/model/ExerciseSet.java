package com.example.benzvikler.fiveby5.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by benzvikler on 2016-01-22.
 */


public class ExerciseSet {

    private List<Exercise> exercises;
    private AllExercises allExercises = AllExercises.getInstance();

    /**
     * makes the set of exercises for the user, has condition that each exercise be of different body part,
     * will create a set of 5 exercises and then return that list of exercises, chooses exercises from the main bank
     * of exercises which is randomized before selection.
     */
    public ExerciseSet(){
        exercises = new ArrayList<Exercise>();
    }

    public void makeSet(int i) throws Exception {

        long seed = System.nanoTime();

        Collections.shuffle(AllExercises.getInstance().getExercises(i), new Random(seed));
        Collections.shuffle(AllExercises.getInstance().getExercises(i), new Random(seed));

                // make workout from correct list based on if user wants free weights or body
                for(Exercise next: allExercises.getExercises(i)){
                    if(exercises.size() < 5){
                        if(exercises.size()==0){
                            exercises.add(next);
                        }
                        else{
                            if (!(next.getBodyPart().equals(exercises.get(exercises.size() - 1).getBodyPart()))) {
                                exercises.add(next);
                            }
                        }
                    }
                }
    }

    public List<Exercise> getSet(){
        return exercises;
    }

    public Exercise displayExerciseAtIndex(int index){
        return exercises.get(index);
    }
}

