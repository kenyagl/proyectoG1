package com.cplcursos.java.kosso.config;

import com.cplcursos.java.kosso.services.MyUserDetailsSrvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig {

    @Autowired
    MyUserDetailsSrvc myUserDetailsSrvc;

    @Autowired
    PasswordEncoder passwordEncoder;
    private static final String[] ENDPOINTS_WHITELIST = {
            "/css/**",
            "/js/**",
            "/image/**",
            "/",
            "/login",
            "/usuario/registro/**",
            "/usuario/css/**",
            "/usuario/js",
            "/usuario/registro?success",
            "/home",
            "",
            "/preguntas",
            "/preguntas/search",
            "/preguntas/preguntaPublicada/**"

    };

    private static final String[] ENDPOINTS_WHITELIST_ADMIN = {
            "/ejercicios/new",
            "/ejercicios/delete",
            "/ejercicios/edit/**",
            "/ejercicios/save",
            "/usuario/listausus"
    };

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsSrvc();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(ENDPOINTS_WHITELIST).permitAll()
                        .requestMatchers(ENDPOINTS_WHITELIST_ADMIN).hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/login?logout")
                )
                .csrf().disable();

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(myUserDetailsSrvc);
        authProvider.setPasswordEncoder(passwordEncoder);

        return authProvider;
    }

}