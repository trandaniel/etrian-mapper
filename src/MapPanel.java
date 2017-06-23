import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Danyo on 2017-06-22.
 */
public class MapPanel extends JPanel implements MouseListener, MouseMotionListener {

    private int X_ORIGIN = 50;
    private int Y_ORIGIN = 50;

    private Map map ;

    public MapPanel() {
        map = new Map() ;

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g ;

        drawCells(g2) ;

        drawBorders(g2) ;

        drawSections(g2) ;

        drawWalls(g2) ;

    }

    public void drawCells(Graphics2D g2) {
        Cell cell ;

        for(int i = 0 ; i < map.DEFAULT_SIZE ; i++) {
            for(int j = 0 ; j < map.DEFAULT_SIZE ; j++) {
                cell = map.map[i][j] ;

                g2.setColor(cell.getCellColor()) ;
                g2.fillRect(X_ORIGIN + (i * cell.getWidth()), Y_ORIGIN + (j * cell.getHeight()), cell.getWidth(), cell.getHeight()) ;
            }
        }
    }

    public void drawWalls(Graphics2D g2) {

        Cell cell ;

        for(int i = 0 ; i < map.DEFAULT_SIZE ; i++) {
            for(int j = 0 ; j < map.DEFAULT_SIZE ; j++) {
                cell = map.map[i][j] ;
                if(cell.isWallTop()) {
                    drawTopBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(cell.isWallRight()) {
                    drawRightBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(cell.isWallBottom()) {
                    drawBottomBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(cell.isWallLeft()) {
                    drawLeftBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }
            }
        }
    }

    public void drawSections(Graphics2D g2) {
        Cell cell ;

        for(int i = 0 ; i < map.DEFAULT_SIZE ; i++) {
            for(int j = 0 ; j < map.DEFAULT_SIZE ; j++) {
                cell = map.map[i][j] ;
                if(!cell.isWallTop() && cell.isSectionTop()) {
                    drawTopBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(!cell.isWallRight() && cell.isSectionRight()) {
                    drawRightBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(!cell.isWallBottom() && cell.isSectionBottom()) {
                    drawBottomBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(!cell.isWallLeft() && cell.isSectionLeft()) {
                    drawLeftBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }
            }
        }
    }

    public void drawBorders(Graphics2D g2) {
        Cell cell ;

        for(int i = 0 ; i < map.DEFAULT_SIZE ; i++) {
            for(int j = 0 ; j < map.DEFAULT_SIZE ; j++) {
                cell = map.map[i][j] ;

                if(!cell.isWallTop() && !cell.isSectionTop()) {
                    drawTopBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(!cell.isWallRight() && !cell.isSectionRight()) {
                    drawRightBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(!cell.isWallBottom() && !cell.isSectionBottom()) {
                    drawBottomBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }

                if(!cell.isWallLeft() && !cell.isSectionLeft()) {
                    drawLeftBorder(g2, cell, X_ORIGIN, Y_ORIGIN) ;
                }
            }
        }
    }

    // draw borders from cell border colors
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

    public Map getMap() {
        return map ;
    }


}
