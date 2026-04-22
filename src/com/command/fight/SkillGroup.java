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

    public void addSkillGroup(SkillGroup skillGroup) {
        this.skills.addAll(skillGroup.getSkills());
    }

    public HashSet<Skill>  getSkills() {
        return skills;
    }

    public String formatSkillGroup(){
        StringBuilder sb = new StringBuilder("技能:");
        for (Skill skill : skills){
            sb.append("\n").append(skill.formatSkill());
        }
        return sb.toString();
    }

}
