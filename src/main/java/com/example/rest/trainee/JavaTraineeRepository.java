package com.example.rest.trainee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaTraineeRepository extends JpaRepository<JavaTraineeEntity, String> {
}
