package com.adidas.codingchallenge.common.exception;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

/**
 * Class for return a json for exceptions
 *
 * @author jabenitez (Juan Antonio Benitez)
 */
@Controller
public class CustomExceptionController extends AbstractErrorController {

    private static final String PATH = "/error";

    /**
     * Constructor
     *
     * @param errorAttributes The errors attribute
     */
    public CustomExceptionController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /**
     * This method handle the errors producers in the application
     *
     * @param request Request received from client
     * @return Map with errors produced
     */
    @RequestMapping(value = PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> handleError(HttpServletRequest request) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, Boolean.FALSE);
        return errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
