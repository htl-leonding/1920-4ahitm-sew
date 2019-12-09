package at.htl.mock;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * https://www.vogella.com/tutorials/Mockito/article.html
 */
public class ClassroomTest {

    @Test
    void test001() {

        // arrange - given
        Classroom classroom = new Classroom();
        classroom.students = mock(List.class);

        // act - when
        classroom.addX("IrfanView");

        // assert - then
        verify(classroom.students, times(1))
                .add("IrfanView");
    }
}
