package com.programmer.StaffSync.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.programmer.StaffSync.dto.LoginUserDto;
import com.programmer.StaffSync.dto.RegisterUserDto;
import com.programmer.StaffSync.entity.User;
import com.programmer.StaffSync.enums.UserRole;
import com.programmer.StaffSync.repository.UserRepository;

import jakarta.mail.MessagingException;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final MailService mailService;
    private final JwtService jwtService;

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder,
        MailService mailService,
        JwtService jwtService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
        this.jwtService = jwtService;
    }

    public User signup(RegisterUserDto input, UserRole userRole) {
        User user = new User();
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(userRole); // Default role is EMPLOYEE
        sendResetPasswordEmail(user);
        return userRepository.save(user);
    }

    public void sendResetPasswordEmail(User user) {
        String jwtToken = jwtService.generateToken(new HashMap<>(), user, 60_000 * 5); // 5 min valid token
        String[] emails = { user.getEmail() };
        System.out.println(jwtToken);
        Map<String, Object> variables = Map.of("link", "https://google.com?token=" + jwtToken);
        try {
            this.mailService.sendTemplateEmail(emails, "Reset password", "reset-password", variables);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}