package com.lxdeng.simplenote2.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NoteManagement {
	
	private static HashMap<Integer, Note> map = new HashMap<>();
	
	private static AtomicInteger counter = new AtomicInteger(0);
	
	private NoteManagement() {}

	public static String list() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		
		for (Note n : map.values()) {
			sb.append(n.toString());
			sb.append(' ');
		}
		
		sb.append(']');
		
		return sb.toString();
	}
	
	public static List<Note> listJson() {
		List<Note> list = new ArrayList<>();
		for (Note n : map.values()) {
			list.add(n);
		}
		
		System.out.println("listJson: size=" + list.size());
		return list;
	}
	
	public static int addNoteWithAutoId(Note note) {
		int id = counter.incrementAndGet();
		note.setId(id);
		map.put(id,  note);
		return id;
	}
	
	public static Note getNote(int id) {
		return map.get(id);
	}
	
	public static void deleteNote(int id) {
		if (map.containsKey(id))
			map.remove(id);
	}
	
}
