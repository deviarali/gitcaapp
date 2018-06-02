package com.ajahsma.caapp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//    private UserDetailsService userDetailsService;
    
	@Autowired
	CustomAuthenticationProvider customAuthProvider;
	

    @Autowired
//    @Qualifier("myAccessDeniedHandler")
    AccessDeniedHandler myAccessDeniedHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) 
      throws Exception {
 
        auth.authenticationProvider(customAuthProvider);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	/*http.authorizeRequests().antMatchers("/resources/**", "/registration").permitAll().anyRequest().authenticated()
				.and().formLogin().loginPage("/login").permitAll().and().logout().permitAll();*/

		http.authorizeRequests().antMatchers("/login*").anonymous().antMatchers("/resources/**").permitAll().antMatchers("/caapp/**").authenticated().anyRequest().permitAll().and().formLogin().loginPage("/login").loginProcessingUrl("/login")
				.usernameParameter("userName").passwordParameter("password")
				.defaultSuccessUrl("/caapp/").failureUrl("/login?error=true").and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login").and().sessionManagement().invalidSessionUrl("/login").and().exceptionHandling().accessDeniedHandler(myAccessDeniedHandler).and().csrf().disable();
	
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }
}