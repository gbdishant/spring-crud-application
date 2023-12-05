package com.springcrud.user;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEntityRepository extends JpaRepository<UserEntity,Integer>, DataTablesRepository<UserEntity,Integer> {

    List<UserEntity> findByGender(String gender);
}
