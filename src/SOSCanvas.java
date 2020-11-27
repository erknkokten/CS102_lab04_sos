import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cs101.sosgame.SOS;
public class SOSCanvas extends JPanel {

    SOS sos;
    //Constructor
    public SOSCanvas(SOS sos){
        this.sos = sos;
        setPreferredSize(new Dimension(sos.getDimension()*30,sos.getDimension()*30 ));
        //setLayout(new GridLayout(1,2));


    }

    /**
     * Paints grids for SOS game and also puts letters S and O in grids.
     */
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




}
