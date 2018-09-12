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
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.employeeportalhibernate.mappers.SkillMapper;
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
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Skill.class);
		List list=criteria.list();
		return list;
	}

	@Override
	public boolean create(Skill skill) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			session.save(skill);
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
