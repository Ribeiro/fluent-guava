package br.com.gigio.fluent_guava.guavatest;

import com.google.common.collect.FluentIterable;
import org.junit.Test;
import java.util.List;
import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Lists.transform;
import static br.com.gigio.fluent_guava.functions.Functions.byHalf;
import static br.com.gigio.fluent_guava.predicates.Predicates.bigValues;
import static br.com.gigio.fluent_guava.predicates.Predicates.byEvenNumbers;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
/***
 * 
 * @author gribeiro
 *
 */
public class GuavaTest {
	
    @Test
    public void fluentListIsJustAJavaListInDisguise() {
        List<Integer> javaList = asList(1, 2, 3, 4, 5);
        FluentIterable<Integer> richList = from(javaList);
        assertThat(richList, contains(1, 2, 3, 4, 5));
    }

    @Test
    public void guavaTransformsStillWorkBothWays() {
        List<Integer> numberList = asList(1, 2, 3, 4, 5);
        List<Integer> oldStyle = transform(numberList, byHalf());
        List<Integer> fluentStyle = from(numberList).transform(byHalf()).toList();
        assertThat(fluentStyle, equalTo(oldStyle));
    }

    @Test
    public void moreOptionsToConsider() {
        FluentIterable<Integer> numbers = from(asList(1, 2, 3, 4, 5, 6));
        assertThat(numbers.filter(byEvenNumbers()), contains(2, 4, 6));
        assertThat(numbers.filter(bigValues()), contains(6));
        assertThat(numbers.limit(3), contains(1, 2, 3));
        assertThat(numbers.anyMatch(bigValues()), is(true));
    }

}