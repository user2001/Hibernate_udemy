package org.hibernateExample.demo.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernateExample.demo.hibernate.entity.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {
        //Create student entity object
        System.out.println("create");
        Student student = new Student("Iva", "Fryshchyn", "ivanna@gmail.com");
        //Create session factory object
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        System.out.println("save");
        session.save(student);
        System.out.println("Inserted Successfully");
        session.getTransaction().commit();
        System.out.println("done");
        session.close();
        sessionFactory.close();
    }
}