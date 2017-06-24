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
        newToolBar.add(clearMap("../img/clear.png")) ;
        newToolBar.add(setPaint1("../img/blue.png")) ;
        newToolBar.add(setPaint2("../img/red.png")) ;
        newToolBar.add(setPaint3("../img/orange.png")) ;
        newToolBar.add(setPaint4("../img/green.png")) ;
        newToolBar.add(wallModeBtn("../img/wall.img")) ;

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

    // TODO: Add ActionListener
    public JButton plusSize(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }
        catch (Exception e) {
            button = new JButton("Add") ;
        }

        button.setToolTipText("Increases the Map size by one row and column section") ;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ?????
            }
        });

        return button ;
    }

    // TODO: Add ActionListener
    public JButton minusSize(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }
        catch (Exception e) {
            button = new JButton("Sub") ;
        }

        button.setToolTipText("Decreases the map size but one row and column section") ;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ?????
            }
        });

        return button ;
    }

    public JButton clearMap(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }
        catch (Exception e) {
            button = new JButton("Clear Map") ;
        }

        button.setToolTipText("Clears the map") ;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.newMap() ;
            }
        });

        return button ;
    }

    public JButton setPaint1(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }
        catch (Exception e) {
            button = new JButton("Color 1") ;
        }

        button.setToolTipText("Switches to painting Cells with Color 1") ;

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mapPanel.setMode(mapPanel.PAINT_CELL) ;
                mapPanel.setPaintColor(mapPanel.PAINT_COLOR_1) ;
            }
        }) ;

        return button ;
    }

    public JButton setPaint2(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }
        catch (Exception e) {
            button = new JButton("Color 2") ;
        }

        button.setToolTipText("Switches to painting Cells with Color 2") ;

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mapPanel.setMode(mapPanel.PAINT_CELL) ;
                mapPanel.setPaintColor(mapPanel.PAINT_COLOR_2) ;
            }
        });

        return button ;
    }

    public JButton setPaint3(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }
        catch (Exception e) {
            button = new JButton("Color 3") ;
        }

        button.setToolTipText("Switches to painting Cells with Color 3") ;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.setMode(mapPanel.PAINT_CELL) ;
                mapPanel.setPaintColor(mapPanel.PAINT_COLOR_3) ;
            }
        });

        return button ;
    }

    public JButton setPaint4(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }
        catch (Exception e) {
            button = new JButton("Color 4") ;
        }

        button.setToolTipText("Switches to painting Cells with Color 4") ;

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.setMode(mapPanel.PAINT_CELL) ;
                mapPanel.setPaintColor(mapPanel.PAINT_COLOR_4) ;
            }
        });

        return button ;
    }

    public JButton wallModeBtn(String img) {
        JButton button ;

        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }

        catch (Exception e) {
            button = new JButton("Edit Walls") ;
        }

        button.setToolTipText("Sets the current Mode to Edit Walls");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mapPanel.setMode(mapPanel.PAINT_WALL) ;
            }
        });

        return button ;
    }

    public void actionPerformed(ActionEvent e) {

    }

    public Map getMap() {
        return mapPanel.getMap() ;
    }
}
