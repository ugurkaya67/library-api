package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() throws Exception {
        // Prépare des livres factices
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("1984");
        book1.setAuthor("George Orwell");
        book1.setIsbn("9780451524935");

        Book book2 = new Book();
        book2.setId(2L);
        book2.setTitle("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");
        book2.setIsbn("9780061120084");

        // Mock du repository
        Mockito.when(bookRepository.findAll()).thenReturn(Arrays.asList(book1, book2));

        // Teste le endpoint GET /api/books
        mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].title").value("1984"))
                .andExpect(jsonPath("$[1].title").value("To Kill a Mockingbird"));
    }

    @Test
    public void testCreateBook() throws Exception {
        // Prépare un livre factice
        Book book = new Book();
        book.setId(1L);
        book.setTitle("1984");
        book.setAuthor("George Orwell");
        book.setIsbn("9780451524935");

        // Mock du repository
        Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(book);

        // Teste le endpoint POST /api/books
        mockMvc.perform(post("/api/books")
                        .contentType(APPLICATION_JSON)
                        .content("{\"title\": \"1984\", \"author\": \"George Orwell\", \"isbn\": \"9780451524935\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("1984"))
                .andExpect(jsonPath("$.author").value("George Orwell"))
                .andExpect(jsonPath("$.isbn").value("9780451524935"));
    }
}
