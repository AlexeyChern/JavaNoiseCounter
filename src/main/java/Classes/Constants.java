package Classes;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static List<List<Double>> GetConsts(){
        List<Double> gc = new ArrayList<>();
        List<Double> cabgc = new ArrayList<>();
        List<Double> kgc = new ArrayList<>();
        List<List<Double>> res = new ArrayList<>();
        gc.add(0.19);
        gc.add(0.22);
        gc.add(0.25);
        gc.add(0.27);
        gc.add(0.3);
        gc.add(0.31);
        gc.add(0.33);
        gc.add(0.35);
        res.add(gc);

        cabgc.add(0.3);
        cabgc.add(0.5);
        cabgc.add(0.3);
        cabgc.add(0.3);
        cabgc.add(0.3);
        cabgc.add(0.3);
        cabgc.add(0.3);
        cabgc.add(0.6);
        res.add(cabgc);
        kgc.add(-26.0);
        kgc.add(-16.1);
        kgc.add(-8.6);
        kgc.add(-3.2);
        kgc.add(0.0);
        kgc.add(1.2);
        kgc.add(1.0);
        kgc.add(1.1);
        res.add((kgc));
        return res;

    }


    public static Double gvip = 0.25;
}
