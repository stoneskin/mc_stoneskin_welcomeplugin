package mc.stoneskin.welcomeplugin;

import static org.junit.Assert.assertTrue;

import java.io.Console;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        String test="test1 \n test2";
        System.out.print("test string = "+test);
        String[] s=test.split("\n",10);

        for (String m : s){
            System.out.print("\n");
            System.out.print("m="+m);
        }
        

        assertTrue( true );
    }
}
