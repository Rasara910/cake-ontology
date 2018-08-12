package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.service.CakeOntologyService;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.util.FileManager;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by praveen on 8/12/18
 */
@Service
public class CakeOntologyServiceImpl implements CakeOntologyService {


    @Override
    public List<String> findAllCakeBases() {
        FileManager.get().addLocatorClassLoader(CakeOntologyServiceImpl.class.getClassLoader());
        Model model = FileManager.get().loadModel("/Users/praveen/cake-ontology/Code/sementic-web-suit/sementic-web-ui/src/main/java/com/sw/ontology/assets/cake.owl");

        List<String> cakeBaseList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT DISTINCT ?bases " +
                "WHERE { ?subject cake:hasCakeBase ?bases}";

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("bases");
                cakeBaseList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeBaseList;
    }
}
