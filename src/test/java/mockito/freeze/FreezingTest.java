package mockito.freeze;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(
    classes = {
        FreezingTest.MockBeans.class},
    webEnvironment = NONE)
@RunWith(SpringRunner.class)
public class FreezingTest {

    @MockBean
    private FreezingTest freezingTest;

    @Test
    public void testFreeze() {
        // Success
        assertThat(freezingTest).isNotNull();
    }

    @Configuration
    public static class MockBeans {

        public static FreezingTest freezingTestMock = mock(FreezingTest.class);

        @Bean
        public FreezingTest freezingTestMockBean() {
            return freezingTestMock;
        }
    }

}
