package com.libertymutual.goforcode.invoicify.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.security.core.GrantedAuthority;

import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

public class UserModelTests {

	private UserRepository userRepo;
	
	@Before
	public void setUp() {
		userRepo = mock(UserRepository.class);
	}
	
	@Test
	public void test_get_Authorities_returns_correct_authorities() {
		// Arrange
		User user = new User();
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(new UserRole("CLERK", user));
		roles.add(new UserRole("ADMIN", user));
		roles.add(new UserRole("ACCOUNTANT", user));
		user.setRoles(roles);
		
		// Act
		List<? extends GrantedAuthority> actualRoles = user.getAuthorities().stream().collect(Collectors.toList());
		
		// Assert
		assertThat(actualRoles.get(0).getAuthority()).isEqualTo("ROLE_CLERK");
	}
	
	@Test
    public void test_all_gets_and_sets() {
        new BeanTester().testBean(User.class);
    } 
	
	@Test
	public void test_isAccountNonExpired_returns() {
		// Arrange
		User user = new User();
		user.isAccountNonExpired();
		
		// Act
		boolean actual = user.isAccountNonExpired();
		
		//Assert
		assertThat(actual).isEqualTo(true);
	}
	
	@Test
	public void test_is_Account_Non_Locked_returns() {
		// Arrange
		User user = new User();
		user.isAccountNonLocked();
		
		// Act
		boolean actual = user.isAccountNonLocked();
		
		// Assert
		assertThat(actual).isEqualTo(true);
	}
	
	@Test
	public void test_is_Credentials_Non_Expired_returns() {
		User user = new User();
		assertThat(user.isCredentialsNonExpired()).isEqualTo(true);
	}
	
	@Test
	public void test_is_Enabled_returns() {
		User user = new User();
		assertThat(user.isEnabled()).isEqualTo(true);
	}

}
