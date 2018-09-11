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

import com.metacube.training.employeeportalhibernate.mappers.SkillMapper;
import com.metacube.training.employeeportalhibernate.model.Projects;
import com.metacube.training.employeeportalhibernate.model.Skill;
import com.metacube.training.employeeportalhibernate.query.Query;

@Repository
public class SkillDaoJDBCImpl implements SkillDao{

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*@Autowired
    public SkillDaoJDBCImpl(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}*/
	
	@Override
	public List<Skill> getAll() {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Projects.class);
		List list=criteria.list();
		return list;
		//return jdbcTemplate.query(Query.SQL_GET_ALL_SKILL,new SkillMapper());
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
		//return jdbcTemplate.update(Query.SQL_INSERT_SKILL,skill.getName())>0;
	}

	@Override
	public boolean update(Skill t) {
		return false;
	}

	@Override
	public boolean delete(Skill t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
