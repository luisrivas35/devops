package com.edutecno.book.dao;

import java.util.List;

import com.edutecno.book.modelo.Book;


public interface BookDAO {
	
	/*
	 * métodos del CRUD
	 */
	public List<Book> getAllBooks();
	public List<Book> findByTittleOrAuthor(String cadena);
	public int add(Book book);
	public int update(Book book);
	public int delete(Book book);

}
