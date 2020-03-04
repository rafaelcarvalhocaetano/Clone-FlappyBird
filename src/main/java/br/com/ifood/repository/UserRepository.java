package br.com.ifood.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ifood.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

  
}