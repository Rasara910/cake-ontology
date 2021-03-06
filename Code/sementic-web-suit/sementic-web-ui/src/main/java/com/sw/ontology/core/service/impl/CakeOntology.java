package com.sw.ontology.core.service.impl;


import com.sw.ontology.model.Cake;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by praveen on 8/12/18
 */
public class CakeOntology {
    public List<String> findAllCakeBases() {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

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
                System.out.println(bases.getLocalName());
                cakeBaseList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeBaseList;
    }

    public List<String> findAllFrostings() {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeFrostingList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT  DISTINCT ?frosting" +
                " WHERE { ?subject cake:hasFrosting ?frosting}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("frosting");
                System.out.println(bases.getLocalName());
                cakeFrostingList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeFrostingList;
    }

    public List<String> findAllToppings() {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeToppingList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT DISTINCT ?toppings " +
                "WHERE { ?subject cake:hasTopping ?toppings}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("toppings");
                System.out.println(bases.getLocalName());
                cakeToppingList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeToppingList;
    }

    public List<String> findAllFruitAddings() {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeFruitAddingList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT DISTINCT ?fruits " +
                "WHERE { ?subject cake:hasFruit ?fruits}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("fruits");
                System.out.println(bases.getLocalName());
                cakeFruitAddingList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeFruitAddingList;
    }

    public List<String> findAllOtherIngredients() {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeOtherIngredientList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT DISTINCT ?additonal_ingredients " +
                " WHERE { ?subject cake:hasIngredient ?additonal_ingredients}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("additonal_ingredients");
                System.out.println(bases.getLocalName());
                cakeOtherIngredientList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeOtherIngredientList;
    }

    public List<String> findAllOccasions() {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeOccasionList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT DISTINCT ?occasion " +
                "WHERE { ?subject cake:hasOccasion ?occasion}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("occasion");
                System.out.println(bases.getLocalName());
                cakeOccasionList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeOccasionList;
    }

    public List<String> findAllShapes() {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

        List<String> cakeShapeList = new ArrayList<String>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT DISTINCT ?shape " +
                "WHERE { ?subject cake:hasShape ?shape}";
        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource bases = solution.getResource("shape");
                System.out.println(bases.getLocalName());
                cakeShapeList.add(bases.getLocalName());
            }
        } finally {
            qexec.close();
        }
        return cakeShapeList;
    }

    public List<Cake> findCakesForCakeSearch(String selectedBase, String selectedFrosting, String selectedTopping, String selectedFruitAdding, String selectedOtherIngredient, String selectedOccasion, String selectedShape, String priceFrom, String priceTo) {

        FileManager.get().addLocatorClassLoader(CakeOntology.class.getClassLoader());
        Model model = FileManager.get().loadModel("/assets/cake.owl");
        //  model.write(System.out,"TURTLE");

        List<Cake> cakeList = new ArrayList<Cake>();

        String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                "PREFIX cake: <http://www.cake.com/ontologies/cake.owl#> " +
                "SELECT ?subject ?price " +
                "WHERE { ";

        if (!(selectedBase == null || selectedBase.isEmpty())) {
            queryString += "?subject cake:hasCakeBase cake:" + selectedBase + ". ";

        }

        if (!(selectedFrosting == null || selectedFrosting.isEmpty())) {
            queryString += "?subject cake:hasFrosting cake:" + selectedFrosting + ". ";
        }
        if (!(selectedTopping == null || selectedTopping.isEmpty())) {
            queryString += "?subject cake:hasTopping cake:" + selectedTopping + ". ";
        }

        if (!(selectedFruitAdding == null || selectedFruitAdding.isEmpty())) {
            queryString += "?subject cake:hasFruit cake:" + selectedFruitAdding + ". ";
        }

        if (!(selectedOtherIngredient == null || selectedOtherIngredient.isEmpty())) {
            queryString += "?subject cake:hasIngredient cake:" + selectedOtherIngredient + ". ";
        }

        if (!(selectedOccasion == null || selectedOccasion.isEmpty())) {
            queryString += "?subject cake:hasOccasion cake:" + selectedOccasion + ". ";
        }
        if (!(selectedShape == null || selectedShape.isEmpty())) {
            queryString += "?subject cake:hasShape cake:" + selectedShape + ". ";
        }
        if (!(priceFrom == null || priceFrom.isEmpty()) && !(priceTo == null || priceTo.isEmpty())) {
            queryString += "?subject cake:hasPriceValue ?price. " +
                    "FILTER (?price > " + priceFrom + " && ?price < " + priceTo + ")}";
        } else {
            queryString += "?subject cake:hasPriceValue ?price.}";
        }

        System.out.println(queryString);

        Query query = QueryFactory.create(queryString);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution solution = results.nextSolution();
                Resource subject = solution.getResource("subject");
                Literal price = solution.getLiteral("price");
                System.out.println(subject.getLocalName());

                Cake cake = new Cake();

                cake.setCakeName(subject.getLocalName());
                cake.setPrice(Integer.parseInt(price.getString()));

                cakeList.add(cake);
            }
        } finally {
            qexec.close();
        }
        return cakeList;
    }
}
