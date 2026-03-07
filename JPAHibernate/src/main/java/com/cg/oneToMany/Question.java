package com.cg.oneToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int qid;
    private String qname;
    private String qlabel;
    //if cascade type= Persist then question can only create answer but cannot remove
    @OneToMany(mappedBy = "q", cascade = CascadeType.ALL) //map by to directly map with answer and not create 3rd table. The value "" should be same as that of instance of Question in Answer class
    private List<Answer> answer;

    Question() {}
    Question(String qname, String qlabel) {
        this.qname = qname;
        this.qlabel = qlabel;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getQlabel() {
        return qlabel;
    }

    public void setQlabel(String qlabel) {
        this.qlabel = qlabel;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}
