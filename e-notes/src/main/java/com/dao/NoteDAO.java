package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.entities.Note;

public class NoteDAO {
	
	private Connection conn;
	
	public NoteDAO(Connection conn) {
		this.conn=conn;
	}
	
	public boolean addNote(String title,String content,int userid) {
		boolean f=false;
		
		try {
			
			String q="INSERT INTO notes(title,content,userid) VALUES(?,?,?);";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setInt(3, userid);
			
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Note> getAllNotes() {
		List<Note> list=new ArrayList<Note>();
		
		Note note = null;

		try {
			String q = "SELECT * FROM notes ORDER BY id desc ;";
			PreparedStatement pst = conn.prepareStatement(q);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				note=new Note();
				note.setId(rs.getInt(1));
				note.setTitle(rs.getString(2));
				note.setContent(rs.getString(3));
				note.setPdate(rs.getString(4)+"");
				list.add(note);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Note getNoteById(int id) {
		Note note=new Note();

		try {
			String q = "SELECT * FROM notes WHERE id=?;";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setInt(1, id);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				note=new Note();
				note.setId(rs.getInt(1));
				note.setTitle(rs.getString(2));
				note.setContent(rs.getString(3));
				note.setPdate(rs.getString(4)+"");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return note;
	}
	
	public Boolean updateNoteById(int id,String title,String content) {
		Note note=new Note();
		 boolean b=false;

		try {
			String q = "UPDATE notes SET title=?, content=? WHERE id=?;";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, title);
			pst.setString(2, content);
			pst.setInt(3, id);
			
			int r=pst.executeUpdate();
			
			if(r==1) {
				b=true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean deleteNote(int i) {
		boolean f=false;
		
		try {
			
			String q="DELETE FROM notes WHERE id=? ;";
			PreparedStatement pst=conn.prepareStatement(q);
			pst.setInt(1,i);
			int v=pst.executeUpdate();
			
			if(v==1) {
				f=true;	
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
