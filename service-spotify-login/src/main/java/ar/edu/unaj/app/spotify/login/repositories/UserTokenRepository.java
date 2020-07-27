package ar.edu.unaj.app.spotify.login.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unaj.app.spotify.login.entities.UserToken;

public interface UserTokenRepository extends CrudRepository<UserToken, String> {
	Optional<UserToken> findById(String id);
}
