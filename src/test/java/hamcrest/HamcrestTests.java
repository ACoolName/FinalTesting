/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hamcrest;

import static hamcrest.DivisibleBy.divisibleBy;
import static hamcrest.IsEven.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teo
 */
public class HamcrestTests {

    @Test
    public void isEvenPassTest() throws Exception {
        Integer test = 4;
        assertThat(test, isEven());
    }
    
    @Test
    public void isEvenFailTest() throws Exception {
        Integer divisor = 5;
        assertThat(divisor, not(isEven()));
    }
    
    @Test
   public void divisibleByPassTest() throws Exception {
       Integer divisor = 15;
       assertThat(divisor, is(divisibleBy(5)));
   }

   @Test
   public void divisibleByFailTest() throws Exception {
       Integer divisor = 17;
       assertThat(divisor, is(not(divisibleBy(3))));
   }
}
