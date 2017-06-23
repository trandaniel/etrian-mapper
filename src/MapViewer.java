import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


/**
 * Created by Danyo on 2017-06-20.
 */
public class MapViewer implements ActionListener {

    JFrame mainWindow ; //window

    JPanel outerPane ;

    MapPanel mapPanel ;

    JMenuBar menuBar ;


    JToolBar toolBar ;
    JButton  newBtn ;
    JButton  opnBtn ;
    JButton  saveBtn ;
    JButton  clrBtn ;

    boolean borderedBtns ;
    boolean compactBtns ;

    public MapViewer() {
        mainWindow = new JFrame() ;
        mapPanel = new MapPanel() ;

        mainWindow.setTitle("EO Mapper") ;

        mainWindow.setSize(new Dimension(800, 600)) ;
        mainWindow.setLocationRelativeTo(null) ;
        mainWindow.setVisible(true) ;
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;

        outerPane = (JPanel) mainWindow.getContentPane() ;

        outerPane.setLayout(new BorderLayout()) ;




        toolBar = new JToolBar() ;

        toolBar = addToolBarBtns(toolBar) ;

        mapPanel.setVisible(true) ;

        outerPane.add(toolBar, BorderLayout.NORTH) ;

        outerPane.add(mapPanel) ;



    }

    public JToolBar addToolBarBtns(JToolBar toolbar) {
        JToolBar newToolBar = toolBar ;

        newToolBar.add(makeBtn("New", "../img/new.png", "New File")) ;
        newToolBar.add(makeBtn("Add Row", "../img/addRow.png", "Add Row")) ;
        newToolBar.add(makeBtn("Delete Row", "../img/delRow.png", "Delete Row")) ;
        newToolBar.add(makeBtn("Add Col", "../img/addCol.png", "Add Column")) ;
        newToolBar.add(makeBtn("Delete Col", "../img/delCol.png", "Delete Column")) ;

        return newToolBar ;
    }

    public JButton makeBtn(String text, String img, String toolTip) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }

        catch (Exception e) {
            button = new JButton(text) ;
        }

        button.setToolTipText(toolTip) ;
        button.addActionListener(this) ;

        if (borderedBtns) {
            button.setBorder(new LineBorder(Color.gray, 1, false)) ;
        }
        else if (compactBtns) {
            button.setBorder(new EmptyBorder( 0, 0, 0, 0));
        }

        return button ;
    }


    public void actionPerformed(ActionEvent e) {

    }

    public Map getMap() {
        return mapPanel.getMap() ;
    }
}
