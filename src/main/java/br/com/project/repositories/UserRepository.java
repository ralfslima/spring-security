package br.com.project.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long>{
    
    Optional<UserModel> findByUser(String user);

}