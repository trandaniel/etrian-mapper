/**
 * Created by Danyo on 2017-06-20.
 */
public class MapLauncher {

    public static void main (String[] args) {

        MapViewer mapViewer = new MapViewer() ;

        Map map = mapViewer.getMap() ;

        map.toggleTopWallByCell(2, 2) ;
        map.toggleRightWallByCell(4, 4) ;
        map.toggleBottomWallByCell(6, 6) ;
        map.toggleLeftWallByCell(10, 8) ;

        map.paintCellBlue(2, 2) ;

        map.paintCellRed(4, 4) ;

        map.paintCellOrange(6, 6) ;

        map.paintCellGreen(10, 8) ;

        map.printCells();

        mapViewer.mapPanel.repaint() ;

    }
}
