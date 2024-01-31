/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.projeto.Integrador.data;

import java.util.List;
import org.springframework.data.jpa.mapping.JpaPersistentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author julianob
 */
public interface vendaRepository extends JpaRepository<vendaEntity,Integer> {
     @Query(value =("select * from estoque_entity inner join venda on estoque_entity.id_estoque=venda.estoque_id inner join cliente_entity on cliente_entity.id_cliente=venda.cliente_id where cliente_entity.nome= :nomeCliente"), nativeQuery = true)
   List<vendaEntity> findByNomeCliente(@Param("nomeCliente") String nomeCliente);

    
}
