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

import com.compassouol.domain.Cliente;
import com.compassouol.dto.ClienteDTO;
import com.compassouol.repositories.ClienteRepository;
import com.compassouol.services.exception.DataIntegrityException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"ID do cliente não foi encontrado na base de dados ! Id: " + id + ", Tipo: " + Cliente.class.getName(), null));
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Existem dados ainda vinculados ao cliente");
		}
	}
	
	 public Page<Cliente> search(
	            String searchTerm,
	            int page,
	            int size) {
	        PageRequest pageRequest = PageRequest.of(
	                page,
	                size,
	                Sort.Direction.ASC,
	                "nomeCompleto");

	        return repo.search(
	                searchTerm.toLowerCase(),
	                pageRequest);
	    }

	    public Page<Cliente> findAll() {
	        int page = 0;
	        int size = 10;
	        PageRequest pageRequest = PageRequest.of(
	                page,
	                size,
	                Sort.Direction.ASC,
	                "nomeCompleto");
	        return new PageImpl<>(
	                repo.findAll(), 
	                pageRequest, size);
	    }
	    
	    public Cliente update(Cliente obj) {

			/* Save serve para Inserir/Atualizar */

			Cliente newObj = find(obj.getId());
			updateData(newObj, obj);

			return repo.save(newObj);
		}
	    
	    public Cliente fromDTO(ClienteDTO objDTO) {

			return new Cliente(objDTO.getId(),null,null, null, 0, null);
		}
	    
	    private void updateData(Cliente newObj, Cliente obj) {
		//	newObj.setNome(obj.getNomeCompleto());
		//	newObj.setEmail(obj.getEmail());

		}
}
