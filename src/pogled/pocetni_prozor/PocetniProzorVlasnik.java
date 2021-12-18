package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.PrijavljenKorisnik;
import pogled.PrijavaProzor;
import pogled.meni.MeniFabrika;
import pogled.meni.MeniVlasnik;
import pogled.panel.PanelInfoRestorana;
import pogled.panel.PanelJelovnik;
import pogled.panel.PanelProfil;
import pogled.panel.PanelRezervacije;
import pogled.panel.PanelZahteviZaJelo;
import pogled.panel.PanelZaposleni;

public class PocetniProzorVlasnik extends PocetniProzor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6761965705200164299L;
	private MeniVlasnik meni;
	private PanelZaposleni panelZaposleni;
	
	public PocetniProzorVlasnik() {
		this.setName("VlasnikPocetniProzor");
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniVlasnik) meniFabrika.napraviMeni("VLASNIK");
		panelZaposleni = new PanelZaposleni();
		paneli = new ArrayList<>(
	            Arrays.asList(new PanelProfil(this),
	                          new PanelJelovnik(),
	                          panelZaposleni,
	                          new PanelZahteviZaJelo(),
	                          new PanelRezervacije(),
	                          new PanelInfoRestorana()));
		
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
		
		meni.getStavkaZaposleni().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("Zaposleni");
				osveziProzor();
			}
		});

		meni.getStavkaZahteviZaJelo().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("ZahteviZaJelo");
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
		
		meni.getStavkaInfoRestorana().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("InfoRestorana");
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
	
	public PanelZaposleni getPanelZaposleni() {
		return this.panelZaposleni;
	}
}
