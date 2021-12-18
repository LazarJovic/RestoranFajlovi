package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.PrijavljenKorisnik;
import pogled.PrijavaProzor;
import pogled.meni.MeniFabrika;
import pogled.meni.MeniMenadzer;
import pogled.panel.PanelJelovnik;
import pogled.panel.PanelProfil;
import pogled.panel.PanelRezervacije;

public class PocetniProzorMenadzer extends PocetniProzor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -458287390081596178L;
	private MeniMenadzer meni;
	
	public PocetniProzorMenadzer() {
		this.setName("MenadzerPocetniProzor");
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniMenadzer) meniFabrika.napraviMeni("MENADZER");
		
		paneli = new ArrayList<>(
	            Arrays.asList(new PanelProfil(this),
	                          new PanelJelovnik(),
	                          new PanelRezervacije()));
		
		add(paneli.get(0), BorderLayout.CENTER);
		add(meni, BorderLayout.WEST);
		
		meni.getStavkaProfil().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Profil");
				osveziProzor();
			}
		});
		
		meni.getStavkaJelovnik().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Jelovnik");
				osveziProzor();
			}
		});
		
		meni.getStavkaRezervacije().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Rezervacije");
				osveziProzor();
			}
		});
		
		meni.getStavkaOdjava().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrijavljenKorisnik.setInstanceToNull();
				zatvori();
				PrijavaProzor prijavaProzor = new PrijavaProzor();
				prijavaProzor.setVisible(true);
			}
		});
	}
}
