package f_powermock;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.verifyNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserValidator.class)

public class PowerMockTest {
    @Test
    public void test() throws Exception {
        UserValidator userValidator = Mockito.mock(UserValidator.class);
        PowerMockito.whenNew(UserValidator.class).withNoArguments().thenReturn(userValidator);

        UserValidator userValidator1 = new UserValidator();
        Assertions.assertThat(userValidator1).isEqualTo(userValidator);
        verifyNew(UserValidator.class).withNoArguments();
    }

    @Test
    public void test2() {
        UserValidator userValidator = PowerMockito.mock(UserValidator.class);
        PowerMockito.when(userValidator.validateFinal()).thenReturn(false);
        boolean valid = userValidator.validateFinal();
        Assertions.assertThat(valid).isFalse();
    }
    @Test
    public void test3() {
        PowerMockito.mockStatic(UserValidator.class);
        PowerMockito.when(UserValidator.validateStatic()).thenReturn(false);
        boolean valid = UserValidator.validateStatic();
        Assertions.assertThat(valid).isFalse();
    }
}
