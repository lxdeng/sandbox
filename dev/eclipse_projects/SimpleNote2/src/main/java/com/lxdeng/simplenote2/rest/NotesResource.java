package com.lxdeng.simplenote2.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
		
	@POST
	@Consumes("text/plain")
	@Produces(MediaType.TEXT_PLAIN)
    public String add(String content) {
		Note note = new Note(content);
        int id = NoteManagement.addNoteWithAutoId(note);
        return Integer.toString(id);
	}
}
