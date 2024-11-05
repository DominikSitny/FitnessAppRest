package de.FitnessTracking.Repository;

import org.springframework.data.repository.CrudRepository;

import de.FitnessTracking.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByEmail(String email); 

}