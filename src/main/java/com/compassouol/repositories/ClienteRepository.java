package com.compassouol.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.compassouol.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findByNomeCompleto(String nomeCompleto);

	@Query("FROM Cliente cliente " + "WHERE LOWER(cliente.nomeCompleto) like %:searchName% ")
	Page<Cliente> search(@Param("searchName") String searchName, Pageable pageable);

}
