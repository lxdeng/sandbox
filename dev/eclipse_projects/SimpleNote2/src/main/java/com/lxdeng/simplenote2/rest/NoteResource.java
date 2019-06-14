package com.lxdeng.simplenote2.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lxdeng.simplenote2.impl.Note;
import com.lxdeng.simplenote2.impl.NoteManagement;

@Path("notes/{id [0-9]*}")
public class NoteResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getNote(@PathParam("id") int id) {
		Note note = NoteManagement.getNote(id);
		
		if (note == null)
			return "";
		else
			return note.toString();
	}
	
	@DELETE
	public void deleteNote(@PathParam("id") int id) {
		NoteManagement.deleteNote(id);
	}
}
