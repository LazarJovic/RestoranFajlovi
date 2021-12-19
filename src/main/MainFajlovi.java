package main;

import java.io.IOException;

import izuzeci.ResultEmptyException;
import pogled.PrijavaProzor;
import serijalizacija.Serijalizacija;

public class MainFajlovi {

	public static void main(String[] args) throws IOException, ResultEmptyException {
		Serijalizacija serijalizacija = new Serijalizacija();
		serijalizacija.ucitaj();
		PrijavaProzor prijavaProzor = new PrijavaProzor();
		prijavaProzor.setVisible(true);
	}

}
