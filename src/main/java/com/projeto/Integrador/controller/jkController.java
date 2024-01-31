/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projeto.Integrador.controller;

import com.projeto.Integrador.data.estoqueEntity;
import com.projeto.Integrador.data.funcionarioRepository;
import com.projeto.Integrador.service.estoqueService;
import com.projeto.Integrador.service.vendaDao;
import com.projeto.Integrador.data.clienteEntity;
import com.projeto.Integrador.data.funcionarioEntity;
import com.projeto.Integrador.data.vendaEntity;
import com.projeto.Integrador.service.clienteService;
import com.projeto.Integrador.service.funcionarioService;
import com.projeto.Integrador.service.vendaService;
import jakarta.persistence.Convert;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author julianob
 */
@Controller
public class jkController {

    @Autowired
    funcionarioService FuncionarioService;
    @Autowired
    estoqueService EstoqueService;
    @Autowired
    vendaDao VendaDao;
    @Autowired
    vendaService vendaService;

    @Autowired
    clienteService ClienteService;

    @GetMapping("/index")
    public String Index(Model model,@RequestParam(value = "nome", required = false) String nomeCliente) throws IOException {
        estoqueEntity estoq = new estoqueEntity();
        List<funcionarioEntity> func= FuncionarioService.findAll();
        List<estoqueEntity> estoqueList = EstoqueService.getEstoqueList();
        List<clienteEntity> clientes = ClienteService.findeByAll();
              for (estoqueEntity estoque : estoqueList) {
            estoque.setImagens("/imagens/" + estoque.getImagens());
        }
        model.addAttribute("funcionario", func);
        model.addAttribute("clientes", clientes);
        model.addAttribute("estoque", estoqueList);
        model.addAttribute("estoq", estoq);
        return "index";
    }

    @PostMapping("/compra")
    public String processarCompra(@RequestParam("nome") String nome, @RequestParam("produtos") String produtos, Model model) {
        List<String> Estoque = VendaDao.separarProduto(produtos);
        VendaDao.adcionarVenda(Estoque, nome);
        return "redirect:/index";
    }



}
