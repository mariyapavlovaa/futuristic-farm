package com.uni.fmi.futuristicfarm.ai;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateRequest;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FarmOntology {

    private final OWLOntologyManager ontologyManager;
    private OWLOntology farmOntology;
    private final OWLDataFactory dataFactory;
    private OWLReasoner reasoner;

    private final String ontologyIRIStr;
    private boolean contains = false;

    // Create an empty Jena model
    private Model model = ModelFactory.createDefaultModel();

    public FarmOntology() {
        ontologyManager = OWLManager.createOWLOntologyManager();
        dataFactory = ontologyManager.getOWLDataFactory();

        loadOntologyFromFile();
        ontologyIRIStr = farmOntology.getOntologyID().getOntologyIRI().toString() + "#";

        String filename = "src/files/farm.owl";
        model.read(filename);
    }

    private void loadOntologyFromFile() {
        File ontoFile = new File("src/files/farm.owl");

        try {
            farmOntology = ontologyManager.loadOntologyFromOntologyDocument(ontoFile);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
    }

    public List<String> getIllnessBySymptom(String plant, List<String> symptoms) {

        String prefixes = """
                        PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                        PREFIX owl: <http://www.w3.org/2002/07/owl#>
                        PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                        PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
                        PREFIX p:<http://www.semanticweb.org/user/ontologies/2023/5/farm#>
                """;

        StringBuilder sb = new StringBuilder(prefixes);
        String illness = plant + "Illness";

        //sb.append("SELECT * WHERE {?y rdfs:subClassOf  ?x .");

        sb.append("SELECT * WHERE {?y rdfs:subClassOf p:");
        sb.append(illness);
        sb.append(".\n");

        symptoms.forEach(s -> {
            String str = "?y p:hasSymptom p:" + s + ".\n";
            sb.append(str);
        });

        sb.append("}");

        Query query = QueryFactory.create(sb.toString());
        List<String> labels = new ArrayList<>();
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet resultSet = qexec.execSelect();

            while (resultSet.hasNext()) {
                QuerySolution sol = resultSet.nextSolution();
                Resource resource = sol.getResource("y");

                String label = resource.toString();
                label = resource.toString().substring(label.indexOf('#') + 1);

                labels.add(label);
                System.out.println("!!!!!!!!!!!!!!!!!!!" + label);

            }
        }

        return labels;
    }

    public List<String> getAllPlants() {

        String prefixes = """
                        PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                        PREFIX owl: <http://www.w3.org/2002/07/owl#>
                        PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                        PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
                        PREFIX p:<http://www.semanticweb.org/user/ontologies/2023/5/farm#>
                """;

        StringBuilder sb = new StringBuilder(prefixes);
        sb.append("SELECT ?x WHERE {?y rdfs:subClassOf p:IllCrop . ?x rdfs:subClassOf ?y . }");

        Query query = QueryFactory.create(sb.toString());
        List<String> labels = new ArrayList<>();
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet resultSet = qexec.execSelect();

            while (resultSet.hasNext()) {
                QuerySolution sol = resultSet.nextSolution();
                Resource resource = sol.getResource("x");

                String label = resource.toString();
                label = resource.toString().substring(label.indexOf('#') + 1);

                labels.add(label);

            }
        }

        return labels;
    }

    public List<String> getAllSymptoms() {

        String prefixes = """
                        PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
                        PREFIX owl: <http://www.w3.org/2002/07/owl#>
                        PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
                        PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
                        PREFIX p:<http://www.semanticweb.org/user/ontologies/2023/5/farm#>
                """;

        StringBuilder sb = new StringBuilder(prefixes);
        sb.append("SELECT * WHERE {?y rdfs:subClassOf p:Symptom . }");

        Query query = QueryFactory.create(sb.toString());
        List<String> labels = new ArrayList<>();
        try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
            ResultSet resultSet = qexec.execSelect();

            while (resultSet.hasNext()) {
                QuerySolution sol = resultSet.nextSolution();
                Resource resource = sol.getResource("y");

                String label = resource.toString();
                label = resource.toString().substring(label.indexOf('#') + 1);

                labels.add(label);

            }
        }

        return labels;
    }

    public void createSymptom(String symptomName) {
        String superclassURI = "http://www.semanticweb.org/user/ontologies/2023/5/farm#Symptom";
        String subclassURI = "http://www.semanticweb.org/user/ontologies/2023/5/farm#" + symptomName;
        if (!symptomName.toLowerCase().contains("symptom")) {
            subclassURI = subclassURI + "Symptom";
        }

        String sparqlQuery = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "INSERT DATA {\n" +
                "  <" + subclassURI + "> rdf:type owl:Class ;\n" +
                "                         rdfs:subClassOf <" + superclassURI + "> .\n" +
                "}";

        UpdateRequest request = UpdateFactory.create(sparqlQuery);
        UpdateAction.execute(request, model);

        String outputFile = "src/files/farm.owl";
        try (OutputStream out = new FileOutputStream(outputFile)) {
            model.write(out, "RDF/XML");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteSymptom(String symptom) {

        String subclassURI = "http://www.semanticweb.org/user/ontologies/2023/5/farm#" + symptom;
        if (!symptom.toLowerCase().contains("symptom")) {
            subclassURI = subclassURI + "Symptom";
        }
        Resource symptomResource = ResourceFactory.createResource(subclassURI);
        model.removeAll(symptomResource, null, null);

        String outputFile = "src/files/farm.owl";
        try (OutputStream out = new FileOutputStream(outputFile)) {
            model.write(out, "RDF/XML");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateSymptom(String newSymptomName, String oldSymptomName) {
        deleteSymptom(oldSymptomName);
        createSymptom(newSymptomName);
    }
}
