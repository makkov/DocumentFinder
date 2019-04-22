package ru.makkov.documentFinder.service;

import java.util.List;

/**
 * service for working with text documents
 */
public interface DocumentService {

    /**
     * @param directoryName - directory name with documents
     * @return list of documents in the format .txt
     */
    List<String> getAllNamesTextFiles(String directoryName);

    /**
     * @param directoryName - directory of the document
     * @param documentName - the name of checked document
     * @param numberForFind - number to search
     * @return true - if the document contains a number, false - otherwise
     */
    boolean isDocumentContainNumber(String directoryName, String documentName, String numberForFind);
}
