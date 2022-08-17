package org;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernateExample.demo.hibernate.Student;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try{
            System.out.println("create");
            Student tempStudent= new Student("Iva", "Fryshchyn","ivanna@gmail.com");
            session.beginTransaction();
            System.out.println("save");
            session.save(tempStudent);
            session.flush();
            session.getTransaction().commit();
            System.out.println("done!");
            session.close();
        } finally {
factory.close();
        }
    }
}
