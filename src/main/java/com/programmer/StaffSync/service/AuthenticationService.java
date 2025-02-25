package com.programmer.StaffSync.service;

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

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder,
        MailService mailService
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mailService = mailService;
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
        String[] emails = { user.getEmail() };
        Map<String, Object> variables = Map.of("link", "https://google.com");
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