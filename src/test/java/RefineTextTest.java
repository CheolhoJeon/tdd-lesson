import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefineTextTest {

    private RefineText refineTextInstance = new RefineText();

    // 각 입력에 대한 테스트 결과를 출력해줌
    // 단, JUnit에서 여러 공백 문자가 있을 시에 공백 처리를 해줘서 테스트 결과에는 다르게 표기되지 않는 문제가 있음
    @ParameterizedTest
    @ValueSource(strings = {
        "hello  world",
        "hello   world",
        "hello    world",
        "hello     world",
        "hello      world",
        "hello       world"
    })
    void testWithParameterizedTest(String source) {
        String actual = refineTextInstance.refineText(source);
        assertEquals("hello world", actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "hello\t world",
        "hello \tworld",
    })
    void testAboutTabCharacter(String source) {
        String actual = refineTextInstance.refineText(source);
        assertEquals("hello world", actual);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void testAboutBannedWords(String source, List<String> bannedWords, String expected) {
        String actual = refineTextInstance.refineText(source);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
            Arguments.of("hello mockist", List.of("mockist", "purist"), "hello *******"),
            Arguments.of("hello purist", List.of("mockist", "purist"), "hello ******")
        );
    }

}
