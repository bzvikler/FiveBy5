package com.example.benzvikler.fiveby5.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by benzvikler on 2016-01-22.
 */

public class AllExercises implements Iterable<Exercise>{

    // this is a singleton class
    private static AllExercises instance = null;
    private List<Exercise> exerciseList;
    private List<Exercise> exerciseListWeights;
    private List<Exercise> exerciseListBody;

    private AllExercises(){
        exerciseList = new ArrayList<Exercise>();
        // maybe linked list?
        exerciseListWeights = new ArrayList<Exercise>();
        exerciseListBody = new ArrayList<Exercise>();
    }

    public static AllExercises getInstance(){
        if(instance == null){
            instance = new AllExercises();
        }
        return instance;
    }

    /**
     * will allow the user to create their own exercises and add them to the bank of exercises
     * checks to make sure exercise being added doesn't already contain exercise
     * @param exercise
     */
    public void addExercise(Exercise exercise){
        if(!exerciseList.contains(exercise)){
            exerciseList.add(exercise);
        }
    }

    public void setEndurance(){
        for(Exercise next: exerciseList){
            next.setRepetitions("12 - 15");
        }
    }

    public void setStrength(){
        for(Exercise next: exerciseList){
            next.setRepetitions("8 - 10");
        }
    }

    // filters list of exercises to free weights or body
    // 0 for body and 1 for free weights
    public void filterWeightsOrBody(int i){
        if(i == 0){
            for(Exercise next: exerciseList){
                if(!next.getRequiresWeight()){
                    exerciseListBody.add(next);
                }
            }
        }
        if(i == 1){
            for(Exercise next: exerciseList){
                if(next.getRequiresWeight()){
                    exerciseListWeights.add(next);
                }
            }
        }
    }

    public List<Exercise> getExercises(int i) throws Exception {
        if(i==0){
            return exerciseListBody;
        }
        if(i == 1){
            return exerciseListWeights;
        }
        else throw new Exception("Using getExercises with invalid parameter not 0 or 1");
    }

    @Override
    public Iterator<Exercise> iterator() {
        return exerciseList.iterator();
    }
}

