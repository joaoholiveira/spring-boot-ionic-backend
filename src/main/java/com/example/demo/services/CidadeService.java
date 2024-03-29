package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cidade;
import com.example.demo.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo; 
	
	public List<Cidade> fundByEstado(Integer estadoId){
		return repo.findCidades(estadoId); 
	}
}
