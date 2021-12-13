package pogled;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import util.PogledUtil;

public class PrijavaProzor extends JFrame {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5492013022423502649L;
	private TekstPolje tfKorIme;
	private LozinkaPolje tfLozinka;
	
	//private AuthKontroler authKontroler;
	
	public PrijavaProzor() {
		setSize(new Dimension(500, 400));
		setTitle("Prijava");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	
		//this.authKontroler = new AuthKontroler();
		
		Font fntNaslov = PogledUtil.getMaliNaslovFont();
		Font fntLabela = PogledUtil.getLabelaFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		
		JPanel pnlPrijava = new JPanel();
		
		Labela lblNaslov = new Labela("Prijavite se na sistem restorana", fntNaslov, clrForeground);
		
		JLabel lblImage = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/restaurant1.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		Labela lblKorIme = new Labela("Korisničko ime: ", fntLabela, clrForeground);
		tfKorIme = new TekstPolje("", fntTekstPolje, 140, 30);
		
		Labela lblLozinka = new Labela("Lozinka: ", fntLabela, clrForeground);
		tfLozinka = new LozinkaPolje("", 140, 30);
		
		FormaDugme btnPrijava = new FormaDugme("Prijava", clrPrimarna, clrForeground, 70, 30);
		btnPrijava.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
//				try {
//					String uloga = authKontroler.login(tfKorIme.getText(), String.valueOf(tfLozinka.getPassword()));
//					zatvori();
//					PocetniProzor procetniProzor = new PocetniProzorFabrika().napraviPocetniProzor(uloga);
//					procetniProzor.setVisible(true);
//				} catch (MissingValueException e) {
//					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);
//				} catch (BadCredentialsException e) {
//					JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.ERROR_MESSAGE);	
//				}
			}
		});
		
		FormaDugme btnIzlaz = new FormaDugme("Izlaz", clrPrimarna, clrForeground, 70, 30);
		btnIzlaz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		pnlPrijava.setBackground(clrPrimarna);
		pnlPrijava.setLayout(new MigLayout("", "[][]", "30[]20[]20[]10[]10[]"));
		
		pnlPrijava.add(lblNaslov, "wrap, span2, align center");
		pnlPrijava.add(lblImage, "wrap, span2, align center");
		pnlPrijava.add(lblKorIme, "gapleft 30");
		pnlPrijava.add(tfKorIme, "wrap, pushx, growx, gapright 30");
		pnlPrijava.add(lblLozinka, "gapleft 30");
		pnlPrijava.add(tfLozinka, "wrap, pushx, growx, gapright 30");
		pnlPrijava.add(btnPrijava, "span2, split2, align right");
		pnlPrijava.add(btnIzlaz, "gapright 30");
		add(pnlPrijava);
	}
	
	private void zatvori() {
		this.dispose();
	}
}
