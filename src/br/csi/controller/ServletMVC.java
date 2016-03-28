package br.csi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.csi.controller.logica.LogarLogica;

/**
 * Servlet implementation class ServletMVC
 */
@WebServlet(name = "mvc", urlPatterns = { "/mvc" })
public class ServletMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMVC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(".... entrou no MVC");
		String log = request.getParameter("logica");
		String classe = "br.csi.controller.logica."+log;
		System.out.println("valor de log: "+log);
		System.out.println("vai carregar a classe: "+classe);
		
		try {
			Class classeCarregada = Class.forName(classe);
			LogarLogica logLogica = (LogarLogica) classeCarregada.newInstance();
			String fluxo = logLogica.executa(request, response);
			
			request.getRequestDispatcher(fluxo).forward(request, response);	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
