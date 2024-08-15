package com.exelBatch.reppo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exelBatch.model.data_exel;

@Repository
public interface dataExelReppo extends JpaRepository<data_exel,Long> {
  

}
