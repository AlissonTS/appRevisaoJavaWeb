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
		String id = rq.getParameter("id");
		System.out.println("id ..."+id);
		
		Usuario u = new Usuario();
		u.setLogin(login);
		u.setSenha(senha);
		if(id == null){
			System.out.println("novo usuario");
		}else{
			u.setId(Long.parseLong(id));
		}
		
		UsuarioDao uD = new UsuarioDao();
		
		String pagina = "/index.jsp";
		
		try {
			boolean retorno =  uD.inserirUsuario(u);
			if(retorno){
				pagina = "/WEB-INF/jsp/cadastroUsuario.jsp";
				rq.setAttribute("usuarios", uD.getUsuarios());
			}else{
				rq.setAttribute("msg", "Problemas ao Inserir Usuário");
			}
		} catch (Exception e) {
			e.printStackTrace();
			rq.setAttribute("msg", "Problemas ao Inserir Usuário");
			return pagina;
		}
		
		return pagina;
	}
	
		
}
