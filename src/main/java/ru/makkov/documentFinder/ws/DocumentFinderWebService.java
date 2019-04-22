package ru.makkov.documentFinder.ws;

import ru.makkov.documentFinder.pojo.Result;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DocumentFinderWebService {

    @WebMethod
    public Result findNumber(Integer number);
}
