package Classes;
import javax.swing.*;
public class Main {
    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Gui.createGUI();
            }
        });
        System.out.println(Excelparser.parse("constdatas.xlsx"));
        System.out.println(Excelparser.names);

    }
}
