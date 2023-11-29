package com.example.wwwweek56.models;

import com.example.wwwweek56.enums.SkillLevel;
import com.example.wwwweek56.ids.CandidateSkillID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Objects;

@Entity(name = "candidateSkill")
@IdClass(CandidateSkillID.class)
@Data @AllArgsConstructor @NoArgsConstructor
public class CandidateSkill {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    private Candidate candidate;

    @Id
    @ManyToOne
    private Skill skill;

    @Enumerated
    private SkillLevel skillLevel;

    private String moreInfo;

    public CandidateSkill(Candidate candidate, Skill skill) {
        this.candidate = candidate;
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandidateSkill that = (CandidateSkill) o;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill);
    }
}
