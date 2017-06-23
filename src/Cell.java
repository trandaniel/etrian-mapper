import java.awt.*;

/**
 * Created by Danyo on 2017-06-22.
 */
public class Cell {

    private final int BORDER_WIDTH = 2 ;
    private final int CELL_WIDTH = 20 ;
    private final int CELL_HEIGHT = 20 ;

    private final Color BORDER_COLOR    = new Color(8, 57, 90) ;
    private final Color SECTION_COLOR   = new Color(24, 74, 115) ;
    private final Color WALL_COLOR    = new Color(148, 255, 239) ;

    private final Color CELL_COLOR_DEFAULT    = new Color(0, 41, 74) ;
    private final Color CELL_COLOR_BLUE       = new Color(49, 133, 181) ;
    private final Color CELL_COLOR_RED        = new Color(181, 20, 20) ;
    private final Color CELL_COLOR_ORANGE     = new Color(246, 147, 28) ;
    private final Color CELL_COLOR_GREEN      = new Color(122, 197, 117) ;

    private Color cellColor ;

    private int height ;
    private int width ;
    private int border ;
    private int col ;
    private int row ;

    private boolean wallTop ;
    private boolean wallRight ;
    private boolean wallBottom ;
    private boolean wallLeft ;

    private boolean sectionTop ;
    private boolean sectionRight ;
    private boolean sectionBottom ;
    private boolean sectionLeft ;


    private Cell cellTop ;
    private Cell cellRight ;
    private Cell cellBottom ;
    private Cell cellLeft ;

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

        sectionTop = false ;
        sectionRight = false ;
        sectionBottom = false ;
        sectionLeft = false ;
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

        // do something here to set section borders??

        sectionTop = false ;
        sectionRight = false ;
        sectionBottom = false ;
        sectionLeft = false ;

        this.row = i ;
        this.col = j ;

        sectionBorders() ;
    }

    public void sectionBorders() {
        if(col == 0) {
            sectionLeft = true ;
        }

        if(row == 0) {
            sectionTop = true ;
        }

        if((col + 1) % 5 == 0) {
            sectionRight = true ;
        }

        if((row + 1) % 5 == 0) {
            sectionBottom = true ;
        }

        if((col + 1) % 5 == 1) {
            sectionLeft = true ;
        }

        if((row + 1) % 5 == 1) {
            sectionTop = true ;
        }
    }

    public void paintDefault() {
        cellColor = CELL_COLOR_DEFAULT ;
    }

    public void paintBlue() {
        cellColor = CELL_COLOR_BLUE ;
    }

    public void paintRed() {
        cellColor = CELL_COLOR_RED ;
    }

    public void paintOrange() {
        cellColor = CELL_COLOR_ORANGE ;
    }

    public void paintGreen() {
        cellColor = CELL_COLOR_GREEN ;
    }

    public void toggleTopWall() {
        wallTop = !wallTop ;
    }

    public void toggleRightWall() {
        wallRight = !wallRight ;
    }

    public void toggleBottomWall() {
        wallBottom = !wallBottom ;
    }

    public void toggleLeftWall() {
        wallLeft = !wallLeft ;
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

    public boolean isSectionTop() {
        return sectionTop ;
    }

    public boolean isSectionRight() {
        return sectionRight ;
    }

    public boolean isSectionBottom() {
        return sectionBottom ;
    }

    public boolean isSectionLeft() {
        return sectionLeft ;
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

    public Color getBorderTopColor() {
        if(isWallTop()) {
            return WALL_COLOR ;
        }

        else if(isSectionTop()){
            return SECTION_COLOR ;
        }

        else {
            return BORDER_COLOR ;
        }
    }

    public Color getBorderRightColor() {
        if(isWallRight()) {
            return WALL_COLOR ;
        }

        else if(isSectionRight()){
            return SECTION_COLOR ;
        }

        else {
            return BORDER_COLOR ;
        }
    }

    public Color getBorderBottomColor() {
        if(isWallBottom()) {
            return WALL_COLOR ;
        }

        else if(isSectionBottom()){
            return SECTION_COLOR ;
        }

        else {
            return BORDER_COLOR ;
        }
    }

    public Color getBorderLeftColor() {
        if(isWallLeft()) {
            return WALL_COLOR ;
        }

        else if(isSectionLeft()){
            return SECTION_COLOR ;
        }

        else {
            return BORDER_COLOR ;
        }
    }
}
