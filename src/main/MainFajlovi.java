package main;

import java.io.IOException;

import pogled.PrijavaProzor;
import serijalizacija.Serijalizacija;

public class MainFajlovi {

	public static void main(String[] args) throws IOException {
		Serijalizacija serijalizacija = new Serijalizacija();
		serijalizacija.ucitaj();
		PrijavaProzor prijavaProzor = new PrijavaProzor();
		prijavaProzor.setVisible(true);
	}

}
