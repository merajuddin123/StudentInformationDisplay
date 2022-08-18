package com.zenon.zenontest.loginconfig;
import com.zenon.zenontest.Employee;
import com.zenon.zenontest.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplement implements UserDetailsService{
	
	@Autowired
	private UserRepo userreposit;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp=userreposit.getEmployeeEmail(username);
		if(emp == null) {
			throw new UsernameNotFoundException("Could not found User");
			}
		EmployeeDetails employeedetails=new EmployeeDetails(emp);
		return employeedetails;
	}

	
}
