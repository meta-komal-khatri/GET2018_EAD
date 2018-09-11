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

import com.metacube.training.employeeportalhibernate.model.Employee;
import com.metacube.training.employeeportalhibernate.model.Job;
import com.metacube.training.employeeportalhibernate.model.Projects;
import com.metacube.training.employeeportalhibernate.query.Query;
import com.metacube.training.employeeportalhibernate.mappers.ProjectMapper;

@Repository
public class ProjectDaoJDBCImp implements ProjectDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;



	/*@Autowired
	public ProjectDaoJDBCImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/


	@Override
	public List<Projects> getAll() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Projects.class);
		List list=criteria.list();
		return list;
		//return jdbcTemplate.query(Query.SQL_GET_ALL, new ProjectMapper());
	}

	@Override
	public boolean create(Projects project) {	


		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			session.save(project);
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
		//return jdbcTemplate.update(Query.SQL_INSERT_PROJECT, project.getDescription(), project.getStartDate(),
		//project.getEndDate()) > 0;

	}

	@Override
	public boolean update(Projects project) {
		Session session = sessionFactory.openSession();
		Transaction transaction=null;
		int updatedEntities=0;
		try{
			transaction=session.beginTransaction();	
			String hqlUpdates="update Projects set description=:description,startDate=:startDate,endDate=endDate where id=:id";
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
		//return jdbcTemplate.update(Query.SQL_UPDATE_PROJECT,project.getDescription(),project.getStartDate(),project.getEndDate(),project.getId())>0;

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
		
		//return (Projects) jdbcTemplate.queryForObject(Query.SQL_FIND_PROJECT,new Object[]{id},new ProjectMapper());
	}


	@Override
	public boolean deleteProjectById(int id) {
		return jdbcTemplate.update(Query.SQL_DELETE_PROJECT,new Object[]{id})>0;
	}

}
