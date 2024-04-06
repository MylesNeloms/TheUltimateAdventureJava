package wheetbred.superadventure.gamepack.gameboard.Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class InfoPanel extends JPanel {
    JTextPane infoPane;
    String displayText = "You are the player";
    public InfoPanel(GamePanel gPanel) {
        infoPane = new JTextPane();
        
        displayText = new String();
        this.setBackground(Color.RED);
        this.setBounds(0,gPanel.getHeight(), 700,150);

        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        // StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);` is setting the
        // alignment of text in the JTextPane to be centered. This means that any text added to the
        // JTextPane after this line will be displayed in the center of the pane horizontally.
        // StyleConstants.setAlignment(attributeSet, StyleConstants.ALIGN_CENTER);
        // StyleConstants.setBackground(attributeSet, Color.gray);
        // StyleConstants.setFontFamily(attributeSet, "Trattatelo");
        // skia Spot Mono
        infoPane.setCharacterAttributes(attributeSet, true);
        infoPane.setText(displayText);
        infoPane.setVisible(true);

        Document doc = infoPane.getStyledDocument();
    try {
        doc.insertString(doc.getLength(), displayText, attributeSet);
        } catch (BadLocationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }
        // this.setLayout();
        // this.setVisible(true);



    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
