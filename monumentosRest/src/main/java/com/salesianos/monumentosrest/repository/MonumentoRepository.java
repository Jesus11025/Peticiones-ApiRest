package com.salesianos.monumentosrest.repository;

import com.salesianos.monumentosrest.model.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonumentoRepository extends JpaRepository<Monumento, Long> {

}
