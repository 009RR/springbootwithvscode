package com.api.book.bootrestbook.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list=new ArrayList<>();
    // private Book book;
    //private Iterable<Book> findAll;

    // static{
    //    list.add(new Book(12,"Black book","Rajesh"));
    //    list.add(new Book(14,"Java complete reference","Manjeet"));
    //    list.add(new Book(16,"Black book2","Abhinav"));
    // }

    //get all books
    public List<Book> getAllBooks(){
      List<Book> list= (List<Book>)this.bookRepository.findAll();
        return list;

    }
    //get single book by id
    public Book getBookById(int id){
        Book book=null;
        try{
            //book = list.stream().filter(e->e.getId()==id).findFirst().get();
           book=this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return book;
    }
    //adding the book
    public Book addBook(Book b){
       Book result =bookRepository.save(b);
        // list.add(b);
       // return b;
    return result;
    }
//delete the book
public void deleteBook(int bid){
    bookRepository.deleteById(bid);
   //list=list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());

}
//update book
public void updateBook(Book book,int bookId){
    // list=list.stream().map(b->{
    //     if(b.getId()==bookId){
    //         b.setTitle(book.getTitle());
    //        b.setAuthor(book.getAuthor());
    //     }
    // return b;

    // }).collect(Collectors.toList());
book.setId(bookId);
    bookRepository.save(book);


}


}
