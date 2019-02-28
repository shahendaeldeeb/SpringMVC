package spitter.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spitter.model.Spittle;
import spitter.data.SpittleServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    @Autowired
    private SpittleServiceImpl imp;
//    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
    private static final String MAX_LONG_AS_STRING = "100";


    @Autowired
    public SpittleController(SpittleServiceImpl spittleRepository) {
        this.imp = spittleRepository;

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
                                  @RequestParam(value = "count", defaultValue = "20") int count) {
        return imp.findSpittles(
                Long.MAX_VALUE, 20);
    }

    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String showSpittle(
            @RequestParam("spittle_id") long spittleId,
            Model model) {
        model.addAttribute(imp.findOne(spittleId));
        return "spittle";
    }

    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId,
            Model model) {
        model.addAttribute(imp.findOne(spittleId));
        return "spittle";
    }
}
