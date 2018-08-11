package com.sw.ontology.core.service;

import java.util.List;

import com.sw.ontology.model.ProductType;

/**
 * 
 * @author Umaya
 *
 */
public interface ProductTypeService {
	
	public ProductType findByProductType(String productType);
    
    public List<ProductType> findAll();
    
    public void save(ProductType productType) throws Exception;

}
