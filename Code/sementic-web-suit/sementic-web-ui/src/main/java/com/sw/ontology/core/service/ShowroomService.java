/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.model.Showroom;
import java.util.List;

/**
 *
 * @author Amith
 */
public interface ShowroomService {
    
    
    public Showroom findByName(String name);
    
    public List<Showroom> findAll();
    
    public void save(Showroom showroom)throws Exception;
}
