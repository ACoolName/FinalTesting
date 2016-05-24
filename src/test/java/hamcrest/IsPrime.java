package hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class IsPrime extends TypeSafeDiagnosingMatcher<Integer> {

    @Override
    protected boolean matchesSafely(Integer integer, Description description) {

        description.appendText("was ").appendValue(integer).appendText(" which is divisible by ");
        if (integer % 2 == 0) {
            description.appendValue(2);
            return false;
        }
        for (int i = 3; i * i <= integer; i += 2) {
            if (integer % i == 0) {
                description.appendValue(i);
                return false;
            }
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("A prime number");
    }

    public static IsPrime isPrime() {
        return new IsPrime();
    }
}
