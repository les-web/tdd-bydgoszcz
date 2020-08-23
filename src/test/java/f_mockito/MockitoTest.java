package f_mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;

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
        Mockito.when(mockedList.size())
                .thenReturn(100)
                .thenReturn(200)
                .thenReturn(300);

        System.out.println(mockedList.size());
        System.out.println(mockedList.size());
        System.out.println(mockedList.size());
    }

    @Test

    public void test3() {
        List mockedList = Mockito.mock(List.class);
        Mockito.when(mockedList.get(0))
                .thenReturn("first");
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(200));
    }

    @Test

    public void test4() {
        List mockedList = Mockito.mock(List.class);
        Mockito.when(mockedList.get(anyInt()))
                .thenReturn("first");
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(200));
    }

    @Test
    public void test5() {
        List mockedList = Mockito.mock(List.class);
        Mockito.when(mockedList.get(666))
                .thenThrow(new RuntimeException("el diablo"));

        try {
            mockedList.get(666);
            fail("expected exception to be thrown");
        } catch (Exception e) {
            //       System.out.println(e);
            org.assertj.core.api.Assertions.assertThat(e.getMessage())
                    .isEqualTo("el diablo");

        }
    }

}
