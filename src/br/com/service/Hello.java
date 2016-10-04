package br.com.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("hello")
public class Hello {

	@GET
	@Produces("application/json")
	public Response hello(){
		JSONObject json = new JSONObject();
		json.put("message", "Hello");
		return Response.status(200).entity(json.toString()).build();
	}


}
