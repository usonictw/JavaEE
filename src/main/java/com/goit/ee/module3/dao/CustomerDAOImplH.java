package com.goit.ee.module3.dao;

import com.goit.ee.module3.dto.Customer;
import com.goit.ee.module3.dto.Project;
import com.goit.ee.module3.util.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.goit.ee.module3.contoller.ConsoleUtils.getParam;

public class CustomerDAOImplH implements CustomerDAO {

    @Override
    public void create(Customer customer) {
        Set<Project> projectSet = new HashSet<>();
        ProjectDAOImplH projectDAOImplH = new ProjectDAOImplH();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            long numberProject;
            projectDAOImplH.getAll().forEach(System.out::println);
            numberProject = getParam("number of project");
            for (int i = 0; i < numberProject; i++){
                projectSet.add((Project) session.get(Project.class, getParam("id of project")));
            }
            customer.setProjects(projectSet);
            session.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
    }

    @Override
    public Customer get(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            Customer customer = (Customer) session.get(Customer.class, id);
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
        return null;
    }

    @Override
    public void update(Customer customer, long id) {
        Set<Project> projectSet = new HashSet<>();
        ProjectDAOImplH projectDAOImplH = new ProjectDAOImplH();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            Customer proxyCustomer = (Customer) session.load(Customer.class, id);
            proxyCustomer.setName(customer.getName());
            proxyCustomer.setAddress(customer.getAddress());
            long numberProject;
            projectDAOImplH.getAll().forEach(System.out::println);
            numberProject = getParam("number of project");
            for (int i = 0; i < numberProject; i++){
                projectSet.add((Project) session.get(Project.class, getParam("id of project")));
            }
            proxyCustomer.setProjects(projectSet);
            session.update(proxyCustomer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
    }

    @Override
    public void delete(long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Customer customer = (Customer) session.load(Customer.class, id);
        if (customer.getProjects().size() != 0) {
            while (customer.getProjects().iterator().hasNext()) {
                long idProject = customer.getProjects().iterator().next().getId();
                new ProjectDAOImplH().delete(idProject);
                customer.getProjects().remove(customer.getProjects().iterator().next());
            }
        }
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public List<Customer> findByAddress(String address) {
        return null;
    }

    public Set<Customer> getAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        try {
            return new HashSet<>(session.createQuery("select cust from Customer cust").list());
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.getTransaction().commit();
            session.clear();
        }
        return Collections.emptySet();
    }


}
