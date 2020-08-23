package f_mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/*
# Zadanie

        1. Utwórz klasę z testami `BooksProcessorTest`.
        2. Przetestuj metody klasy `BooksProcessor`. Rozważ różne przypadki testowe.
        3. Przy tworzeniu obiektu typu `BooksProcessor` pamiętaj o wstrzyknięciu
        atrapy obiektu typu `Database`.
        4.  początku użyj standardowego sposobu tworzenia mocków.
         Kiedy skończysz zmień kod w taki sposób
        aby wykorzystywał adnotacje `@Mock` i `@InjectMocks`.
*/
public class BooksProcessorTest {

    @Test
    public void getTotalPrice_whenNoBooksInDatabase_shouldReturn0() {

        Database mockedDatabase = Mockito.mock(Database.class);
        BooksProcessor booksProcessor = new BooksProcessor(mockedDatabase);
        double totalPrice = booksProcessor.getTotalPrice();
        assertThat(totalPrice).isEqualTo(0D);
    }


    @Test
    public void getTotalPrice_whenOneBookInDatabase_shouldReturnItsPrice() {

        Database mockedDatabase = Mockito.mock(Database.class);
        Book book = new Book("To", 100.0);

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);
        Mockito.when(mockedDatabase.getBooks())
                .thenReturn(listOfBooks);
        BooksProcessor booksProcessor = new BooksProcessor(mockedDatabase);
        double totalPrice = booksProcessor.getTotalPrice();
        assertThat(totalPrice).isEqualTo(100D);
    }

    @Test
    public void getTotalPrice_when2booksInDatabase_shouldReturnTotalPrice() {

        Database mockedDatabase = Mockito.mock(Database.class);
        Book book = new Book("To", 100.0);
        Book book1 = new Book("Tamto", 300.0);

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book);
        listOfBooks.add(book1);

        Mockito.when(mockedDatabase.getBooks())
                .thenReturn(listOfBooks);
        BooksProcessor booksProcessor = new BooksProcessor(mockedDatabase);
        double totalPrice = booksProcessor.getTotalPrice();
        assertThat(totalPrice).isEqualTo(400D);
    }

    @Test
    public void getTotalPrice_whenGettingTotalPrice_shouldCallgetBooksMethod() {

        Database mockedDatabase = Mockito.mock(Database.class);

        BooksProcessor booksProcessor = new BooksProcessor(mockedDatabase);
        double totalPrice = booksProcessor.getTotalPrice();
        verify(mockedDatabase).getBooks();
        //    verifyNoInteractions(mockedDatabase);

    }

    @Test
    public void getTotalPrice_whenExceptionThrownInFirstAttempt_shouldCallMethodSecondTime() {

        Database mockedDatabase = Mockito.mock(Database.class);
        List<Book> list = new ArrayList<>();
        Mockito.when(mockedDatabase.getBooks())
                .thenThrow(new RuntimeException())
                .thenReturn(list);
        BooksProcessor booksProcessor = new BooksProcessor(mockedDatabase);
        double totalPrice = booksProcessor.getTotalPrice();
        verify(mockedDatabase, times(2)).getBooks();
    }

    @Test
    public void getTotalPrice_whenExceptionThrownInFirstAndSecondAttempt_shouldCallMethodThirdTime() {

        Database mockedDatabase = Mockito.mock(Database.class);
        List<Book> list = new ArrayList<>();
        Mockito.when(mockedDatabase.getBooks())
                .thenThrow(new RuntimeException())
                .thenThrow(new RuntimeException())
                .thenReturn(list);
        BooksProcessor booksProcessor = new BooksProcessor(mockedDatabase);
        double totalPrice = booksProcessor.getTotalPrice();
        verify(mockedDatabase, times(3)).getBooks();
    }
}
