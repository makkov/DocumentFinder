package ru.makkov.documentFinder.thread;

import java.util.List;
import ru.makkov.documentFinder.service.DocumentService;
import ru.makkov.documentFinder.service.serviceImpl.DocumentServiceImpl;

public class DocumentCheck extends Thread {

  private String directoryName;
  private String fileName;
  private String numberForFind;
  private List<String> list;

  public DocumentCheck(String directoryName, String fileName, String numberForFind, List<String> list) {
    this.directoryName = directoryName;
    this.fileName = fileName;
    this.numberForFind = numberForFind;
    this.list = list;
  }

  @Override
  public void run() {
    DocumentService documentService = new DocumentServiceImpl();
      if (documentService.isDocumentContainNumber(directoryName, fileName, numberForFind)) {
        list.add(fileName);
      }
  }
}
