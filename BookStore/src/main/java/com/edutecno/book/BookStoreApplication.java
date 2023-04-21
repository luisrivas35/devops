package com.edutecno.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.edutecno.book.modelo.Book;
import com.edutecno.book.service.BookService;
import com.edutecno.book.vo.BookVO;


@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BookService svc = context.getBean(BookService.class);
		Book book = new Book();
		BookVO myList;

		//Imprimimos la lista para verificar que hay en la base de datos
		printBooks(svc);
		
		
		 
		
		//Lo eliminamos e imprimimos el mensaje del resultado que entrega el servicio
		//System.out.println(svc.delete(auxUsuario).getMensaje());
		
		//Agregar libros nuevos
		/*
		book.setAuthor("Gabriel Garcia Marquez");
		book.setPress("Editorial Real Y Buena");
		book.setPrinted("1975");
		book.setTittle("100 años de Soledad");
		book.setStock("S");
		svc.add(book);
		
		book.setAuthor("Gabriela Mistral");
		book.setPress("Editorial PO");
		book.setPrinted("1969");
		book.setTittle("Pensamientos");
		book.setStock("S");
		svc.add(book);
		
		book.setAuthor("Romulo Gallegos");
		book.setPress("Editorial Pata Pelada");
		book.setPrinted("1955");
		book.setTittle("Lanzas Coloradas");
		book.setStock("S");
		svc.add(book);
		*/
		

		context.close();
		
	}
	//Obtenemos la lista de los libros por autor o titulo
	private static void printByAuthorOrTittle(BookService svc) {
	
		
	}
	
	
	private static void printBooks(BookService svc) {
		System.out.println("--------------Print Final----------------------------------------");
		System.out.println("Lista de Libros en Base de Datos- - - - - - - -");
		for(Book book : svc.getAllBooks().getBooks()) {			
			System.out.println(book);
		}
		System.out.println("Final de la Lista de Libros- - - - - - - -");
		
	}

}
