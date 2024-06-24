import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame {
    private JTextArea textArea;
    private JButton countButton;
    private JLabel wordCountLabel;

    public WordCounter() {
        createUI();
    }

    private void createUI() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Text area for input
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(350, 150));

        // Button to trigger word count
        countButton = new JButton("Count Words");

        // Label to display word count
        wordCountLabel = new JLabel("Word Count: 0");

        // Panel for button and label
        JPanel panel = new JPanel();
        panel.add(countButton);
        panel.add(wordCountLabel);

        // Add components to frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel, BorderLayout.SOUTH);

        // Button action
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Split the text into words based on whitespace
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WordCounter wc = new WordCounter();
                wc.setVisible(true);
            }
        });
    }
}
