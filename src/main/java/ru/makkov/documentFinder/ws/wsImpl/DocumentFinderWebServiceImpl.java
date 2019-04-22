package ru.makkov.documentFinder.ws.wsImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.jws.WebService;
import org.apache.log4j.Logger;
import ru.makkov.documentFinder.pojo.Result;
import ru.makkov.documentFinder.repository.dao.ResultDao;
import ru.makkov.documentFinder.repository.dao.daoImpl.ResultDaoImpl;
import ru.makkov.documentFinder.service.DocumentService;
import ru.makkov.documentFinder.service.serviceImpl.DocumentServiceImpl;
import ru.makkov.documentFinder.thread.DocumentCheck;
import ru.makkov.documentFinder.ws.DocumentFinderWebService;

@WebService(endpointInterface = "ru.makkov.documentFinder.ws.DocumentFinderWebService")
public class DocumentFinderWebServiceImpl implements DocumentFinderWebService {

    final static Logger LOGGER = Logger.getLogger(DocumentService.class);

    @Override
    public Result findNumber(Integer number) {
        DocumentService documentService = new DocumentServiceImpl();
        Result result = new Result();
        String directoryName = "files";
        List<String> allFileNames = documentService.getAllNamesTextFiles(directoryName);
        if (allFileNames.size() != 20) {
            result.setError("The number of files is not equal to 20");
        }
        List<Thread> threadList = new ArrayList<>();
        List<String> documentNames = new LinkedList<>();
        for (String fileName: allFileNames) {
            threadList.add(new DocumentCheck(directoryName, fileName, String.valueOf(number), documentNames));
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (documentNames.isEmpty()) {
            result.setCode("01.Result.NotFound");
            List<String> list = new LinkedList<>();
            list.add("-");
            result.setFileNames(list);
        } else {
            result.setCode("00.Result.OK");
            result.setFileNames(documentNames);
        }
        ResultDao resultDao = new ResultDaoImpl();
        resultDao.addResult(result, number);
        LOGGER.info("The result was written to the database. " + result.toString() + "\n");
        return result;
    }
}
