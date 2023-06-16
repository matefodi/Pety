package com.Windir.Pety.repository;

import com.Windir.Pety.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Repository for the Entity {@link Dog}
 */
@Repository
public interface DogRepository extends JpaRepository<Dog,Long> {
}
