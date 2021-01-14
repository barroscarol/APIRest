package com.compassouol.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.compassouol.domain.Cidade;
import com.compassouol.dto.CidadeDTO;
import com.compassouol.repositories.CidadeRepository;
import com.compassouol.services.exception.DataIntegrityException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;

	public Cidade find(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"ID da cidade não foi encontrado na base de dados ! Id: " + id + ", Tipo: " + Cidade.class.getName(),
				null));
	}

	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Page<Cidade> search(String searchName, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");

		return repo.search(searchName.toLowerCase(), pageRequest);
	}

	public Page<Cidade> findAll() {
		int page = 0;
		int size = 5;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return new PageImpl<>(repo.findAll(), pageRequest, size);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Existem dados ainda vinculados ao cliente");
		}
	}

	public Page<Cidade> pesquisa(String pesquisarEstado, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "estado");

		return repo.pesquisa(pesquisarEstado.toLowerCase(), pageRequest);
	}

	public Page<Cidade> findAlle() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "estado");
		return new PageImpl<>(repo.findAll(), pageRequest, size);
	}

	public Cidade fromDTO(CidadeDTO objDTO) {
		return new Cidade(objDTO.getId(), objDTO.getNome(), objDTO.getEstado());
	}
}
