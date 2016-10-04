package br.com.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import br.com.DAO.AlimentoDAO;
import br.com.entity.Alimento;
import br.com.persistence.AlimentoPersistence;

@Path("alimentos")
public class AlimentoService {

	private AlimentoDAO alimentoDAO = AlimentoPersistence.getInstance();
	
	@POST
	@Produces("application/json")
	public Response create(@QueryParam("nome") String nome, 
			@QueryParam("grupo_alimentar_id") Integer grupo_alimentar_id, 
			@QueryParam("nutrientes_id") Integer nutrientes_id){
		Alimento alimento = new Alimento(null, nome, grupo_alimentar_id, nutrientes_id);
		alimento = alimentoDAO.create(alimento);
		//System.out.println("nome: " + alimento.getNome() + " - Grupo Alimentar: " + alimento.getGrupo_alimentar_id() +
			//	" - Nutrientes: " + alimento.getNutrientes_id());
		return Response.status(200).entity(alimento).build();
	}
	
	@GET
	@Produces("application/json")
	public List<Alimento> findAll(){
		List<Alimento> alimentos = alimentoDAO.findAll();
		
		return alimentos;
	}
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Alimento find(@PathParam("id") Integer id){
		Alimento alimento = null;
		alimento = alimentoDAO.find(id);
		
		return alimento;
	}
	
	@Path("{id}")
	@PUT
	@Produces("application/json")
	public Alimento update(@PathParam("id") Integer id, @QueryParam("nome") String nome, 
			@QueryParam("grupo_alimentar_id") Integer grupo_alimentar_id, 
			@QueryParam("nutrientes_id") Integer nutrientes_id){
		Alimento alimento = new Alimento(id,nome,grupo_alimentar_id, nutrientes_id);
		alimento = alimentoDAO.update(alimento);
		
		return alimento;
	}
	
	@Path("{id}")
	@DELETE
	@Produces("application/json")
	public Alimento delete(@PathParam("id") Integer id){
		Alimento alimento = alimentoDAO.delete(id);
		
		return alimento;
	}
}
