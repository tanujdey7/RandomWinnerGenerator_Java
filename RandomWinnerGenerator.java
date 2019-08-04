import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Scanner;
public class RandomWinnerGenerator extends JFrame {
    RandomWinnerGenerator() {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        JLabel l1 = new JLabel("Enter number of Players: ");
        JLabel l2 = new JLabel();
        JButton b = new JButton("Confirm!");
        JTextField text = new JTextField();
        l1.setBounds(91,100,230,50);
        text.setBounds(330,115,50,24);
        b.setBounds(180,160,90,30);
        l2.setBounds(180,170,300,50);
        l1.setFont(new Font("Serif",Font.BOLD,20));
        add(b);
        add(l1);
        add(l2);
        add(text);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(ae.getSource() == b) {
                    try {
                        int num = Integer.parseInt(text.getText());      //stores in varible num
                        int dialog = JOptionPane.showConfirmDialog(null, "Continue with "+num+" players?", "Confirm!", JOptionPane.YES_NO_OPTION);
                        if(dialog == 1) {
                            System.out.println("cancel");
                        }
                        if(dialog == 0) {
                            String name[] = new String[num];              
                            for(int i = 0 ; i < name.length ; i++) {        
                                name[i] = JOptionPane.showInputDialog(null, "Enter name of "+num+" players");
                            }
                            int winner = 0;
                            winner = rand.nextInt(name.length);            //Random function returns anything from 0 to length of array
                            if(winner == 0 ) {                             //If the prediction is 0 we'll again run this code
                                winner = rand.nextInt(name.length);  
                            }
                            JOptionPane.showMessageDialog(null, "Winner is: "+name[winner]);       //Show the final result
                        }
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Enter Numeric Value","Warning",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
}
    public static void main(String[] args) {
        new RandomWinnerGenerator();
    }
}