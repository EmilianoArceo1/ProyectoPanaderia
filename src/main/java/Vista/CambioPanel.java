package Vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioPanel extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public CambioPanel() {
        // Configuración básica del JFrame
        setTitle("Cambio de Panel con JButton");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear el CardLayout y aplicarlo en el mainPanel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Crear los paneles
        JPanel panel1 = crearPanel1();
        JPanel panel2 = crearPanel2();

        // Agregar los paneles al mainPanel, con identificadores
        mainPanel.add(panel1, "panel1");
        mainPanel.add(panel2, "panel2");

        // Agregar el mainPanel al JFrame
        add(mainPanel);

        // Mostrar el primer panel inicialmente
        cardLayout.show(mainPanel, "panel1");
    }

    private JPanel crearPanel1() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setLayout(new BorderLayout());
        
        JLabel label = new JLabel("Panel 1", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // Botón para cambiar al Panel 2
        JButton boton = new JButton("Ir al Panel 2");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar al Panel 2 al hacer clic
                cardLayout.show(mainPanel, "panel2");
            }
        });
        panel.add(boton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel crearPanel2() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Panel 2", SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        // Botón para volver al Panel 1
        JButton boton = new JButton("Volver al Panel 1");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cambiar al Panel 1 al hacer clic
                cardLayout.show(mainPanel, "panel1");
            }
        });
        panel.add(boton, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CambioPanel frame = new CambioPanel();
            frame.setVisible(true);
        });
    }
}
