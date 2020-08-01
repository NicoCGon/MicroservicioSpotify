package ar.edu.unaj.app.playlist.resquest.data;

public class MyTracksParams {
	String market;
	String fields;
	String limit;
	String offset;
	
	public MyTracksParams(String market, String fields, String limit, String offset) {
		this.market = market;
		this.fields = fields;
		this.limit = limit;
		this.offset = offset;
	}
	public MyTracksParams() {
	
	}
	
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getOffset() {
		return offset;
	}
	public void setOffset(String offset) {
		this.offset = offset;
	}

}
