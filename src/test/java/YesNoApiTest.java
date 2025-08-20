import io.github.kiber2009.yesnoapi.Answer;
import io.github.kiber2009.yesnoapi.YesNo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.io.IOException;

final class YesNoApiTest {
    @Test
    void test() throws IOException, InterruptedException {
        final YesNo yesNo = YesNo.get();

        Assertions.assertFalse(yesNo.forced());
    }

    @ParameterizedTest
    @EnumSource(Answer.class)
    void testForce(final Answer answer) throws IOException, InterruptedException {
        final YesNo yesNo = YesNo.get(answer);

        Assertions.assertTrue(yesNo.forced());
        Assertions.assertEquals(answer, yesNo.answer());
    }
}
