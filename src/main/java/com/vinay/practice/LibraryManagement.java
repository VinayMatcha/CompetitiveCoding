package com.vinay.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Book{
    private int book_id;
    private String status;
    private String book_title;


    public Book(int id, String title){
        this.book_id = id;
        this.status = "available";
        this.book_title = title;
    }

    public int getBook_id() {
        return book_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", status='" + status + '\'' +
                ", book_title='" + book_title + '\'' +
                '}';
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}


class BookManagement{

        public HashMap<String, List<Book>>bookMapping;
        public HashMap<Integer, Book> books;

        public  BookManagement (){
            bookMapping = new HashMap<>();
            books = new HashMap<>();
        }

        public Book borrow_book(String book_title) {
            if(!bookMapping.containsKey(book_title) || bookMapping.get(book_title).size() == 0){
                return null;
            }
            List<Book> bookList= bookMapping.get(book_title);
            Book book_returned = bookList.get(0);
            book_returned.setStatus("borrowed");
            bookList.remove(0);
            return book_returned;
        }

        public void return_book(String book_title, int book_id) {

            if(books.containsKey(book_id)) {
                Book book = books.get(book_id);
                book.setStatus("available");
                bookMapping.get(book_title).add(book);
            } else {
                add_book(book_title, book_id);
            }
        }

        public void add_book(String book_title, int book_id) {
            Book book = new Book(book_id, book_title);
            books.put(book_id, book);
            if(bookMapping.containsKey(book_title)) {
                bookMapping.get(book_title).add(book);
            } else {
                List<Book> list = new ArrayList<>();
                list.add(book);
                bookMapping.put(book_title, list);
            }
        }

    public String check_book_status(int book_id) {
        if(!books.containsKey(book_id)) {
            return "borrowed";
        }
        Book book = books.get(book_id);
        return book.getStatus();
    }

}

public class LibraryManagement {


    public static void main(String[] args) {

        BookManagement bookManagement = new BookManagement();
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<5;i++) {
            int  book_id = Integer.parseInt(scanner.nextLine());
            String book_title = scanner.nextLine();
            bookManagement.add_book(book_title, book_id);
        }
        for(int key : bookManagement.books.keySet()) {
            System.out.println(bookManagement.books.get(key));
        }
    }



}
