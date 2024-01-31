/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.service;

import com.projeto.Integrador.data.estoqueEntity;
import com.projeto.Integrador.data.estoqueRepository;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julianob
 */
@Service
public class estoqueService {

  @Autowired
private estoqueRepository EstoqueRepository;

    public void inserirEstoque(estoqueEntity estoque) 
    {
      EstoqueRepository.save(estoque);
    }
    
    public List<estoqueEntity> getEstoqueList() 
    {
    List<estoqueEntity> estoqueList = EstoqueRepository.findAll();
    return estoqueList;
    }

        public estoqueEntity findByEstoque(String nome)
        {
           return EstoqueRepository.findByNome(nome); 
        }
}
