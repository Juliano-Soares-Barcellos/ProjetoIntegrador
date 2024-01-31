/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.projeto.Integrador.data;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author julianob
 */
public interface clienteRepository extends JpaRepository<clienteEntity,Integer>
{
 clienteEntity findByNome(String nome);
    
}
