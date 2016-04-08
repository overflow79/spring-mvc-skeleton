package com.springmvc.skeleton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by overflow79@gmail.com on 2016. 4. 8..
 */
@Controller
public class WebController extends BaseController{

  @RequestMapping("/hello")
  public String hello(Model model) {

    model.addAttribute("greeting", "Hello World!!");

    return "helloWorld";
  }
}
