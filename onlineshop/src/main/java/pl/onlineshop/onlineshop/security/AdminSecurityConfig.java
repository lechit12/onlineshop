package pl.onlineshop.onlineshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import pl.onlineshop.onlineshop.services.CustomUserDetailsService;

@Configuration

public class AdminSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final CustomUserDetailsService customUserDetailsService;

    public AdminSecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/admin/**")).authenticated()
                                .dispatcherTypeMatchers(HttpMethod.valueOf("/admin/login")).permitAll()
                                .anyRequest().permitAll()
                )
                .formLogin(login ->
                        login
                                .loginPage("/admin/login")
                                .usernameParameter("email")
                                .loginProcessingUrl("/admin/login")
                                .defaultSuccessUrl("/admin/admin")
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/admin/logout")
                                .logoutSuccessUrl("/")
                                .permitAll()
                );
    }

    @Bean
    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
            @Override
            public void configure(HttpSecurity http) {
                // Dodaj tutaj dodatkową konfigurację, jeśli to konieczne
            }
        };
    }

//    @Bean
//    public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .dispatcherTypeMatchers(HttpMethod.valueOf("/authentication/**")).permitAll()
//                                .dispatcherTypeMatchers(HttpMethod.valueOf("/admin/**")).authenticated()
//                                .dispatcherTypeMatchers(HttpMethod.valueOf("/admin/login")).permitAll()
//                                .dispatcherTypeMatchers(HttpMethod.valueOf("/admin/home")).hasAuthority("ADMIN")
//                                .anyRequest().authenticated()
//                )
//                .formLogin(login ->
//                        login
//                                .loginPage("/admin/login")
//                                .usernameParameter("email")
//                                .loginProcessingUrl("/admin/login")
//                                .defaultSuccessUrl("/admin/home")
//                                .permitAll()
//                )
//                .logout(logout ->
//                        logout
//                                .logoutUrl("/admin/logout")
//                                .logoutSuccessUrl("/")
//                );
//
//        return http.build();
//    }
}
