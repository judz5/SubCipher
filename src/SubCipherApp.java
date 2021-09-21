import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore;

public class SubCipherApp {
    private JButton encrypt;
    private JButton decrypt;
    private JTextField text;
    private JTextField key;
    private JPanel CipherApp;
    private JButton generateRandomKeyButton;


    public SubCipherApp() {
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Substitution.encrypt(text.getText(), key.getText()));
            }
        });
        decrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, Substitution.decrypt(text.getText(), key.getText()));
            }
        });
        generateRandomKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add generate Random key
                key.setText(Substitution.generateKey());
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Substitution Cipher");
        frame.setContentPane(new SubCipherApp().CipherApp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}