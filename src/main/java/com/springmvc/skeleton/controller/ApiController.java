package com.springmvc.skeleton.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by overflow79@gmail.com on 2016. 4. 8..
 */
@RestController
@RequestMapping("/")
public class ApiController extends BaseController{

  /**
   * title
   *
   * @param
   * @return
   */
  @RequestMapping(method = {RequestMethod.GET}, value = "/test")
  @ResponseBody
  public String search(@RequestParam("q") String query) {
    String result = "query : " + query;
    LOGGER.debug(result);
    return result;
  }

}
