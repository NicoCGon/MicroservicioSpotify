package ar.edu.unaj.app.gateway.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String display_name;
	private String href;	
	private String id;
	private ArrayList<Object> images;
	private Object external_urls;
	private String type;
	private String uri;
	private Object followers;
	
	
	public Profile(String display_name,Object followers,Object external_urls, String href, String id, ArrayList<Object> images, String type, String uri) {
		super();
		this.display_name = display_name;
		this.external_urls = external_urls;
		this.href = href;
		this.id = id;
		this.images = images;
		this.type = type;
		this.uri = uri;
		this.followers = followers;
	}


	public String getDisplay_name() {
		return display_name;
	}


	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
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


	public ArrayList<Object> getImage() {
		return images;
	}


	public void setImage(ArrayList<Object> image) {
		this.images = image;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Object getExternal_urls() {
		return external_urls;
	}


	public void setExternal_urls(Object external_urls) {
		this.external_urls = external_urls;
	}


	public Object getFollowers() {
		return followers;
	}


	public void setFollowers(Object followers) {
		this.followers = followers;
	}

}
