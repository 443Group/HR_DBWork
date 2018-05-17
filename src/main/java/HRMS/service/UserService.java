package HRMS.service;

import HRMS.entity.Employee;
import HRMS.repository.AdminRepository;
import HRMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        List<GrantedAuthority> ah = new ArrayList<GrantedAuthority>();
//        ah.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        ah.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//        return new User("user","ee11cbb19052e40b07aac0ca060c23ee",ah);
        String[] paras = username.split("#");
        if(paras.length != 2)
            throw new UsernameNotFoundException(
                    "Bad Request: "+username);

        Integer role = Integer.valueOf(paras[0]);
        Long id = Long.valueOf(paras[1]);
        Optional<Employee> user = employeeRepository.findById(id);

        if (user.isPresent()) {
            Employee employee = user.get();
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

            if(adminRepository.findByEmpId(employee.getId()) != null)
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

            return new User(
                    employee.getId().toString(),
                    employee.getPassword(),
                    authorities);
        }
        throw new UsernameNotFoundException(
                "Employee '" + username + "' not found.");
    }
}
