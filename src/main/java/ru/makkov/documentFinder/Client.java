package ru.makkov.documentFinder;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ru.makkov.documentFinder.pojo.Result;
import ru.makkov.documentFinder.ws.DocumentFinderWebService;

public class Client {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8080/documentFinder?wsdl");
        QName qName = new QName("http://wsImpl.ws.documentFinder.makkov.ru/", "DocumentFinderWebServiceImplService");
        Service service = Service.create(url, qName);
        DocumentFinderWebService docService = service.getPort(DocumentFinderWebService.class);

        long timeStart = System.currentTimeMillis();
        Result result = docService.findNumber(92741);
        long timeEnd = System.currentTimeMillis();
        System.out.println(timeEnd - timeStart);
        System.out.println(result);
    }
}
