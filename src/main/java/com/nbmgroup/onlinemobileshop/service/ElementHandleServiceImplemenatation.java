package com.nbmgroup.onlinemobileshop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbmgroup.onlinemobileshop.Exception.NotFoundException;
import com.nbmgroup.onlinemobileshop.entity.Element;

import com.nbmgroup.onlinemobileshop.repository.ElementsHandleRepo;

@Service
public class ElementHandleServiceImplemenatation implements ElementHandleServiceInterface{

	@Autowired
	private ElementsHandleRepo elementsHandleRepo;
	
	

	@Override
	public List<Element> getFirstTenElement() {
	
			
		return elementsHandleRepo.findAll();
	}
	@Override
	public Element addElementWithImage(String elementName, String elementType, byte[] data, String elementDiscription,  
			String elementPrize ,Boolean isInCart,String contentType) {
		
		Element element=new Element(elementName,elementType,data,contentType,elementDiscription,elementPrize,isInCart);
		elementsHandleRepo.save(element);
		return element;
	}
	

	@Override
	public void save(Element outputElement) {
	
		elementsHandleRepo.save(outputElement);
		
	}
	@Override
	public Element getImageElement(String id) throws NotFoundException {
		try {
			Optional<Element> o= elementsHandleRepo.findById(id);
			return o.get();
			}catch(Exception e) {
				throw new NotFoundException("Data Not Found");
			}
	}

}
