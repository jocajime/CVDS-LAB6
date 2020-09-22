package edu.eci.cvds.servlet.model;
public class Todo {
	private int userId,id;
	private String title;
	private boolean completed;
	
	public Todo() {}
	
	// getter
	public int getUserId() {
		return userId;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public boolean getCompleted() {
		return completed;
	}
	
	//setter
	public void setUserId(int nUserId) {
		this.userId = nUserId;
	}
	public void setId(int nId) {
		this.id = nId;
	}
	public void setTitle(String nTitle) {
		this.title = nTitle;
	}
	public void setCompleted(boolean nCompleted) {
		this.completed = nCompleted;
	}
	
}
