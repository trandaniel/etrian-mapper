import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Danyo on 2017-06-22.
 */
public class MapPanel extends JPanel implements MouseListener, MouseMotionListener {

    int X_ORIGIN = 40;
    int Y_ORIGIN = 40;

    Map map ;
    public MapPanel() {
        map = new Map() ;

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g ;
        Cell cell ;
        for(int i = 0 ; i < map.DEFAULT_SIZE ; i++) {
            for(int j = 0 ; j < map.DEFAULT_SIZE ; j++) {
                cell = map.map[i][j] ;
                g2.setColor(cell.getCellColor()) ;
                g2.fillRect(40 + (i * cell.getWidth()), 40 + (j * cell.getHeight()), cell.getWidth(), cell.getHeight()) ;

//                thickness = cell.getBorder() ;
//                g2.setStroke(new BasicStroke(thickness)) ;
//                g2.setColor(cell.BORDER_COLOR) ;
//                g2.drawRect(40 + (i * cell.getWidth()), 40 + (j * cell.getHeight()), cell.getWidth(), cell.getHeight()) ;
//                g2.setStroke(oldStroke) ;

                // REFACTOR ALL THIS TO METHOD
//                drawTopBorder(g2, cell.getBorder(), 40 + (i * cell.getWidth()), 40 + (j * cell.getHeight()),
//                        40 + ((i + 1) * cell.getWidth()), 40 + (j * cell.getHeight()), cell.getBorderColor()) ;
                drawTopBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                drawRightBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                drawBottomBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                drawLeftBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;

            }
        }
    }

    public void drawTopBorder(Graphics2D g2, Cell cell, int x, int y) {
        Stroke oldStroke = g2.getStroke();

        int x1 = x + (cell.getRow() * cell.getWidth());
        int y1 = y + (cell.getCol() * cell.getHeight());

        int x2 = x1 + cell.getWidth();
        int y2 = y1;

        g2.setStroke(new BasicStroke(cell.getBorder()));

        g2.setColor(cell.getBorderTopColor());
        g2.drawLine(x1, y1, x2, y2);

        g2.setStroke(oldStroke);
    }

    public void drawRightBorder(Graphics2D g2, Cell cell, int x, int y) {
        Stroke oldStroke = g2.getStroke() ;

        int x1 = x + ((cell.getRow() + 1) * cell.getWidth()) ;
        int y1 = y + (cell.getCol() * cell.getHeight()) ;

        int x2 = x1 ;
        int y2 = y1 + cell.getHeight() ;

        g2.setStroke(new BasicStroke(cell.getBorder())) ;

        g2.setColor(cell.getBorderRightColor()) ;
        g2.drawLine(x1, y1, x2, y2) ;

        g2.setStroke(oldStroke) ;
    }

    public void drawBottomBorder(Graphics2D g2, Cell cell, int x, int y) {
        Stroke oldStroke = g2.getStroke() ;

        int x1 = x + (cell.getRow() * cell.getWidth()) ;
        int y1 = y + ((cell.getCol() + 1) * cell.getHeight()) ;

        int x2 = x1 + cell.getWidth() ;
        int y2 = y1 ;

        g2.setStroke(new BasicStroke(cell.getBorder())) ;

        g2.setColor(cell.getBorderBottomColor()) ;
        g2.drawLine(x1, y1, x2, y2) ;

        g2.setStroke(oldStroke) ;
    }

    public void drawLeftBorder(Graphics2D g2, Cell cell, int x, int y) {
        Stroke oldStroke = g2.getStroke() ;

        int x1 = x + (cell.getRow() * cell.getWidth());
        int y1 = y + (cell.getCol() * cell.getHeight());

        int x2 = x1 ;
        int y2 = y1 + cell.getHeight() ;

        g2.setStroke(new BasicStroke(cell.getBorder())) ;

        g2.setColor(cell.getBorderLeftColor()) ;
        g2.drawLine(x1, y1, x2, y2) ;

        g2.setStroke(oldStroke) ;
    }

    public void mouseExited(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

    }


}
