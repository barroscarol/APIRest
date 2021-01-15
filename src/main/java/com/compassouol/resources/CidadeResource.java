package com.compassouol.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compassouol.domain.Cidade;
import com.compassouol.domain.Cliente;
import com.compassouol.dto.CidadeDTO;
import com.compassouol.services.CidadeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;

	@ApiOperation(value = "Listar todas Cidades")
	@GetMapping
	public ResponseEntity<List<CidadeDTO>> findAll() {

		List<Cidade> list = service.findAll();
		List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value = "Listar todas as Cidades com Paginação")
	@GetMapping("/page")
	public Page<Cidade> getAll() {
		return service.findAllPage();
	}

	@ApiOperation(value = "Buscar cidade por id")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cidade>> find(@PathVariable Integer id) {

		Optional<Cidade> obj = Optional.ofNullable(service.find(id));
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Buscar cidade por nome")
	@GetMapping("/search")
	public Page<Cidade> search(@RequestParam("searchName") String searchName,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return service.search(searchName, page, size);
	}

	@ApiOperation(value = "Buscar cidade por estado")
	@GetMapping("/pesquisa")
	public Page<Cidade> pesquisa(@RequestParam("searchName") String searchName,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return service.pesquisa(searchName, page, size);
	}

	@ApiOperation(value = "Inserir nova cidade")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CidadeDTO objDto) {
		Cidade obj = service.fromDTO(objDto);
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@GetMapping(value = "/nome")
	public ResponseEntity<Cidade> buscar(@RequestParam("searchName") @PathVariable String nome) {
		Cidade obj = service.findByName(nome);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/estado")
	public ResponseEntity<List<CidadeDTO>> buscarEstado(@RequestParam("searchName") @PathVariable String estado) {

		List<CidadeDTO> cidadesDTO = service.findByEstado(estado);

		return ResponseEntity.ok().body(cidadesDTO);
	}

}
