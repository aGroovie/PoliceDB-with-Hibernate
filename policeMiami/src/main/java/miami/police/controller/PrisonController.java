package miami.police.controller;

import miami.police.model.Prison;
import miami.police.service.PrisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PrisonController {

    PrisonService prisonService;

@Autowired
    public void setPrisonService(PrisonService prisonService) {
        this.prisonService = prisonService;
    }

    @GetMapping("/registration-prison")
    public String showForm(Model m) {
        m.addAttribute("prison", new Prison());
        return "/registration-prison";
    }

    @RequestMapping(value = "/savePrison", method = RequestMethod.POST)
    public String save(@ModelAttribute("prison") Prison prison) {
        prisonService.savePrison(prison);
        return "redirect:/prison-result";
    }


    @GetMapping("/prison-result")
    public List<Prison> getallPrisons() {
        return prisonService.findAll();
    }

    @RequestMapping(value = "/deletePrisonById/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
    prisonService.deletePrisonById(id);
        return "redirect:/prison-result";

    }
}
