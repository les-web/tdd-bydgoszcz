package c_params;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MyProviderForAddTest implements ArgumentsProvider {


    @Override

    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(5, 7, 12),
                Arguments.of(6, 8, 14),
                Arguments.of(7, 1, 10)
        );
    }
}
