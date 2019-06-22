package yuans.amnesia.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import yuans.amnesia.spring.service.CuzUserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    private final DataSource dataSource;
//
//    @Autowired
//    public SecurityConfiguration(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private final CuzUserDetailServiceImpl userDetailService;

    @Autowired
    public SecurityConfiguration(CuzUserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .and()
                .logout()
                    .permitAll()
                    .and()
                .httpBasic();
//        http
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin().and()
//                .httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .inMemoryAuthentication()
////                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder())
////                .withUser("user")
////                .password("password")
////                .roles("USER");
////        auth
////                .jdbcAuthentication()
////                .dataSource(dataSource)
////                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder())
////                .usersByUsernameQuery()
//        auth
//                .userDetailsService(userDetailService);
//    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
//        UserDetails user =
//                User
//                        .withUsername("user")
//                        .passwordEncoder((String password) ->
//                                PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password))
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
        return userDetailService;
    }
}
