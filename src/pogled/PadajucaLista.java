package pogled;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

@SuppressWarnings("rawtypes")
public class PadajucaLista extends JComboBox {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5940640216385227698L;

	public PadajucaLista() {}
	
	@SuppressWarnings("unchecked")
	public PadajucaLista(String[] opcije, Color pozadinaBoja, Color prednjaBoja, Font font, int sirina, int visina) {
		super(opcije);
		this.setBackground(pozadinaBoja);
		this.setForeground(prednjaBoja);
		this.setFont(font);
		this.setPreferredSize(new Dimension(sirina, visina));
		this.setUI(StrelicaUI.createUI(this, pozadinaBoja));
		this.setRenderer(new PadajucaListaRenderer(this.getRenderer(), pozadinaBoja));
		this.setEditable(false);
	}

}

@SuppressWarnings({"rawtypes", "unchecked", "serial"})
class PadajucaListaRenderer extends DefaultListCellRenderer {

	  
	  private ListCellRenderer defaultRenderer;
	  private Color boja;

	  public PadajucaListaRenderer(ListCellRenderer defaultRenderer, Color boja) {
	    this.defaultRenderer = defaultRenderer;
	    this.boja = boja;
	  }

	  @Override
	  public Component getListCellRendererComponent(JList list, Object value,
	      int index, boolean isSelected, boolean cellHasFocus) {
		Component c = defaultRenderer.getListCellRendererComponent(list, value,
	        index, isSelected, cellHasFocus);
	    if (c instanceof JLabel) {
	      if (isSelected) {
	        c.setBackground(Color.white);
	      } else {
	        c.setBackground(boja);
	      }
	    } else {
	      c.setBackground(Color.red);
	      c = super.getListCellRendererComponent(list, value, index, isSelected,
	          cellHasFocus);
	    }
	    return c;
	  }
	}

class StrelicaUI extends BasicComboBoxUI {

	private Color pozadinaBoja;
	
	public StrelicaUI(Color pozadinaBoja) {
		this.pozadinaBoja = pozadinaBoja;
	}
	
    public static ComboBoxUI createUI(JComponent c, Color pozadinaBoja) {
        return new StrelicaUI(pozadinaBoja);
    }

    @Override protected JButton createArrowButton() {
        return new BasicArrowButton(
            BasicArrowButton.SOUTH,
            pozadinaBoja, pozadinaBoja,
            Color.WHITE, Color.WHITE);
    }
}
