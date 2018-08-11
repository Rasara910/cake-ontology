/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.model.Salutation;
import java.util.List;

/**
 *
 * @author Amith
 */
public interface SalutationService {

    public void save(Salutation salutation) throws Exception;

    public Salutation findBySalutation(String salutation);

    public List<Salutation> findAll();
}
