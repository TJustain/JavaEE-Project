/*
 *  Justian Tremblay | Martin Weaver
 *  SpriteFacadeRest.java
 *  Purose: The goal of this class is to handel API requests and return the appropriate response code.
 *  This class allows CRUD operation on the Sprites through an API.
 */
package service;

import cst8218.trem0354.entity.Sprite;
import cst8218.trem0354.entity.AbstractFacade;
import java.util.List;
import java.util.Objects;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Justain and Martin
 */

@Stateless
@RolesAllowed({"Admin", "RestGroup"})
@Path("cst8218.trem0354.entity.sprite")
public class SpriteFacadeREST extends AbstractFacade<Sprite> {

    @PersistenceContext(unitName = "SpriteJustain-ejbPU")
    private EntityManager em;

    public SpriteFacadeREST() {
        super(Sprite.class);
    }

    /**
     * Method that creates a new Sprite form the root 
     * You can specify the id and it will update an existing one otherwise it will create one 
     * 
     * @param entity the new sprite
     * @return created response
     */
    @POST
    //@RolesAllowed("Admin") 
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createRoot(Sprite entity) {
        if(entity.getId() == null){
            super.create(entity);
            return Response.status(Response.Status.CREATED).build();        
        }else if(super.find(entity.getId()) == null){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }else{
            super.find(entity.getId()).update(entity);
            return Response.status(Response.Status.CREATED).build();
        }      
    }
     /**
     * Method that updates an id's data
     * You can specify the id and it will update an existing one otherwise it will create one 
     * 
     * @param entity the new sprite
     * @return created response
     */
    @POST    
    @Path("{id}")
    //@RolesAllowed("Admin") 
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response createWithID(@PathParam("id") Long id, Sprite entity) {
        if(super.find(id) == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        if(!Objects.equals(id, entity.getId())){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        super.find(id).update(entity);
        return Response.status(Response.Status.CREATED).build();
    }
    /**
     * Method that modifies a Sprite  
     * 
     * @param id the id to be modified
     * @param entity the new data
     * @return HTTP response(Not found, Bad request or accepted)
     */
    @PUT
    @Path("{id}")
    //@RolesAllowed("Admin") 
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Long id, Sprite entity) {
        if(super.find(id) == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }else if(!Objects.equals(id, entity.getId())){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        super.edit(entity);
        return Response.status(Response.Status.ACCEPTED).build();
    }
    
    /**
     * Method that when the put is called on the root returns a forbidden request
     * 
     * @return http response code 403(FORBIDDEN)
     */
    @PUT
    //@RolesAllowed("Admin") 
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response editRoot() {
         return Response.status(Response.Status.FORBIDDEN).build();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    @DELETE
    //@RolesAllowed("Admin") 
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        if(super.find(id) == null){
           return Response.status(Response.Status.NOT_FOUND).build();
        }
        super.remove(super.find(id));
        return Response.status(Response.Status.OK).build();
    }
    
    /**
     * Get by id method when the user request an id.
     * if the id exists return the information along with ok response code
     * if the id does not exists return the not found error message(404)
     * 
     * @param id the id the user wishes to get
     * @return response code and id 
     */
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        if(super.find(id) == null){
             return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(super.find(id)).build();
    }
    /**
     * When called return all sprites
     * 
     * @return all Sprites  
     */
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findAll() {
        return super.findAll();
    }

    /**
     * Returns all sprites within a range specified by the get statement
     * 
     * @param from the first sprite
     * @param to the last sprite
     * @return all sprites within the range specified 
     */
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sprite> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    /**
     * Gets the number of sprites
     * 
     * @return number of sprites
     */
    @GET 
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    /**
     * Gets the entity manager
     * 
     * @return en entity manager
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}