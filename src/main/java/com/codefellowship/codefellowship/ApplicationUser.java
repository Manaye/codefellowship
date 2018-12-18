package com.codefellowship.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

public class ApplicationUser {

    //signup page

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.GET)

    public String signup(Model m) {
//    bCryptPasswordEncoder.encode(password);
        return "signup";
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public RedirectView create

    //

    @RequestMapping(value="/users/{id}")
    @ResponseBody
    public String getUser(@PathVariable("id") int id){
        return "user id: "+id;
    }

}
