package com.eazipay.eazipaytask.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    @Qualifier("customAuthenticationEntryPoint")
    private AuthenticationEntryPoint authEntryPoint;

    @Bean
    public UserDetailsService userDetailsService(){
     return new UserSecurityInfoService();
    };


    @Bean
    public AuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
         provider.setUserDetailsService(userDetailsService());
         provider.setPasswordEncoder(passwordEncoder());
         return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("api/v1/user/register",
                        "api/v1/user/editInvoice",
                        "api/v1/user/authenticate",
                        "api/v1/user/updateProfile",
                        "api/v1/user/confirmPayment",
                        "api/v1/user/upload/{userId}",
                        "api/v1/user/generateInvoice",
                        "api/v1/user/createInventory",
                        "api/v1/user/addItemToInvoice",
                        "api/v1/user/addItemToInventory",
                        "api/v1/user/sendInvoice/{invoiceId}",
                        "api/v1/user/cancelInvoice/{invoiceId}",
                        "api/v1/user/generateReceipt/{invoiceId}",
                        "api/v1/user/extendPaymentTime/{invoiceId}",
                        "api/v1/user/viewTransactionRecord/{appUserId}"
                        )
                .permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("")
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .build();

    }
}
