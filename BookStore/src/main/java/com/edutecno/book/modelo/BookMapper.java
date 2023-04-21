package com.edutecno.book.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		Book book = new Book();
		book.setBook_id(rs.getInt("book_id"));
		book.setTittle(rs.getString("tittle"));
		book.setPrinted(rs.getString("printed"));
		book.setAuthor(rs.getString("author"));
		book.setPress(rs.getString("press"));
		book.setStock(rs.getString("stock"));
		return book;
	}

}


