package com.metacube.training.employeeportalhibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
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


@Repository
@Transactional
public class ProjectDaoJDBCImp implements ProjectDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public List<Projects> getAll() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Projects> criteria = builder.createQuery(Projects.class);
		Root<Projects> projectRoot = criteria.from(Projects.class);
		criteria.select(projectRoot);
		List<Projects> project = session.createQuery(criteria).getResultList();
		session.close();
		return project;
		
	}

	@Override
	public boolean create(Projects project_master) {	
	
		Session session = sessionFactory.openSession();
		int a=(Integer) session.save(project_master);
		session.close();
		return true;
		

	}

	@Override
	public boolean update(Projects project) {
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Projects> criteria = builder.createCriteriaUpdate(Projects.class);
		Root<Projects> projectRoot = criteria.from(Projects.class);
		criteria.set(projectRoot.get("description"), project.getDescription()).where(builder.equal(projectRoot.get("id"), project.getId()));
		criteria.set(projectRoot.get("startDate"), project.getStartDate()).where(builder.equal(projectRoot.get("id"), project.getId()));
		criteria.set(projectRoot.get("endDate"), project.getEndDate()).where(builder.equal(projectRoot.get("id"), project.getId()));
		session.createQuery(criteria).executeUpdate();
		transaction.commit();
		session.close();
		return true;
		
		
	}

	@Override
	public boolean delete(Projects t) {
		return false;

	}


	@Override
	public Projects getProjectById(int id) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Projects> criteria = builder.createQuery(Projects.class);
		Root<Projects> projectRoot = criteria.from(Projects.class);
		criteria.select(projectRoot);
		criteria.where(builder.equal(projectRoot.get("id"), id));
		Projects project = session.createQuery(criteria).getSingleResult();
		session.close();
		return project;
		
	
	}


	@Override
	public boolean deleteProjectById(int id) {
Session session = sessionFactory.openSession();
		
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaDelete<Projects> criteriaDelete=criteriaBuilder.createCriteriaDelete(Projects.class);
		Root<Projects> projectRoot=criteriaDelete.from(Projects.class);
		criteriaDelete.where(criteriaBuilder.equal(projectRoot.get("id"),id));
		int update=session.createQuery(criteriaDelete).executeUpdate();
		session.close();
		return update>0;
	}

}
