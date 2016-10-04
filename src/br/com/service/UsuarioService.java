package br.com.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import br.com.DAO.UsuarioDAO;
import br.com.entity.Usuario;
import br.com.persistence.UsuarioPersistence;

@Path("usuario")
public class UsuarioService {

	private UsuarioDAO usuarioDAO = UsuarioPersistence.getInstance();
	
	@POST
	@Produces("application/json")
	public Response create(@QueryParam("nome") String nome, @QueryParam("senha") String senha){
		Usuario usuario = new Usuario(null, nome, senha);
		usuario = usuarioDAO.create(usuario);
		
		return Response.status(200).entity(usuario).build();
	}
}
