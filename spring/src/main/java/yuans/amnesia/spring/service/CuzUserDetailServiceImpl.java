package yuans.amnesia.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;
import yuans.amnesia.spring.entity.Role;
import yuans.amnesia.spring.entity.User;
import yuans.amnesia.spring.repository.UserRepository;

@Service
public class CuzUserDetailServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Autowired
    public CuzUserDetailServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByName(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .passwordEncoder((String password) ->
                        PasswordEncoderFactories
                                .createDelegatingPasswordEncoder()
                                .encode(password))
                .password(user.getPassword())
                .roles(user
                        .getRoles()
                        .stream()
                        .map(Role::getName)
                        .toArray(String[]::new))
                .build();
    }
}
