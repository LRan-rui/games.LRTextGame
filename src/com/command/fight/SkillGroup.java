package com.command.fight;

import java.util.Arrays;
import java.util.HashSet;

public class SkillGroup {
    private HashSet<Skill> skills = new HashSet<>();

    public  SkillGroup(HashSet<Skill> skills) {
        this.skills = skills;
    }

    public SkillGroup(Skill... skills) {
        this.skills.addAll(Arrays.asList(skills));
    }

    public SkillGroup(SkillGroup... skills){
        for (SkillGroup group : skills){
            this.skills.addAll(group.getSkills());
        }
    }

    public SkillGroup() {

    }

    public HashSet<Skill>  getSkills() {
        return skills;
    }

    public String formatSkillGroup(){
        StringBuilder sb = new StringBuilder();
        for (Skill skill : skills){

        }
        return "".formatted();
    }

}
