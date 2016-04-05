package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.dao.UsuarioDao;

public class RemoverUsuario implements Logica {
		
	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		String id = rq.getParameter("id");
		
		new UsuarioDao().remover(Long.parseLong(id));
		
		rq.setAttribute("usuarios", new UsuarioDao().getUsuarios());		
		return "/WEB-INF/jsp/cadastroUsuario.jsp";
	}
}
