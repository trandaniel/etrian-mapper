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

    Color BORDER_COLOR    = new Color(8, 57, 90) ;
    Color SECTION_COLOR   = new Color(24, 74, 115) ;
    Color WALL_COLOR    = new Color(148, 255, 239) ;

    Color CELL_COLOR_DEFAULT    = new Color(0, 41, 74) ;
    Color CELL_COLOR_BLUE       = new Color(49, 133, 181) ;

    Color cellColor ;

    int height ;
    int width ;
    int border ;
    int col ;
    int row ;

    boolean wallTop ;
    boolean wallRight ;
    boolean wallBottom ;
    boolean wallLeft ;

    Cell cellTop ;
    Cell cellRight ;
    Cell cellBottom ;
    Cell cellLeft ;

    public Cell() {
        height = CELL_HEIGHT ;
        width = CELL_WIDTH ;
        border = BORDER_WIDTH ;

        cellColor = CELL_COLOR_DEFAULT ;

        wallTop = false ;
        wallRight = false ;
        wallBottom = false ;
        wallLeft = false ;

        cellTop = null ;
        cellRight = null ;
        cellBottom = null ;
        cellLeft = null ;
    }

    public Cell(int i, int j) {
        height = CELL_HEIGHT ;
        width = CELL_WIDTH ;
        border = BORDER_WIDTH ;

        cellColor = CELL_COLOR_DEFAULT ;

        wallTop = false ;
        wallRight = false ;
        wallBottom = false ;
        wallLeft = false ;

        cellTop = null ;
        cellRight = null ;
        cellBottom = null ;
        cellLeft = null ;

        col = j ; //  col
        row = i ; //  row
    }


    public void paintBlue() {
        cellColor = CELL_COLOR_BLUE ;
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

    public void setRow(int row) {
        this.row = row ;
    }

    public void setCol(int col) {
        this.col = col ;
    }

    public void setCellTop(Cell cell) {
        cellTop = cell ;
    }

    public void setCellRight(Cell cell) {
        cellRight = cell ;
    }

    public void setCellBottom(Cell cell) {
        cellBottom = cell ;
    }

    public void setCellLeft(Cell cell) {
        cellLeft = cell ;
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

    public Cell getCellTop() {
        return cellTop ;
    }

    public Cell getCellRight() {
        return cellRight ;
    }

    public Cell getCellBottom() {
        return cellBottom ;
    }

    public Cell getCellLeft() {
        return cellLeft ;
    }

    public Color getCellColor() {
        return cellColor ;
    }

    public Color getWallColor() {
        return WALL_COLOR ;
    }

    public Color getSectionColor() {
        return SECTION_COLOR ;
    }

    public Color getBorderColor() {
        return BORDER_COLOR ;
    }
}
