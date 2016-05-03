package com.example.benzvikler.fiveby5.model;

/**
 * Created by benzvikler on 2016-01-22.
 */
public class Exercise {
    private String name;
    private boolean requiresWeight;
    private String bodyPart;
    private String repetitions;

    /**
     *
     * @param name
     * @param bodyPart
     * @param repetitions
     * @param requiresWeight
     *
     * constructs an Exercise object
     */
    public Exercise(String name, String bodyPart, String repetitions, boolean requiresWeight){
        this.name= name;
        this.bodyPart= bodyPart;
        this.repetitions= repetitions;
        this.requiresWeight = requiresWeight;
    }


    public String getName(){
        return name;
    }

    public String getBodyPart(){
        return bodyPart;
    }

    public String getRepetitions(){
        return repetitions;
    }

    public void setRepetitions(String repetitions){
        this.repetitions = repetitions;
    }

    public boolean getRequiresWeight(){
        return requiresWeight;
    }

    public void setRequiresWeight(boolean requiresWeight){
        this.requiresWeight= requiresWeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercise exercise = (Exercise) o;

        if (requiresWeight != exercise.requiresWeight) return false;
        if (!name.equals(exercise.name)) return false;
        if (!bodyPart.equals(exercise.bodyPart)) return false;
        return repetitions.equals(exercise.repetitions);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (requiresWeight ? 1 : 0);
        result = 31 * result + bodyPart.hashCode();
        result = 31 * result + repetitions.hashCode();
        return result;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Exercise)) return false;
//
//        Exercise exercise = (Exercise) o;
//
//        if (requiresWeight != exercise.requiresWeight) return false;
//        if (repetitions != exercise.repetitions) return false;
//        if (!name.equals(exercise.name)) return false;
//        return bodyPart.equals(exercise.bodyPart);
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + (requiresWeight ? 1 : 0);
//        result = 31 * result + bodyPart.hashCode();
//        result = 31 * result + repetitions;
//        return result;
//    }
}

