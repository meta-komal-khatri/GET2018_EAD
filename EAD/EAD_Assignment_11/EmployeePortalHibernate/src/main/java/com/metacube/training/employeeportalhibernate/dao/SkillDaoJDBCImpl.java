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




import com.metacube.training.employeeportalhibernate.model.Projects;
import com.metacube.training.employeeportalhibernate.model.Skill;
import com.metacube.training.employeeportalhibernate.query.Query;

@Repository
@Transactional
public class SkillDaoJDBCImpl implements SkillDao{

	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@Override
	public List<Skill> getAll() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
		Root<Skill> projectRoot = criteria.from(Skill.class);
		criteria.select(projectRoot);
		List<Skill> skill = session.createQuery(criteria).getResultList();
		session.close();
		return skill;
	}

	@Override
	public boolean create(Skill skill) {
		Session session = sessionFactory.openSession();
		int a=(Integer) session.save(skill);
		session.close();
		return true;
	}

	@Override
	public boolean update(Skill t) {
		return false;
	}

	@Override
	public boolean delete(Skill t) {
		return false;
	}
	
}
