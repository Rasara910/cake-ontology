package com.sw.ontology.core.service.impl;

import java.util.List;

import com.sw.ontology.core.dao.ProductTypeDao;
import com.sw.ontology.core.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.ontology.model.ProductType;

/**
 * 
 * @author Umaya
 *
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
	
	@Autowired
	private ProductTypeDao productTypeDao;

	@Override
	public ProductType findByProductType(String productType) {
		return productTypeDao.read(productType);
	}

	@Override
	public List<ProductType> findAll() {
		return productTypeDao.findAll();
	}

	@Override
	public void save(ProductType productType) throws Exception {
		productTypeDao.create(productType);
		
	}
	
}
