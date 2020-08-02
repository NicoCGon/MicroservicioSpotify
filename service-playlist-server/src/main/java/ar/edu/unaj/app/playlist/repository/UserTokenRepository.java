package ar.edu.unaj.app.playlist.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unaj.app.playlist.models.UserToken;


public interface UserTokenRepository  extends CrudRepository<UserToken, String> {
	@Override
	Optional<UserToken> findById(String id);
}
