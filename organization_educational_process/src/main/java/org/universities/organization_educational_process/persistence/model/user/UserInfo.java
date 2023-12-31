package org.universities.organization_educational_process.persistence.model.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.universities.organization_educational_process.enumarations.Role;
import org.universities.organization_educational_process.persistence.model.BookingAuditorium;
import org.universities.organization_educational_process.persistence.model.university.Teacher;
import org.universities.organization_educational_process.persistence.model.university.Student;

import java.util.Collection;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "users_info", uniqueConstraints = {@UniqueConstraint(columnNames = {"last_name", "first_name", "patronymic"})})
public class UserInfo implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_user")
    private Long indexUser;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "user_email", nullable = false, unique = true)
    @NonNull
    private String userEmail;

    @Column(name = "password_user", length = 1000, nullable = false)
    @NonNull
    private String passwordUser;

    @Column(name = "last_name", nullable = false)
    @NonNull
    private String lastName;

    @Column(name = "first_name", nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "patronymic", nullable = false)
    @NonNull
    private String patronymic;

    @Column(name = "current_data", nullable = false)
    private boolean currentData;

    @PreRemove
    public void preRemove() {
        this.currentData = false;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private transient Teacher teacher;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private transient Student student;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.SET_DEFAULT)
    private transient Set<BookingAuditorium> bookingAuditoriums;

    @OneToMany(mappedBy = "user")
    private transient Set<Token> tokens;

    //security

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return passwordUser;
    }

    @Override
    public String getUsername() {
        return userEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return currentData;
    }
}
