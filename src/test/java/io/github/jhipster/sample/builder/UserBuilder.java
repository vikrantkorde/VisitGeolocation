package io.github.jhipster.sample.builder;

import io.github.jhipster.sample.domain.Authority;
import io.github.jhipster.sample.domain.User;
import io.github.jhipster.sample.security.AuthoritiesConstants;
import io.github.jhipster.sample.service.dto.UserDTO;
import io.github.jhipster.sample.web.rest.vm.ManagedUserVM;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Builder to simplify creation of User objects in the unit and integration tests.
 *
 **/
public class UserBuilder {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String imageUrl;
    private String langKey;
    private Set<String> authorities = Set.of(AuthoritiesConstants.USER);

    private UserBuilder() {}

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public static UserBuilder aUser(ManagedUserVM user) {
        return aUser()
            .withLogin(user.login)
            .withPassword(user.password)
            .withFirstName(user.firstName)
            .withLastName(user.lastName)
            .withEmail(user.email)
            .withImageUrl(user.imageUrl)
            .withAuthorities(user.authorities);
    }

    public ManagedUserVM buildVM() {
        ManagedUserVM user = new ManagedUserVM();
        user.login = this.login;
        user.password = this.password;
        user.firstName = this.firstName;
        user.lastName = this.lastName;
        user.email = this.email;
        user.imageUrl = this.imageUrl;
        user.langKey = this.langKey;
        user.authorities = Collections.unmodifiableSet(this.authorities);
        return user;
    }

    public UserDTO buildDTO() {
        UserDTO user = new UserDTO();
        user.login = this.login;
        user.firstName = this.firstName;
        user.lastName = this.lastName;
        user.email = this.email;
        user.imageUrl = this.imageUrl;
        user.langKey = this.langKey;
        user.authorities = Collections.unmodifiableSet(this.authorities);
        return user;
    }

    public User build() {
        User user = new User();
        user.login = this.login;
        user.firstName = this.firstName;
        user.lastName = this.lastName;
        user.email = this.email;
        user.imageUrl = this.imageUrl;
        user.langKey = this.langKey;
        user.authorities = Collections.unmodifiableSet(this.authorities.stream().map(Authority::new).collect(Collectors.toSet()));
        return user;
    }

    public UserBuilder withLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public UserBuilder withLangKey(String langKey) {
        this.langKey = langKey;
        return this;
    }

    public UserBuilder withAuthorities(Set<String> authorities) {
        this.authorities = Collections.unmodifiableSet(authorities);
        return this;
    }
}
