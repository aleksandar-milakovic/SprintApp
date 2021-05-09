package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Sprint;


@Repository
public interface SprintRepository  extends JpaRepository<Sprint, Long>{

	   Sprint findOneById(Long id);

//    List<Sprint> findByzadaciId(List<Long> zadatakId);

	   

}
