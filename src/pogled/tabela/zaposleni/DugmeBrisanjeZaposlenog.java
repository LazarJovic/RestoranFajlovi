package pogled.tabela.zaposleni;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class DugmeBrisanjeZaposlenog extends AbstractCellEditor
	implements TableCellRenderer, TableCellEditor, MouseListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7038624689794191147L;
	private JTable tabela;
	private JButton prikazDugme;
	private JButton akcijaDugme;
	private boolean isEditorActive = false;
	
	public DugmeBrisanjeZaposlenog(JTable tabela, int kolona) {
		
		this.tabela = tabela;
		this.tabela.getColumnModel().getColumn(kolona).setCellRenderer(this);
		this.tabela.getColumnModel().getColumn(kolona).setCellEditor(this);
		this.tabela.addMouseListener(this);
		
		this.prikazDugme = new JButton("Obriši");
		this.akcijaDugme = new JButton("Obriši");
		
		this.akcijaDugme.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				JOptionPane.showMessageDialog(tabela, "Funkcionalnost je u izradi", "Nedovršena funkcionalnost", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		this.isEditorActive = false;
	}
	
	@Override
	public Object getCellEditorValue() {
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (tabela.isEditing() && tabela.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (isEditorActive && tabela.isEditing()) {
			tabela.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected,
			int row, int column) {
		return akcijaDugme;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		return prikazDugme;
	}

	
	
}
