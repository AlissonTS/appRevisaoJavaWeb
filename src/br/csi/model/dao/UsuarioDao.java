package br.csi.model.dao;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import br.csi.model.Usuario;
import br.csi.model.util.ConectaBDPostgres;

/*
create table usuario(
	id serial,
	login varchar(10) not null,
	senha varchar(10) not null,
	primary key(id)
)
*/


public class UsuarioDao {
	
	public static void main(String args[]){
		Usuario u = new Usuario();
		u.setLogin("alisson");
		u.setSenha("123");
		
		try{
			// new UsuarioDao().autenticado(u);
			System.out.println("autenticado? " + ""+new UsuarioDao().autenticado(u));
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	public boolean autenticado(Usuario u) throws SQLException{
		boolean autenticado = false;
		
		Connection c  = ConectaBDPostgres.getConexao();
		Statement stmt = c.createStatement();
		String sql = "select * from usuario where login = '"+u.getLogin()+"' and senha='"+u.getSenha()+"';";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			long id = rs.getLong("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			
			autenticado = true;
		}
		
		return autenticado;
	}
	
}
