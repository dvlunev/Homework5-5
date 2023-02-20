package hw55.dao.impl;

import hw55.dao.EmployeeDao;
import hw55.model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;
import hw55.config.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Optional;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void createOrUpdateEmployee(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(Employee.class, id));
        }
    }

    @Override
    public List<Employee> getAllEmployeeList() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("FROM Employee", Employee.class).list();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
    }
}
