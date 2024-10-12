package org.OneToOneExaple;

import org.connectionExample.Address;
import org.connectionExample.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
        Answer answer = new Answer();
        answer.setAnswer("Java is programming language");
        question.setQuestion("what is Java");
        answer.setAnswerId(1);
        answer.setQuestion(question);
        question.setAnswer(answer);
        Transaction transaction = session.beginTransaction();
        session.merge(answer);
        session.merge(question);
        transaction.commit();
        session.close();
    }
}
