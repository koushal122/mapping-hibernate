package org.OneToManyExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args )
    {
        //activates hibernate framework
        Configuration cfg = new Configuration();
        //read configuration file, here we are not given file location because
        //it is present in default location i.e. src/main/resources/hibernate.cfg.xml
        //otherwise we need to give location.
        cfg.configure();
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session= sessionFactory.openSession();
        Question question = new Question();
        question.setId(1);
        question.setQuestion("what is Java");

        Answer answer = new Answer();
        answer.setAnswer("Java is programming language");
        answer.setAnswerId(1);
        answer.setQuestion(question);

        Answer answer1 = new Answer();
        answer1.setAnswer("Java is programming language2");
        answer1.setAnswerId(2);
        answer1.setQuestion(question);

        List<Answer> answers= new ArrayList<>();
        answers.add(answer);
        answers.add(answer1);
        question.setAnswer(answers);

        Transaction transaction = session.beginTransaction();
        session.save(question);
        session.save(answer);
        session.save(answer1);



        transaction.commit();
        session.close();
    }
}
