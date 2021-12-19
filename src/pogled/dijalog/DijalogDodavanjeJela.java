package pogled.dijalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.NotSavedException;
import kontroler.JeloKontroler;
import model.JeloCena;
import net.miginfocom.swing.MigLayout;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.PadajucaLista;
import pogled.TekstPolje;
import pogled.tabela.jelovnik.TabelaModelJelovnik;
import util.Fajlovi;
import util.PogledUtil;

public class DijalogDodavanjeJela extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1785489710996217189L;
	private TekstPolje tfNaziv;
	private JTextArea taOpis;
	private JTextArea taRecept;
	private TekstPolje tfCena;
	private File selektovanaSlika = null;
	
	public DijalogDodavanjeJela() {}
	
	public DijalogDodavanjeJela(JeloKontroler jeloKontroler, String[] naziviTipovaJela, TabelaModelJelovnik tabelaModelJelovnik) {
		setSize(new Dimension(520, 750));
		setLocationRelativeTo(null);
		setTitle("Dodavanje jela");
		setResizable(false);
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/meal96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		Labela lblNaziv = new Labela("Naziv:", fntLabela, clrTercijarna);
		tfNaziv = new TekstPolje("", fntTekstPolje, 140, 30);
		
		Labela lblTipJela = new Labela("Tip zaposlenog:", fntLabela, clrTercijarna);
		PadajucaLista plTipoviJela = new PadajucaLista(naziviTipovaJela,
				clrSekundarna, clrForeground, fntTekstPolje, 140, 30);
		
		Labela lblOpis = new Labela("Opis:", fntLabela, clrTercijarna);
		taOpis = new JTextArea(60, 200);
		JScrollPane scrollOpis = new JScrollPane(taOpis);
		scrollOpis.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollOpis.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		Labela lblRecept = new Labela("Recept:", fntLabela, clrTercijarna);
		taRecept = new JTextArea(60, 200);
		JScrollPane scrollRecept = new JScrollPane(taRecept);
		scrollRecept.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollRecept.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		Labela lblCena = new Labela("Cena:", fntLabela, clrTercijarna);
		tfCena = new TekstPolje("", fntTekstPolje, 140, 30);

		JLabel lblSlikaJela = new JLabel();
		lblSlikaJela.setPreferredSize(new Dimension(80, 60));
		lblSlikaJela.setBackground(Color.RED);
		
		FormaDugme btnDodajSliku = new FormaDugme("Dodaj sliku", clrSekundarna, clrForeground, 150, 20);
		btnDodajSliku.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fcSlika = new JFileChooser();
				fcSlika.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","png");
				fcSlika.addChoosableFileFilter(filter);
				int result = fcSlika.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					selektovanaSlika = fcSlika.getSelectedFile();
					Image slika = Fajlovi.dobaviSlikuOdFajla(selektovanaSlika);
					Image promenjenaSlika = slika.getScaledInstance(120, 100,  java.awt.Image.SCALE_SMOOTH);
					lblSlikaJela.setIcon(new ImageIcon(promenjenaSlika));
				}
			}
		});
		
		FormaDugme btnDodaj = new FormaDugme("Dodaj", clrSekundarna, clrForeground, 150, 20);
		btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					JeloCena dodatoJelo = jeloKontroler.dodajJelo(tfNaziv.getText(), (String) plTipoviJela.getSelectedItem(), taOpis.getText(), taRecept.getText(), tfCena.getText(), selektovanaSlika);
					if (dodatoJelo != null) {
						tabelaModelJelovnik.dodajJelo(dodatoJelo);
						tabelaModelJelovnik.notifyObservers();
						zatvori();
					}
				} catch (MissingValueException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (BadFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (NotSavedException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		setLayout(new MigLayout("", "30[]25[]25", "30[]30[]15[]15[]15[]15[]15[]40[]"));
		
		add(lblImage, "wrap, span2, align center");
		add(lblNaziv);
		add(tfNaziv, "wrap");
		add(lblTipJela);
		add(plTipoviJela, "wrap");
		add(lblOpis);
		add(scrollOpis, "wrap");
		add(lblRecept);
		add(scrollRecept, "wrap");
		add(lblCena);
		add(tfCena, "wrap");
		add(btnDodajSliku);
		add(lblSlikaJela, "wrap");
		add(btnDodaj, "wrap, span2, align center");
	}
	

	private void zatvori() {
		this.dispose();
	}
}
