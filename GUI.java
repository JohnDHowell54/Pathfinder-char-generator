import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/**
 * Deals with the GUI components
 * 
 * @author (JOhn 
 * @version (a version number or a date)
 */
public class GUI
{
   
    JFrame frame;
    JLabel statusLabel;
    String VERSION = "0.3";
    Generation generate;
    PrintStream ps = System.out;
    /**
     * Constructor for objects of class GU
     */
    public GUI() throws FileNotFoundException
    {
     makeFrame();
     generate = new Generation();
    }
    
    //Button functionality
    
    private String gen() throws FileNotFoundException
    {
         generate.genStats();
         return generate.printAll();
        
    }
    //Menu Functionality
    
    private void quit()
    {
        System.exit(0);
    }

    /**
     * Create the frame
     */
    private void makeFrame()
    {
        //The frame
        frame = new JFrame("Blaza's Character Generator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        //Container for the content
        Container contentPane = frame.getContentPane();
        
        //Area to hold the text generated
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        //frame.add(textArea);
        
        JScrollPane sp = new JScrollPane(textArea);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setPreferredSize(new java.awt.Dimension(300, 300));
        frame.add(sp);
        
        frame.setSize(500,500);
        makeMenuBar(frame);
        
        // Specify the layout manager
        contentPane.setLayout(new BorderLayout(10, 10));
        
        
        //Create the left panel with the generate button
        JPanel leftPane = new JPanel();
        {
            JButton generate = new JButton("Generate");
            
            generate.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
						textArea.append(gen());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
                
                
            });
            contentPane.add(generate, BorderLayout.WEST);
            
  
            
            
            
        }
       
//         //Create the right panel that will contain all the information generated

        JPanel rightPane = new JPanel();
       {
           contentPane.add(sp, BorderLayout.EAST);
       }

       

        statusLabel = new JLabel(VERSION);
        contentPane.add(statusLabel, BorderLayout.SOUTH);   
       
        
        // center the frame on screen
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();


        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu menu;
        JMenuItem item;
        
        // create the File menu
        menu = new JMenu("File");
        menubar.add(menu);
      
        item = new JMenuItem("Quit");
            item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
            item.addActionListener(new ActionListener() {
                               public void actionPerformed(ActionEvent e) { quit(); }
                           });
        menu.add(item);


       
    }
}
