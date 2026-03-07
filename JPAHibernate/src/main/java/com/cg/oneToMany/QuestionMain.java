package com.cg.oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class QuestionMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
//        Question q1 = new Question("What is Java?", "Hard");
//        List<Answer> answers = new ArrayList<Answer>();
//        answers.add(new Answer("Java is OOP programming language", q1));
//        answers.add(new Answer("Java is platform independent", q1));
//        answers.add(new Answer("Java supports robustness", q1));
//        q1.setAnswer(answers);
//        em.persist(q1);
//        em.getTransaction().commit();
//        System.out.println("Created..... ");

        //read:
        Question q=em.find(Question.class, 1);
        System.out.println(q.getQname());
        q.getAnswer().forEach(answer -> {System.out.println(answer.getAnswer());});
        //to get question for answer:
        Answer a=em.find(Answer.class, 1);
        System.out.println(a.getAnswer());
        System.out.println(a.getQ().getQname());

        //to delete answer:
        em.remove(a);

        //but if a question is removed then all its answers are removed too
        em.remove(q);
        em.getTransaction().commit();
    }
}
