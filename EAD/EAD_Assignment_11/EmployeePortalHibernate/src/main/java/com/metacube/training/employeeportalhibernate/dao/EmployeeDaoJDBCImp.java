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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.employeeportalhibernate.mappers.EmployeeMapper;
import com.metacube.training.employeeportalhibernate.model.Employee;
import com.metacube.training.employeeportalhibernate.query.Query;


@Repository
@Transactional
public class EmployeeDaoJDBCImp implements EmployeeDao{

	
	@Autowired
	   private SessionFactory sessionFactory;
	
	@Override
	public List<Employee> getAll() {
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		List list=criteria.list();

		return list;
		
	}

	@Override
	public boolean create(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int a=(Integer) session.save(employee);
		tx.commit(); 
		session.close();
		return true;
		
	}

	@Override
	public boolean update(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hqlUpdate = "update Employee set first_name=:firstName,middle_name=:middleName,last_name=:lastName\n"
				+ ",dob=:dob,gender=:gender,contact_no=:contactNo,email_id=:emailId where employee_code=:employeeCode";
		
		int updatedEntities = session.createQuery( hqlUpdate )
		        .setString( "firstName", employee.getFirstName() )
		        .setString( "middleName", employee.getMiddleName() )
		        .setString( "lastName", employee.getLastName() )
		        .setDate( "dob", employee.getDob() )
		        .setString( "gender", employee.getGender() )
		        .setInteger( "contactNo", employee.getContactNo() )
		        .setString("emailId",employee.getEmailId())
		        .setString("employeeCode",employee.getEmployeeCode())
		        .executeUpdate();
		tx.commit();
		session.close();
		return updatedEntities>0;
		
	}

	
	@Override
	public boolean delete(Employee t) {
		return false;
	}
	@Override
	public boolean upadteStatusOfEmployee(String employeeCode,String status) {
		Session session = sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();	
		String hqlUpdates="update Employee set status=:status where employeeCode=:employeeCode";
		
		int updatedEntities=session.createQuery(hqlUpdates)
				.setString("status",status)
				.setString("employeeCode", employeeCode)
				.executeUpdate();
		return updatedEntities>0;
		
	}
	@Override
	public Employee getEmployeeById(String employeeCode) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class)
		.add(Restrictions.eq("employeeCode", employeeCode));
		Object result=criteria.uniqueResult();
		if(result!=null){
			return (Employee) result;
		}
		else{
			return null;
		}
		
	}
	@Override
	public boolean deleteEmployeeById(String employeeCode) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			
			Employee employee = (Employee) session.createCriteria(Employee.class)
	                 .add(Restrictions.eq("employeeCode", employeeCode)).uniqueResult();
	        session.delete(employee);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null)
				tx.rollback();
			return false;
		}finally{
			session.close();
		}

		return true;

        
		//return jdbcTemplate.update(Query.SQL_DELETE_EMPLOYEE,new Object[]{employeeCode})>0;
	}
	@Override
	public List<Employee> getEmployeeByName(String firstName) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		List list=criteria.add(Restrictions.eq("firstName",firstName )).list();
		return list;
		
	}

}
