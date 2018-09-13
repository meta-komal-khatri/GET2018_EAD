package com.metacube.training.employeeportalhibernate.dao;


import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;


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









import com.metacube.training.employeeportalhibernate.model.Employee;
import com.metacube.training.employeeportalhibernate.query.Query;


@Repository

public class EmployeeDaoJDBCImp implements EmployeeDao{


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getAll() {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		
		
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
		List<Employee> employee = session.createQuery(criteria).getResultList();
		session.close();
		return employee;
		


	}

	@Override
	public boolean create(Employee employee) {
		Session session = sessionFactory.openSession();
		int a=(Integer) session.save(employee);
		session.close();
		return true;

	}

	@Override
	public boolean update(Employee employee) {


		Session session = sessionFactory.openSession();
		//Transaction transaction=session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteria = builder.createCriteriaUpdate(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.set(employeeRoot.get("firstName"), employee.getFirstName()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
		criteria.set(employeeRoot.get("middleName"), employee.getMiddleName()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
		criteria.set(employeeRoot.get("lastName"), employee.getLastName()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
		criteria.set(employeeRoot.get("dob"), employee.getDob()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
		criteria.set(employeeRoot.get("gender"), employee.getGender()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
		criteria.set(employeeRoot.get("contactNo"), employee.getContactNo()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
		criteria.set(employeeRoot.get("emailId"), employee.getEmailId()).where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));

		int updated=session.createQuery(criteria).executeUpdate();
		//transaction.commit();
		
		session.close();
		return updated>0;


	}


	@Override
	public boolean delete(Employee t) {
		return false;
	}
	@Override
	public boolean upadteStatusOfEmployee(String employeeCode,String status) {
		Session session = sessionFactory.openSession();
		//Transaction transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaUpdate<Employee> criteriaUpdate=criteriaBuilder.createCriteriaUpdate(Employee.class);
		Root<Employee> employeeRoot=criteriaUpdate.from(Employee.class);
		criteriaUpdate.set(employeeRoot.get("status"), status).where(criteriaBuilder.equal(employeeRoot.get("employeeCode"), employeeCode));
		int update=session.createQuery(criteriaUpdate).executeUpdate();
		//transaction.commit();
		session.close();
		return update>0;

	}
	@Override
	public Employee getEmployeeById(String employeeCode) {
		
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
	    criteria.where(builder.equal(employeeRoot.get("employeeCode"), employeeCode));
			
	    Employee employee = session.createQuery(criteria).getSingleResult();
			
			return employee;
		
		
	}
	@Override
	public boolean deleteEmployeeById(String employeeCode) {
		Session session = sessionFactory.openSession();
		//Transaction transaction=session.beginTransaction();
		CriteriaBuilder criteriaBuilder=session.getCriteriaBuilder();
		CriteriaDelete<Employee> criteriaDelete=criteriaBuilder.createCriteriaDelete(Employee.class);
		Root<Employee> employeeRoot=criteriaDelete.from(Employee.class);
		criteriaDelete.where(criteriaBuilder.equal(employeeRoot.get("employeeCode"),employeeCode));
		int update=session.createQuery(criteriaDelete).executeUpdate();
		//transaction.commit();
		session.close();
		return update>0;


	}
	@Override
	public List<Employee> getEmployeeByName(String firstName) {
		Session session = sessionFactory.openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteria.from(Employee.class);
		criteria.select(employeeRoot);
	    criteria.where(builder.equal(employeeRoot.get("firstName"), firstName));
			
	    List<Employee> employee = session.createQuery(criteria).getResultList();
			
			return employee;

	}

}
