package com.sw.ontology.core.service;


import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

import java.util.Queue;

/**
 * Created by praveen on 8/12/18
 */
public class TestJena {
    public static void main(String[] args){
        FileManager.get().addLocatorClassLoader(TestJena.class.getClassLoader());
        Model model =  FileManager.get().loadModel("/Users/praveen/cake-ontology/Code/sementic-web-suit/sementic-web-ui/src/main/java/com/sw/ontology/assets/cake.owl");
      //  model.write(System.out,"TURTLE");

        String queryString ="PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT DISTINCT ?bases " +
                "WHERE { ?subject cake:hasCakeBase ?bases}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query,model);

        try{
            ResultSet results=qexec.execSelect();
            while(results.hasNext()){
                QuerySolution solution=results.nextSolution();
                Resource bases= solution.getResource("bases");
                System.out.println(bases);
            }
        }finally{
            qexec.close();
        }
    }
}
