package com.codefellowship.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

//import sun.security.util.Password;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class CodefellowshipController {

@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
private  ApplicationUserRepository userRepo;
//index
@RequestMapping(value = "/", method = RequestMethod.GET)
public String index(Model m) { return "index"; }
//signup page
@RequestMapping(value = "/signup", method = RequestMethod.GET)
public String signup(Model m) { return "signup";}

@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
public RedirectView create(Model m,
        @RequestParam String firstname,
        @RequestParam String lastname,
        @RequestParam String dateofbirth,
        @RequestParam String username,
        @RequestParam String password,
        @RequestParam String bio
        ){
password = bCryptPasswordEncoder.encode(password);
System.out.println(password);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try{

    ApplicationUser newuser = new ApplicationUser(firstname,  lastname,sdf.parse(dateofbirth),  username, password, bio);
    userRepo.save(newuser);
    m.addAttribute("profiles",userRepo.findAll());
    System.out.println(sdf.parse(dateofbirth));

}
catch (Exception e){
    System.out.println(e.getMessage());
}

    return new RedirectView("profiles");

}
//profiles
@RequestMapping(value = "/profiles", method = RequestMethod.GET)
public String showProfiles(Model m) {
//    m.addAttribute("profiles",userRepo.findAll());
    return "profiles";
}
//
//get a single user
    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable long id,Model m){
 //Optional<ApplicationUser> user = userRepo.findById(id);
   //  m.addAttribute("user", user.get());
        return "user";
    }
//login
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String renderLoginPage(Model m){

       return "login";
    }
    //login post
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validateAndLoginUser(Model m){

        return "user";
    }
    //myprofile
//@RequestMapping(value="/myprofile", method = RequestMethod.GET)
//public String getMyProfile(@PathVariable long id,Model m){
//    Optional<ApplicationUser> user = userRepo.findById(id);
//    m.addAttribute("user",user.get());
//    return "user";
//}
}
