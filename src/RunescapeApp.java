import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyStore;

public class RunescapeApp {
    private JButton encrypt;
    private JButton decrypt;
    private JTextField text;
    private JTextField key;
    private JPanel CipherApp;
    private JButton generateRandomKeyButton;


    public RunescapeApp() {
        encrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextArea ja = new JTextArea(10, 10);
                ja.setText(Substitution.encrypt(text.getText(), key.getText()));

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
                ta.setText(Substitution.decrypt(text.getText(), key.getText()));

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
                key.setText(Substitution.generateKey());
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Runescape Cipher");
        frame.setContentPane(new RunescapeApp().CipherApp);
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