package ru.makkov.documentFinder.pojo;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    private String code;
    private List<String> fileNames;
    private String error;

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", fileNames=" + fileNames +
                ", error='" + error + '\'' +
                '}';
    }
}
