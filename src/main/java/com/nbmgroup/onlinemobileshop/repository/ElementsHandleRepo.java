package com.nbmgroup.onlinemobileshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nbmgroup.onlinemobileshop.entity.Element;


public interface ElementsHandleRepo extends MongoRepository<Element,String>{

	

}
