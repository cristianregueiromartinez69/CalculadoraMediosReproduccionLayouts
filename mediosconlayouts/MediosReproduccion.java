
package mediosconlayouts;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediosReproduccion extends JFrame {
	private JPanel panelBotonesPlayPauseStop;
	private JPanel panelPistas;
	private JPanel panelPrincipal;
	private JButton play;
	private JButton pause;
	private JButton stop;
	private JButton musica1;
	private JButton musica2;
	private JButton musica3;
	private JButton musica4;
	private JButton musica5;
	private JButton acelerarMusica;
	private JButton revovinarMusica;
	private JPanel progresoMusica;
	private JProgressBar barraProgresoMusica;
	private Timer timer;
	private JTextArea infoCambiosReproductor;

	public MediosReproduccion() {
		setTitle("Reproductor Musical");
		setVisible(true);
		setPreferredSize(new Dimension(600, 700));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());
		add(panelPrincipal, BorderLayout.CENTER);

		panelBotonesPlayPauseStop = new JPanel();
		panelBotonesPlayPauseStop.setLayout(new BoxLayout(panelBotonesPlayPauseStop, BoxLayout.X_AXIS));
		panelPrincipal.add(panelBotonesPlayPauseStop, BorderLayout.SOUTH);

		play = new JButton("|>");
		panelBotonesPlayPauseStop.add(play);
		pause = new JButton("||");
		panelBotonesPlayPauseStop.add(pause);
		stop = new JButton("[]");
		panelBotonesPlayPauseStop.add(stop);

		panelPistas = new JPanel();
		panelPistas.setLayout(new GridLayout(4, 4));
		panelPrincipal.add(panelPistas, BorderLayout.CENTER);

		musica1 = new JButton("Stay");
		panelPistas.add(musica1);
		musica2 = new JButton("Montero (Call Me By Your Name)");
		panelPistas.add(musica2);
		musica3 = new JButton("Good 4 U");
		panelPistas.add(musica3);
		musica4 = new JButton("Levitating");
		panelPistas.add(musica4);
		musica5 = new JButton("Blinding Lights");
		panelPistas.add(musica5);
		acelerarMusica = new JButton(">>");
		panelPistas.add(acelerarMusica);
		revovinarMusica = new JButton("<<");
		panelPistas.add(revovinarMusica);

		progresoMusica = new JPanel();
		progresoMusica.setLayout(new BorderLayout());
		panelPrincipal.add(progresoMusica, BorderLayout.NORTH);

		barraProgresoMusica = new JProgressBar();
		barraProgresoMusica.setMinimum(0);
		barraProgresoMusica.setMaximum(100);
		barraProgresoMusica.setStringPainted(true);
		progresoMusica.add(barraProgresoMusica);
		infoCambiosReproductor = new JTextArea();
		infoCambiosReproductor.setEditable(false);
		panelPistas.add(infoCambiosReproductor);

		play.addActionListener(this::actionPerformed);
		pause.addActionListener(this::actionPerformed);
		stop.addActionListener(this::actionPerformed);
		acelerarMusica.addActionListener(this::actionPerformed);
		revovinarMusica.addActionListener(this::actionPerformed);

		musica1.addActionListener(this::cambioPista);
		musica2.addActionListener(this::cambioPista);
		musica3.addActionListener(this::cambioPista);
		musica4.addActionListener(this::cambioPista);
		musica5.addActionListener(this::cambioPista);

		pack();
		setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == play) {
			if (timer == null) {
				timer = new Timer(700, new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						int value = barraProgresoMusica.getValue();
						if (value < 100) {
							barraProgresoMusica.setValue(value + 1);
							infoCambiosReproductor.setText("reproduciendose");

						} else {
							timer.stop();
							barraProgresoMusica.setValue(0);
							infoCambiosReproductor.setText("cancion terminada");
						}
					}
				});
			}
			timer.start();
		} else if (e.getSource() == pause) {
			if (timer != null) {
				timer.stop();
				infoCambiosReproductor.setText("cancion pausada");
			}
		} else if (e.getSource() == stop) {
			if (timer != null) {
				timer.stop();
				barraProgresoMusica.setValue(0);
				infoCambiosReproductor.setText("cancion desde 0");
			}
		} else if (e.getSource() == acelerarMusica) {
			int value = barraProgresoMusica.getValue();
			if (value < 100) {
				barraProgresoMusica.setValue(value + 5);
				infoCambiosReproductor.setText("cancion acelerandose");
			}
		} else if (e.getSource() == revovinarMusica) {
			int value = barraProgresoMusica.getValue();
			if (value > 0) {
				barraProgresoMusica.setValue(value - 5);
				infoCambiosReproductor.setText("cancion revovinandose");
			}
		}
	}

	public void cambioPista(ActionEvent e) {

		if (timer != null) {
			timer.stop();
			barraProgresoMusica.setValue(0);
		}

		if (e.getSource() == musica1) {
			String cancion1 = "Stay";
			infoCambiosReproductor.setText("Cancion " + cancion1 + " seleccionada, pulsa |> para reproducir");
		} else if (e.getSource() == musica2) {
			String cancion2 = "Montero (Call Me By Your Name)";
			infoCambiosReproductor.setText("Cancion " + cancion2 + " seleccionada, pulsa |> para reproducir");

		} else if (e.getSource() == musica3) {
			String cancion3 = "Good 4 U";
			infoCambiosReproductor.setText("Cancion " + cancion3 + " seleccionada, pulsa |> para reproducir");

		} else if (e.getSource() == musica4) {
			String cancion4 = "Levitating";
			infoCambiosReproductor.setText("Cancion " + cancion4 + " seleccionada, pulsa |> para reproducir");

		} else if (e.getSource() == musica5) {
			String cancion5 = "Blinding Lights";
			infoCambiosReproductor.setText("Cancion " + cancion5 + " seleccionada, pulsa |> para reproducir");

		}
	}

}
