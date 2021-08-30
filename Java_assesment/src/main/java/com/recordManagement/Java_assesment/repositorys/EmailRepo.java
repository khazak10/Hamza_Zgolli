package com.recordManagement.Java_assesment.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.recordManagement.Java_assesment.model.EmailEntity;

@Repository
@Transactional
public interface EmailRepo extends JpaRepository<EmailEntity, Long>{

}
