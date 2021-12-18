package pogled.dijalog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import izuzeci.BadFormatException;
import izuzeci.MissingValueException;
import izuzeci.UniqueValueException;
import kontroler.KorisnikKontroler;
import model.Korisnik;
import net.miginfocom.swing.MigLayout;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.LozinkaPolje;
import pogled.PadajucaLista;
import pogled.TekstPolje;
import pogled.tabela.zaposleni.TabelaModelZaposleni;
import util.PogledUtil;

public class DijalogRegistrovanjeZaposlenog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5054215967715312072L;
	private TekstPolje tfIme;
	private TekstPolje tfPrezime;
	private TekstPolje tfTelefon;
	private TekstPolje tfEmail;
	private TekstPolje tfDatumRodjenja;
	private TekstPolje tfKorIme;
	private LozinkaPolje tfLozinka;
	
	public DijalogRegistrovanjeZaposlenog() {}
	
	public DijalogRegistrovanjeZaposlenog(KorisnikKontroler korisnikKontroler, TabelaModelZaposleni tabelaModelZaposleni) {
		setSize(new Dimension(520, 650));
		setLocationRelativeTo(null);
		setTitle("Registrovanje zaposlenog");
		
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrTercijarna = PogledUtil.getTercijarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		this.getContentPane().setBackground(clrPrimarna);
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/profile96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		Labela lblIme = new Labela("Ime:", fntLabela, clrTercijarna);
		tfIme = new TekstPolje("yy", fntTekstPolje, 140, 30);
		
		Labela lblPrezime = new Labela("Prezime:", fntLabela, clrTercijarna);
		tfPrezime = new TekstPolje("yy", fntTekstPolje, 140, 30);
				
		Labela lblTelefon = new Labela("Telefon:", fntLabela, clrTercijarna);
		tfTelefon = new TekstPolje("54353", fntTekstPolje, 140, 30);
		
		Labela lblEmail = new Labela("Email:", fntLabela, clrTercijarna);
		tfEmail = new TekstPolje("yy@r.co", fntTekstPolje, 140, 30);

		Labela lblDatumRodjenja = new Labela("Datum rodjenja:", fntLabela, clrTercijarna);
		tfDatumRodjenja = new TekstPolje("1998-12-12", fntTekstPolje, 140, 30);
		
		Labela lblKorIme = new Labela("Korisničko ime:", fntLabela, clrTercijarna);
		tfKorIme = new TekstPolje("yy", fntTekstPolje, 140, 30);
		
		Labela lblLozinka = new Labela("Lozinka:", fntLabela, clrTercijarna);
		tfLozinka = new LozinkaPolje("yyAA234234", 140, 30);
		
		Labela lblTipZaposlenog = new Labela("Tip zaposlenog:", fntLabela, clrTercijarna);
		PadajucaLista plTipoviZaposlenih = new PadajucaLista(PogledUtil.getTipoviZaposlenih(),
				clrSekundarna, clrForeground, fntTekstPolje, 140, 30);
		
		FormaDugme btnRegistruj = new FormaDugme("Registruj", clrSekundarna, clrForeground, 150, 20);
		btnRegistruj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Korisnik korisnik = korisnikKontroler.registrujKorisnika(tfIme.getText(), tfPrezime.getText(), tfTelefon.getText(),
							tfEmail.getText(), tfDatumRodjenja.getText(), tfKorIme.getText(), String.valueOf(tfLozinka.getPassword()),
							(String) plTipoviZaposlenih.getSelectedItem());
					tabelaModelZaposleni.notifyObservers();
					zatvori();
				} catch (MissingValueException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
				} catch (BadFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (UniqueValueException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		setLayout(new MigLayout("", "115[]25[]", "30[]30[]15[]15[]15[]15[]15[]15[]15[]40[]"));
		
		add(lblImage, "wrap, span2, align center");
		add(lblIme);
		add(tfIme, "wrap");
		add(lblPrezime);
		add(tfPrezime, "wrap");
		add(lblTelefon);
		add(tfTelefon, "wrap");
		add(lblEmail);
		add(tfEmail, "wrap");
		add(lblDatumRodjenja);
		add(tfDatumRodjenja, "wrap");
		add(lblKorIme);
		add(tfKorIme, "wrap");
		add(lblLozinka);
		add(tfLozinka, "wrap");
		add(lblTipZaposlenog);
		add(plTipoviZaposlenih, "wrap");
		add(btnRegistruj, "wrap, span2, align center");
	}
	
	private void zatvori() {
		this.dispose();
	}
}
