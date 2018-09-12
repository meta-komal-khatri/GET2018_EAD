package com.metacube.training.employeeportalhibernate.dao;

import java.util.List;

import javax.sql.DataSource;



import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.employeeportalhibernate.model.Employee;
import com.metacube.training.employeeportalhibernate.model.Job;
import com.metacube.training.employeeportalhibernate.model.Projects;
import com.metacube.training.employeeportalhibernate.query.Query;
import com.metacube.training.employeeportalhibernate.mappers.ProjectMapper;

@Repository
@Transactional
public class ProjectDaoJDBCImp implements ProjectDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Projects> getAll() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Projects.class);
		List list=criteria.list();
		return list;
		
	}

	@Override
	public boolean create(Projects project_master) {	


	
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			session.save(project_master);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			System.out.println(e.getMessage());
			return false;
		}finally{
			session.close();
		}

		return true;
		

	}

	@Override
	public boolean update(Projects project) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
		int updatedEntities=0;
		try{
			transaction=session.beginTransaction();	
			String hqlUpdates="update Projects set description=:description,startDate=:startDate,endDate=:endDate where id=:id";
			updatedEntities=session.createQuery(hqlUpdates)
					.setString("description",project.getDescription())
					.setDate("startDate",project.getStartDate())
					.setDate("endDate",project.getEndDate())
					.setInteger("id",project.getId())
					.executeUpdate();
			transaction.commit();
		}catch(HibernateException exception){
			if(transaction!=null){
				transaction.rollback();
			}
			throw new RuntimeException();
		}finally{
			session.close();
		}
		return updatedEntities>0;
		
	}

	@Override
	public boolean delete(Projects t) {
		return false;

	}


	@Override
	public Projects getProjectById(int id) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Projects.class)
				.add(Restrictions.eq("id", id));
				Object result=criteria.uniqueResult();
				if(result!=null){
					return (Projects) result;
				}
				else{
					return null;
				}
		
	
	}


	@Override
	public boolean deleteProjectById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			
			Projects project = (Projects) session.createCriteria(Projects.class)
	                 .add(Restrictions.eq("id", id)).uniqueResult();
	        session.delete(project);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			return false;
		}finally{
			session.close();
		}

		return true;
	}

}
