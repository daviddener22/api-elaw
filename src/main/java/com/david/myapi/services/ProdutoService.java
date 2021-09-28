package com.david.myapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.myapi.domain.Produto;
import com.david.myapi.repositories.ProdutoRepository;
import com.david.myapi.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto findById(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrado ID: " + id));
	}
	
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto update(Long id, Produto produto) {
		Produto produtoAlterado = findById(id);
		produtoAlterado.setNome(produto.getNome());
		produtoAlterado.setModelo(produto.getModelo());
		produtoAlterado.setDescricao(produto.getDescricao());
		produtoAlterado.setValor(produto.getValor());
		return produtoRepository.save(produtoAlterado);
	}

	public Produto create(Produto produto) {
		produto.setId(null);
		return produtoRepository.save(produto);
	}

	public void delete(Long id) {
		findById(id);
		produtoRepository.deleteById(id);
	}

}
