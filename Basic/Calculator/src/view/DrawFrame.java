/*
 *
 *
 *                          Rafel Ridha, 900710
 *
 * Calculator
 */

package view;
import java.awt.*;              // Jframe
import java.awt.event.*;        // Actionlistner
import javax.swing.*;           // Jframe
import controller.Handler;
import controller.Operator;

public class DrawFrame extends JFrame{
    // Definerar och skapar mina objekt/variablar
    // Knapparna
    private JButton[] b = {
                            new JButton("* Multiplicera"),
                            new JButton("+ Addera"),
                            new JButton("- Subtrahera"),
                            new JButton("/ Dividera")
    };

    // Textfälten
    private JTextField txt = new JTextField(15);
    private JTextField v1 = new JTextField(15);
    private JTextField v2 = new JTextField(15);

    // Informationstexter
    private JLabel tv1 = new JLabel("Första värdet :");
    private JLabel tv2 = new JLabel("Andra värdet :");
    private JLabel tv3 = new JLabel("Svar :");
    String error1 = "Du måste fylla i båda fälten!";
    String error2 = "Du får endast mata in siffror!";
    String error3 = "Siffror endast mellan -99999999 och 999999999";
    String error4 = "Inget är delbart med 0";

    // Få fram information om skärmen för att Centrera Jframen
    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    public int screenHeight = screenSize.height;
    public int screenWidth = screenSize.width;

    public DrawFrame() {
        setSize(215, 400);
        // Centrera på skärmen
        setLocation(screenWidth / 4, screenHeight / 10);
        setResizable(false);
        setTitle("Calculator");
        setUndecorated(false); // True om vi vill ta bort Titlebar + knapparna

        // Lägger till DrawPanel till Jframen
        init();

     }

    private ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String id = ((JButton) e.getSource()).getText();
            String x1 = v1.getText();
            String x2 = v2.getText();

            //Konstrollerar att båda fälten är ifyllda
            if ((x1.isEmpty()) || (x2.isEmpty())){
                JOptionPane.showMessageDialog(null,error1);
            }
            //Kontrollerar att båda fälten endast innehåller siffror
            else if(!(Handler.isNumber(x1)) || !(Handler.isNumber(x2))){
                JOptionPane.showMessageDialog(null,error2);
                v1.setText("");
                v2.setText("");
            }
            //Konstrollerar att fälten har rätt längd
            else if((Handler.isToLong(x1,10)) || (Handler.isToLong(x2,10))){
                JOptionPane.showMessageDialog(null,error3);
            }
            else{
                char  x3 = id.charAt(0);
                String sum = Operator.calculate(x1, x2, x3);
                txt.setText(sum);
            }
        }
    };

    // Objekter som ska visas i Jframen
    public void init() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        for (int i = 0; i < b.length; i++) {

            b[i].addActionListener(al);
            cp.add(b[i]);

        }
        cp.add(tv1);
        cp.add(v1);
        cp.add(tv2);
        cp.add(v2);
        cp.add(tv3);
        cp.add(txt);
    }

}
