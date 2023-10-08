package org.example;

import java.util.*;

public class FamilyTree {
    private Map<String, Person> familyTree;

    public FamilyTree() {
        familyTree = new HashMap<>();
    }

    public void addPerson(String name) {
        familyTree.put(name, new Person(name));
    }

    public void addRelationship(String name, String relation, String targetName) {
        Person person1 = familyTree.get(name);
        Person person2 = familyTree.get(targetName);

        if (person1 != null && person2 != null) {
            person1.addRelationship(relation, person2);
        } else {
            System.out.println("Person not found in the family tree.");
        }
    }

    public void connectPeople(String name1, String relationship, String name2) {
        Person person1 = familyTree.get(name1);
        Person person2 = familyTree.get(name2);

        if (person1 != null && person2 != null) {
            person1.addRelationship(relationship, person2);
            System.out.println(name1 + " is now connected as " + relationship + " of " + name2);
        } else {
            System.out.println("Invalid person names. Make sure both names exist in the family tree.");
        }
        System.out.println(getFamilyTree());
    }

    public void countSons(String name) {
        int count = 0;

        Person person = familyTree.get(name);
        if (person != null && person.getRelationships().containsKey("son")) {
            List<Person> people = person.getRelationships().get("son");
            for(Person person1 : people) {
                Map<String, List<Person>> map = familyTree.get(person1.getName()).getRelationships();
                if(map.containsKey("son")) {
                    List<Person> personList = map.get("son");
                    for(Person personn : personList) {
                        if(personn.getName().equals(name)) count++;
                    }
                }
            }
        }

        System.out.println(count + " son exists");
        return;
    }

    public void countDaughters(String name) {
        int count = 0;

        Person person = familyTree.get(name);
        if (person != null && person.getRelationships().containsKey("daughter")) {
            List<Person> people = person.getRelationships().get("daughter");
            for(Person person1 : people) {
                Map<String, List<Person>> map = familyTree.get(person1.getName()).getRelationships();
                if(map.containsKey("son")) {
                    List<Person> personList = map.get("daughter");
                    for(Person personn : personList) {
                        if(personn.getName().equals(name)) count++;
                    }
                }
            }
        }

        System.out.println(count + " daughter exists");
        return;
    }

    public void countWives(String name) {
        System.out.println(countRelationships(name, "husband"));
    }

    public void getFather(String name) {
        Person person = familyTree.get(name);
        if (person != null && person.getRelationships().containsKey("son")) {
            List<Person> fathers = person.getRelationships().get("son");
            System.out.println(fathers.get(0).getName());
            return;
        } else if (person != null && person.getRelationships().containsKey("daughter")) {
            List<Person> fathers = person.getRelationships().get("daughter");
            System.out.println(fathers.get(0).getName());
            return;
        }
        System.out.println("Father not found in the family tree.");
    }

    private int countRelationships(String name, String relation) {
        Person person = familyTree.get(name);
        if (person != null && person.getRelationships().containsKey(relation)) {
            List<Person> people = person.getRelationships().get(relation);
            return people.size();
        }
        return 0;
    }

    public Map<String, Person> getFamilyTree() {
        System.out.println("--------------------------------------------------------");
        for (Map.Entry<String,Person> entry : familyTree.entrySet()) {
            String key = entry.getKey();
            Person person = entry.getValue();
            System.out.println("Key = " + key);
            person.getRelationTree();
        }
        System.out.println("--------------------------------------------------------");
        return familyTree;
    }
}
