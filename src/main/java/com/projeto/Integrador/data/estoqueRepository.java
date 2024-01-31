/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.projeto.Integrador.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author julianob
 */
public interface estoqueRepository extends JpaRepository<estoqueEntity,Integer>{
    List<estoqueEntity> findAll(); 
    
     estoqueEntity findByNome(String nome);

}
