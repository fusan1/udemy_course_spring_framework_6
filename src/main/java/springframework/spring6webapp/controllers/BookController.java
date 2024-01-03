package springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springframework.spring6webapp.services.BookServiceImpl;

@Controller
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBook(Model model) {
        model.addAttribute("books", bookService.findAll());

        return "book";
    }
}
