package ar.edu.unaj.app.playlist.response.data;

import java.util.List;

public class Track {

	Object album;
	List<Object> artists;
	String id;
	String name;
	String uri;
	String preview_url;
	public Object getAlbum() {
		return album;
	}
	public void setAlbum(Object album) {
		this.album = album;
	}
	public List<Object> getArtists() {
		return artists;
	}
	public void setArtists(List<Object> artists) {
		this.artists = artists;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getPreview_url() {
		return preview_url;
	}
	public void setPreview_url(String preview_url) {
		this.preview_url = preview_url;
	}
	
	

}
