package com.edutecno.book.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutecno.book.modelo.Book;
import com.edutecno.book.modelo.BookMapper;


@Repository
public class BookDAOImpl implements BookDAO {

	
	JdbcTemplate jdbcTemplate;
	DataSource dataSource;
	
	@Autowired
	public BookDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public List<Book> getAllBooks() {
		
		return jdbcTemplate.query("select * from BOOK", new BookMapper());
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findByTittleOrAuthor(String cadena) {
		//Para ejecutar una query devolviendo un sólo registro se utiliza queryForObject
		return (List<Book>) jdbcTemplate.queryForObject("select * from BOOK where tittle= ? or author= ?", new BookMapper());
	}

	@Override
	public int add(Book book) {
		//el método update de jdbcTemplate devuelve la cantidad de registros que fueron modificados eliminados o creados (dependiendo de la query que se use con el método)
		//de esta forma, podemos saber si nuestro insert funcionó correctamente.
		return jdbcTemplate.update("insert into book values (sq_book.nextval, ?, ?, ?, ?, ?)", 
				book.getTittle(),book.getPrinted(), book.getAuthor(), book.getPress(), book.getStock());
	}

	@Override
	public int update(Book book) {
		return jdbcTemplate.update("update book set tittle = ?, printed = ?, author = ?, press = ?, stock = ? where book_id = ?",
				book.getTittle(), book.getPrinted(), book.getAuthor(), book.getPress(), book.getStock());
	}

	@Override
	public int delete(Book book) {
		return jdbcTemplate.update("delete from book where book_id = ?", book.getBook_id());
	}

}

