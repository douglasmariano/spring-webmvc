package com.douglasmariano.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douglasmariano.dao.SeparadorDAO;
import com.douglasmariano.model.Separador;

@Controller
public class SeparadorController {
	
	private final SeparadorDAO dao;

	  @Autowired
	  public SeparadorController(SeparadorDAO dao) {
	        this.dao = dao;  
	    }

	@RequestMapping(value = "novoSeparador", method = { RequestMethod.GET })
	public String form() {
		return "separador/formulario";
	}

	@RequestMapping("adicionaSeparador")
	public String adiciona(@Valid Separador separador, BindingResult result) {
		
		if (result.hasFieldErrors("nome")) {
			return "separador/formulario";
		}
		
		dao.adiciona(separador);
		return "separador/adicionada";
	}

	/*
	 * @RequestMapping(value = "adicionaTarefa", method = {RequestMethod.POST})
	 * public String adiciona( @RequestParam("descricao") String descricao,
	 * BindingResult result){ if(result.hasFieldErrors("descricao")){ return
	 * "separador/formulario"; } TarefaDAO dao = new TarefaDAO(); Tarefa tarefa =
	 * new Tarefa(); tarefa.setDescricao(descricao);
	 * tarefa.setFinalizado(false);
	 * 
	 * dao.adiciona(tarefa); return "tarefa/adicionada"; }
	 */

	@RequestMapping("listaSeparadores")
	public String lista(Model model) {
		
		model.addAttribute("separadores", dao.lista());
		return "separador/lista";
	}

	@RequestMapping("removeSeparador")
	public String remove(Separador separador) {
	
		dao.remove(separador);
		return "redirect:listaSeparador";
	}



	@RequestMapping("alteraSeparador")
	public String altera(Separador separador) {
		
		dao.altera(separador);
		return "redirect:listaSeparador";
	}

	

	
}
