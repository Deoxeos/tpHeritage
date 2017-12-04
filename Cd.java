
public class Cd extends Media{

	private String format; 
	
	public Cd(String auteur,String titre, String format) {
		super(auteur, titre);
		this.format = format; 
	}

	public String toString(){
		return super.toString() + " [" + this.format + "]";
	}
}
