package com.metacube.training.employeeportalhibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;





import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.employeeportalhibernate.model.Employee;
import com.metacube.training.employeeportalhibernate.model.Job;
import com.metacube.training.employeeportalhibernate.query.Query;

@Repository
@Transactional
public class JobDaoJDBCImp implements JobDao {
	

	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<Job> getAll() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Job> criteria = builder.createQuery(Job.class);
		Root<Job> jobRoot = criteria.from(Job.class);
		criteria.select(jobRoot);
		List<Job> job = session.createQuery(criteria).getResultList();
		session.close();
		return job;
		
	}

	@Override
	public boolean create(Job job) {
		Session session = sessionFactory.openSession();
		int a=(Integer) session.save(job);
		session.close();
		return true;

		
	}

	@Override
	public boolean update(Job t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Job t) {
		// TODO Auto-generated method stub
		return false;
	}
}
