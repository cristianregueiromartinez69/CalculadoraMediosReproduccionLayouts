package calculadorasimpleconlayouts;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame {
    private JButton sumar;
    private JButton restar;
    private JButton multiplicar;
    private JButton dividir;
    private JButton raiz_cuadrada;
    private JButton raiz_cubica;
    private JButton confirmar;
    private JButton borrar;
    private JButton numero1;
    private JButton numero2;
    private JButton numero3;
    private JButton numero4;
    private JButton numero5;
    private JButton numero6;
    private JButton numero7;
    private JButton numero8;
    private JButton numero9;
    private JButton numero0;
    private JTextArea resultado;
    private JPanel areaOperaciones;
    private JPanel numerosYOperaciones;
    private JPanel aeraResultado;
    private JPanel operacionesEspeciales;
    private long numero;
    String texto_boton = null;

    public Calculadora() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 500));

        areaOperaciones = new JPanel();
        areaOperaciones.setLayout(new BorderLayout());
        add(areaOperaciones, BorderLayout.CENTER);

        numerosYOperaciones = new JPanel(new GridLayout(4, 4));
        areaOperaciones.add(numerosYOperaciones, BorderLayout.CENTER);

        // Botones del panel numerosYOperaciones
        numero0 = new JButton("0");
        numerosYOperaciones.add(numero0);
        numero1 = new JButton("1");
        numerosYOperaciones.add(numero1);
        numero2 = new JButton("2");
        numerosYOperaciones.add(numero2);
        numero3 = new JButton("3");
        numerosYOperaciones.add(numero3);
        numero4 = new JButton("4");
        numerosYOperaciones.add(numero4);
        numero5 = new JButton("5");
        numerosYOperaciones.add(numero5);
        numero6 = new JButton("6");
        numerosYOperaciones.add(numero6);
        numero7 = new JButton("7");
        numerosYOperaciones.add(numero7);
        numero8 = new JButton("8");
        numerosYOperaciones.add(numero8);
        numero9 = new JButton("9");
        numerosYOperaciones.add(numero9);

        sumar = new JButton("+");
        numerosYOperaciones.add(sumar);
        restar = new JButton("-");
        numerosYOperaciones.add(restar);
        multiplicar = new JButton("x");
        numerosYOperaciones.add(multiplicar);
        dividir = new JButton("/");
        numerosYOperaciones.add(dividir);
        raiz_cuadrada = new JButton("√");
        numerosYOperaciones.add(raiz_cuadrada);
        raiz_cubica = new JButton("∛");
        numerosYOperaciones.add(raiz_cubica);
        confirmar = new JButton("=");

        borrar = new JButton("C");

        aeraResultado = new JPanel();
        aeraResultado.setLayout(new BorderLayout());
        areaOperaciones.add(aeraResultado, BorderLayout.NORTH);

        resultado = new JTextArea();
        resultado.setEditable(false);
        resultado.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(resultado);
        aeraResultado.add(scrollPane, BorderLayout.CENTER);
        operacionesEspeciales = new JPanel();
        operacionesEspeciales.setLayout(new BoxLayout(operacionesEspeciales, BoxLayout.X_AXIS));
        operacionesEspeciales.add(confirmar);
        operacionesEspeciales.add(borrar);
        areaOperaciones.add(operacionesEspeciales, BorderLayout.EAST);

        sumar.addActionListener(e -> sumar());
        restar.addActionListener(e -> restar());
        multiplicar.addActionListener(e -> multiplicar());
        dividir.addActionListener(e -> dividir());
        raiz_cuadrada.addActionListener(e -> raizCuadrada());
        raiz_cubica.addActionListener(e -> raizCubica());
        confirmar.addActionListener(e -> IgualA());
        borrar.addActionListener(e -> eliminacion());

        numero0.addActionListener(e -> agregarNumero(0));
        numero1.addActionListener(e -> agregarNumero(1));
        numero2.addActionListener(e -> agregarNumero(2));
        numero3.addActionListener(e -> agregarNumero(3));
        numero4.addActionListener(e -> agregarNumero(4));
        numero5.addActionListener(e -> agregarNumero(5));
        numero6.addActionListener(e -> agregarNumero(6));
        numero7.addActionListener(e -> agregarNumero(7));
        numero8.addActionListener(e -> agregarNumero(8));
        numero9.addActionListener(e -> agregarNumero(9));

        pack();
        setLocationRelativeTo(null);
    }

    private void agregarNumero(int num) {
        resultado.append(String.valueOf(num));
    }

    private void sumar() {
        resultado.append(" + ");
    }

    private void restar() {
        resultado.append(" - ");
    }

    private void multiplicar() {
        resultado.append(" * ");
    }

    private void dividir() {
        resultado.append(" / ");
    }

    private void raizCuadrada() {
        resultado.append(" √ ");
    }

    private void raizCubica() {
        resultado.append(" ∛ ");
    }

    private void IgualA() {

        try {
            String expresion = resultado.getText();
            String[] numerosYOperadores = expresion.split(" ");
            double resultado = Double.parseDouble(numerosYOperadores[0]);
            for (int i = 1; i < numerosYOperadores.length; i += 2) {
                String operador = numerosYOperadores[i];
                double siguienteNumero = Double.parseDouble(numerosYOperadores[i + 1]);
                switch (operador) {
                    case "+":
                        resultado += siguienteNumero;
                        break;
                    case "-":
                        resultado -= siguienteNumero;
                        break;
                    case "*":
                        resultado *= siguienteNumero;
                        break;
                    case "/":
                        resultado /= siguienteNumero;
                        break;
                    case "√":
                        resultado = Math.sqrt(resultado);
                        break;
                    case "∛":
                        resultado = Math.cbrt(resultado);
                        break;
                }
            }
            this.resultado.setText(String.valueOf(resultado));
        } catch (Exception e) {
            this.resultado.setText("Error");
        }
    }

    private void eliminacion() {
        resultado.setText("");
    }

   
}
