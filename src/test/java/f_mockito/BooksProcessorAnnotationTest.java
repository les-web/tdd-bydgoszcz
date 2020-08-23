package f_mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BooksProcessorAnnotationTest {

    @Mock
    Database mockedDatabase;
    
    @Test
    public void getTotalPrice_whenExceptionThrownInFirstAndSecondAttempt_shouldCallMethodThirdTime() {


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
