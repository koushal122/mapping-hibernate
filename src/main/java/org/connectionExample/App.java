package org.connectionExample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *src/main/java/hibernate.cfg.xml
 */
public class App 
{
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
        //Student is normal java class annotated with @Entity annotation.
        Student student = new Student();
        student.setId(1);
        Address address = new Address("city","state");
        student.setAddress(address);
        student.setName("Koushal");
        Transaction transaction = session.beginTransaction();
        session.merge(student);
        Student student1 = session.get(Student.class,1);
        System.out.println(student1);
        transaction.commit();
        session.close();
    }
}
