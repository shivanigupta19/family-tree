package org.example;

import org.example.FamilyTree;

import java.util.*;

public class FamilyTreeApp {
    static String personName;

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Family Tree!!!");

        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");

            if (parts[0].equals("exit")) {
                break;
            } else if (parts[0].equals("add")) {
                if(parts[1].equals("person")) {
                    if (parts.length >= 3) {
                        String name = parts[2];
                        familyTree.addPerson(name);
                        personName = name;
                        System.out.println(name + " has been added to the family tree.");
                    } else {
                        System.out.println("Invalid command. Usage: 'add person <name>'.");
                    }
                } else if(parts[1].equals("relationship")) {
                    if (parts.length >= 3) {
                        String relationship = parts[2];
//                        familyTree.addRelationship(relationship, personName);
                        System.out.println(relationship + " relationship has been added.");
                    } else {
                        System.out.println("Invalid command. Usage: 'add relationship <relationship>'.");
                    }
                } else {
                    System.out.println(parts[1]);
                    System.out.println("Invalid command ");
                }
            } else if (parts[0].equals("connect")) {
                if (parts.length >= 5 && parts[2].equals("as") && parts[4].equals("of")) {
                    String name1 = parts[1];
                    String relationship = parts[3];
                    String name2 = parts[5];

                    familyTree.connectPeople(name1, relationship, name2);
                } else {
                    System.out.println("Invalid command. Usage: 'connect <name1> as <relationship> of <name2>'.");
                }
            } else if (parts[0].equals("count")) {
                if(parts[1].equals("sons")) {
                    familyTree.countSons(parts[3]);
                } else if(parts[1].equals("daughter")) {
                    familyTree.countDaughters(parts[3]);
                } else if(parts[1].equals("wives")) {
                    familyTree.countWives(parts[3]);
                } else {
                    System.out.println("Relationship doesn't exits");
                }
            } else if(parts[0].equals("father")) {
                familyTree.getFather(parts[2]);
            } else {
                System.out.println(parts[0]);
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}

// add person RamKrishna
// add relationship father

// add person Shanti
// add relationship wife

// add person Seema
// add relationship daughter

// add person Sanjeev
// add relationship son

// add person Rajeev
// add relationship son

// add person Soni
// add relationship daughter

// add person Shashi
// add relationship wife

// add person Renu
// add relationship wife

// connect Shanti as wife of RamKrishna
// connect RamKrishna as husband of Shanti

// connect RamKrishna as father of Seema
// connect Seema as daughter of RamKrishna

// connect RamKrishna as father of Sanjeev
// connect Sanjeev as son of RamKrishna

// connect RamKrishna as father of Rajeev
// connect Rajeev as son of RamKrishna

// connect RamKrishna as father of Soni
// connect Soni as daughter of Ram Krishna

// connect Shashi as wife of Sanjeev
// connect Renu as wife of Rajeev


// count sons of RamKrishna
// count daughter of RamKrishna
// count wives of RamKrishna
// count sons of RamKrishna

// father of Sanjeev