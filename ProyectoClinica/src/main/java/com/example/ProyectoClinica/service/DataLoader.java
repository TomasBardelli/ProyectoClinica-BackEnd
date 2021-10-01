package com.example.ProyectoClinica.service;

import com.example.ProyectoClinica.model.AppUser;
import com.example.ProyectoClinica.model.AppUserRole;
import com.example.ProyectoClinica.model.Odontologo;
import com.example.ProyectoClinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");

        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");

        userRepository.save(new AppUser("Tomas","Bardo","tomas@gmail.com",hashedPassword, AppUserRole.ODONTOLOGO));
        userRepository.save(new AppUser("Maximo","Maxi","maxi@gmail.com",hashedPassword2, AppUserRole.PACIENTE));




    }
}
