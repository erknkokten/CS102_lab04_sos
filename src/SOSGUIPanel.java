import javax.swing.*;
import cs101.sosgame.SOS;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SOSGUIPanel extends JPanel implements MouseListener {
    SOSCanvas sosCanvas;
    JLabel name1, name2;
    JComboBox comboBox;
    SOS sos;
    String player1, player2;
    JPanel inner;

    public SOSGUIPanel(SOS sos, String name1, String name2){
        setLayout( new GridLayout());

        inner = new JPanel();
        inner.setLayout(new BorderLayout(1,2));
        inner.setBackground(Color.CYAN);
        player1 = name1;
        player2 = name2;
        this.sos = sos;
        this.name1 = new JLabel(name1);
        this.name2 = new JLabel(name2);
        comboBox = new JComboBox();

        sosCanvas = new SOSCanvas(this.sos);
        add(sosCanvas);

        comboBox.addItem('s');
        comboBox.addItem('o');
        inner.add(comboBox, BorderLayout.SOUTH);
        inner.add(this.name1, BorderLayout.NORTH);
        inner.add(this.name2, BorderLayout.CENTER);
        add(inner);
        addMouseListener(this);
        setBackground(Color.WHITE);

        this.name1.setForeground(Color.red);
        this.name2.setForeground(Color.black);
    }

    public void mouseClicked(MouseEvent event){

        char letter = (char) comboBox.getSelectedItem();
        System.out.println(letter);
        int y = event.getX() -5;
        int x = event.getY() -5;
        System.out.println(x );
        System.out.println(y );

        int x_index = (int) (x/30) + 1;
        int y_index = (int) (y/30) + 1;
        System.out.println(x_index );
        System.out.println(y_index );





        if( !sos.isGameOver()){
          if(sos.getCellContents(x_index - 1 , y_index - 1) == '.'){
                sos.play(letter , x_index, y_index);

              name1.setText(player1 + ": " + sos.getPlayerScore1());
              name2.setText(player2 + ": " + sos.getPlayerScore2());
              sos.printBoard();
              sosCanvas.repaint();
              if(sos.getTurn() == 1) {
                  name1.setForeground(Color.red);
                  name2.setForeground(Color.black);
              }
              else{
                  name1.setForeground(Color.black);
                  name2.setForeground(Color.red);
              }

            }
          if(sos.isGameOver()){
              if(sos.getPlayerScore1() == sos.getPlayerScore2()){
                  JOptionPane.showMessageDialog(this, "its a tie");
              }
              else if(sos.getPlayerScore1() > sos.getPlayerScore2()){
                  JOptionPane.showMessageDialog(this, player1 + " wins");
              }
              else if(sos.getPlayerScore1() < sos.getPlayerScore2()){
                  JOptionPane.showMessageDialog(this, player2 + " wins");
              }
          }
        }







    }
    public void mouseReleased(MouseEvent event){}
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}
    public void mousePressed(MouseEvent event){}
}
