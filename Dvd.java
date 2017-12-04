
public class Dvd extends Media {

	private int zones;
	
	public Dvd(String auteur,String titre, int zones) {
		super(auteur, titre);
		this.zones = zones;
	}

	public boolean readable(int[] zones) {
		boolean result = false;

		result = this.zones == 0;

		for (Integer current : zones) {
			if (current == this.zones)
				result = true;
		}

		return result;
	}
}
