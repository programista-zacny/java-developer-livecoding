package pl.programistazacny.javadeveloperlivecoding;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerTest {

    /**
     * return collection, unique, sorted
     */

    @Test
    void shouldProcessToList() {
        // given
        Integer[] ints = new Integer[]{15, 1, 11, 3, null, 2, -1, 2};
        List<Integer> expected = List.of(1, 2, 3, 11, 15);

        // when
        List<Integer> result = toList(ints);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void shouldProcessToSet() {
        // given
        Integer[] ints = new Integer[]{15, 1, 11, 3, null, 2, -1, 2};
        Set<Integer> expected = Set.of(1, 2, 3, 11, 15);

        // when
        Set<Integer> result = toSet(ints);

        // then
        assertThat(result).isEqualTo(expected);
    }

    private List<Integer> toList(Integer[] ints) {
        return Arrays.stream(ints)
                .filter(i -> i != null && i > 0)
                .distinct()
                .sorted()
                .toList();
    }

    private Set<Integer> toSet(Integer[] ints) {
        return Arrays.stream(ints)
                .filter(i -> i != null && i > 0)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
