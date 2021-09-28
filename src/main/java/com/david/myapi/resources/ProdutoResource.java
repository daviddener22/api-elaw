package com.david.myapi.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.david.myapi.domain.Produto;
import com.david.myapi.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		return ResponseEntity.ok().body(produto);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtos = produtoService.findAll();
		return ResponseEntity.ok().body(produtos);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
		Produto produtoAlterado = produtoService.update(id, produto);
		return ResponseEntity.ok().body(produtoAlterado);
	}

	@PostMapping
	public ResponseEntity<Produto> create(@RequestBody Produto produto) {
		Produto novoProduto = produtoService.create(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novoProduto.getId()).toUri();
		return ResponseEntity.created(uri).body(novoProduto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
