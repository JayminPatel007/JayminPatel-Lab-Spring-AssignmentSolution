package com.example.springmvc.controllers;

import com.example.springmvc.entities.DebateRegistration;
import com.example.springmvc.repositories.DebateRegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private DebateRegistrationsRepository drRepo;

    @GetMapping("")
    public String home(Model model) {
        List<DebateRegistration> list = drRepo.findAll();
        model.addAttribute("registrations", list);
        return "index";
    }

    @GetMapping("/add")
    public String add_form() {
        return "add";
    }

    @GetMapping("/edit/{id}")
    public String edit_form(@PathVariable(value = "id") long id, Model model) {
        Optional<DebateRegistration> debateRegistrationOp = drRepo.findById(id);
        DebateRegistration debateRegistration = debateRegistrationOp.get();
        model.addAttribute("registration", debateRegistration);
        return "edit";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute DebateRegistration registration, HttpSession session) {
        drRepo.save(registration);
        session.setAttribute("msg", "Registration added successfully...");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute DebateRegistration registration, HttpSession session) {
        drRepo.save(registration);
        session.setAttribute("msg", "Registration updated successfully...");
        return "redirect:/";
    }
}
