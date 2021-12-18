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
import pogled.TekstPolje;
import util.PogledUtil;

public class DialogIzmenaProfila extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5983854443986119609L;
	private TekstPolje tfIme;
	private TekstPolje tfPrezime;
	private TekstPolje tfTelefon;
	private TekstPolje tfEmail;
	
	public DialogIzmenaProfila(Korisnik korisnik, KorisnikKontroler korisnikKontroler) {
		setSize(new Dimension(420, 550));
		setLocationRelativeTo(null);
		setTitle("Izmena profila");
		
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
		tfIme = new TekstPolje(korisnik.getIme(), fntTekstPolje, 140, 30);
		
		Labela lblPrezime = new Labela("Prezime:", fntLabela, clrTercijarna);
		tfPrezime = new TekstPolje(korisnik.getPrezime(), fntTekstPolje, 140, 30);
				
		Labela lblTelefon = new Labela("Telefon:", fntLabela, clrTercijarna);
		tfTelefon = new TekstPolje(korisnik.getTelefon(), fntTekstPolje, 140, 30);
		
		Labela lblEmail = new Labela("Email:", fntLabela, clrTercijarna);
		tfEmail = new TekstPolje(korisnik.getEmail(), fntTekstPolje, 140, 30);
		
		FormaDugme btnIzmena = new FormaDugme("Izmeni", clrSekundarna, clrForeground, 150, 20);
		btnIzmena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					korisnikKontroler.izmeniKorisnika(tfIme.getText(), tfPrezime.getText(), tfTelefon.getText(), tfEmail.getText(), korisnik.getEmail());
					zatvori();
				} catch (MissingValueException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (BadFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (UniqueValueException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), e1.getNaslov(), JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		setLayout(new MigLayout("", "85[]25[]", "30[]30[]15[]15[]15[]40[]"));
		
		add(lblImage, "wrap, span2, align center");
		add(lblIme);
		add(tfIme, "wrap");
		add(lblPrezime);
		add(tfPrezime, "wrap");
		add(lblTelefon);
		add(tfTelefon, "wrap");
		add(lblEmail);
		add(tfEmail, "wrap");
		add(btnIzmena, "wrap, span2, align center");
	}
	
	private void zatvori() {
		this.dispose();
	}
}
