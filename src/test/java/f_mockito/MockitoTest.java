package f_mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockitoTest {
    @Test

    public void test() {
        List mockedList = Mockito.mock(List.class);
        mockedList.add("one");

        Mockito.verify(mockedList).add("one");
    }

    @Test

    public void test2() {
        List mockedList = Mockito.mock(List.class);
        Mockito.when(mockedList.size()).thenReturn(100);

        System.out.println(mockedList.size());
        System.out.println(mockedList.size());

    }

}
