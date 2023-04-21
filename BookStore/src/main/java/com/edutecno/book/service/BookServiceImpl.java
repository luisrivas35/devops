package com.edutecno.book.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edutecno.book.dao.BookDAO;
import com.edutecno.book.modelo.Book;
import com.edutecno.book.vo.BookVO;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO dao;

	BookVO respuesta;
	
	@Override
	public BookVO getAllBooks() {
		respuesta = new BookVO(new ArrayList<Book>(), "Ha ocurrido un error");
		try {
			respuesta.setBooks(new ArrayList<>(dao.getAllBooks()));
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getBooks().size()));
			
		} catch (Exception e) {
			
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public BookVO findByTittleOrAuthor(String cadena) {
		respuesta = new BookVO(new ArrayList<Book>(), "Ha ocurrido un error");
		try {
			
			respuesta.setBooks(dao.findByTittleOrAuthor(cadena));
			
			
		} catch (Exception e) {
			
			System.err.print(e);
		}
		return respuesta;
		
	}

	@Override
	public BookVO add(Book book) {
		respuesta = new BookVO(new ArrayList<Book>(), "Ha ocurrido un error");
		try {
			int registrosActualizados = dao.add(book);
			respuesta.setMensaje(registrosActualizados == 1 ? "Se ha creado el usuario correctamente" : "No se ha podido crear el usuario");
			
		} catch (Exception e) {
			
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public BookVO update(Book book) {
		respuesta = new BookVO(new ArrayList<Book>(), "Ha ocurrido un error");
		try {
			int registrosActualizados = dao.update(book);
			respuesta.setMensaje(String.format("Se ha/n actualizado correctamente %d usuario/s", registrosActualizados));
			
		} catch (Exception e) {
			
			System.err.print(e);
		}
		return respuesta;
	}

	@Override
	public BookVO delete(Book book) {
		respuesta = new BookVO(new ArrayList<Book>(), "Ha ocurrido un error");
		try {
			int registrosActualizados = dao.delete(book);
			respuesta.setMensaje(String.format("Se ha/n eliminado correctamente a %d usuario/s", registrosActualizados));
			
		} catch (Exception e) {
			
			System.err.print(e);
		}
		return respuesta;
	}

}
