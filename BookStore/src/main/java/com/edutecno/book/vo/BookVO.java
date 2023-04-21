package com.edutecno.book.vo;


import java.util.List;

import com.edutecno.book.modelo.Book;


public class BookVO {

	List<Book> books;
	String mensaje;
	
	
	public BookVO(List<Book> books, String mensaje) {
		super();
		this.books = books;
		this.mensaje = mensaje;
		
	}
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

	@Override
	public String toString() {
		return "BookVO [mensaje=" + mensaje + "]";
	}

}
