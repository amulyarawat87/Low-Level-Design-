package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakesLadders {
    private final Map<Byte, Byte> snakes;
    private final Map<Byte, Byte> ladders;

    SnakesLadders(){
        snakes = new HashMap<Byte, Byte>();
        ladders = new HashMap<Byte, Byte>();

        snakes.put((byte)99, (byte)10);
        snakes.put((byte)96, (byte)76);
        snakes.put((byte)93, (byte)75);
        snakes.put((byte)73, (byte)63);
        snakes.put((byte)53, (byte)35);
        snakes.put((byte)33, (byte)12);
        snakes.put((byte)23, (byte)3);


        ladders.put((byte)56, (byte)86);
        ladders.put((byte)55, (byte)78);
        ladders.put((byte)41, (byte)98);
        ladders.put((byte)36, (byte)61);
        ladders.put((byte)21, (byte)97);
        ladders.put((byte)9, (byte)54);
        ladders.put((byte)7, (byte)27);

    }

    Map<Byte, Byte> getSnakes() {
        return snakes;
    }

    Map<Byte, Byte> getLadders() {
        return ladders;
    }
}
