package com.cg.oneToMany;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int aid;
    private  String answer;
    @ManyToOne
    @JoinColumn(name = "qid")
    private Question q;

    public Answer() {}
    public Answer(String answer, Question q) {
        this.answer = answer;
        this.q = q;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
    }
}
