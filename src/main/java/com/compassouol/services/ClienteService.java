package com.compassouol.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.compassouol.domain.Cliente;
import com.compassouol.dto.ClienteDTO;
import com.compassouol.dto.ClienteNewDTO;
import com.compassouol.repositories.ClienteRepository;
import com.compassouol.services.exception.DataIntegrityException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public List<ClienteDTO> findByName(String nomeCompleto) {

		List<Cliente> clientes = repo.findByNomeCompleto(nomeCompleto);
		List<ClienteDTO> clientesDTO = new ArrayList<>();

		for (Cliente cliente : clientes) {

			ClienteDTO clienteDTO = new ClienteDTO(cliente);
			clientesDTO.add(clienteDTO);

		}
		if (clientesDTO.isEmpty()) {

			throw new ObjectNotFoundException("Cliente não encontrado na base de dados", nomeCompleto);

		}

		return clientesDTO;
	}

	public Page<Cliente> search(String searchName, int page, int size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nomeCompleto");

		return repo.search(searchName.toLowerCase(), pageRequest);
	}

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"ID do cliente não foi encontrado na base de dados ! Id: " + id + ", Tipo: " + Cliente.class.getName(),
				null));
	}

	public List<Cliente> findAll() {

		return repo.findAll();
	}

	public Page<Cliente> findAllPage() {
		int page = 0;
		int size = 10;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "nomeCompleto");
		return new PageImpl<>(repo.findAll(), pageRequest, size);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNomeCompleto(), objDto.getSexo(), objDto.getDataDeNascimento(),
				objDto.getIdade(), objDto.getCidadeOndeReside());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Existem dados ainda vinculados ao cliente");
		}
	}

	public Cliente update(Cliente obj) {

		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);

		return repo.save(newObj);
	}

	private void updateData(Cliente newObj, Cliente obj) {

		newObj.setNomeCompleto(obj.getNomeCompleto());

	}

	public Cliente fromNewDTO(ClienteNewDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNomeCompleto(), null, null, 0, null);
	}

}
