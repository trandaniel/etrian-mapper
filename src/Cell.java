import java.awt.*;

/**
 * Created by Danyo on 2017-06-22.
 */
public class Cell {

    final int WALL_TOP = 0 ;
    final int WALL_RIGHT = 1 ;
    final int WALL_BOTTOM = 2 ;
    final int WALL_LEFT = 3 ;

    final int BORDER_WIDTH = 2 ;
    final int CELL_WIDTH = 20 ;
    final int CELL_HEIGHT = 20 ;

    Color BORDER_COLOR_DARK     = new Color(8, 57, 90) ;
    Color BORDER_COLOR_LIGHT    = new Color(24, 74, 115) ;
    Color BORDER_COLOR_WALL    = new Color(148, 255, 239) ;

    Color CELL_COLOR_DEFAULT    = new Color(0, 41, 74) ;
    Color CELL_COLOR_BLUE       = new Color(49, 133, 181) ;

    Color cellColor ;
    Color borderTop ;
    Color borderLeft ;
    Color borderBottom ;
    Color borderRight ;

    int height ;
    int width ;
    int border ;
    int col ;
    int row ;

    boolean wallTop ;
    boolean wallRight ;
    boolean wallBottom ;
    boolean wallLeft ;

    public Cell() {
        height = CELL_HEIGHT ;
        width = CELL_WIDTH ;
        border = BORDER_WIDTH ;

        cellColor = CELL_COLOR_DEFAULT ;
        borderTop = BORDER_COLOR_DARK ;
        borderRight = BORDER_COLOR_DARK ;
        borderBottom = BORDER_COLOR_DARK ;
        borderLeft = BORDER_COLOR_DARK ;

        wallTop = false ;
        wallRight = false ;
        wallBottom = false ;
        wallLeft = false ;
    }

    public Cell(int i, int j) {
        height = CELL_HEIGHT ;
        width = CELL_WIDTH ;
        border = BORDER_WIDTH ;

        cellColor = CELL_COLOR_DEFAULT ;
        borderTop = BORDER_COLOR_DARK ;
        borderRight = BORDER_COLOR_DARK ;
        borderBottom = BORDER_COLOR_DARK ;
        borderLeft = BORDER_COLOR_DARK ;

        wallTop = false ;
        wallRight = false ;
        wallBottom = false ;
        wallLeft = false ;

        col = j ; //  col
        row = i ; //  row
    }

    public void borderSectionTop() {
        borderTop = BORDER_COLOR_LIGHT ;
    }

    public void borderSectionRight() {
        borderRight = BORDER_COLOR_LIGHT ;
    }

    public void borderSectionBottom() {
        borderBottom = BORDER_COLOR_LIGHT ;
    }

    public void borderSectionLeft() {
        borderLeft = BORDER_COLOR_LIGHT ;
    }

    public void paintBlue() {
        cellColor = CELL_COLOR_BLUE ;
    }

    public void wallTop() {
        borderTop = BORDER_COLOR_WALL ;
    }

    public void wallRight() {
        borderRight = BORDER_COLOR_WALL ;
    }

    public void wallBottom() {
        borderBottom = BORDER_COLOR_WALL ;
    }

    public void wallLeft() {
        borderLeft = BORDER_COLOR_WALL ;
    }

    public int getHeight() {
        return height ;
    }

    public int getWidth() {
        return width ;
    }

    public int getBorder() {
        return border ;
    }

    public int getRow() {
        return row ;
    }

    public int getCol() {
        return col ;
    }

    public void toggleWall(int id) {
        switch(id){
            case WALL_TOP:      wallTop = !wallTop ;
                                break ;
            case WALL_RIGHT:    wallRight = !wallRight ;
                                break ;
            case WALL_BOTTOM:   wallBottom = !wallBottom ;
                                break ;
            case WALL_LEFT:     wallLeft = !wallLeft ;
                                break ;
            default:            break ;
        }
    }

    public boolean isWallTop() {
        return wallTop ;
    }

    public boolean isWallRight() {
        return wallRight ;
    }

    public boolean isWallBottom() {
        return wallBottom ;
    }

    public boolean isWallLeft() {
        return wallLeft ;
    }
    
    public Color getCellColor() {
        return cellColor ;
    }
}
