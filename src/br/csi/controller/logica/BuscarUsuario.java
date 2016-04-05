package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.dao.UsuarioDao;

public class BuscarUsuario implements Logica{
		
	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		
		String id = rq.getParameter("id");
		System.out.println("id do usuario: "+id);
		
		rq.setAttribute("usuarios", new UsuarioDao().getUsuarios());
		rq.setAttribute("usuario", new UsuarioDao().getUsuario(Long.parseLong(id)));
		return "/WEB-INF/jsp/cadastroUsuario.jsp";
	}
}
