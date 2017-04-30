package net.lezhang.spring.beanbasic;

import java.util.List;
import java.util.Map;

public class Person {
    private int id;
    private String name;
    private int taxIdThisNameDoesntMatter;
    private Address address;
    private String password;
    private String testField;
    private List<String> favFruits;
    private List<Person> friends;
    private Map<String, String> favBooks;
    private Map<String, Person> relations;
    
    public void setId(int id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setTaxId(int taxId) {
        this.taxIdThisNameDoesntMatter = taxId;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setTestField(String test) {
        this.testField = test;
    }
    public void setFavFruits(List<String> fruits) {
        this.favFruits = fruits;
    }
    public void setFriends(List<Person> persons) {
        this.friends = persons;
    }
    public void setFavBooks(Map<String, String> books) {
        this.favBooks = books;
    }
    public void setRelations(Map<String, Person> relations) { this.relations = relations; }
    
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Person() {}
    
    // factory method: note this method needs to be static!
    public static Person getInstance() {
        System.out.println("Creating person using factory method");
        return new Person(555, "FactoryBorn");
    }


    // init method
    public void onCreate() {
        System.out.println("Person created: " + name);
    }
    
    // destroy method
    public void onDestroy() {
        System.out.println("Person destroyed: " + name);
    }
    
    
    public void speak() {
        System.out.println("Person " + id + " speaking: " + name);
        System.out.println("\ttaxId " + taxIdThisNameDoesntMatter);
        System.out.println("\taddress " + address);
        System.out.println("\tpassword " + password);
        System.out.println("\ttestField " + testField);
    }
    public List<String> getFavFruits() {
        return favFruits;
    }
    public String getFriends() {
        StringBuilder sb = new StringBuilder();
        for(Person p : friends) {
            sb.append(p.id + " ");
        }
        return sb.toString();
    }
    public String getFavBooks() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> book : favBooks.entrySet()) {
            sb.append("[" + book.getKey() + "]" + book.getValue() + ";");
        }
        return sb.toString();
    }
    public String getRelations() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Person> r : relations.entrySet()) {
            sb.append("[" + r.getKey() + "]" + r.getValue().id + ";");
        }
        return sb.toString();
    }

}
