package DGP.CJLU.Utils;

import java.util.concurrent.ThreadLocalRandom;

public class Rand {

    public static int randInt(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
