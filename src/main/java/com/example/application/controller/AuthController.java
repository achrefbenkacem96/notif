package com.example.application.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.entities.ERole;
import com.example.application.entities.Role;
import com.example.application.entities.Utilisateur;
import com.example.application.payload.request.LoginRequest;
import com.example.application.payload.request.SignupRequest;
import com.example.application.payload.response.JwtResponse;
import com.example.application.payload.response.MessageResponse;
import com.example.application.dao.RoleRepository;
import com.example.application.dao.UtilisateurRepository;
import com.example.application.security.jwt.JwtUtils;
import com.example.application.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUtilisateur(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUtilisateur(@Valid @RequestBody SignupRequest signUpRequest) {
        if (utilisateurRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (utilisateurRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Utilisateur utilisateur = new Utilisateur(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));


        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role utilisateurRole = roleRepository.findByName(ERole.ROLE_UTILISATEUR)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(utilisateurRole);

        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMINISTRATEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "ges":
                        Role gesRole = roleRepository.findByName(ERole.ROLE_GESTIONNAIRE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(gesRole);

                        break;
                    case "res":
                        Role resRole = roleRepository.findByName(ERole.ROLE_RESPONSABLE)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(resRole);

                        break;
                    default:
                        Role utilisateurRole = roleRepository.findByName(ERole.ROLE_UTILISATEUR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(utilisateurRole);
                }
            });
        }

        utilisateur.setRoles(roles);
        utilisateurRepository.save(utilisateur);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
