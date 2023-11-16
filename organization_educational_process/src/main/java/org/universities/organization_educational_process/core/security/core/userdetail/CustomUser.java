package org.universities.organization_educational_process.core.security.core.userdetail;

import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode
public class CustomUser implements UserDetails {
    private String password;
    private String username;
    private GrantedAuthority authority;
    private  boolean accountNonExpired;
    private  boolean accountNonLocked;
    private  boolean credentialsNonExpired;
    private  boolean enabled;
    private  String secret;

    public CustomUser(String username, String password, GrantedAuthority authorities, String secret) {
        this(username, password, true, true, true, true, authorities, secret);
    }

    public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                      boolean accountNonLocked, GrantedAuthority authority, final String secret) {

        if (((username == null) || username.isEmpty()) || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }

        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authority = authority;
        this.secret= secret;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void eraseCredentials() {
        password = null;
    }

    public String getSecret() {
        return secret;
    }

    public static final class CustomUserBuilder {
        private String password;
        private String username;
        private GrantedAuthority authority;
        private boolean accountNonExpired;
        private boolean accountNonLocked;
        private boolean credentialsNonExpired;
        private boolean enabled;
        private String secret;

        private CustomUserBuilder() {}

        public static CustomUserBuilder aCustomUser() {
            return new CustomUserBuilder();
        }

        public CustomUserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public CustomUserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public CustomUserBuilder withAuthorities(GrantedAuthority authority) {
            this.authority = authority;
            return this;
        }

        public CustomUserBuilder withAccountNonExpired(boolean accountNonExpired) {
            this.accountNonExpired = accountNonExpired;
            return this;
        }

        public CustomUserBuilder withAccountNonLocked(boolean accountNonLocked) {
            this.accountNonLocked = accountNonLocked;
            return this;
        }

        public CustomUserBuilder withCredentialsNonExpired(boolean credentialsNonExpired) {
            this.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public CustomUserBuilder withEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public CustomUserBuilder withSecret(String secret) {
            this.secret = secret;
            return this;
        }

        public CustomUser build() {
            CustomUser customUser = new CustomUser(username, password, !enabled, !accountNonExpired, !credentialsNonExpired, !accountNonLocked, authority, secret);
            customUser.authority = this.authority;
            return customUser;
        }
    }
}
