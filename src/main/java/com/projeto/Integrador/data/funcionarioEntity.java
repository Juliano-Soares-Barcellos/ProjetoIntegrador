/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author julianob
 */
@Data
@Entity
public class funcionarioEntity {
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_funcionario")
    private Integer id; 
   
   private String nome;
   

    public funcionarioEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public funcionarioEntity(){
        
    }


}
