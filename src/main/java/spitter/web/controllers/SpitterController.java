package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spitter.model.Spitter;
import spitter.data.SpitterServiceImpl;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    @Autowired
    private SpitterServiceImpl imp;

    @Autowired
    public SpitterController(SpitterServiceImpl spitterServiceImpl) {
        this.imp = spitterServiceImpl;
    }
    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute( new Spitter());
        return "registerForm";
    }

    @RequestMapping(value="/register", method=POST)
    public String processRegistration(@ModelAttribute @Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        imp.save(spitter);
        System.out.println("spitter after save : " + spitter);
        return "redirect:/spitter/" +
                spitter.getUsername();
    }

    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = imp.findByUsername(username);
        System.out.println("in get spitter : " + spitter);
        model.addAttribute(spitter);
        return "profile";
    }
}
