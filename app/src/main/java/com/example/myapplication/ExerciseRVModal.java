package com.example.myapplication;

public class ExerciseRVModal {
    private String exerciseName;
    private String exerciseDescription;
    private String imgUrl;
    private int calories,time;

    public ExerciseRVModal(String exerciseName, String exerciseDescription, String imgUrl, int calories, int time) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.imgUrl = imgUrl;
        this.calories = calories;
        this.time = time;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public int getCalories() {
        return calories;
    }

    public int getTime() {
        return time;
    }
}
