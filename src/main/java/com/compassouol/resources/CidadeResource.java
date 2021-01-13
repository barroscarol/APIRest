package com.compassouol.resources;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.compassouol.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cidade>> find(@PathVariable Integer id) {

		Optional<Cidade> obj = Optional.ofNullable(service.find(id));
		return ResponseEntity.ok().body(obj);
	}

	
	@GetMapping
	public Page<Cidade> getAll() {
		return service.findAll();
	}
	 
	@GetMapping("/search")
	public Page<Cidade> search(@RequestParam("searchTerm") String searchTerm,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return service.search(searchTerm, page, size);

	}
	
	@GetMapping("/pesquisa")
    public Page<Cidade> pesquisa(
            @RequestParam("pesquisarEstado") String pesquisarEstado,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10") int size) {
        return service.pesquisa(pesquisarEstado, page, size);

    }

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Cidade obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	


}
 
