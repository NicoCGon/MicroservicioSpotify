package ar.edu.unaj.app.gateway.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unaj.app.gateway.models.UserToken;


public interface UserTokenRepository  extends CrudRepository<UserToken, String> {
	Optional<UserToken> findById(String id);
}
