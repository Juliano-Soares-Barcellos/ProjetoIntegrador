/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.service;

import com.projeto.Integrador.data.funcionarioEntity;
import com.projeto.Integrador.data.funcionarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julianob
 */
@Service
public class serviceFuncionario {
    @Autowired
    funcionarioRepository FuncionarioRepository;
    
    
    public List<funcionarioEntity> getAllFuncionario()
     {
       return FuncionarioRepository.findAll();
     }
     
    public Optional<funcionarioEntity> getById(Integer id)
    {
        return FuncionarioRepository.findById(id);
    }
    
    public funcionarioEntity getByNome(String nome)
    {
        return  FuncionarioRepository.findByNome(nome);
    }
    
    public void deletaFuncionario(String nome)
    {
        funcionarioEntity func=getByNome(nome);
        FuncionarioRepository.delete(func);
    }
    
    public funcionarioEntity adcionaFuncionario(funcionarioEntity funcionario)
    {
        return FuncionarioRepository.save(funcionario);
    }
}
