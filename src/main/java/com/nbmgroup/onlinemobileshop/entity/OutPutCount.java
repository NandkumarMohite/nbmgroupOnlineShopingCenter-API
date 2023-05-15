package com.nbmgroup.onlinemobileshop.entity;

public class OutPutCount {
	
	private String elementName;
	private Long elementCartCount;
	public OutPutCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutPutCount(String elementName, Long long1) {
		super();
		this.elementName = elementName;
		this.elementCartCount = long1;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public Long getElementCartCount() {
		return elementCartCount;
	}
	public void setElementCartCount(Long elementCartCount) {
		this.elementCartCount = elementCartCount;
	}

}
