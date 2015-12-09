package com.douglasmariano.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douglasmariano.dao.ConectionWinthor;

@Controller
public class PedidoWinthorController {

	
	@Autowired
	private ConectionWinthor conectionWinthor;
	


	@RequestMapping("listaPedidosWinthor")
	public String lista(Model model) {
		
		model.addAttribute("pedidosWinthor", conectionWinthor.lista());
		return "pedido/listaWinthor";
	}


	
	
	
}
