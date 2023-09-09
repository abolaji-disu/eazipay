package com.eazipay.eazipaytask.security;

import com.eazipay.eazipaytask.exception.UserNotFoundException;
import com.eazipay.eazipaytask.models.AppUser;
import com.eazipay.eazipaytask.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSecurityInfoService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<AppUser> userInfo =  appUserRepository.findUserByEmail(username);
        try {
            return userInfo.map(AppUserInfoDetails::new)
                    .orElseThrow(() -> new UserNotFoundException(
                            String.format("%S%S%S", "user with business name",
                                    username, "not found")));
        } catch (UserNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
