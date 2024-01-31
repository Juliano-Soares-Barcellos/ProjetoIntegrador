/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.controller;

import com.projeto.Integrador.data.funcionarioEntity;
import com.projeto.Integrador.data.vendaEntity;
import com.projeto.Integrador.service.funcionarioService;
import com.projeto.Integrador.service.vendaService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author julianob
 */
    @RestController

public class JkRestController {
        @Autowired
        vendaService VendaService;
            @Autowired
        funcionarioService FuncionarioService;
        
    @GetMapping("/Busca")
    public ResponseEntity<List<vendaEntity>> modal(@RequestParam("nome") String nomeCliente) {
        List<vendaEntity> vendas = VendaService.vendas(nomeCliente);
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }
@DeleteMapping("/deletar")
public String deletarFuncionario(@RequestParam("nome") String nomeCliente) 
{
    boolean excluido = FuncionarioService.deletar(nomeCliente);
    String mensagem = excluido ? "Funcionário excluído com sucesso." : "Falha ao excluir o funcionário.";
    System.out.println(nomeCliente);
    return  mensagem ;
}

    
   @PostMapping("/adcionar")
    public String addFuncionario(@RequestParam("nome") String nome)
    {
        funcionarioEntity novoFuncionario = new funcionarioEntity();
        novoFuncionario.setNome(nome);
        Boolean adcionado = FuncionarioService.inserir(novoFuncionario);
        String mensagem=adcionado?"Funcionario Contratado":"erro ao inserir funcionario";
        return mensagem;
    }



}
