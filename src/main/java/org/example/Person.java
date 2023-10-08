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
}

