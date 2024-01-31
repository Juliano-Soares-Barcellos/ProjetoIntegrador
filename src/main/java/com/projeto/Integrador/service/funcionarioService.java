/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.service;

import com.projeto.Integrador.data.funcionarioEntity;
import com.projeto.Integrador.data.funcionarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author julianob
 */
@Service
public class funcionarioService {
    @Autowired
  funcionarioRepository Funcionario;
    
    public funcionarioEntity finbfunc(String nome)
    {
        return Funcionario.findByNome(nome);
    }
    
 public boolean deletar(String nome) {
    funcionarioEntity funcionario = finbfunc(nome);
    if (funcionario != null) {
        Funcionario.deleteById(funcionario.getId());
        return true; 
    } else {
        return false; 
    }
}
public List<funcionarioEntity> findAll()
{
    return Funcionario.findAll();
}
    
    public boolean inserir(funcionarioEntity funcionario)
    {
       funcionarioEntity func = new funcionarioEntity();
       func= finbfunc(funcionario.getNome());
       
       if(func==null)
       {
        Funcionario.save(funcionario);
        return true;
       }
       else
       {
         return false;  
       }
         
    }
}
