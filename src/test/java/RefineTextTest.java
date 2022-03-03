import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RefineTextTest {

    private RefineText refineTextInstance = new RefineText();

//    @Test
//    @DisplayName("sut transforms \"hello  world\" to \"hello world\"")
//    void test1() {
//        String actual = refineTextInstance.refineText("hello  world");
//        assertEquals("hello world", actual);
//    }
//
//    @Test
//    @DisplayName("sut transforms \"hello    world\" to \"hello world\"")
//    void test2() {
//        String actual = refineTextInstance.refineText("hello    world");
//        assertEquals("hello world", actual);
//    }
//
//    @Test
//    @DisplayName("sut transforms \"hello   world\" to \"hello world\"")
//    void test3() {
//        String actual = refineTextInstance.refineText("hello   world");
//        assertEquals("hello world", actual);
//    }
//
//    @Test // 여러 입력 중, 어떤 입력에 대해 테스트가 실패했는지 알 수 없음
//    @DisplayName("sut correctly works")
//    void testWithLooping() {
//        List<String> sources = List.of("hello  world", "hello    world", "hello   world");
//        for (String source : sources) {
//            String actual = refineTextInstance.refineText(source);
//            assertEquals("hello world", actual);
//        }
//    }

    // 각 입력에 대한 테스트 결과를 출력해줌
    // 단, JUnit에서 여러 공백 문자가 있을 시에 공백 처리를 해줘서 테스트 결과에는 다르게 표기되지 않는 문제가 있음
    @ParameterizedTest
    @ValueSource(strings = { "hello  world", "hello    world", "hello   world" })
    void testWithParameterizedTest(String source) {
        String actual = refineTextInstance.refineText(source);
        assertEquals("hello world", actual);
    }

}
