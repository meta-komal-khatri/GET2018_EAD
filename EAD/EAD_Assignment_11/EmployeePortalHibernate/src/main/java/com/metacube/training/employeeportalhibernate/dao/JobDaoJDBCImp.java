package com.metacube.training.employeeportalhibernate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.employeeportalhibernate.mappers.JobMapper;
import com.metacube.training.employeeportalhibernate.model.Employee;
import com.metacube.training.employeeportalhibernate.model.Job;
import com.metacube.training.employeeportalhibernate.query.Query;

@Repository
public class JobDaoJDBCImp implements JobDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	/*@Autowired
	public JobDaoJDBCImp(DataSource dataSource){
		jdbcTemplate=new JdbcTemplate(dataSource);
	}*/

	@Override
	public List<Job> getAll() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Job.class);
		List list=criteria.list();

		return list;
		//return jdbcTemplate.query(Query.SQL_GET_ALL_JOBS,new JobMapper());
	}

	@Override
	public boolean create(Job job) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			session.save(job);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			return false;
		}finally{
			session.close();
		}

		return true;

		//return jdbcTemplate.update(Query.SQL_INSERT_JOBS,job.getTitle())>0;
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
