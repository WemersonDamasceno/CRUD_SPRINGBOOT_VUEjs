package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	//listar todos os produtos
	@GetMapping("/produtos")
	public List<Produto> listar(){ 
		return produtoRepository.findAll();
	}
	
	
	//salvar um produto no banco
	@PostMapping("/produto")
	public Produto salvarProduto(@RequestBody Produto produto) {	
		return produtoRepository.save(produto);
	}
	
	//deletar um produto no banco
	@DeleteMapping("/produto")
	public void deletarProduto(@RequestBody Produto produto) {	
		produtoRepository.delete(produto);			
	}
		
	//atualizar um produto do banco
	@PutMapping("/produto")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	
	
}
