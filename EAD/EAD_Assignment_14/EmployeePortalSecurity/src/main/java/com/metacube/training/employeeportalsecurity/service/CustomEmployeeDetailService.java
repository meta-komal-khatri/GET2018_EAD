package com.metacube.training.employeeportalsecurity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.employeeportalsecurity.model.Employee;
import com.metacube.training.employeeportalsecurity.model.Role;

@Service("CustomEmployeeDetailService")
public class CustomEmployeeDetailService implements UserDetailsService {

	@Autowired
	private EmployeeService employeeService;

	@Autowired 
	private RoleService roleService;
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String employeeCode)
			throws UsernameNotFoundException {
		Employee employee=employeeService.getEmployeeByEmployeeCode(employeeCode);
		
		if(employee==null){
			throw new UsernameNotFoundException("Username not found"); 
		}
//		return new UserDetails() {
//			
//			@Override
//			public boolean isEnabled() {
//				return employee.isEnable().equals("True");
//			}
//			
//			@Override
//			public boolean isCredentialsNonExpired() {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public boolean isAccountNonLocked() {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public boolean isAccountNonExpired() {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public String getUsername() {
//				return employee.getEmployeeCode();
//			}
//			
//			@Override
//			public String getPassword() {
//				return employee.getPassword();
//			}
//			
//			@Override
//			public Collection<? extends GrantedAuthority> getAuthorities() {
//				return getGrantedAuthorities(employee);
//			}
//		};
		return new User(employee.getEmployeeCode(), employee.getPassword(), 
				employee.isEnable().equals("True"), true, true, true, getGrantedAuthorities(employee));
	}


	private List<GrantedAuthority> getGrantedAuthorities(Employee employee){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role:roleService.getRoleByEmployeeCode(employee.getEmployeeCode())){
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

}

