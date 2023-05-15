package com.nbmgroup.onlinemobileshop.service;

import java.util.List;

import com.nbmgroup.onlinemobileshop.Exception.NotFoundException;
import com.nbmgroup.onlinemobileshop.entity.Element;

public interface  ElementHandleServiceInterface {



	List<Element> getFirstTenElement();

	

	Element addElementWithImage(String elementName, String elementType, byte[] data, String elementDiscription,
			String elementPrize, Boolean isInCart, String contentType);

	Element getImageElement(String id) throws NotFoundException;


	void save(Element outputElement);



	

//	Element saveImage(String elementId, String elementName, String elementType, byte[] data, double elementPrize);

}
