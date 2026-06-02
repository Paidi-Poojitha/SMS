package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.sms.entity.Student;
import com.util.HibernateUtil;

public class StudentDao {

    public int saveStudent(Student s1) {

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getSession();

            transaction = session.beginTransaction();

            int result = (int) session.save(s1);

            transaction.commit();

            return result;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println(e);

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return 0;
    }

    public int deleteStudent(int id) {

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getSession();

            transaction = session.beginTransaction();

            Student s1 = session.get(Student.class, id);

            if (s1 != null) {

                session.delete(s1);

                transaction.commit();

                return 1;
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println(e);

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return 0;
    }

    public List<Student> getStudents() {

        Session session = null;

        try {

            session = HibernateUtil.getSession();

            Query<Student> query = session.createQuery("from Student", Student.class);

            return query.list();

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return null;
    }

    public Student getStudentById(int id) {

        Session session = null;

        try {

            session = HibernateUtil.getSession();

            return session.get(Student.class, id);

        } catch (Exception e) {

            System.out.println(e);

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return null;
    }

    public int updateStudent(int id, int choice, Object value) {

        Session session = null;
        Transaction transaction = null;

        try {

            session = HibernateUtil.getSession();

            transaction = session.beginTransaction();

            Student s1 = session.get(Student.class, id);

            if (s1 != null) {

                switch (choice) {

                case 1:

                    s1.setName((String) value);

                    break;

                case 2:

                    s1.setDepartment((String) value);

                    break;

                case 3:

                    s1.setCgpa((Double) value);

                    break;

                case 4:

                    s1.setPhno((Long) value);

                    break;

                default:

                    return 0;
                }

                transaction.commit();

                return 1;
            }

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println(e);

        } finally {

            if (session != null) {
                session.close();
            }
        }

        return 0;
    }
}
