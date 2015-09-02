package com.douglasmariano.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douglasmariano.converters.SeparadorEditor;
import com.douglasmariano.converters.VendedorEditor;
import com.douglasmariano.dao.PedidoDAO;
import com.douglasmariano.dao.SeparadorDAO;
import com.douglasmariano.dao.VendedorDAO;
import com.douglasmariano.model.Pedido;
import com.douglasmariano.model.Separador;
import com.douglasmariano.model.Vendedor;

@Controller
public class PedidoController {
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private SeparadorDAO separadorDAO;
	
	@Autowired 
	private SeparadorEditor separadorEditor;
	
	@Autowired
	private VendedorDAO vendedorDAO;
	
	@Autowired 
	private VendedorEditor vendedorEditor;

	@RequestMapping(value = "novoPedido", method = { RequestMethod.GET })
	public String form(Pedido pedido, Model model) {
		
		model.addAttribute("separadores", separadorDAO.lista());
		model.addAttribute("vendedores", vendedorDAO.lista());
		return "pedido/formulario";
	}

	@RequestMapping("adicionaPedido")
	public String adiciona(/*@Valid*/ Pedido pedido, BindingResult result, Model model) {
		
		if (result.hasFieldErrors("descricao")) {
			model.addAttribute("separadores", separadorDAO.lista());
			model.addAttribute("vendedores", vendedorDAO.lista());
			return "pedido/formulario";
		}
		
		pedidoDAO.adiciona(pedido);
		return "pedido/adicionada";
	}

	/*
	 * @RequestMapping(value = "adicionaPedido", method = {RequestMethod.POST})
	 * public String adiciona( @RequestParam("descricao") String descricao,
	 * BindingResult result){ if(result.hasFieldErrors("descricao")){ return
	 * "pedido/formulario"; } PedidoDAO dao = new PedidoDAO(); Pedido pedido =
	 * new Pedido(); pedido.setDescricao(descricao);
	 * pedido.setFinalizado(false);
	 * 
	 * dao.adiciona(pedido); return "pedido/adicionada"; }
	 */

	@RequestMapping("listaPedidos")
	public String lista(Model model) {
		
		model.addAttribute("pedidos", pedidoDAO.lista());
		model.addAttribute("separadores", separadorDAO.lista());
		return "pedido/lista";
	}

	@RequestMapping("removePedido")
	public String remove(Pedido pedido) {
	
		pedidoDAO.remove(pedido);
		return "redirect:listaPedidos";
	}

	@RequestMapping("mostraPedido")
	public String mostra(Long id, Model model) {
		
		model.addAttribute("pedido", pedidoDAO.buscaPorId(id));
		model.addAttribute("separadores",separadorDAO.lista());
		model.addAttribute("vendedores",vendedorDAO.lista());
		
		return "pedido/mostra";
	}

	@RequestMapping("alteraPedido")
	public String altera(Pedido pedido ,Model model) {
		if (!pedido.isFinalizado()) {
			pedido.setDataFinalizacao(null);
		}
		
		pedidoDAO.altera(pedido);
		return "redirect:listaPedidos";
	}

	
	@RequestMapping("finalizaPedido")
	public String finaliza(Long id, Model model) {
	 
	  pedidoDAO.finaliza(id);
	  model.addAttribute("pedido", pedidoDAO.buscaPorId(id));
	  return "pedido/finalizada";
	}
	

		
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Separador.class, this.separadorEditor);
        binder.registerCustomEditor(Vendedor.class, this.vendedorEditor);
        
    }
	
	
}
