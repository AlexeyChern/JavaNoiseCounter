package Classes;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Gui {
    public static Integer ChosedIndex = 0;
    public static void createGUI() {


        final JFrame frame = new JFrame("Enter fields");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel desclabel = new JLabel("Введите значения:");
        JLabel desclabel1 = new JLabel("S кап:");
        JLabel label = new JLabel("Test label");
        frame.getContentPane().add(label);



        JTextField text = new JTextField("      ");
        JTextField text1 = new JTextField("      ");
        JTextField text2 = new JTextField("      ");
        JTextField text3 = new JTextField("      ");
        JTextField text4 = new JTextField("      ");
        JTextField textldvs63 = new JTextField("      ");
        JTextField textldvs125 = new JTextField("      ");
        JTextField textldvs250 = new JTextField("      ");
        JTextField textldvs500 = new JTextField("      ");
        JTextField textldvs1000 = new JTextField("      ");
        JTextField textldvs2000 = new JTextField("      ");
        JTextField textldvs4000 = new JTextField("      ");
        JTextField textldvs8000 = new JTextField("      ");
        JTextField textlvip63 = new JTextField("      ");
        JTextField textlvip125 = new JTextField("      ");
        JTextField textlvip250 = new JTextField("      ");
        JTextField textlvip500 = new JTextField("      ");
        JTextField textlvip1000 = new JTextField("      ");
        JTextField textlvip2000 = new JTextField("      ");
        JTextField textlvip4000 = new JTextField("      ");
        JTextField textlvip8000 = new JTextField("      ");
        text.setSize(100,70);

        JComboBox combo = new JComboBox(Excelparser.names.toArray());
        combo.setSelectedIndex(0);
        combo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String matName = (String) cb.getSelectedItem();
                System.out.println(matName);
                ChosedIndex = java.util.Arrays.asList(Excelparser.names.toArray()).indexOf(matName);

            }
        });

        JButton button = new JButton("Count It");
        button.setSize(500,100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Double> dataforfunc = new ArrayList<>();
                List<Double> masldvs = new ArrayList<>();
                List<Double> maslvip = new ArrayList<>();
                JDialog dialog = new JDialog(frame, "Results");
                dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                dialog.setSize(1800, 280);

                dataforfunc.add(Double.parseDouble(text.getText().replaceAll(" ","")));
                dataforfunc.add(Double.parseDouble(text1.getText().replaceAll(" ","")));
                dataforfunc.add(Double.parseDouble(text2.getText().replaceAll(" ","")));
                dataforfunc.add(Double.parseDouble(text3.getText().replaceAll(" ","")));
                dataforfunc.add(Double.parseDouble(text4.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs63.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs125.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs250.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs500.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs1000.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs2000.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs4000.getText().replaceAll(" ","")));
                masldvs.add(Double.parseDouble(textldvs8000.getText().replaceAll(" ","")));

                maslvip.add(Double.parseDouble(textlvip63.getText().replaceAll(" ","")));
                maslvip.add(Double.parseDouble(textlvip125.getText().replaceAll(" ","")));
                maslvip.add(Double.parseDouble(textlvip250.getText().replaceAll(" ","")));
                maslvip.add(Double.parseDouble(textlvip500.getText().replaceAll(" ","")));
                maslvip.add(Double.parseDouble(textlvip1000.getText().replaceAll(" ","")));
                maslvip.add(Double.parseDouble(textlvip2000.getText().replaceAll(" ","")));
                maslvip.add(Double.parseDouble(textlvip4000.getText().replaceAll(" ","")));
                maslvip.add(Double.parseDouble(textlvip8000.getText().replaceAll(" ","")));

                List<List> math = Funcs.CounterAll(dataforfunc, masldvs, maslvip);
//                JLabel labelVkap1 = new JLabel(String.valueOf(math.get(0)));
//                JLabel labelCw1 = new JLabel(String.valueOf(math.get(1)));
//                JLabel b1 = new JLabel(String.valueOf(math.get(2)));
//                JLabel akab1 = new JLabel(String.valueOf(math.get(3)));
//                JLabel b1 = new JLabel(String.valueOf(math.get(2)));
                JLabel labelRES = new JLabel(String.valueOf(math.get(math.size()-1).get(0)));
                JPanel panel = new JPanel();
//                panel.add(labelVkap1);
//                panel.add(labelCw1);
                panel.add(labelRES);
                dialog.add(panel);
                dialog.setVisible(true);
            }
        });
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        button.setSize(100,50);
        GridLayout layout = new GridLayout(0, 2, 1, 1);
        GridLayout layout1 = new GridLayout(6, 0, 1, 1);
        GridLayout layout2 = new GridLayout(1, 0, 1, 1);
        GridLayout layout3 = new GridLayout(1, 0, 5, 1);
        GridLayout layout4 = new GridLayout(1, 0, 5, 1);
        panel.setLayout(layout);
        panel2.setLayout(layout2);
        panel3.setLayout(layout3);
        panel4.setLayout(layout4);
        panel.add(desclabel1);
        panel.add(text);
        panel.add(new JLabel("S пер"));
        panel.add(text1);
        panel.add(new JLabel("S каб"));
        panel.add(text2);
        panel.add(new JLabel("S каб i"));
        panel.add(text3);
        panel.add(new JLabel("R вып"));
        panel.add(text4);

        ///////
        panel2.add(new JLabel("Частота"));
        panel2.add(new JLabel("  63"));
        panel2.add(new JLabel("  125"));
        panel2.add(new JLabel("  250"));
        panel2.add(new JLabel("  500"));
        panel2.add(new JLabel("  1000"));
        panel2.add(new JLabel("  2000"));
        panel2.add(new JLabel("  4000"));
        panel2.add(new JLabel("  8000"));
        panel3.add(new JLabel("Lw ДВС"));
        panel3.add(textldvs63);
        panel3.add(textldvs125);
        panel3.add(textldvs250);
        panel3.add(textldvs500);
        panel3.add(textldvs1000);
        panel3.add(textldvs2000);
        panel3.add(textldvs4000);
        panel3.add(textldvs8000);
        panel4.add(new JLabel("Lw Вып"));
        panel4.add(textlvip63);
        panel4.add(textlvip125);
        panel4.add(textlvip250);
        panel4.add(textlvip500);
        panel4.add(textlvip1000);
        panel4.add(textlvip2000);
        panel4.add(textlvip4000);
        panel4.add(textlvip8000);



        panel.add(text4);

        JPanel panel1 = new JPanel();
        panel1.setLayout(layout1);

        panel1.add(panel);
        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        panel1.add(combo);
        panel1.add(button);
        frame.getContentPane().add(panel1);
        //frame.setPreferredSize(new Dimension(500, 400));
        frame.setSize(800,600);
        frame.pack();
        frame.setVisible(true);
    }
}
