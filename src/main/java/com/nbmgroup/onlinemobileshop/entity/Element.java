package com.nbmgroup.onlinemobileshop.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "Element")
public class Element {

	@Id
	private String elementId;
	private String elementName;
	private String elementType;
	@Field("elementImage")
	private byte[] elementImage;
	private String contentType;
	
	private String elementDiscription;
	private String elementPrize;
	private Boolean isElementInCart ;
	
	public Element( String elementName, String elementType, byte[] elementImage,String contentType,
			String elementDiscription, String elementPrize, Boolean isElementInCart) {
		super();
		this.contentType=contentType;
		this.elementName = elementName;
		this.elementType = elementType;
		this.elementImage = elementImage;
		this.elementDiscription = elementDiscription;
		this.elementPrize = elementPrize;
		this.isElementInCart = isElementInCart;
	}
	public Element() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getElementId() {
		return elementId;
	}
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}
	public String getElementName() {
		return elementName;
	}
	public void setElementName(String elementName) {
		this.elementName = elementName;
	}
	public String getElementType() {
		return elementType;
	}
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	
	public byte[] getElementImage() {
		return elementImage;
	}
	public void setElementImage(byte[] elementImage) {
		this.elementImage = elementImage;
	}
	public String getElementDiscription() {
		return elementDiscription;
	}
	public void setElementDiscription(String elementDiscription) {
		this.elementDiscription = elementDiscription;
	}
	public String getElementPrize() {
		return elementPrize;
	}
	public void setElementPrize(String elementPrize) {
		this.elementPrize = elementPrize;
	}
	public Boolean getIsElementInCart() {
		return isElementInCart;
	}
	public void setIsElementInCart(Boolean isElementInCart) {
		this.isElementInCart = isElementInCart;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
	
}
