package ar.edu.unaj.app.gateway.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Boolean collaborative;
	String description;
	Object external_urls;
	String href;
	String id;
	ArrayList<Object> images;
	String name;
	Object owner;
	String snapshot_id;
	Object tracks;
	String type;
	String uri;
	
	
	public Playlist(Boolean collaborative, String description, Object external_urls, String href, String id,
			ArrayList<Object> images, String name, Object owner, String snapshot_id, Object tracks, String type,
			String uri) {
		super();
		this.collaborative = collaborative;
		this.description = description;
		this.external_urls = external_urls;
		this.href = href;
		this.id = id;
		this.images = images;
		this.name = name;
		this.owner = owner;
		this.snapshot_id = snapshot_id;
		this.tracks = tracks;
		this.type = type;
		this.uri = uri;
	}
	
	public Boolean getCollaborative() {
		return collaborative;
	}
	public void setCollaborative(Boolean collaborative) {
		this.collaborative = collaborative;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object getExternal_urls() {
		return external_urls;
	}
	public void setExternal_urls(Object external_urls) {
		this.external_urls = external_urls;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Object> getImages() {
		return images;
	}
	public void setImages(ArrayList<Object> images) {
		this.images = images;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getOwner() {
		return owner;
	}
	public void setOwner(Object owner) {
		this.owner = owner;
	}
	public String getSnapshot_id() {
		return snapshot_id;
	}
	public void setSnapshot_id(String snapshot_id) {
		this.snapshot_id = snapshot_id;
	}
	public Object getTracks() {
		return tracks;
	}
	public void setTracks(Object tracks) {
		this.tracks = tracks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	

}
