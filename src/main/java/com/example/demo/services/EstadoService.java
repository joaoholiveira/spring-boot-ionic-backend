package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Estado;
import com.example.demo.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo; 
	
	public List<Estado> findAll(){
		return repo.findAllByOrderByNome();
	}
	
}
