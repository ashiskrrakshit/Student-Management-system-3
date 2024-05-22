package com.project.SMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.SMS.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
