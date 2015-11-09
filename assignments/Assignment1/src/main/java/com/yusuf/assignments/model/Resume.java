package com.yusuf.assignments.model;

import java.io.Serializable;

public class Resume implements Serializable {

    private static final long serialVersionUID = 1992661343167297721L;

    private String experiences;

    private int skill1;

    private int skill2;

    private int skill3;

    private int skill4;

    private int skill5;

    private int skill6;

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public int getSkill1() {
        return skill1;
    }

    public void setSkill1(int skill1) {
        this.skill1 = skill1;
    }

    public int getSkill2() {
        return skill2;
    }

    public void setSkill2(int skill2) {
        this.skill2 = skill2;
    }

    public int getSkill3() {
        return skill3;
    }

    public void setSkill3(int skill3) {
        this.skill3 = skill3;
    }

    public int getSkill4() {
        return skill4;
    }

    public void setSkill4(int skill4) {
        this.skill4 = skill4;
    }

    public int getSkill5() {
        return skill5;
    }

    public void setSkill5(int skill5) {
        this.skill5 = skill5;
    }

    public int getSkill6() {
        return skill6;
    }

    public void setSkill6(int skill6) {
        this.skill6 = skill6;
    }

    public int[] getSkillsArray(){
        return new int[]{ skill1, skill2, skill3, skill4, skill5, skill6 };
    }
}
