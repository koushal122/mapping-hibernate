package org.ManyToManyExample;

import org.OneToManyExample.Answer;
import org.OneToManyExample.Question;
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
        SessionFactory sessionFactory = cfg. buildSessionFactory();
        Session session= sessionFactory.openSession();

        Emp e1=new Emp();
        e1.setId(1);
        e1.setName("First Emp");
        Emp e2=new Emp();
        e2.setId(2);
        e2.setName("Second Emp");

        Project p1= new Project();
        p1.setId(1);
        p1.setProjectName("First Project");
        Project p2= new Project();
        p2.setId(2);
        p2.setProjectName("Second Project");

        List<Emp> empList=new ArrayList<>();
        empList.add(e1);
        empList.add(e2);

        List<Project> projectList = new ArrayList<>();
        projectList.add(p1);
        projectList.add(p2);

        e1.setProjects(projectList);
        //setting only p2 will not set for employee because mapping is handled by employee, and we need to
        //explicitly tell that where e2 is working so we have written next statement.
        p2.setEmployees(empList);
        e2.setProjects(List.of(p2));


        Transaction transaction = session.beginTransaction();
        session.merge(e1);
        session.merge(e2);
        session.merge(p1);
        session.merge(p2);

        transaction.commit();
        session.close();
    }
}
