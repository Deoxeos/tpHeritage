import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestMedia {

	@Test
	public void testFiltre() throws ClassNotFoundException {

		Mediatheque mediatheque = new Mediatheque();
		Cd Cd1 = new Cd("Jules Edouard", "Mr Mojo Rising", "MP3");
		Dvd Dvd1 = new Dvd("Bastien Pujos", "Into The Wild", 0);
		Livre livre1 = new Livre("Jeremy Hoarau", "Harry Potter et la Chambre des Secrets");
		Cd Cd2 = new Cd("Solal Edouard", "Wild Horses", "Cd Musical");
		mediatheque.add(Cd1);
		mediatheque.add(Cd2);
		mediatheque.add(Dvd1);
		mediatheque.add(livre1);

		ArrayList<Media> expected = new ArrayList<Media>();
		expected.add(Cd1);
		expected.add(Cd2);
		assertEquals(expected, mediatheque.filtre("AUTEUR", "Edouard"));

		ArrayList<Media> expected2 = new ArrayList<Media>();
		expected2.add(Cd2);
		assertEquals(expected2, mediatheque.filtre("titre", "wild horses"));

		ArrayList<Media> expected3 = new ArrayList<Media>();
		expected3.add(livre1);
		assertEquals(expected3, mediatheque.filtre("auteur", "jeremy"));

		ArrayList<Media> expected4 = new ArrayList<Media>();
		expected4.add(livre1);
		assertEquals(expected4, mediatheque.filtre("media", "Livre"));

		ArrayList<Media> expected5 = new ArrayList<Media>();
		expected5.add(Cd1);
		expected5.add(Cd2);
		assertEquals(expected5, mediatheque.filtre("media", "cd"));

		ArrayList<Media> expected6 = new ArrayList<Media>();
		expected6.add(Dvd1);
		assertEquals(expected6, mediatheque.filtre("media", "DVD"));
	}

	@Test
	public void testMoyenneVotes() {
		Media media = new Media("Julow", "Try");
		media.vote(-1);
		media.vote(0);
		media.vote(1);
		media.vote(2);
		media.vote(3);
		media.vote(4);
		media.vote(5);
		media.vote(6);

		assertEquals(2.5, media.moyenneNotes(), 0.0001);

		Media media2 = new Media("Julow", "Try");

		assertEquals(0, media2.moyenneNotes(), 0.0001);

		Media media3 = new Media("Julow", "Try");
		media3.vote(-1);
		media3.vote(150);

		assertEquals(0, media3.moyenneNotes(), 0.0001);
	}

	@Test
	public void testToString() {
		Livre livre = new Livre("Otomai", "Le Pourpre");
		assertEquals("\"Le Pourpre\" par Otomai", livre.toString());

		Cd cd = new Cd("Khaled", "Blueberry", "Cd Musical");
		assertEquals("\"Blueberry\" par Khaled [Cd Musical]", cd.toString());

		Dvd dvd = new Dvd("Steven Spilbeirg", "E.T", 0);
		assertEquals("\"E.T\" par Steven Spilbeirg", dvd.toString());
	}

	@Test
	public void testReadable() {

		Dvd dvd = new Dvd("Steven Spilbeirg", "E.T", 0);
		assertEquals(true, dvd.readable(new int[] { 0, 1, 2, 3, 4 }));

		Dvd dvd2 = new Dvd("Steven Spilbeirg", "E.T", 5);
		assertEquals(false, dvd2.readable(new int[] { 0, 1, 2, 3, 4 }));

		Dvd dvd3 = new Dvd("Steven Spilbeirg", "E.T", 5);
		assertEquals(false, dvd3.readable(new int[] {}));

		Dvd dvd4 = new Dvd("Steven Spilbeirg", "E.T", 0);
		assertEquals(true, dvd4.readable(new int[] {}));
	}

	@Test
	public void testVote() {

		Livre livre = new Livre("Jules Verne", "20.000 Lieux sous les mers");
		assertEquals(false, livre.vote(-5));
		assertEquals(true, livre.vote(2)); // La fonction vote() renvoie un boolean pour les besoins de ces tests
		assertEquals(false, livre.vote(10));
	}
}
