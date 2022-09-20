package pl.programistazacny.javadeveloperlivecoding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringTest {

    @Test
    void shouldProperlyCompare() {
        // given
        String s1 = "aaa";
        String s2 = "bbb";
        String s3 = "aaa";
        String s4 = new String("aaa");

        // then
        assertThat(s2).isNotSameAs(s3);
        assertThat(s1)
                .isSameAs(s3)
                .isNotSameAs(s4)
                .isEqualTo(s3)
                .isEqualTo(s4);
    }
}
