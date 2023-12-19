package uk.lpmmi.archi.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import uk.lpmmi.archi.sample.repository.BookRepository;

@Controller
public class SimpleController {
	
	@Value("${spring.application.name}")
    String appName;
	
	@Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("app2", appName);
        return "home";
    }
    
    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

}
