package DGP.CJLU.Utils.Implementation;

import java.util.concurrent.ThreadLocalRandom;

/**
 * custom implementation of randInt method
 */
public class Rand {
    public static int randInt(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
