package zheteng;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author yancy
 */

public class CompactNumberFormatsTest {

    public static void main(String[] args) {
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        String result1 = fmt.format(3000);
        System.out.println(result1);

        String result2 = fmt.format(1000000);
        System.out.println(result2);
    }
}
