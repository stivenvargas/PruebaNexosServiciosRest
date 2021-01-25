/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.service;

import Entidades.ProductDto1;
import Entidades.ProductoDto;
import Modelo.ProductoDao;
import Util.logCarritoCompras;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author stive
 */
@Path("restProduct")
public class RestProductResource {

    logCarritoCompras log= new logCarritoCompras();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestProductResource
     */
    public RestProductResource() {
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(){
        try {
            ProductoDto productos= new ProductoDto();
            ProductoDao productoDao= new ProductoDao();
            productos= productoDao.listar();
            
            String json = new Gson().toJson(productos);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            log.setLogError("error al crear servicio rest getProduct" + e.getMessage() + e);
            return Response.status(Response.Status.SEE_OTHER).entity("error: " + e.toString()).build();
        }
        
    }
    
    @GET
    @Path("/product/{idProducto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductId(@PathParam("idProducto") int id){
        try {
            ProductDto1 productos= new ProductDto1();
            ProductoDao productoDao= new ProductoDao();
            productos= productoDao.listarPorId(id);
            
            String json = new Gson().toJson(productos);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            log.setLogError("error al crear servicio rest getProduct1" + e.getMessage() + e);
            return Response.status(Response.Status.SEE_OTHER).entity("error: " + e.toString()).build();
        }
        
    }
}
