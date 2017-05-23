package br.com.tasklist.webservice.controllers;

import java.util.ArrayList;
import java.util.List;
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
import br.com.tasklist.entity.Task;

@Path("task")
public class TaskController {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> listTask() {

        Task task = new Task();
        task.setIdTask(11l);
        task.setDsTitulo("Task Titulo");
        task.setDsTask("Task descricao");

        Task task2 = new Task();
        task2.setIdTask(12l);
        task2.setDsTitulo("Task2 Titulo");
        task2.setDsTask("Task2 descricao");

        List<Task> lista = new ArrayList<Task>();
        lista.add(task);
        lista.add(task2);

        //        GenericEntity<List<Task>> list = new GenericEntity<List<Task>>(lista) {};
        //        return Response.ok(list).build();

        return lista;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}/")
    public Task getTask(@PathParam("id") long id) {
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response create(Task chamado) {
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response update(Task chamado) {
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{id}/")
    public Response delete(@PathParam("id") long id) {
        return Response.status(Response.Status.OK).build();
    }

    @PUT
    @Path("{id}/")
    public Response concluir(@PathParam("id") long id) {

        return Response.status(Response.Status.OK).build();
    }
}
