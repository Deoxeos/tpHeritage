import java.util.ArrayList;

public class Media {

	private String titre;
	private String auteur;
	private ArrayList<Integer> notes;

	public Media(String auteur, String titre) {
		this.titre = titre;
		this.auteur = auteur;
		this.notes = new ArrayList<Integer>();
	}

	public String toString() {
		return ("\"" + this.titre + "\" par " + this.auteur);
	}

	
	 //La fonction vote() renvoie un boolean pour les besoins du test testVote() de la classe TestMedia
	public boolean vote(int note) {
		boolean aVote = false;

		if (0 <= note && note <= 5) {
			notes.add(note);
			aVote = true;
		}
		return aVote;
	}

	public float moyenneNotes() {
		float result = 0;
		int sum = 0;

		if (this.notes.size() > 0) {
			for (Integer current : this.notes) {
				sum += current;
			}
			result = (float) sum / this.notes.size();
		}
		return result;
	}
}
