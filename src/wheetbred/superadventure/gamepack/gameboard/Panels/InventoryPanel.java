package wheetbred.superadventure.gamepack.gameboard.Panels;

import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;

import java.awt.Color;


public class InventoryPanel extends JPanel {

    JTextPane inventoryPane;
    public InventoryPanel(GamePanel gPanel) {
        inventoryPane = new JTextPane();
        
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
        // infoPane.setCharacterAttributes(attributeSet, true);
        // infoPane.setText(displayText);
        // infoPane.setVisible(true);

       
        Document doc = inventoryPane.getStyledDocument();


    }

}