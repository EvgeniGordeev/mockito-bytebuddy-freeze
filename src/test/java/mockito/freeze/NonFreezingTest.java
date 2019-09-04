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

/**
 * AClass.
 *
 * @author evgeni.gordeev
 * @version 10
 * @since 2019-08-09
 */
@SpringBootTest(
    classes = {
        NonFreezingTest.MockBeans.class},
    webEnvironment = NONE)
@RunWith(SpringRunner.class)
public class NonFreezingTest {

    @MockBean
    private NonFreezingTest freezingTest;

    @Test
    public void testFreeze() {
        // Success
        assertThat(freezingTest).isNotNull();
    }

    @Configuration
    static class MockBeans {

        @Bean
        public NonFreezingTest nonFreezingTestMockBean() {
            return mock(NonFreezingTest.class);
        }
    }

}
