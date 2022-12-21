package com.lendo.assessment.LendoAssmt.repository;


import com.lendo.assessment.LendoAssmt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {


}
