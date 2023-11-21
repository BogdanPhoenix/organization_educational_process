package org.universities.organization_educational_process.persistence.dao.repositories.university;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.universities.organization_educational_process.persistence.model.university.Group;
import org.universities.organization_educational_process.persistence.model.university.Student;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;

import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByUserAndGroup(UserInfo user, Group group);
}
