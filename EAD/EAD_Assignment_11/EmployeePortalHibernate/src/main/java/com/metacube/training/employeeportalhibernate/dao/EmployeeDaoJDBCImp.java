package com.metacube.training.employeeportalhibernate.dao;

import java.util.List;

import javax.sql.DataSource;








import org.hibernate.Criteria;
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

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	   private SessionFactory sessionFactory;
	/*@Autowired
	public EmployeeDaoJDBCImp(DataSource dataSource) {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}*/
	@Override
	public List<Employee> getAll() {
		
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		List list=criteria.list();

		return list;
		//return jdbcTemplate.query(Query.SQL_SELECT_EMPLOYEE,new EmployeeMapper());
	}

	@Override
	public boolean create(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		int a=(Integer) session.save(employee);
		System.out.println(a);
		tx.commit(); 
		session.close();
		return true;
		/*return jdbcTemplate.update(Query.SQL_INSERT_EMPLOYEE,employee.getEmployeeCode(),employee.getFirstName()
				,employee.getMiddleName(),employee.getLastName(),
				employee.getDob(),employee.getGender(),employee.getContactNo(),employee.getEmailId(),employee.getPassword())>0;*/
	}

	@Override
	public boolean update(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String hqlUpdate = "update Employee set first_name=:firstName,middle_name=:middleName,last_name=:lastName\n"
				+ ",dob=:dob,gender=:gender,contact_no=:contactNo,email_id=:emailId where employee_code=:employeeCode";
		// or String hqlUpdate = "update Customer set name = :newName where name = :oldName";
		
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
		/*return jdbcTemplate.update(Query.SQL_UPDATE_EMPLOYEE,employee.getFirstName()
				,employee.getMiddleName(),employee.getLastName(),
				employee.getDob(),employee.getGender(),employee.getContactNo(),employee.getEmailId(),employee.getEmployeeCode())>0;*/
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
		//return jdbcTemplate.update(Query.SQL_UPDATE_EMPLOYEE_STATUS,status,employeeCode)>0;
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
		//return jdbcTemplate.queryForObject(Query.SQL_SELECT_EMPLOYEE_BY_EMPLOYEECODE,new Object[]{employeeCode}, new EmployeeMapper());
	}
	@Override
	public boolean deleteEmployeeById(String employeeCode) {
		return jdbcTemplate.update(Query.SQL_DELETE_EMPLOYEE,new Object[]{employeeCode})>0;
	}
	@Override
	public List<Employee> getEmployeeByName(String firstName) {
		Criteria criteria=sessionFactory.getCurrentSession().createCriteria(Employee.class);
		List list=criteria.add(Restrictions.eq("firstName",firstName )).list();
		return list;
		//return jdbcTemplate.query(Query.SQL_SELECT_EMPLOYEE_BY_FIRST_NAME,new Object[]{firstName},new EmployeeMapper());
	}

}
