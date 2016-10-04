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

import br.com.DAO.GrupoAlimentarDAO;
import br.com.entity.GrupoAlimentar;
import br.com.persistence.GrupoAlimentarPersistence;

@Path("gruposalimentares")
public class GrupoAlimentarService {

	private GrupoAlimentarDAO grupoAlimentarDAO = GrupoAlimentarPersistence.getInstance();
	
	@POST
	@Produces("application/json")
	public Response create(@QueryParam("grupo_alimentar") String grupoAlimentar){
		GrupoAlimentar grupoA = new GrupoAlimentar(null, grupoAlimentar);
		grupoA = grupoAlimentarDAO.create(grupoA);
		
		return Response.status(200).entity(grupoA).build();
	}
	
	@GET
	@Produces("application/json")
	public List<GrupoAlimentar> findAll(){
		List<GrupoAlimentar> grupos = grupoAlimentarDAO.findAll();
		
		return grupos;
	}
	
	@Path("{id}")
	@GET
	@Produces
	public GrupoAlimentar find(@PathParam("id") Integer id){
		GrupoAlimentar grupoAlimentar = grupoAlimentarDAO.find(id);
		
		return grupoAlimentar;
	}
	
	@Path("{id}")
	@PUT
	@Produces("application/json")
	public GrupoAlimentar update(@PathParam("id") Integer id, @QueryParam("grupo_alimentar") String grupoAlimentar){
		GrupoAlimentar grupoA = new GrupoAlimentar(id, grupoAlimentar);
		grupoA = grupoAlimentarDAO.update(grupoA);
		
		return grupoA;
	}
	
	@Path("{id}")
	@DELETE
	@Produces("application/json")
	public GrupoAlimentar delete(@PathParam("id") Integer id){
		GrupoAlimentar grupoAlimentar = grupoAlimentarDAO.delete(id);
		
		return grupoAlimentar;
	}
}
