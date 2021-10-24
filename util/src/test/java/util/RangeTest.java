package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static util.Range.range;

public class RangeTest {

    @Test
    void rangeIteratorNaiveTest() {
        var r = range(1, 2);
        var iterator = r.iterator();

        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(1);
        assertThat(iterator.hasNext()).isTrue();
        assertThat(iterator.next()).isEqualTo(2);
        assertThat(iterator.hasNext()).isFalse();

    }

    @Test
    void rangeForEachTest() {
        List<Integer> actual = new ArrayList<>();
        for (Integer current : range(1, 4)) {
            actual.add(current);
        }

        assertThat(actual)
                .containsExactly(1, 2, 3, 4);
    }

    @Test
    void rangeWithNegativeTest() {
        List<Integer> actual = new ArrayList<>();
        for (Integer current : range(-1, 4)) {
            actual.add(current);
        }

        assertThat(actual)
                .containsExactly(-1, 0, 1, 2, 3, 4);
    }

}
