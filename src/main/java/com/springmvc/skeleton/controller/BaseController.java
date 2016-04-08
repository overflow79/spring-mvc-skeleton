package com.springmvc.skeleton.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by overflow79@gmail.com on 2016. 4. 8..
 */
public class BaseController {
    protected Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected Integer checkError(BindingResult bindingResult, HttpServletResponse response){

        if (bindingResult.hasErrors()) {
            LOGGER.error("Parameter binding error.");
            StringBuilder errMsgBuilder = new StringBuilder();
            for (ObjectError error: bindingResult.getAllErrors()) {
                LOGGER.error("Error: " + error.getCode());
                LOGGER.error("Message: " + error.getDefaultMessage());
                errMsgBuilder.append(error.getDefaultMessage() + "\n");
            }
            //TODO: ADD error message generator with status code
            try {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, errMsgBuilder.toString());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return -1;
        }

        return 0;
    }
}
