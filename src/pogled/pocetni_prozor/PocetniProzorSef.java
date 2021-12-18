package pogled.pocetni_prozor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.PrijavljenKorisnik;
import pogled.PrijavaProzor;
import pogled.meni.MeniFabrika;
import pogled.meni.MeniSefKuhinje;
import pogled.panel.PanelJelovnik;
import pogled.panel.PanelProfil;
import pogled.panel.PanelTipoviJela;
import pogled.panel.PanelZahteviZaJelo;

public class PocetniProzorSef extends PocetniProzor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5303103792307993741L;
	private MeniSefKuhinje meni;
	
	public PocetniProzorSef() {
		this.setName("SefPocetniProzor");
		MeniFabrika meniFabrika = new MeniFabrika();
		meni = (MeniSefKuhinje) meniFabrika.napraviMeni("SEF_KUHINJE");
		paneli = new ArrayList<>(
	            Arrays.asList(new PanelProfil(this),
	                          new PanelJelovnik(),
	                          new PanelTipoviJela(),
	                          new PanelZahteviZaJelo()));
		
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
		
		meni.getStavkaTipoviJela().getDugmeStavke().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				postaviPanel("TipoviJela");
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
