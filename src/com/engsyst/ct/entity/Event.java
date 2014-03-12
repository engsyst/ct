package com.engsyst.ct.entity;

public class Event {
	private long id;
	private String title;
	private String description;
	private int color;
	private boolean selected;


	public Event(long id, String title, String description, int color,
			boolean selected) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.color = color;
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
