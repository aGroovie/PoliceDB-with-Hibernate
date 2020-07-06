package miami.police.controller;

import miami.police.model.Person;
import miami.police.service.PersonService;
import miami.police.service.PrisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PersonController {
    PersonService personService;

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/home")
    public String showHome() {
        return "home";
    }


    @GetMapping("/registration")
    public String showForm(Model m) {
        m.addAttribute("person", new Person());
        return "/registration";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("person") Person person) {
        personService.savePerson(person);
        return "redirect:/result";
    }

    @GetMapping("/result")
    public List<Person> getallPersons() {
        return personService.findAll();
    }

    @RequestMapping(value = "/deletePersonById/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        personService.deletePersonById(id);
        return "redirect:/result";

    }


}

