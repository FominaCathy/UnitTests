package FominaKat.fourth.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    static BookRepository repositoryMock;
    static BookService bookService;

    @BeforeAll
    static void setUp() {
        repositoryMock = mock(BookRepository.class);
        Book bookFirst = new Book("01", "title First", "author First");
        Book bookSecond = new Book("02", "title Second", "author Second");

        List<Book> bookList = new ArrayList<>();
        bookList.add(bookFirst);
        bookList.add(bookSecond);

        when(repositoryMock.findById("01")).thenReturn(bookFirst);
        when(repositoryMock.findById("02")).thenReturn(bookSecond);
        when(repositoryMock.findAll()).thenReturn(bookList);
        bookService = new BookService(repositoryMock);
    }

    @ParameterizedTest(name = "{index} получение книги по ID {0}: {1} - {2}")
    @CsvSource(value = {"01, title First, author First", "02, title Second, author Second"})
    @DisplayName("Проверка получения книги по ID")
    void testFindBookById(String id, String title, String author) {
        Book book = bookService.findBookById(id);
        assertEquals(author, book.getAuthor());
        assertEquals(title, book.getTitle());
        assertEquals(id, book.getId());
    }


    @Test
    @DisplayName("Проверка получения списка всех книг")
    void testFindAllBooks() {
        BookService bookService = new BookService(repositoryMock);
        List<Book> allBooks = bookService.findAllBooks();
        List<String> listAuthors = new ArrayList<>(List.of(new String[]{"author First", "author Second"}));
        List<String> listTitle = new ArrayList<>(List.of(new String[]{"title First", "title Second"}));

        assertEquals(2, allBooks.size());
        assertTrue(allBooks.stream().allMatch(e -> listAuthors.contains(e.getAuthor())));
        assertTrue(allBooks.stream().allMatch(e -> listTitle.contains(e.getTitle())));
    }

}
