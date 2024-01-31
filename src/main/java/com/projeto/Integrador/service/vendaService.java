/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.service;

import com.projeto.Integrador.data.clienteEntity;
import com.projeto.Integrador.data.estoqueEntity;
import com.projeto.Integrador.data.vendaEntity;
import com.projeto.Integrador.data.vendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julianob
 */
@Service
public class vendaService {
    @Autowired
    vendaRepository VendRepository;
    
    public vendaEntity findById(Integer Id)
    {
       return VendRepository.findById(Id).orElseThrow();
    }
    
    public void adcionarVenda(clienteEntity cliente,estoqueEntity estoque)
    {
        vendaEntity venda= new vendaEntity();
        venda.setEstoque(estoque);
        venda.setCliente(cliente);
        VendRepository.save(venda);
        
    }
       public List<vendaEntity> vendas(String nome) 
    {
        return VendRepository.findByNomeCliente(nome);
        
    }
    
}
