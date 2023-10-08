package org.example;

import java.util.*;

public class Person {
    private String name;
    private Map<String, List<Person>> relationships;

    public Person(String name) {
        this.name = name;
        this.relationships = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addRelationship(String relationship, Person person) {
        relationships.computeIfAbsent(relationship, k -> new ArrayList<>()).add(person);
    }

    public List<Person> getRelative(String relationship) {
        return relationships.get(relationship);
    }

    public Map<String, List<Person>> getRelationships() {
        return relationships;
    }

    public Map<String, List<Person>> getRelationTree() {
        for (Map.Entry<String,List<Person>> entry : relationships.entrySet()) {
            System.out.println("********");
            System.out.print(entry.getKey() + " _____________ ");
            for(Person person : entry.getValue()) {
                System.out.print(person.getName() + " ");
            }
            System.out.println("____________");
            System.out.println("********");
        }

        return relationships;
    }
}

