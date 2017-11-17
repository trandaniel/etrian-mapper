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
//    JToolBar colorBar = new JToolBar();
//
//    ButtonGroup cellColor = new ButtonGroup() ;

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

//        JRadioButton btn1 = new JRadioButton("one") ;
//        JRadioButton btn2 = new JRadioButton("two") ;
//
//        cellColor.add(btn1) ;
//        cellColor.add(btn2) ;
//
//        colorBar.add(btn1) ;
//        colorBar.add(btn2) ;
//
//        outerPane.add(colorBar, BorderLayout.SOUTH) ;


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
        newToolBar.add(wallModeBtn("img/drawWall.png")) ;
        newToolBar.add(eraseWallModeBtn("img/eraseWall.png")) ;
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
            button = new JButton("Draw Walls") ;
        }

        button.setToolTipText("Sets the current mode to draw walls");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mapPanel.setMode(mapPanel.DRAW_WALL) ;
            }
        });

        return button ;
    }

    public JButton eraseWallModeBtn(String img) {
        JButton button ;

        System.out.println("Path: " + img) ;
        try {
            button = new JButton(new ImageIcon(getClass().getResource(img))) ;
        }

        catch (Exception e) {
            button = new JButton("Erase Walls") ;
        }

        button.setToolTipText("Sets the current mode to erase walls");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapPanel.setMode(mapPanel.ERASE_WALL) ;
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
