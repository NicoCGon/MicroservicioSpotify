package ar.edu.unaj.app.gateway.models;

import java.io.Serializable;
import java.util.ArrayList;

public class UserPlaylist implements Serializable{
	
	String href;
	ArrayList<Playlist> items;
	Integer limit;
	String next;
	Integer offset;
	String previous ;
	Integer total;
	
	
	public UserPlaylist(String href, ArrayList<Playlist> items, Integer limit, String next, Integer offset,
			String previous, Integer total) {
		super();
		this.href = href;
		this.items = items;
		this.limit = limit;
		this.next = next;
		this.offset = offset;
		this.previous = previous;
		this.total = total;
	}

	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public ArrayList<Playlist> getItems() {
		return items;
	}
	public void setItems(ArrayList<Playlist> items) {
		this.items = items;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
