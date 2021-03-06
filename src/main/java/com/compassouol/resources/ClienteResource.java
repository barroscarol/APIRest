package com.compassouol.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compassouol.domain.Cliente;
import com.compassouol.dto.ClienteDTO;
import com.compassouol.dto.ClienteNewDTO;
import com.compassouol.services.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@ApiOperation(value = "Inserir um novo cliente")
	@PostMapping
	public ResponseEntity<Cliente> insert(@Valid @RequestBody ClienteDTO objDto) {
		Cliente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Buscar clientes por nome completo")
	@GetMapping(value = "/nome")
	public ResponseEntity<List<ClienteDTO>> buscar(@RequestParam("searchName") @PathVariable String nomeCompleto) {

		List<ClienteDTO> clientesDTO = service.findByName(nomeCompleto);

		return ResponseEntity.ok().body(clientesDTO);
	}

	@ApiOperation(value = "Buscar clientes por nome com paginação")
	@GetMapping("/search")
	public Page<Cliente> search(@Valid @RequestParam("searchName") String searchName,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return service.search(searchName, page, size);

	}

	@ApiOperation(value = "Buscar Cliente por id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> find(@PathVariable Integer id) {

		Optional<Cliente> obj = Optional.ofNullable(service.find(id));
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Listar todos os clientes")
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {

		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value = "Lista paginada")
	@GetMapping("/page")
	public Page<Cliente> getAll() {
		return service.findAllPage();
	}

	@ApiOperation(value = "Remover cliente")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Alterar nome de cliente por id")
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteNewDTO objDto, @PathVariable Integer id) {

		Cliente obj = service.fromNewDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
	}

}
