import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HolaMundo {
    private JPanel rootPanel;
    private JButton OKButton;
    private JLabel resultado;
    private JTextField numero1;
    private JTextField numero2;
   // int i=0;
    public HolaMundo() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(numero1.getText());
                double num2 = Double.parseDouble(numero2.getText());
                double div = num1 / (num2*num2);
                resultado.setText("Resultado: " + div);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HolaMundo");
        frame.setContentPane(new HolaMundo().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
