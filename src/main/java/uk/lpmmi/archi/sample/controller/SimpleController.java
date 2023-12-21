package uk.lpmmi.archi.sample.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uk.lpmmi.archi.sample.data.Book;
import uk.lpmmi.archi.sample.repository.BookRepository;

@Controller
@RestController
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
    
    @GetMapping("/register_book")
    public String register_book(Model model) {
        model.addAttribute("book", new Book());
        return "register_book";
    }
    
    @PostMapping("/book")
    public String book(@ModelAttribute Book book, Model model) {
    	bookRepository.save(book);
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }
    
    @GetMapping("/books")
    public String books(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

}
