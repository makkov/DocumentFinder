package ru.makkov.documentFinder;

import ru.makkov.documentFinder.ws.wsImpl.DocumentFinderWebServiceImpl;

import javax.xml.ws.Endpoint;

public class DocumentFinderWebServicePublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/documentFinder", new DocumentFinderWebServiceImpl());
    }
}
