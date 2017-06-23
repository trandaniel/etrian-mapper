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

        System.out.println(map.getCellByIndex(2, 2).getBorderTopColor()) ;
        mapViewer.mapPanel.repaint() ;

    }
}
