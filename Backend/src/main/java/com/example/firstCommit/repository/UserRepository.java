package com.example.firstCommit.repository;

import com.example.firstCommit.entities.User;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByUsername (String email);

   Boolean existsByUsername(String username);

   Boolean existsByEmail(String email);
}
