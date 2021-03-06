package com.douglasmariano.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douglasmariano.dao.UsuarioDAO;
import com.douglasmariano.model.Usuario;


@Controller
public class LoginController {
	private final UsuarioDAO dao;
	
	@Autowired
	  public LoginController(UsuarioDAO dao) {
	        this.dao = dao;  
	    }
	
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}

	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {

		if (dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		return "redirect:loginForm";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
	  session.invalidate();
	  return "redirect:loginForm";
	}
}
