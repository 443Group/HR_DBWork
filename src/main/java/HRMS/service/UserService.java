package HRMS.service;

import HRMS.entity.Employee;
import HRMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> ah = new ArrayList<GrantedAuthority>();
        ah.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        ah.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User("user","ee11cbb19052e40b07aac0ca060c23ee",ah);

/*        Optional<Employee> user = employeeRepository.findById(Integer.valueOf(username));
        if (user.isPresent()) {
            Employee admin = user.get();
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(
                    admin.getId().toString(),
                    admin.getPassword(),
                    authorities);

        }
        throw new UsernameNotFoundException(
                "Employee '" + username + "' not found.");*/
    }
}
