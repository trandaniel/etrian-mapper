/**
 * Created by Danyo on 2017-06-22.
 */
public class Map {

    final int DEFAULT_SIZE = 20 ;

    // [row][col]
    Cell[][] map ;
    int size ;

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
            for(int j = 0 ; j < s ; j++) {
                map[i][j] = new Cell(i, j) ;
            }
        }
    }

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
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                System.out.println(map[i][j]) ;
            }
            System.out.println() ;
        }
    }

    public int getSize() {
        return size ;
    }

    public void paintCellDefault(int j, int i) {
        map[i][j].paintDefault() ;

        setAdjCells();
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

    public Cell getCellByIndex(int j, int i) {
        return map[i][j] ;
    }
}
