package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import datos.Jugador;
import datos.MusicaAdmi;
import datos.Niveles;
import operaciones.OperacionesJugador;
import operaciones.ValoresJuego;
import recursos.Fuentes;

public class VentanaJuego extends JPanel {

    private MusicaAdmi music;
    private javax.swing.Timer animacion;
    private int contador = 0;
    private int[] resultadoFinal;
    private int slotW = 140;
    private int slotH = 200;
    private JLabel lblDeuda;
    
    // NUEVO
    private Jugador jugador;

    // CONSTRUCTOR NUEVO (recibe jugador)
    public VentanaJuego(MusicaAdmi music, Jugador jugador) {
        this.music = music;
        this.jugador = jugador;
        music.detenerMusica();
        setLayout(null);
        setBackground(Color.decode("#1e1e1e"));

        Dimension d = new Dimension(1020, 550);
        setPreferredSize(d);
        
        inicializarComponentes();
        music.Sonarmusica("/musica/Juego.wav");
    }

    // CONSTRUCTOR VIEJO (para que todo siga funcionando igual)
    public VentanaJuego(MusicaAdmi music) {
        this(music, null);
    }

    private void inicializarComponentes() {
        if (jugador == null) {
            jugador = new Jugador();
        }
       
        if (jugador.getNombre() == null) {
        JDialog nomb = new JDialog((java.awt.Frame) null, "ZOMBIEZPIN - REGISTRO", true);
        nomb.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        VentanaNombre requiNombre = new VentanaNombre(music, jugador, "");
        nomb.setContentPane(requiNombre);
        nomb.setSize(460, 420);
        nomb.setLocationRelativeTo(null);
        nomb.setVisible(true);
}

        // PANEL PRINCIPAL DEL JUEGO
        JLabel img4 = new JLabel();
        JLabel img5 = new JLabel();
        JLabel img6 = new JLabel();
        JPanel panelJ = new JPanel() {

            private Image fondoOriginal = new ImageIcon(
                getClass().getResource("/images/Tragamonedas.png")
            ).getImage();
            private Image fondoEscalado = fondoOriginal.getScaledInstance(1020, 550, Image.SCALE_SMOOTH);
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(fondoEscalado, 0, 0, this);
            }
        };
        panelJ.setLayout(null);
        panelJ.setBounds(0, 0, 1020, 550);
        add(panelJ);

        // LABEL NIVEL (TEXTO FIJO) 
        JLabel lblNivel = new JLabel("NIVEL №");
        lblNivel.setBounds(790, 10, 145, 60);
        lblNivel.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 42));
        lblNivel.setForeground(Color.decode("#e688c6"));
        lblNivel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNivel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblNivel);

        JLabel lblNivelValor = new JLabel(String.valueOf(jugador.getNivel()));
        lblNivelValor.setBounds(950, 12, 80, 60);
        lblNivelValor.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 30));
        lblNivelValor.setForeground(Color.decode("#e688c6"));
        panelJ.add(lblNivelValor);
        

        // LABEL APUESTA (TEXTO FIJO) 
        JLabel lblApuesta = new JLabel("APUEZTA");
        lblApuesta.setBounds(820, 80, 135, 60);
        lblApuesta.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 40));
        lblApuesta.setForeground(Color.decode("#c8ff00"));
        lblApuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApuesta.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblApuesta);

        // LABEL APUESTAMINIMA (TEXTO FIJO) 
        JLabel lblApuestaM = new JLabel("APUEZTA MINIMA  10");
        lblApuestaM.setBounds(820, 160, 130, 60);
        lblApuestaM.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 13));
        lblApuestaM.setForeground(Color.decode("#c8ff00"));
        lblApuestaM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApuestaM.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblApuestaM);

        
        //SOL DE APUESTA MINIMA
        JLabel sol = new JLabel();
        ImageIcon icon = new ImageIcon(
            getClass().getResource("/images/Estrella.png")
        );
        Image img = icon.getImage().getScaledInstance(
            20, 20, Image.SCALE_SMOOTH
        );
        sol.setIcon(new ImageIcon(img));
        sol.setBounds(950, 178, 20, 20);
        panelJ.add(sol);

        //SOL DE CANTIDAD
        JLabel sol2 = new JLabel();
        ImageIcon icon2 = new ImageIcon(
            getClass().getResource("/images/Estrella.png")
        );
        Image img2 = icon2.getImage().getScaledInstance(
            50, 50, Image.SCALE_SMOOTH
        );
        sol2.setIcon(new ImageIcon(img2));
        sol2.setBounds(10, 20, 50, 50);
        panelJ.add(sol2);

        //SOL DE DEUDA
        JLabel sol3 = new JLabel();
        ImageIcon icon3 = new ImageIcon(
            getClass().getResource("/images/Estrella.png")
        );
        Image img3 = icon3.getImage().getScaledInstance(
            50, 50, Image.SCALE_SMOOTH
        );
        sol3.setIcon(new ImageIcon(img3));
        sol3.setBounds(700, 453, 50, 50);
        panelJ.add(sol3);


        // ====== CAMPO DONDE EL USUARIO ESCRIBE ======
        JTextField valorApuesta = new JTextField();
        valorApuesta.setBounds(810, 130, 150, 40);
        valorApuesta.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 20));
        valorApuesta.setForeground(Color.decode("#e688c6"));
        valorApuesta.setBackground(Color.decode("#2e2e2e"));
        //CENTRAR TEXTO
        valorApuesta.setHorizontalAlignment(JTextField.CENTER);

        valorApuesta.setBorder(null);valorApuesta.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#c8ff00"), 2),
            javax.swing.BorderFactory.createEmptyBorder(0, 10, -10, 10)
        )
        ); 
        panelJ.add(valorApuesta);

        // ====== BOTÓN JUGAR ======
        JButton jugar = new JButton("JUGAR");
        jugar.setBounds(810, 240, 150, 150);
        jugar.setBackground(Color.decode("#2e2e2e"));
        jugar.setForeground(Color.decode("#277717"));
        jugar.setBorder(null);jugar.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#277717"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        );
        jugar.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 45));
        jugar.setFocusPainted(false);
        panelJ.add(jugar);

        //medidas de los iconos
        img4.setBounds(270, 190, slotW, slotH);
        img5.setBounds(440, 190, slotW, slotH);
        img6.setBounds(600, 190, slotW, slotH);

        panelJ.add(img4);
        panelJ.add(img5);
        panelJ.add(img6);

        // ====== BOTÓN DETALLES ======
        JButton detalles = new JButton("----");
        detalles.setBounds(20, 460, 40, 40);
        detalles.setBackground(Color.decode("#2e2e2e"));
        detalles.setForeground(Color.decode("#299c4f"));
        detalles.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 15));
        detalles.setFocusPainted(false);
        panelJ.add(detalles);

        // LABEL SALDO MOSTRAR (TEXTO VARIABLE) 
        JLabel saldoJLabel = new JLabel();
        saldoJLabel.setText(String.valueOf(jugador.getSaldo()));
        saldoJLabel.setBounds(30, 20, 140, 60);
        saldoJLabel.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 30));
        saldoJLabel.setForeground(Color.decode("#c8ff00"));
        saldoJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoJLabel.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(saldoJLabel);

        // LABEL DETALLES (TEXTO FIJO) 
        JLabel lblDetalles = new JLabel("DETALLEZ");
        lblDetalles.setBounds(15, 450, 225, 60);
        lblDetalles.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 30));
        lblDetalles.setForeground(Color.decode("#299c4f"));
        lblDetalles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDetalles.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        panelJ.add(lblDetalles);

        // ====== BOTÓN PAGAR DEUDA ======
        JButton pagarDeuda = new JButton("PAGAR DEUDA");
        pagarDeuda.setBounds(765, 450, 200, 50);
        pagarDeuda.setBackground(Color.decode("#2e2e2e"));
        pagarDeuda.setForeground(Color.decode("#299c4f"));
        pagarDeuda.setFont(Fuentes.loadFont("/fonts/StormGust.ttf", 30));
        pagarDeuda.setFocusPainted(false);
        pagarDeuda.setBorder(null);pagarDeuda.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#299c4f"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        );
        panelJ.add(pagarDeuda);

        //Deuda Label
        Niveles nivelInfo = new Niveles(jugador.getNivel());
        lblDeuda = new JLabel(String.valueOf(nivelInfo.getDeuda()));
        lblDeuda.setBounds(550, 450, 250, 60);
        lblDeuda.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 25));
        lblDeuda.setForeground(Color.decode("#c8ff00"));
        panelJ.add(lblDeuda);

        pagarDeuda.addActionListener(e -> {
            // 1. Primero calculamos la deuda actual para validar si puede pagar
            Niveles nivelActual = new Niveles(jugador.getNivel());
            int deuda = nivelActual.getDeuda();
            if (jugador.getSaldo() < deuda) {
                javax.swing.JOptionPane.showMessageDialog(this,
                        "No tienes suficiente saldo para pagar la deuda de " + deuda);
                return;
            }
            // 2. Ejecutamos la lógica de pago y subida de nivel
            jugador.setSaldo(jugador.getSaldo() - deuda);
            jugador.setNivel(jugador.getNivel() + 1); // Ahora el jugador es nivel N+1
            OperacionesJugador.guardar(jugador);
            // 3. IMPORTANTE: Creamos una nueva instancia con el NUEVO nivel 
            // para obtener el cálculo de la deuda siguiente
            Niveles siguienteNivel = new Niveles(jugador.getNivel());
            // 4. Actualizamos la UI con los valores post-cambio
            saldoJLabel.setText(String.valueOf(jugador.getSaldo()));
            lblNivelValor.setText(String.valueOf(jugador.getNivel()));
            lblDeuda.setText(String.valueOf(siguienteNivel.getDeuda())); // <- Aquí ya tienes el valor nuevo
            panelJ.revalidate();
            panelJ.repaint();
            javax.swing.JOptionPane.showMessageDialog(this,
                    "¡Subiste de nivel! Ahora eres nivel " + jugador.getNivel());
        });
    

        // ====== BOTÓN GUARDAR ======
        JButton guardar = new JButton("GUARDAR");
        guardar.setBounds(20, 420, 90, 25);
        guardar.setBackground(Color.decode("#2e2e2e"));
        guardar.setForeground(Color.decode("#00bdbd"));
        guardar.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 10));
        guardar.setFocusPainted(false);
                guardar.setBorder(null);guardar.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#00bdbd"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        );
        panelJ.add(guardar);

        guardar.addActionListener(e -> {
        OperacionesJugador.guardar(jugador);
        javax.swing.JOptionPane.showMessageDialog(this, "Partida guardada");
        });

        // ====== BOTÓN MENU ======
        JButton meButton = new JButton("MENU");
        meButton.setBounds(20, 380, 90, 25);
        meButton.setBackground(Color.decode("#2e2e2e"));
        meButton.setForeground(Color.decode("#e688c6"));
        meButton.setFont(Fuentes.loadFont("/fonts/CurseoftheZombie.ttf", 10));
        meButton.setFocusPainted(false);
                meButton.setBorder(null);meButton.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(Color.decode("#e688c6"), 2),
            javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
        )
        );
        panelJ.add(meButton);

        meButton.addActionListener(e -> {
        music.detenerMusica();
        music.Sonarmusica("/musica/Menu.wav");
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
        });
        

        // ABRIR VENTANA VALORES (JDialog)
        detalles.addActionListener(e -> {
        java.awt.Window owner = javax.swing.SwingUtilities.getWindowAncestor(this);
            VentanaValores v = new VentanaValores(owner);
        }); 
            
        // Funcionar Boton jugar
        jugar.addActionListener(e -> {
            jugar.setEnabled(false);
            String veri = valorApuesta.getText();
                if (veri == null || veri.trim().isEmpty()) {
                    jugar.setEnabled(true);
                    return;
                }
            double apuesta;
            try {
                apuesta = Double.parseDouble(valorApuesta.getText());
            } catch (Exception ex) {
                return;
            }

            if ((apuesta<10)||(jugador.getSaldo() < apuesta)){ 
                jugar.setEnabled(true);
                return;
            }
            jugador.setSaldo(jugador.getSaldo() - (int) apuesta);
            saldoJLabel.setText(String.valueOf(jugador.getSaldo()));
            ValoresJuego juego = new ValoresJuego();
            resultadoFinal = juego.jugar();
            contador = 0;
            animacion = new javax.swing.Timer(120, ev -> {
                int r1 = (int)(Math.random() * 4) + 1;
                int r2 = (int)(Math.random() * 4) + 1;
                int r3 = (int)(Math.random() * 4) + 1;
                img4.setIcon(getImagen(r1));
                img5.setIcon(getImagen(r2));
                img6.setIcon(getImagen(r3));
                contador++;
                if (contador >= 10) {
                    animacion.stop();
                    img4.setIcon(getImagen(resultadoFinal[0]));
                    img5.setIcon(getImagen(resultadoFinal[1]));
                    img6.setIcon(getImagen(resultadoFinal[2]));
                    int a = resultadoFinal[0];
                    int b = resultadoFinal[1];
                    int c = resultadoFinal[2];
                    double ganancia=0;
                    if (a == b && b == c) {
                    ganancia = juego.calcularResultado(a, apuesta);
                    jugador.setSaldo(jugador.getSaldo() + (int) ganancia);
                    jugar.setEnabled(true);
                }
                // 2 iguales (premio 2)
                else if (a == b) {
                    ganancia = juego.calcularResultado2(a, apuesta);
                    jugador.setSaldo(jugador.getSaldo() + (int) ganancia);
                    jugar.setEnabled(true);
                }
                saldoJLabel.setText(String.valueOf(jugador.getSaldo()));
                jugar.setEnabled(true);
                }
            });

            animacion.start();
        });
    }
    private ImageIcon getImagen(int valor) {

    return switch (valor) {

        case 1 -> escalar("/images/girasol.png", slotW, slotH);
        case 2 -> escalar("/images/hongo.png", slotW, slotH);
        case 3 -> escalar("/images/michael.png", slotW, slotH);
        case 4 -> escalar("/images/faraon.png", slotW, slotH);

        default -> null;
    };
}
    private ImageIcon escalar(String ruta, int w, int h) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
        Image img = icon.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
}