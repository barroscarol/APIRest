package com.compassouol.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.compassouol.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	
	@Query("FROM Cidade cidade " + "WHERE LOWER(cidade.nome) like %:searchName% ")
	Page<Cidade> search(@Param("searchName") String searchName, Pageable pageable);

	@Query("FROM Cidade c " +
	           "WHERE LOWER(c.estado) like %:pesquisarEstado% ")
	    Page<Cidade> pesquisa(
	            @Param("pesquisarEstado") String pesquisarEstado, 
	            Pageable pageable);

}
