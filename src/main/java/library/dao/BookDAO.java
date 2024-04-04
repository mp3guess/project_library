package library.dao;

import library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("select * from book where id=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("insert into book(name,author_name,year) values(?,?,?)",
                book.getName(), book.getAuthor_name(), book.getYear());
    }

    public void update(int id, Book updatedBook){
        jdbcTemplate.update("update book set name=?,author_name=?,year=? where id=?",
                updatedBook.getName(),updatedBook.getAuthor_name(),updatedBook.getYear(),id);
    }

    public void delete(int id){
        jdbcTemplate.update("delete from book where id=?",id);
    }
}
