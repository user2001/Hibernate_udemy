package org.hibernateExample.demo.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernateExample.demo.hibernate.entity.Student;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        int studentId=1;
        //getting session object from session factory
        Session session = sessionFactory.openSession();
        //getting transaction object from session object
        session.beginTransaction();
        System.out.println("getting student with id: "+studentId);
       Student temp= (Student) session.get(Student.class,studentId);
        System.out.println("updating student...");
        temp.setFirstName("Scooby");
        session.getTransaction().commit();
        session.close();
        // new code
        session=sessionFactory.openSession();
        session.beginTransaction();
        System.out.println("update emails");
        session.createQuery("update Student set email='sunny@gmail.com'").executeUpdate();
        session.getTransaction().commit();




        System.out.println("done");
        session.close();
        sessionFactory.close();
    }
}