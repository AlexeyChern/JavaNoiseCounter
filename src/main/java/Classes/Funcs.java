package Classes;


import java.util.ArrayList;
import java.util.List;

public class Funcs {
    static final Integer IndexToCount = Gui.ChosedIndex;


    public static List<List> CounterAll(List<Double> k, List<Double> ldvs, List<Double> lvip) {
        Double b1 = 10 * Math.log10(k.get(1) / k.get(0));
        Double b3 = 0.0;

        System.out.println(k);
        List<List<Double>> constants = Constants.GetConsts();
        List<List<Double>> exelvalues = Excelparser.parse("constdatas.xlsx");

        List<List> resmas = new ArrayList<>();
        Double constantskap = k.get(0);
        ///Vkap1
        List<Double> Vkap = new ArrayList<>();


        for (int i = 0; i < constants.get(0).size(); i++) {
            Vkap.add(constants.get(0).get(i) * k.get(0) / (1 - constants.get(0).get(i)));
            System.out.println(Vkap);
            System.out.println(constants.get(0).get(i));
            System.out.println(k.get(0));
        }
        resmas.add(Vkap);
        ///

        ////Cw
        List<Double> Cw = new ArrayList<>();
        for (int i = 0; i < Vkap.size(); i++) {
            Cw.add(10 * Math.log10((1.5 / (1 * 3.14 * 1.1 * 1.1)) + (2 / Vkap.get(i))));
        }
        resmas.add(Cw);
        /////
        ////Akab1
        List<Double> Akab1 = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            Akab1.add(constants.get(1).get(i) * k.get(2));
        }
        resmas.add(Akab1);
        /////
        ////Aw3
        List<Double> Aw3 = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            Aw3.add(10 * Math.log10(k.get(1) / Akab1.get(i)));
        }
        resmas.add(Aw3);
        /////
        ////LkapDVS
        List<Double> LkabDVSper = new ArrayList<>();
        for (int i = 0; i < Aw3.size(); i++) {
            LkabDVSper.add(ldvs.get(i) + Cw.get(i) + b1 + Aw3.get(i) - exelvalues.get(IndexToCount).get(i));
        }
        resmas.add(LkabDVSper);
        /////
        ////Akab2
        List<Double> Akab2 = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            Akab2.add(constants.get(1).get(i) * k.get(3));
        }
        resmas.add(Akab2);

        List<Double> A1w = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            A1w.add(10 * Math.log10(k.get(3) / Akab2.get(i)));
        }
        resmas.add(A1w);

        List<Double> ikap32 = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            ikap32.add(10 * Math.log10(k.get(0) / (k.get(0) * Math.pow(10, (-0.1 * (exelvalues.get(IndexToCount).get(i) + 5))))));
        }
        resmas.add(ikap32);
        List<Double> ikab32 = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            ikab32.add(10 * Math.log10(k.get(3) / (k.get(3) * Math.pow(10, (-0.1 * (exelvalues.get(IndexToCount).get(i) + 5))))));
        }
        resmas.add(ikab32);

        List<Double> lkabDVSkap = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            lkabDVSkap.add(ldvs.get(i) + Cw.get(i) + b3 + A1w.get(i) - ikap32.get(i) - ikab32.get(i) + 6);
        }
        resmas.add(lkabDVSkap);

        double a1 = 20*Math.log10((k.get(4)/Constants.gvip));

        List<Double> lkabvip = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            lkabvip.add(lvip.get(i)-a1-ikab32.get(i)+Aw3.get(i)-2);
        }
        resmas.add(lkabvip);
        List<Double> lkab = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            lkab.add(10* Math.log10((Math.pow(10,0.1*LkabDVSper.get(i))+Math.pow(10,0.1*lkabDVSkap.get(i))+Math.pow(10,0.1*lkabvip.get(i)))));
        }
        resmas.add(lkab);

        List<Double> helpparam = new ArrayList<>();
        for (int i = 0; i < constants.get(1).size(); i++) {
            helpparam.add(Math.pow(10,(0.1*lkab.get(i)+constants.get(2).get(i))));
        }
        resmas.add(helpparam);
        double actresult = 0;
        double helper = 0;
        for (int i = 0; i < constants.get(1).size(); i++) {
            helper += helpparam.get(i);
        }
        actresult = 10*Math.log10(helper);
        List<Double> helpparam1 = new ArrayList<>();
        helpparam1.add(actresult);
        resmas.add(helpparam1);
        System.out.println(resmas);
        return resmas;
    }


}
