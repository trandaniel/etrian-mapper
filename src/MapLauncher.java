/**
 * Created by Danyo on 2017-06-20.
 */
public class MapLauncher {

    public static void main (String[] args) {

        MapViewer mapViewer = new MapViewer() ;

        Map map = mapViewer.getMap() ;

        map.getCellByIndex(2, 2).toggleTopWall() ;
        map.getCellByIndex(4, 4).toggleRightWall() ;
        map.getCellByIndex(6, 6).toggleBottomWall() ;
        map.getCellByIndex(10, 8).toggleLeftWall() ;

        map.paintCellBlue(2, 2) ;

        map.paintCellRed(4, 4) ;

        map.paintCellOrange(6, 6) ;

        map.paintCellGreen(10, 8) ;

        map.printCells();

        mapViewer.mapPanel.repaint() ;

    }
}
