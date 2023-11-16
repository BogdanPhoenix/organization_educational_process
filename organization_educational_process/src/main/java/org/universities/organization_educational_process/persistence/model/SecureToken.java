package org.universities.organization_educational_process.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "secures_token")
public class SecureToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "index_user")
    private Long indexUser;

    @Column(name = "token", nullable = false, unique = true)
    @NonNull
    private String token;

    @CreationTimestamp
    @Column(name = "time_stamp", updatable = false)
    @NonNull
    private Timestamp timeStamp;

    @Column(name = "expire_at", updatable = false)
    @Basic(optional = false)
    @NonNull
    private LocalDateTime expireAt;

    @ManyToOne
    @JoinColumn(name = "custom_id", nullable = false, referencedColumnName = "index_user")
    @NonNull
    private UsersInfo user;

    @Transient
    private boolean isExpired;
}
