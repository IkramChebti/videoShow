package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	public static void main(String[] args) throws IOException {
		
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// création de la fenêtre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// création de la zône de dessin dans la fenêtre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		
		// affiche la fenêtre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		Visage v = new Visage (d);
		d.ajouterObjet(v);	
		
		Forme f1 = new Etoile(40, 100, 50, 8.f, Color.RED, Color.YELLOW);
		Forme f2 = new PolygoneRegulier(3, 80, 10, 10, 4.0f, Color.DARK_GRAY, Color.GRAY);
		d.ajouterObjet(f1);
		d.ajouterObjet(f2);
		Forme f3 = new Etoile(350, 100, 50, 8.f, Color.GREEN, Color.GREEN);
		Forme f4 = new PolygoneRegulier(5, 240, 40, 40, 4.0f, Color.DARK_GRAY, Color.BLACK);
		d.ajouterObjet(f3);
		d.ajouterObjet(f4);
		
		MvtCirculaire m1 = new MvtCirculaire (100, 300, 300, 200, 100);
		 m1.deplacer(f1);
        MvtCirculaire m2 = new MvtCirculaire (130, 200, 300, 200, 150);
        m2.deplacer(f2);
        AnimationForme a1 = new AnimationForme(f1,m1);
		d.ajouterObjet(a1);
		AnimationForme a2 = new AnimationForme(f2,m2);
		d.ajouterObjet(a2);
		
		
		while(true) {
		// la zone de dessin se réaffiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//réaliser à tous les trains un déplacement élémentaire
		d.animer();
		
		}

	}

}
