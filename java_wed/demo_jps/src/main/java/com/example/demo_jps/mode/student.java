package com.example.demo_jps.mode;

public class student {
    private int id;
    private String name;
    private boolean gender;
    private float score;
    private int classid;

    public student(int id, String name, boolean gender, float score, int classid) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.score = score;
        this.classid = classid;
    }
    public student() {
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
}
