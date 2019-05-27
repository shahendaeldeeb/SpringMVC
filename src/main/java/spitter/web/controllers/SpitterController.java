package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import spitter.data.SpitterRepository;
import spitter.data.SpitterServiceImpl;
import spitter.model.Spitter;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    @Autowired
    private SpitterRepository spitterRepository;


    @Autowired
    public SpitterController(SpitterServiceImpl spitterServiceImpl) {
        this.spitterRepository = spitterServiceImpl;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }


    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @RequestPart("profile_picture") MultipartFile profilePicture,
            @Valid Spitter spitter,
            Errors errors) {

        if (errors.hasErrors()) {
            return "registerForm";
        }


        spitterRepository.save(spitter);
        System.out.println("spitter after save : " + spitter);
        return "redirect:/spitter/" +
                spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        System.out.println("in get spitter : " + spitter);
        model.addAttribute(spitter);
        return "profile";
    }
}
