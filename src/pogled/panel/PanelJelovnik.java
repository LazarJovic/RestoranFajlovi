package pogled.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import enums.Uloga;
import izuzeci.ResultEmptyException;
import kontroler.JeloKontroler;
import kontroler.TipJelaKontroler;
import model.JeloCena;
import model.PrijavljenKorisnik;
import model.podaci.TipJelaLista;
import net.miginfocom.swing.MigLayout;
import observer.Observer;
import pogled.FormaDugme;
import pogled.Labela;
import pogled.PadajucaLista;
import pogled.tabela.jelovnik.TabelaJelovnik;
import pogled.tabela.jelovnik.TabelaModelJelovnik;
import util.PogledUtil;

public class PanelJelovnik extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7893396793228337113L;
	private List<JeloCena> jelovnik;
	private JeloKontroler jeloKontroler;
	private TipJelaKontroler tipJelaKontroler;
	private String[] naziviTipovaJela = new String[] {"Rostilj", "Paste", "Supe"};
	
	private TabelaJelovnik tabelaJelovnik;

	public PanelJelovnik() {
		setName("Jelovnik");
		setVisible(true);

		Font fntNaslov = PogledUtil.getVelikiNaslovFont();
		Font fntTekstPolje = PogledUtil.getTeksPoljeFont();
		Color clrPrimarna = PogledUtil.getPrimarnaBoja();
		Color clrSekundarna = PogledUtil.getSekundarnaBoja();
		Color clrForeground = PogledUtil.getForegroundColor();
		
		setBackground(clrSekundarna);
		
		jeloKontroler = new JeloKontroler();
		tipJelaKontroler = new TipJelaKontroler();
		try {
			this.jelovnik = jeloKontroler.dobaviJelaSaCenama();
		} catch (ResultEmptyException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getNaslov(), JOptionPane.INFORMATION_MESSAGE);
		}
		Labela lblNaslov = new Labela("Jelovnik restorana", fntNaslov, clrForeground);
		
		JLabel lblImage = new JLabel("");
		lblImage.setPreferredSize(new Dimension(80, 80));
		Image image = new ImageIcon(this.getClass().getResource("/menu96.png")).getImage();
		lblImage.setIcon(new ImageIcon(image));
		
		this.naziviTipovaJela = tipJelaKontroler.dobaviNaziveTipovaJela();
		
		Labela lblTipJela = new Labela("Tip jela:", fntTekstPolje, clrForeground);
		PadajucaLista plTipoviZaposlenih = new PadajucaLista(naziviTipovaJela, 
				clrPrimarna, clrForeground, fntTekstPolje, 140, 30);
		
		//TODO: Vidljivo samo kada je sef kuhinje ulogovan
		//TODO: Dodaj action listener
		FormaDugme btnDodajJelo = new FormaDugme("Dodaj jelo", clrPrimarna, clrForeground, 150, 20);
		btnDodajJelo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				DijalogDodavanjeJela dijalogDodavanjeJela = new DijalogDodavanjeJela(jeloKontroler, naziviTipovaJela, (TabelaModelJelovnik) tabelaJelovnik.getModel());
//				dijalogDodavanjeJela.setVisible(true);
			}
		});
		
		FormaDugme btnPretrazi = new FormaDugme("Pretraži", clrPrimarna, clrForeground, 75, 20);
		
		setLayout(new MigLayout("", "80[]40[]", "90[]30[]40[]"));
		
		add(lblNaslov, "wrap, span2, align center");
		add(lblImage, "wrap, span2, align center");
		add(lblTipJela, "cell 0 2, align left");
		add(plTipoviZaposlenih, "cell 0 2, align left");
		add(btnPretrazi, "cell 0 2, gapleft 10, align left");
		add(btnDodajJelo, "cell 1 2, wrap, align right");
		if (PrijavljenKorisnik.getInstance().getUloga() != Uloga.SEF_KUHINJE) {
			btnDodajJelo.setVisible(false);

		}
		this.inicijalizujTabeluZaposlenih();
	}
	
	private void inicijalizujTabeluZaposlenih() {
		
		TabelaModelJelovnik tabelaModelJelovnik = new TabelaModelJelovnik(jelovnik);
		tabelaModelJelovnik.addObserver(this);
		this.tabelaJelovnik = new TabelaJelovnik(tabelaModelJelovnik);
		JScrollPane scrollPane = new JScrollPane(tabelaJelovnik);
		scrollPane.setPreferredSize(new Dimension(800, 500));
		
		add(scrollPane, "wrap, span2, align center");
		
		this.azurirajPrikaz();
	}
	
	private void azurirajPrikaz() {
		TabelaModelJelovnik model = (TabelaModelJelovnik) tabelaJelovnik.getModel();
		model.fireTableDataChanged();
		validate();
	}

	@Override
	public void updatePerformed(EventObject e) {
		//azurirajPrikaz();
	}
}
