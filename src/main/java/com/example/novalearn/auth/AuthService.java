package com.example.novalearn.auth;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.novalearn.dao.RoleDao;
import com.example.novalearn.dao.StudentDao;
import com.example.novalearn.dao.TeacherDao;
import com.example.novalearn.dto.LoginRequest;
import com.example.novalearn.dto.RegisterDto;
import com.example.novalearn.entity.Education;
import com.example.novalearn.entity.Role;
import com.example.novalearn.entity.Student;
import com.example.novalearn.entity.Teacher;
import com.example.novalearn.exception.RegisterAccountTypeError;

/**
 * firstName
 * lastName
 * email
 * ?username
 * !password
 * *teacher
 * [qualification]
 * 
 */
@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    public String login(LoginRequest loginRequest) {
        var auth = new UsernamePasswordAuthenticationToken(loginRequest.userNameEmail(), loginRequest.password());
        Authentication result = authenticationManager.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(result);
        StringBuilder sb = new StringBuilder();
        for (GrantedAuthority authority : authenticationManager.authenticate(auth).getAuthorities()) {
            sb.append(authority.getAuthority());
        }
        return sb.toString();
    }

    public String register(RegisterDto registerDto, String accountType) {

        if ("teacher".equalsIgnoreCase(accountType)) {
            Role role = getRole("ROLE_TEACHER");
            if (role == null) {
                role = new Role();
                role.setRoleName("ROLE_TEACHER");
            }
            var teacher = new Teacher(
                    registerDto.getFirstName(),
                    registerDto.getLastName(),
                    registerDto.getEmail(),
                    registerDto.getUsername(),
                    passwordEncoder.encode(registerDto.getPassword()),registerDto.getNetWorth().valueOf(0));

            Optional.of(registerDto.getQualifications()).ifPresent(
                    qualifications -> {
                        qualifications.forEach(qualification -> teacher.addQualification(qualification));
                    });
            teacher.addRole(role);
            teacherDao.save(teacher);
            return "Successfully registered";

        } else if ("student".equalsIgnoreCase(accountType)) {
            Role role = getRole("ROLE_STUDENT");
            if (role == null) {
                role = new Role();
                role.setRoleName("ROLE_STUDENT");
            }
            var student = new Student(
                    registerDto.getFirstName(),
                    registerDto.getLastName(),
                    registerDto.getEmail(),
                    registerDto.getUsername(),
                    passwordEncoder.encode(registerDto.getPassword()),
                    Education.valueOf(registerDto.getEducation()));
            student.addRole(role);
            studentDao.save(student);
            return "Successfully registered";

        } else {
            throw new RegisterAccountTypeError("Invalid account type: " + accountType);
        }
    }

    private Role getRole(String roleName) {
        return roleDao.findByRoleName(roleName).orElse(null);
    }

}
