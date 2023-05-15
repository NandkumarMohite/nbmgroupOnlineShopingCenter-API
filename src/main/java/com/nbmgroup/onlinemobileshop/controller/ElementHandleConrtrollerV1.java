package com.nbmgroup.onlinemobileshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.nbmgroup.onlinemobileshop.Exception.BadRequestException;
import com.nbmgroup.onlinemobileshop.Exception.NotFoundException;
import com.nbmgroup.onlinemobileshop.Exception.ServiceException;
import com.nbmgroup.onlinemobileshop.entity.Element;
import com.nbmgroup.onlinemobileshop.entity.OutPutCount;
import com.nbmgroup.onlinemobileshop.service.ElementHandleServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class ElementHandleConrtrollerV1 {
	
	@Autowired
	private ElementHandleServiceInterface elementHandleServiceInterface;
	
	@PostMapping("/addElemtsWithImage")
	public ResponseEntity<?> saveImage(
	        @RequestParam(value = "elementName", defaultValue = "0", required = false) String elementName,
	        @RequestParam(value = "elementType", defaultValue = "0", required = false) String elementType,
	        @RequestParam(value = "elementDescription", defaultValue = "0", required = false) String elementDescription,
	        @RequestParam(value = "elementImage", defaultValue = "0", required = false) MultipartFile elementImage,
	        @RequestParam(value = "elementPrize", defaultValue = "0", required = false) String elementPrize,
	        @RequestParam(value = "isElementInCart", defaultValue = "false", required = false) Boolean isElementInCart) throws BadRequestException {
	    try {
	        byte[] data = elementImage.getBytes();
	        String contentType=elementImage.getContentType();
	        Element savedImage = elementHandleServiceInterface.addElementWithImage(elementName, elementType, data, elementDescription, elementPrize, isElementInCart, contentType);
	        savedImage.setElementImage(null);
	        return ResponseEntity.ok().body(savedImage);
	    } catch (Exception e) {
	        throw new BadRequestException("Error while uploading Image");
	    }
	}
	
	@GetMapping("/getfirst10")
	public List<Element> getFirstTenElement() throws ServiceException{
		
		try {
			
			List<Element> returnElement=elementHandleServiceInterface.getFirstTenElement();
			returnElement.stream().forEach(r->{
				r.setElementImage(null);
			});
			
			return returnElement;
	
	}catch(Exception e) {
		
		throw new ServiceException("Some Thing gone Wrong Please check while posting the data");
	
	}
	
	}

	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImageById(@PathVariable("id") String id) throws ServiceException {
		
		
		try {
			
			Element image = elementHandleServiceInterface.getImageElement(id);
			
			HttpHeaders headers = new HttpHeaders();
		
				headers.setContentType(MediaType.parseMediaType(image.getContentType()));
		 
				return new ResponseEntity<>(image.getElementImage(), headers, HttpStatus.OK);
	
	}catch(Exception e) {
		
		throw new ServiceException("Some Thing gone Wrong Please check while posting the data");
	
	}
	
	
	}
	
	
	@GetMapping("/addToCart/{id}")
	public Element changeTheStateOfElement(@PathVariable("id") String Id ) throws NotFoundException {
		
		Element outputElement =elementHandleServiceInterface.getImageElement(Id);
		if(outputElement.getIsElementInCart()==false) {
			outputElement.setIsElementInCart(true);
			}else
			{outputElement.setIsElementInCart(false) ;
			}
				elementHandleServiceInterface.save(outputElement);
		
		outputElement.setElementImage(null);
		return outputElement ;
		
	}

	
	@GetMapping("/countCartElement")
	public List<OutPutCount> countCartElement() throws NotFoundException {
	Predicate<Element> filter = element -> !element.getIsElementInCart()==false;
	
	List<Element> returnElement = elementHandleServiceInterface.getFirstTenElement();
	List<OutPutCount> outputCounts = returnElement.stream()
	.filter(filter)
	.collect(Collectors.groupingBy(Element::getElementType, Collectors.counting()))
	.entrySet().stream()
	.map(entry -> new OutPutCount(entry.getKey(), entry.getValue()))
	.collect(Collectors.toList());

	return outputCounts;
	}
	
	
}
