package com.codefellowship.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
//import sun.security.util.Password;

import java.util.List;
@Controller
public class CodefellowshipController {
//index page

 @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model m) {
        return "index page";
    }
   //signup page

 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

@ResponseBody
@RequestMapping(value = "/signup", method = RequestMethod.GET)

public String signup(Model m) {
//    bCryptPasswordEncoder.encode(password);
    return "signup";}

// @RequestMapping(value = "/signup", method = RequestMethod.POST)


//
//    ApplicationUser = new ApplicationUser
//get a single user
    @RequestMapping(value="/users/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id") int id){
        return "user id: "+id;
    }

}
