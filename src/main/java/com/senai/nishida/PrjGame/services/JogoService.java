package com.senai.nishida.PrjGame.services;

import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.senai.nishida.PrjGame.entities.Jogo;
import com.senai.nishida.PrjGame.repositories.JogoRepository;


@Service
public class JogoService {
	private final JogoRepository jogoRepository;
	
	public JogoService (JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	//preparando buscas por id
	public Jogo getJogoById(Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	//preparando busca geral
	public List<Jogo> getAllJogo(){
		return jogoRepository.findAll();
	}
	
	//salvando o jogo
	public Jogo saveJogo(Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	//apagando o jogo
	public void deleteJogo(Long id) {
		jogoRepository.deleteById(id);
	}
	
	// fazendo o update do jogo com o optional
	public Jogo updateJogo(Long id, Jogo novoJogo) {
	    Optional<Jogo> jogoOptional = jogoRepository.findById(id);
	       if (jogoOptional.isPresent()) {
	        Jogo jogoExistente = jogoOptional.get();
	        jogoExistente.setName(novoJogo.getName());
	        jogoExistente.setPlataform(novoJogo.getPlataform());          
	           return jogoRepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	 }

}
