package swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import kata6.control.Command;
import kata6.control.DownCommand;
import kata6.control.LeftCommand;
import kata6.control.RightCommand;
import kata6.control.UpCommand;
import kata6.model.Block;
import kata6.view.BlockDisplay;

public class Main extends JFrame{

    public static void main(String[] args) {
        new Main().execute();
    }
    private BlockDisplay blockDisplay;
    private final Map<String,Command> commands = new HashMap<>();

    public Main(){
        this.setTitle("Block shifter");
        this.setSize(700, 762);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(blockPanel());
        this.add(toolBar(), BorderLayout.SOUTH);
        
        Block block = new Block(4,4);
        this.blockDisplay.display(block);
        this.commands.put("left", new LeftCommand(block));
        this.commands.put("right", new RightCommand(block));
        this.commands.put("up", new UpCommand(block));
        this.commands.put("down", new DownCommand(block));
    }
    
    private void execute(){
        this.setVisible(true);
    }
    
    private JPanel blockPanel(){
        BlockPanel blockPanel = new BlockPanel();
        this.blockDisplay = blockPanel;
        return blockPanel;
    }

    private JMenuBar toolBar() {
        JMenuBar menu = new JMenuBar();
        menu.add(button("left"));
        menu.add(button("right"));
        menu.add(button("up"));
        menu.add(button("down"));
        return menu;
    }
    
    private JButton button(String name){
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(name).execute();
            }
        });
        return button;
    }
}
