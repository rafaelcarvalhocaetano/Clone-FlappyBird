package br.com.ifood.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.ifood.model.Address;

@Repository
public interface AddressRespository extends MongoRepository<Address, String>{

}