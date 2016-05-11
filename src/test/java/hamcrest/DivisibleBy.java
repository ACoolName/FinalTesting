package hamcrest;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class DivisibleBy extends TypeSafeDiagnosingMatcher<Integer> {
  
   private final Integer divisor;

   public DivisibleBy(Integer divisor) {
       this.divisor = divisor;
   }

   @Override
   protected boolean matchesSafely(Integer integer, Description description) {
       int remainder = integer % divisor;

       description.appendText("was ").appendValue(integer)
               .appendText(" which left a remainder of ").appendValue(remainder);
       return remainder == 0;
   }

   @Override
   public void describeTo(Description description) {
       description.appendText("A number divisible by ").appendValue(divisor);
   }

   public static DivisibleBy divisibleBy(Integer divisor) {
       return new DivisibleBy(divisor);
   }
}