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
import br.com.DAO.NutrientesDAO;
import br.com.entity.Alimento;
import br.com.entity.Nutrientes;
import br.com.persistence.NutrientesPersistence;

@Path("nutrientes")
public class NutrientesService {

	private NutrientesDAO nutrientesDAO = NutrientesPersistence.getInstance();
	
	@POST
	@Produces("application/json")
	public Response create(@QueryParam("proteinas") double proteinas, @QueryParam("carboidratos") double carboidratos,
			@QueryParam("calorias") double calorias,@QueryParam("gorduras_totais") double gorduras_totais,
			@QueryParam("gorduras_saturadas") double gorduras_saturadas,@QueryParam("sodio") double sodio){
		
		Nutrientes nutrientes = new Nutrientes(null, proteinas, carboidratos, calorias, gorduras_totais, 
				gorduras_saturadas,sodio);
		
		nutrientes = nutrientesDAO.create(nutrientes);
		
		return Response.status(200).entity(nutrientes).build();
	}
	
	@GET
	@Produces("application/json")
	public List<Nutrientes> findAll(){
		List<Nutrientes> nutrientes = nutrientesDAO.findAll();
		
		return nutrientes;
	}
	
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Nutrientes find(@PathParam("id") Integer id){
		Nutrientes nutrientes = nutrientesDAO.find(id);
		
		return nutrientes;
	}
	
	@Path("{id}")
	@PUT
	@Produces("application/json")
	public Nutrientes update(@PathParam("id") Integer id, 
			@QueryParam("proteinas") double proteinas, 
			@QueryParam("carboidratos") double carboidratos,
			@QueryParam("calorias") double calorias,
			@QueryParam("gorduras_totais") double gorduras_totais,
			@QueryParam("gorduras_saturadas") double gorduras_saturadas,
			@QueryParam("sodio") double sodio){
		
		Nutrientes nutrientes = new Nutrientes(id, proteinas, carboidratos, calorias, gorduras_totais, 
				gorduras_saturadas,sodio);
		
		nutrientes = nutrientesDAO.update(nutrientes);
		
		return nutrientes;
	}
	
	@Path("{id}")
	@DELETE
	@Produces("application/json")
	public Nutrientes delete(@PathParam("id") Integer id){
		Nutrientes nutrientes = nutrientesDAO.delete(id);
		
		return nutrientes;
	}
	
}
