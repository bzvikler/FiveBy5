package com.example.benzvikler.fiveby5;

import com.example.benzvikler.fiveby5.model.AllExercises;
import com.example.benzvikler.fiveby5.model.Exercise;
import com.example.benzvikler.fiveby5.model.ExerciseSet;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by benzvikler on 2016-01-22.
 */

public class ExerciseSetTest {

    @Before
    public void setUp(){
        Exercise pushUps = new Exercise("Push-Ups", "chest", 10, false);
        Exercise curls = new Exercise("Bicep Curls", "bicep", 10, true);
        Exercise squats = new Exercise("Free Weight Squats", "leg", 10, true);
        Exercise shoulderPress = new Exercise("Free Weight Shoulder Press", "shoulder", 10, true);
        Exercise sitUps = new Exercise("Sit-Ups", "abdominal", 10, false);
        Exercise militaryPushUps = new Exercise("Military Push-Ups", "chest", 10, false);
        Exercise widePushUps = new Exercise("Wide Push-Ups", "chest", 10, false);
        Exercise hammerCurls = new Exercise("Free Weight Hammer Curls", "bicep", 10, true);
        Exercise lunges = new Exercise("Free Weight Lunges", "leg", 10, true);
        Exercise backFlys = new Exercise("Free Weight Bent Over Back Flys", "back", 10, true);
        Exercise pullUps = new Exercise("Pull-Ups", "back", 10, false);

        AllExercises.getInstance().addExercise(pushUps);
        AllExercises.getInstance().addExercise(curls);
        AllExercises.getInstance().addExercise(squats);
        AllExercises.getInstance().addExercise(shoulderPress);
        AllExercises.getInstance().addExercise(sitUps);
        AllExercises.getInstance().addExercise(militaryPushUps);
        AllExercises.getInstance().addExercise(widePushUps);
        AllExercises.getInstance().addExercise(hammerCurls);
        AllExercises.getInstance().addExercise(lunges);
        AllExercises.getInstance().addExercise(backFlys);
        AllExercises.getInstance().addExercise(pullUps);

    }

    @Test
    public void testMakeSet(){
        ExerciseSet set = new ExerciseSet();
        set.makeSet();
        assertEquals(set.getSet().size(), 5);
        System.out.println(set.getSet().get(0).getBodyPart());
        System.out.println(set.getSet().get(1).getBodyPart());
        System.out.println(set.getSet().get(2).getBodyPart());
        System.out.println(set.getSet().get(3).getBodyPart());
        System.out.println(set.getSet().get(4).getBodyPart());
    }
}

