package com.lxdeng.simplenote2.rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;

import com.lxdeng.simplenote2.impl.Note;
import com.lxdeng.simplenote2.impl.NoteManagement;

/**
 * Root resource (exposed at "/notes" path)
 */
@Path("notes")
public class NotesResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String list() {
		return NoteManagement.list();
    }

	// sub-resource
	@GET
	@Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Note> listJson() {
        return NoteManagement.listJson();
    }
	
	@GET
	@Path("/pattern/{filter}")
	@Produces(MediaType.APPLICATION_JSON)
    public Response searchNotesJson(@PathParam("filter") String filter) {
		List<Note> list = NoteManagement.listJson();
		
		if (valid(filter)) {
			
			List<Note> list2 = new ArrayList<>();
			
			for (Note n : list) {
				if (n.getContent().contains(filter))
					list2.add(n);
			}
			
			return Response.ok().entity(list2).build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("{\"error\": \"invalid filter\"}").build();
		}	
	}
    
	private boolean valid(String filter) {
		if (filter == null || filter.length() == 0 || filter.contains("*"))
			return false;
		else
			return true;
	}
		
	@POST
	@Consumes("text/plain")
	@Produces(MediaType.TEXT_PLAIN)
    public String add(String content) {
		Note note = new Note(content);
        int id = NoteManagement.addNoteWithAutoId(note);
        return Integer.toString(id);
	}
}
