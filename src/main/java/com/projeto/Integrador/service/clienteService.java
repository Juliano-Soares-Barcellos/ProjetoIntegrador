/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.service;

import com.projeto.Integrador.data.clienteEntity;
import com.projeto.Integrador.data.clienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author julianob
 */
@Service
public class clienteService {

    @Autowired
    private clienteRepository ClienteRepository;

    public List<clienteEntity> findeByAll()
    {
        return ClienteRepository.findAll();  
    }
    
    public void inserirCliente(clienteEntity cliente)
    {
        
        
        ClienteRepository.save(cliente);
    }
    
    public clienteEntity findeByNome(String nome)
    {
        clienteEntity cliente=new clienteEntity();
        
        try
        {
           return ClienteRepository.findByNome(nome);
            
        }
        catch(Exception ex)
        {

         cliente.setNome(nome);   
         return cliente;
        }
    }
     
}
