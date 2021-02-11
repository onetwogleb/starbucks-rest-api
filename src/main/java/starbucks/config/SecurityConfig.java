package starbucks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/coffee").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/coffee/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/coffee").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/coffee/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/coffee").hasAnyRole("EDITOR", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/coffee/**").hasAnyRole("EDITOR", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/coffee/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
