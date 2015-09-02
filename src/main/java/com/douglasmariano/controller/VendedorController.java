package com.douglasmariano.controller;

import java.util.List;

import javax.sql.DataSource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douglasmariano.dao.VendedorDAO;
import com.douglasmariano.model.Vendedor;

@Controller
public class VendedorController {
	
	private final VendedorDAO dao;

	  @Autowired
	  public VendedorController(VendedorDAO dao) {
	        this.dao = dao;  
	    }

	@RequestMapping(value = "novoVendedor", method = { RequestMethod.GET })
	public String form() {
		return "vendedor/formulario";
	}

	@RequestMapping("adicionaVendedor")
	public String adiciona(@Valid Vendedor vendedor, BindingResult result) {
		
		if (result.hasFieldErrors("nome")) {
			return "vendedor/formulario";
		}
		
		dao.adiciona(vendedor);
		return "vendedor/adicionada";
	}

	/*
	 * @RequestMapping(value = "adicionaTarefa", method = {RequestMethod.POST})
	 * public String adiciona( @RequestParam("descricao") String descricao,
	 * BindingResult result){ if(result.hasFieldErrors("descricao")){ return
	 * "vendedor/formulario"; } TarefaDAO dao = new TarefaDAO(); Tarefa tarefa =
	 * new Tarefa(); tarefa.setDescricao(descricao);
	 * tarefa.setFinalizado(false);
	 * 
	 * dao.adiciona(tarefa); return "tarefa/adicionada"; }
	 */

	@RequestMapping("listaVendedores")
	public String lista(Model model) {
		
		model.addAttribute("vendedores", dao.lista());
		return "vendedor/lista";
	}

	@RequestMapping("removeVendedor")
	public String remove(Vendedor vendedor) {
	
		((List<Vendedor>) dao).remove(vendedor);
		return "redirect:listaVendedor";
	}



	@RequestMapping("alteraVendedor")
	public String altera(Vendedor vendedor) {
		
		dao.altera(vendedor);
		return "redirect:listaVendedor";
	}

	

	
}
