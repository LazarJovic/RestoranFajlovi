package enums;

public enum Uloga {
	VLASNIK {
		public String toString() {
			return "Vlasnik";
		}
	},
	MENADZER {
		public String toString() {
			return "Menadžer";
		}
	},
	SEF_KUHINJE {
		public String toString() {
			return "Šef kuhinje";
		}
	},
	KONOBAR {
		public String toString() {
			return "Konobar";
		}
	}
}
