package ru.rol.springproject1.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rol.springproject1.models.Book;
import ru.rol.springproject1.models.Person;


import java.util.List;
import java.util.Optional;


@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Book> index(){

        //return jdbcTemplate.query("SELECT * FROM person", new PersonMapper() );
        return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class) );
    }

    public Book show(int book_id){

        return jdbcTemplate.query("SELECT * FROM book WHERE book_id=?",
                new BeanPropertyRowMapper<>(Book.class), book_id).stream().findAny().orElse(null);
    }

    public Optional<Person> getBookOwner(int id) {

        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.person_id " +
                "WHERE Book.book_id = ?",new BeanPropertyRowMapper<>(Person.class), id).stream().findAny();
    }


    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO book(book_name, author, year) VALUES (?,?,?)",
                book.getBook_name(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book book) {
        jdbcTemplate.update("UPDATE book SET book_name=?, author=?, year=? where book_id=?",
                book.getBook_name(), book.getAuthor(), book.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM book where book_id =?", id);

    }

    public void release(int book_id) {
        jdbcTemplate.update("UPDATE Book SET person_id=NULL WHERE book_id=?", book_id);
    }

    public void assign(int book_id, Person person) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE book_id=?", person.getPerson_id(), book_id);
    }

}
