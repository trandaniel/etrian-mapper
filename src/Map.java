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
    }

    public void paintCellBlue(int j, int i) {
        map[i][j].paintBlue() ;
    }

    public void paintCellRed(int j, int i) {
        map[i][j].paintRed() ;
    }

    public void paintCellOrange(int j, int i) {
        map[i][j].paintOrange() ;
    }

    public void paintCellGreen(int j, int i) {
        map[i][j].paintGreen() ;
    }

    public Cell getCellByIndex(int j, int i) {
        return map[i][j] ;
    }
}
