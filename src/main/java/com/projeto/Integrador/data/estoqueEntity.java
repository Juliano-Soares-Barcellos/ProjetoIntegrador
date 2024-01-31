package com.projeto.Integrador.data;

import jakarta.persistence.Column;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Data
@Entity
public class estoqueEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estoque")
    private Integer id;
    private String nome;
    private Double valor;
    private String imagens;

    public estoqueEntity(Integer id, String produto, Double valor, String imagens) {
        this.id = id;
        this.nome = produto;
        this.valor = valor;
        this.imagens = imagens;
    }

    public estoqueEntity() {
    }
    
}
