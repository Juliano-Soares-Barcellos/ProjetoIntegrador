/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.service;

import com.projeto.Integrador.data.clienteEntity;
import com.projeto.Integrador.data.clienteRepository;
import com.projeto.Integrador.data.estoqueEntity;
import com.projeto.Integrador.data.vendaEntity;
import com.projeto.Integrador.service.clienteService;
import com.projeto.Integrador.service.estoqueService;
import com.projeto.Integrador.service.vendaService;
import jakarta.websocket.ClientEndpoint;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

/**
 *
 * @author julianob
 */
@Service
public class vendaDao {
   @Autowired
    vendaService VendaService;

   @Autowired
   clienteService ClienteService;
   
   @Autowired
   estoqueService EstoqueService;
   @Autowired
   clienteRepository ClienteRepository;
   
   public List<String> separarProduto(String StringComVirgula)
   {
       List<String>StringSeparada=new ArrayList<>();
     String[]separa=StringComVirgula.split(",");
     for(String produto : separa)
     {
         StringSeparada.add(produto);
     }
     return StringSeparada;
       
   
   }
 
   public void adcionarVenda(List<String> estoque,String cliente)
   {
       clienteEntity clienteVerificacao=new clienteEntity();
       clienteVerificacao= ClienteService.findeByNome(cliente);
       
      if(clienteVerificacao==null)
      {
           clienteEntity  clienteNovo= new  clienteEntity ();
          clienteNovo.setNome(cliente);
          ClienteService.inserirCliente(clienteNovo);
          clienteVerificacao= ClienteService.findeByNome(cliente);
          
          for(String estoqueFor : estoque)
          {
             estoqueEntity pegaListaEstoque= EstoqueService.findByEstoque(estoqueFor);
             VendaService.adcionarVenda( clienteVerificacao, pegaListaEstoque);
          }
      }
      else
      {
             for(String estoqueFor : estoque)
          {
             estoqueEntity pegaListaEstoque= EstoqueService.findByEstoque(estoqueFor);
             VendaService.adcionarVenda( clienteVerificacao, pegaListaEstoque);
          }
      }
   }
      
}
