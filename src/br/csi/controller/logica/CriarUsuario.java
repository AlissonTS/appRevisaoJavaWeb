package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.model.Usuario;
import br.csi.model.dao.UsuarioDao;

public class CriarUsuario implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		System.out.println("...dentro do executa CriarUsuario");
		
		String login = rq.getParameter("login");
		String senha = rq.getParameter("senha");
		
		Usuario u = new Usuario();
		u.setLogin(login);
		u.setSenha(senha);
		
		UsuarioDao uD = new UsuarioDao();
		
		String pagina = "/WEB-INF/jsp/cadastroUsuario.jsp";
		
		try {
			boolean retorno =  uD.inserirUsuario(u);
			if(retorno){
				rq.setAttribute("msg", "Usu�rio "+u.getLogin()+" inserido com Sucesso!");
			}else{
				rq.setAttribute("msg", "Problemas ao Inserir Usu�rio");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas ao Inserir Usu�rio");
			return pagina;
		}
		
		return pagina;
	}
	
		
}
