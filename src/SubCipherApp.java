import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.KeyStore;

public class SubCipherApp extends JFrame {
    private JButton encrypt;
    private JButton decrypt;
    private JTextField text;
    private JTextField key;
    private JPanel CipherApp;
    private JButton generateRandomKeyButton;
    private JCheckBox box;


    public SubCipherApp() {
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea ja = new JTextArea(10, 10);
                if(!box.isSelected()){
                    ja.setText(Substitution.encrypt(text.getText(), key.getText()));
                }else{
                    ja.setText(Runescape.encrypt(text.getText(), key.getText()));
                }

                ja.setWrapStyleWord(true);
                ja.setLineWrap(true);
                ja.setCaretPosition(0);
                ja.setEditable(false);

                JOptionPane.showMessageDialog(null, new JScrollPane(ja));
            }
        });
        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea ta = new JTextArea(10, 10);
                if(!box.isSelected()){
                    ta.setText(Substitution.decrypt(text.getText(), key.getText()));
                }else{
                    ta.setText(Runescape.decrypt(text.getText(), key.getText()));
                }

                ta.setWrapStyleWord(true);
                ta.setLineWrap(true);
                ta.setCaretPosition(0);
                ta.setEditable(false);

                JOptionPane.showMessageDialog(null, new JScrollPane(ta));
            }
        });
        generateRandomKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add generate Random key
                if(!box.isSelected()){
                    key.setText(Substitution.generateKey());
                }else{
                    key.setText(Runescape.generateKey());
                }

            }
        });
        
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("FiggleBottom");
        frame.setContentPane(new SubCipherApp().CipherApp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}