package ar.edu.unaj.app.spotify.login.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unaj.app.spotify.login.entities.User;

public interface UserRepository extends CrudRepository<User, String> {
	Optional<User> findById(String id);
}
