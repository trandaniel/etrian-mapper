/**
 * Created by Danyo on 2017-06-22.
 */
public class Map {

    int DEFAULT_SIZE = 20 ;

    Cell[][] map ;

    public Map() {
        map = new Cell[DEFAULT_SIZE][DEFAULT_SIZE] ;
        for(int i = 0 ; i < DEFAULT_SIZE ; i++) {
            for(int j = 0 ; j < DEFAULT_SIZE ; j++) {
                map[i][j] = new Cell(i, j) ;
            }
        }
    }

    public void printCells() {
        for(int i = 0 ; i < map.length ; i++) {
            for(int j = 0 ; j < map[i].length ; j++) {
                System.out.println("Cell " + i + ", " + j + ": " + map[i][j].getCellColor()) ;
            }
        }
    }

    public Cell getCellByIndex(int i ,int j) {
        return map[i][j] ;
    }
}
