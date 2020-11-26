import cs101.sosgame.SOS;
import java.util.Scanner;
import javax.swing.*;

public class main {
    public static void main(String[] args){



        JFrame frame = new JFrame();
        frame.setVisible(true);
        int n = Integer.parseInt(JOptionPane.showInputDialog(frame, " n x n grid, enter n"));
        SOS sos = new SOS(n);
        String player1 = (String) JOptionPane.showInputDialog(frame, "Enter the name of player1");
        String player2 = (String) JOptionPane.showInputDialog(frame, "Enter the name of player2");
        SOSGUIPanel sosguiPanel = new SOSGUIPanel(sos,player1,player2);

        frame.add(sosguiPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.pack();

    }
}
