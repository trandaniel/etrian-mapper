/**
 * Created by Danyo on 2017-06-20.
 */
public class MapLauncher {

    public static void main (String[] args) {

        MapViewer mapViewer = new MapViewer() ;

        Map map = mapViewer.getMap() ;

        map.getCellByIndex(2, 2).toggleTopWall() ;
        map.getCellByIndex(2, 2).toggleRightWall() ;
        map.getCellByIndex(2, 2).toggleBottomWall() ;
        map.getCellByIndex(2, 2).toggleLeftWall() ;

        map.getCellByIndex(2, 2).paintBlue() ;

        map.getCellByIndex(4, 4).paintRed() ;

        map.getCellByIndex(6, 6).paintOrange() ;

        map.getCellByIndex(10, 8).paintGreen() ;

        map.printCells();

        mapViewer.mapPanel.repaint() ;

    }
}
