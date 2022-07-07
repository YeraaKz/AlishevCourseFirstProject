package com.company.controllers;

import com.company.DAO.BooksDAO;
import com.company.DAO.PersonDAO;
import com.company.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {
    private final PersonDAO personDAO;
    private final BooksDAO booksDAO;
    @Autowired
    public PersonController(PersonDAO personDAO, BooksDAO booksDAO) {
        this.personDAO = personDAO;
        this.booksDAO = booksDAO;
    }

    @GetMapping()
    public String allPeoplePage(Model model){
        model.addAttribute("people", personDAO.getAllPeople());
        return "Person/allPeoplePage";
    }

    @GetMapping("/new")
    public String newPersonForm(Model model){
        model.addAttribute("person", new Person());
        return "Person/newPersonForm";
    }

    @PostMapping
    public String createPerson(@ModelAttribute("person") Person person){
        personDAO.createPerson(person);

        return "redirect:/people";
    }

    /*
    @GetMapping("/{id}")
    public String personPage(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.getOnePerson(id));
        model.addAttribute("books", booksDAO.getPersonsBooks(id));
        return "Person/personPage";
    }
    */
    @GetMapping("/{id}/edit")
    public String editPersonPage(@PathVariable("id") int id, Model model){
        model.addAttribute("person", personDAO.getOnePerson(id));

        return "Person/editPersonForm";
    }

    @PatchMapping("/{id}")
    public String editPerson(@ModelAttribute("person") Person person, @PathVariable("id") int id){
        personDAO.editPerson(id, person);

        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") int id){
        personDAO.deletePerson(id);

        return "redirect:/people";
    }
}
