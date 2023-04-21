package com.edutecno.book.service;
import com.edutecno.book.modelo.Book;
import com.edutecno.book.vo.BookVO;


public interface BookService {

	public BookVO getAllBooks();
	public BookVO findByTittleOrAuthor(String cadena);
	public BookVO add(Book book);
	public BookVO update(Book book);
	public BookVO delete(Book book);

}
