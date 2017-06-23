import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Danyo on 2017-06-22.
 */
public class MapPanel extends JPanel implements MouseListener, MouseMotionListener {

    private final int X_ORIGIN = 50;
    private final int Y_ORIGIN = 50;
    private final int CELL_WIDTH = 20 ;
    private final int BORDER_WIDTH = 2 ;

    private final int PAINT_NULL = 0 ;
    private final int PAINT_CELL = 1 ;
    private final int PAINT_WALL = 2 ;

    private Map map ;
    private int paintMode ;
    int mapSize ;

    public MapPanel() {
        map = new Map() ;
        mapSize = map.getSize() ;
        addMouseListener(this);
        addMouseMotionListener(this);

        paintMode = PAINT_CELL ;

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

        for(int i = 0 ; i < map.getSize() ; i++) {
            for(int j = 0 ; j < map.getSize() ; j++) {
                cell = map.map[i][j] ;

//                System.out.print("1 ") ;

                g2.setColor(cell.getCellColor()) ;
                g2.fillRect(X_ORIGIN + (cell.getCol() * cell.getWidth()), Y_ORIGIN + (cell.getRow() * cell.getHeight()), cell.getWidth(), cell.getHeight()) ;
            }
//            System.out.println() ;
        }
    }

    public void drawWalls(Graphics2D g2) {

        Cell cell ;

        for(int i = 0 ; i < map.getSize() ; i++) {
            for(int j = 0 ; j < map.getSize() ; j++) {
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

        for(int i = 0 ; i < map.getSize() ; i++) {
            for(int j = 0 ; j < map.getSize() ; j++) {
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

        for(int i = 0 ; i < map.getSize() ; i++) {
            for(int j = 0 ; j < map.getSize() ; j++) {
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

        int x1 = x + (cell.getCol() * cell.getWidth());
        int y1 = y + (cell.getRow() * cell.getHeight());

        int x2 = x1 + cell.getWidth();
        int y2 = y1;

        g2.setStroke(new BasicStroke(cell.getBorder()));

        g2.setColor(cell.getBorderTopColor());
        g2.drawLine(x1, y1, x2, y2);

        g2.setStroke(oldStroke);
    }

    public void drawRightBorder(Graphics2D g2, Cell cell, int x, int y) {
        Stroke oldStroke = g2.getStroke() ;

        int x1 = x + ((cell.getCol() + 1) * cell.getWidth()) ;
        int y1 = y + (cell.getRow() * cell.getHeight()) ;

        int x2 = x1 ;
        int y2 = y1 + cell.getHeight() ;

        g2.setStroke(new BasicStroke(cell.getBorder())) ;

        g2.setColor(cell.getBorderRightColor()) ;
        g2.drawLine(x1, y1, x2, y2) ;

        g2.setStroke(oldStroke) ;
    }

    public void drawBottomBorder(Graphics2D g2, Cell cell, int x, int y) {
        Stroke oldStroke = g2.getStroke() ;

        int x1 = x + (cell.getCol() * cell.getWidth()) ;
        int y1 = y + ((cell.getRow() + 1) * cell.getHeight()) ;

        int x2 = x1 + cell.getWidth() ;
        int y2 = y1 ;

        g2.setStroke(new BasicStroke(cell.getBorder())) ;

        g2.setColor(cell.getBorderBottomColor()) ;
        g2.drawLine(x1, y1, x2, y2) ;

        g2.setStroke(oldStroke) ;
    }

    public void drawLeftBorder(Graphics2D g2, Cell cell, int x, int y) {
        Stroke oldStroke = g2.getStroke() ;

        int x1 = x + (cell.getCol() * cell.getWidth());
        int y1 = y + (cell.getRow() * cell.getHeight());

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
        int x = e.getX() ;
        int y = e.getY() ;

        int row = (y - Y_ORIGIN) / CELL_WIDTH ;
        int col = (x - X_ORIGIN) / CELL_WIDTH ;

        if(paintMode == PAINT_CELL) {
            map.map[row][col].paintBlue() ;
        }

        repaint() ;
        System.out.println("Pressed on Cell: (" + col + ", " + row + ")") ;
    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {

        int x = e.getX() ;
        int y = e.getY() ;

        int row = (y - Y_ORIGIN) / CELL_WIDTH ;
        int col = (x - X_ORIGIN) / CELL_WIDTH ;

        if(paintMode == PAINT_CELL && row >= 0 && col >= 0 && row < mapSize && col < mapSize) {
            map.map[row][col].paintBlue() ;
        }

        repaint() ;
    }

    public Map getMap() {
        return map ;
    }


}
