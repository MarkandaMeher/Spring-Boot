package com.api.book.spring_boot_rest_book.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.spring_boot_rest_book.Entities.Book;
import com.api.book.spring_boot_rest_book.Services.BookService;

// @Controller
@RestController //no need to call - @ResponseBody 
public class BookController {
    

    @Autowired
    private BookService bookService;

    // @RequestMapping(path = "/book",method = RequestMethod.GET)
    @GetMapping("/book5")
public String getBook(){
 
    return "this is test book";
}

@GetMapping("/book2")
public Book getBook2(){

    Book book = new Book(101,"Java","xyz");
    return book;
}

// @GetMapping("/book")
// public List< Book> getBook3(){
//     return this.bookService.getAllBook();
// }

@GetMapping("/book")
public ResponseEntity<List<Book>> getBook3(){
    List<Book> list =  this.bookService.getAllBook();
    if(list.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(list));
}


@GetMapping("/book4/{id}")
public ResponseEntity<Book> getBook4(@PathVariable("id") int id){
    Book book = bookService.getBookById(id);
    if(book == null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(book));

}

// @PostMapping("/book")
// public Book addBook(@RequestBody Book book){
//     Book b = this.bookService.addBook(book);
//     return b;

// }

@PostMapping("/book")
public ResponseEntity<Book> addBook(@RequestBody Book book){
    Book b = null;
    try{
         b = this.bookService.addBook(book);
        System.out.println(b);
        return ResponseEntity.status(HttpStatus.CREATED).body(b);
    }catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    

}

@DeleteMapping("/book/{bid}")
public void deleteBook(@PathVariable("bid") int bid){
    this.bookService.deleteBook(bid);
}

@PutMapping("/book/{bid}")
public Book updateBook(@RequestBody Book book,@PathVariable("bid") int bid){
    this.bookService.updateBook(book, bid);
    return book;
}

}