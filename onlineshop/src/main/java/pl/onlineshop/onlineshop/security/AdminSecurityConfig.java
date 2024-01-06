package pl.onlineshop.onlineshop.security;

import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import pl.onlineshop.onlineshop.entities.User;
import pl.onlineshop.onlineshop.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class AdminSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final CustomUserDetailsService customUserDetailsService;

    public AdminSecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorizeHttpRequests) ->
                {
                    try {
                        authorizeHttpRequests
                                .requestMatchers("/admin").hasAuthority("ADMIN")
                                .requestMatchers("/**").permitAll()
                                .and().formLogin()
                                .and().csrf().disable();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        return http.build();
    }


//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().dispatcherTypeMatchers(HttpMethod.valueOf("/")).permitAll();
//        http.authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                                .requestMatchers("/admin").hasRole("ADMIN")
//                )
//
//                .formLogin(login ->
//                        login
//                                .loginPage("/login")
//                                .usernameParameter("email")
//                                .loginProcessingUrl("/login")
//                                .defaultSuccessUrl("/admin")
//                                .permitAll()
//                )
//                .logout(logout ->
//                        logout
//                                .logoutUrl("/admin/logout")
//                                .logoutSuccessUrl("/")
//                                .permitAll()
//                )
//                .csrf().disable();
//    }

//    @Bean
//    public SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter() {
//        return new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
//            @Override
//            public void configure(HttpSecurity http) throws Exception {
//
//            }
//            @Override
//            public void configure(HttpSecurity http) throws Exception {
//                http.authorizeRequests(authorizeRequests ->
//                        {
//                            try {
//                                authorizeRequests
//
//                                        .dispatcherTypeMatchers(HttpMethod.GET, DispatcherType.valueOf("/admin/login")).permitAll()
//                                        .dispatcherTypeMatchers(HttpMethod.POST, DispatcherType.valueOf("/admin/login")).permitAll()
//                                        .dispatcherTypeMatchers(HttpMethod.GET, DispatcherType.valueOf("/admin")).hasRole("ADMIN")
//                                        .anyRequest().permitAll()
//                                        .and().formLogin().permitAll();
//                            } catch (Exception e) {
//                                throw new RuntimeException(e);
//                            }
//                        }
//                        );

//                        .formLogin(login ->
//                                login
//                                        .loginPage("/login")
//                                        .usernameParameter("email")
//                                        .loginProcessingUrl("/login")
//                                        .defaultSuccessUrl("/")
//                                        .permitAll()
//                        )
//                        .logout(logout ->
//                                logout
//                                        .logoutUrl("/admin/logout")
//                                        .logoutSuccessUrl("/login")
//                                        .permitAll()
//                        );

//
//        };
//
//    }
//}

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