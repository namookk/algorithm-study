package com.algorithm.sk.y2021.m11.d11;

import java.util.ArrayList;
import java.util.Collection;

public class DocumentStore {
    protected Collection<String> documents = new ArrayList<String>();
    private int capacity;

    public DocumentStore(int _capacity) {
        capacity = _capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<String> getDocuments() {
        Collection<String> answer = new ArrayList<String>(documents);
        System.out.println(answer.size());
        return documents;
    }

    public void addDocument(String document) {
        if (this.documents.size() >= capacity){
            throw new IllegalStateException();
        }
        documents.add(document);
    }

    @Override
    public String toString() {
        return String.format("Document store: %d/%d", documents.size(), capacity);
    }

    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("item");
        documentStore.addDocument("item");
        System.out.println(documentStore.getDocuments());
        System.out.println(documentStore);
    }
}
