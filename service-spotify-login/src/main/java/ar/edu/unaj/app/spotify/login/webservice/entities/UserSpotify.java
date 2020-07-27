package ar.edu.unaj.app.spotify.login.webservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSpotify {
    @JsonProperty("country")
	private String country;
    @JsonProperty("display_name")
	private String display_name;
    @JsonProperty("email")
	private String email;
    @JsonProperty("explicit_content")
	private Object explicit_content;
    @JsonProperty("external_urls")
	private Object external_urls;
    @JsonProperty("followers")
	private Object followers;
    @JsonProperty("href")
	private String href;
    @JsonProperty("id")
	private String id;
    @JsonProperty("images")
	private Object images;
    @JsonProperty("product")
	private String product;
    @JsonProperty("type")
	private String type;
    @JsonProperty("uri")
	private String uri;
    
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getExplicit_content() {
		return explicit_content;
	}
	public void setExplicit_content(Object explicit_content) {
		this.explicit_content = explicit_content;
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
	public Object getImages() {
		return images;
	}
	public void setImages(Object images) {
		this.images = images;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
