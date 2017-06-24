import java.util.ArrayList;

/**
 * Created by Danyo on 2017-06-22.
 */
public class Map {

    final int DEFAULT_SIZE = 20 ;

    private final int PAINT_COLOR_0 = 0 ;
    private final int PAINT_COLOR_1 = 1 ;
    private final int PAINT_COLOR_2 = 2 ;
    private final int PAINT_COLOR_3 = 3 ;
    private final int PAINT_COLOR_4 = 4 ;

    private final int SECTION_SIZE = 5 ;

    // TODO: Switch to ArrayList
    public ArrayList<ArrayList<Cell>> map1 = new ArrayList<>() ;
    // [row][col]
    public Cell[][] map ;
    public int size ;

    public Map() {
        size = DEFAULT_SIZE ;

        makeMap(size) ;

        setAdjCells() ;
    }

    public Map(int s) {
        size = s ;

        makeMap(size) ;

        setAdjCells() ;
    }

    public void makeMap(int s) {
        map = new Cell[s][s] ;
        for(int i = 0 ; i < s ; i++) {

            map1.add(new ArrayList<>()) ;

            for(int j = 0 ; j < s ; j++) {
                map[i][j] = new Cell(i, j) ;

                map1.get(i).add(new Cell(i, j)) ;
            }
        }
    }

    // TODO: ArrayList
    public void setAdjCells() {
        Cell cell ;
        for(int i = 0 ; i < size ; i++) {
            for(int j = 0 ; j < size ; j++) {

                map[i][j].setCellTop(topCell(i, j)) ;
                map[i][j].setCellRight(rightCell(i, j)) ;
                map[i][j].setCellBottom(bottomCell(i, j)) ;
                map[i][j].setCellLeft(leftCell(i, j)) ;
            }
        }
    }

    // TODO: ArrayList
    private Cell topCell(int i, int j) {
        if(i - 1 < 0) {
            return null ;
        }
        else {
            return map[i - 1][j] ;
        }
    }

    private Cell rightCell(int i, int j) {
        if(j + 1 > size - 1) {
            return null ;
        }
        else {
            return map[i][j + 1] ;
        }
    }

    private Cell bottomCell(int i, int j) {
        if(i + 1 > size - 1) {
            return null ;
        }
        else {
            return map[i + 1][j] ;
        }
    }

    private Cell leftCell(int i, int j) {
        if (j - 1 < 0) {
            return null ;
        }
        else {
            return map[i][j - 1] ;
        }
    }

    public void printCells() {
        for(int i = 0 ; i < map1.size() ; i++) {
            for(int j = 0 ; j < map1.get(i).size() ; j++) {
                System.out.println(map1.get(i).get(j)) ;
            }
            System.out.println() ;
        }
    }

    public int getSize() {
        return size ;
    }

    // TODO: ArrayList
    public void paintCellDefault(int j, int i) {
        map[i][j].paintDefault() ;

        setAdjCells();
    }

    public void paintCell(int j, int i, int color) {
        switch(color) {
            case PAINT_COLOR_0: paintCellDefault(j, i) ;
                                break ;
            case PAINT_COLOR_1: paintCellBlue(j, i) ;
                                break ;
            case PAINT_COLOR_2: paintCellRed(j, i) ;
                                break ;
            case PAINT_COLOR_3: paintCellOrange(j, i) ;
                                break ;
            case PAINT_COLOR_4: paintCellGreen(j, i) ;
                                break ;
            default:            paintCellDefault(j, i) ;
        }
    }

    public void paintCellBlue(int j, int i) {
        map[i][j].paintBlue() ;

        setAdjCells() ;
    }

    public void paintCellRed(int j, int i) {
        map[i][j].paintRed() ;

        setAdjCells() ;
    }

    public void paintCellOrange(int j, int i) {
        map[i][j].paintOrange() ;

        setAdjCells() ;
    }

    public void paintCellGreen(int j, int i) {
        map[i][j].paintGreen() ;

        setAdjCells() ;
    }

    public void toggleTopWallByCell(int j, int i) {
        map[i][j].toggleTopWall() ;

        if(map[i][j].isCellTop()) {
            map[i - 1][j].toggleBottomWall() ;
        }

        setAdjCells() ;
    }

    public void toggleRightWallByCell(int j, int i) {
        map[i][j].toggleRightWall() ;

        if(map[i][j].isCellRight()) {
            map[i][j + 1].toggleLeftWall() ;
        }

        setAdjCells() ;
    }

    public void toggleBottomWallByCell(int j, int i) {
        map[i][j].toggleBottomWall() ;

        if(map[i][j].isCellBottom()) {
            map[i + 1][j].toggleTopWall() ;
        }

        setAdjCells() ;
    }

    public void toggleLeftWallByCell(int j, int i) {
        map[i][j].toggleLeftWall() ;

        if(map[i][j].isCellLeft()) {
            map[i][j - 1].toggleRightWall() ;
        }

        setAdjCells() ;
    }

    public void drawTopWallByCell(int j, int i) {
        map[i][j].drawTopWall() ;

        if(map[i][j].isCellTop()) {
            map[i - 1][j].drawBottomWall() ;
        }

        setAdjCells() ;
    }

    public void drawRightWallByCell(int j, int i) {
        map[i][j].drawRightWall() ;

        if(map[i][j].isCellRight()) {
            map[i][j + 1].drawLeftWall() ;
        }

        setAdjCells() ;
    }

    public void drawBottomWallByCell(int j, int i) {
        map[i][j].drawBottomWall() ;

        if(map[i][j].isCellBottom()) {
            map[i + 1][j].drawTopWall() ;
        }

        setAdjCells() ;
    }

    public void drawLeftWallByCell(int j, int i) {
        map[i][j].drawLeftWall() ;

        if(map[i][j].isCellLeft()) {
            map[i][j - 1].drawRightWall() ;
        }

        setAdjCells() ;
    }

    public Cell getCellByIndex(int j, int i) {
        return map[i][j] ;
    }
}
