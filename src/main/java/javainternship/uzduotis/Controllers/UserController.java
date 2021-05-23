package javainternship.uzduotis.Controllers;

import javainternship.uzduotis.Objects.User;
import javainternship.uzduotis.services.BookService;
import javainternship.uzduotis.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final  String BASE_URL = "/api/user";
    private final UserService userService;
    private  BookService bookService;


    public UserController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping
    public List<User>getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/taking")
    public void takingBook(@RequestParam long bookid, @RequestParam long userid, @RequestParam int daystaken) throws IOException {
        userService.takingBook(bookService.findBookById(bookid), daystaken, userid);
    }
}
