import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cs101.sosgame.SOS;
public class SOSCanvas extends JPanel {

    SOS sos;

    public SOSCanvas(SOS sos){
        this.sos = sos;
        setPreferredSize(new Dimension(sos.getDimension()*30,sos.getDimension()*30 ));
        //setLayout(new GridLayout(1,2));


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        int dim = sos.getDimension();

        for (int i = 0; i<dim; i++) {
            g.drawRect(0, 30*i, 30 * dim, 30);
            g.drawRect(30*i, 0, 30, 30*dim);
        }

        //drawing letters on boxes
        for( int i = 0; i< dim; i++){
            for( int j = 0; j< dim; j++) {
                if (sos.getCellContents(j, i)=='s'){
                    g.drawString("s", (15 + i*30), (15 + j*30));

                }
                else if (sos.getCellContents(j, i)=='o'){
                    g.drawString("o", (15 + i*30), (15 + j*30));

                }
            }

        }

    }
    //public class mouseListener implements MouseListener{

        /*public void mouseClicked(MouseEvent event){

            char letter = (char)comboBox.getSelectedItem();
            System.out.println(letter);
            int y = event.getX() -5;
            int x = event.getY() -5;
            System.out.println(x );
            System.out.println(y );

            int x_index = (int) (x/30) + 1;
            int y_index = (int) (y/30) + 1;
            System.out.println(x_index );
            System.out.println(y_index );


            sosCanvas.repaint();
            sos.printBoard();

            if( !sos.isGameOver()){
                if(sos.getCellContents(x_index - 1 , y_index - 1) == '.'){
                    sos.play(letter , x_index, y_index);

                    name1.setText(player1 + ": " + sos.getPlayerScore1());
                    name2.setText(player2 + ": " + sos.getPlayerScore2());
                }
            }
            else{
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
        public void mouseReleased(MouseEvent event){}
        public void mouseEntered(MouseEvent event){}
        public void mouseExited(MouseEvent event){}
        public void mousePressed(MouseEvent event){}*/

    //}



}
