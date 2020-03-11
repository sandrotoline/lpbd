package lpbd.repository;

import org.springframework.data.repository.CrudRepository;

import lpbd.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}
