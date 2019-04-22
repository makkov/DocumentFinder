package ru.makkov.documentFinder.service.serviceImpl;

import org.apache.log4j.Logger;
import ru.makkov.documentFinder.service.DocumentService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DocumentServiceImpl implements DocumentService {

    final static Logger LOGGER = Logger.getLogger(DocumentService.class);

    public List<String> getAllNamesTextFiles(String directoryName) {
        String path = new File("").getAbsolutePath() + "/" + directoryName;
        List<String> listFileName = new ArrayList<>();
        File[] files = new File(path).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".txt")) {
                    listFileName.add(file.getName());
                }
            }
        }
        return listFileName;
    }

    public boolean isDocumentContainNumber(String directoryName, String documentName, String numberForFind) {
        String path = new File("").getAbsolutePath() + "/" + directoryName + "/" + documentName;
        try {
            if (Files.lines(Paths.get(path))
                    .flatMap( s -> Stream.of(s.split(",")))
                    .anyMatch(s -> s.equals(numberForFind))) {
                return true;
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage() + " Error parsing file\n");
        }
        return false;
    }
}
