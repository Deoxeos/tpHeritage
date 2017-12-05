import java.util.ArrayList;

public class Mediatheque {

	private ArrayList<Media> mediatheque;

	public void add(Media m) {
		mediatheque.add(m);
	}

	public ArrayList<Media> filtre(String critere, String valeur) throws ClassNotFoundException {

		ArrayList<Media> result = new ArrayList<Media>();

		for (Media current : this.mediatheque) {

			if (critere.toLowerCase().equals("media")) {
				
				valeur = valeur.substring(0,1).toUpperCase() + valeur.substring(1,valeur.length()).toLowerCase(); 
				
				if (Class.forName(valeur).isInstance(current)) {
					result.add(current);
				}
			} else {
				if (critere.toLowerCase().equals("auteur")) {
					if (current.toString().toLowerCase().split("\"")[2].contains(valeur.toLowerCase())) {
						result.add(current);
					}
				}

				if (critere.toLowerCase().equals("titre")) {
					if (current.toString().toLowerCase().split("\"")[1].contains(valeur.toLowerCase())) {

						result.add(current);
					}
				}
			}
		}
		return result;
	}

	public Mediatheque() {
		this.mediatheque = new ArrayList<Media>();
	}

}
