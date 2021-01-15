package com.compassouol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.compassouol.domain.Cidade;
import com.compassouol.dto.CidadeDTO;
import com.compassouol.repositories.CidadeRepository;

@Service
public class CidadeService {
	

	@Autowired
	private CidadeRepository repo;

	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cidade find(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"ID da cidade não foi encontrado na base de dados ! Id: " + id + ", Tipo: " + Cidade.class.getName(),
				null));
	}

	public List<Cidade> findAll() {

		return repo.findAll();
	}

	public Page<Cidade> findAllEstados() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "estado");
		return new PageImpl<>(repo.findAll(), pageRequest, size);
	}

	public Page<Cidade> findAllPage() {
		int page = 0;
		int size = 5;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
		return new PageImpl<>(repo.findAll(), pageRequest, size);
	}

	public List<CidadeDTO> findByName(String nome) {

		List<Cidade> cidades = repo.findByEstado(nome);
		List<CidadeDTO> cidadesDTO = new ArrayList<>();

		for (Cidade cidade : cidades) {

			CidadeDTO cidadeDTO = new CidadeDTO(cidade);
			cidadesDTO.add(cidadeDTO);

		}
		if (cidadesDTO.isEmpty()) {

			throw new ObjectNotFoundException("Cidade não encontrada na base de dados", nome);

		}

		return cidadesDTO;
	}

	public Page<Cidade> search(String searchName, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nome");

		return repo.search(searchName.toLowerCase(), pageRequest);
	}

	public List<CidadeDTO> findByEstado(String estado) {

		List<Cidade> cidades = repo.findByEstado(estado);
		List<CidadeDTO> cidadesDTO = new ArrayList<>();

		for (Cidade cidade : cidades) {

			CidadeDTO cidadeDTO = new CidadeDTO(cidade);
			cidadesDTO.add(cidadeDTO);

		}
		if (cidadesDTO.isEmpty()) {

			throw new ObjectNotFoundException("Estado não encontrado na base de dados", estado);

		}

		return cidadesDTO;

	}

	public Page<Cidade> pesquisa(String searchName, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "estado");

		return repo.pesquisa(searchName.toLowerCase(), pageRequest);
	}

	public Cidade fromDTO(CidadeDTO objDTO) {
		return new Cidade(objDTO.getId(), objDTO.getNome(), objDTO.getEstado());
	}

}
