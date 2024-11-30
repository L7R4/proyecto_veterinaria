import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {
    private JPanel panelIzquierdo;
    private JPanel panelDerecho;

    public Dashboard() {
        setTitle("Sistema Veterinaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Panel izquierdo
        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        JButton btnAdmin = new JButton("Administración");
        panelIzquierdo.add(btnAdmin);
        add(panelIzquierdo, BorderLayout.WEST);

        // Panel derecho
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout());
        JLabel etiqueta = new JLabel("Bienvenido al sistema");
        panelDerecho.add(etiqueta, BorderLayout.CENTER);
        add(panelDerecho, BorderLayout.CENTER);

        // Evento para abrir CRUD
        btnAdmin.addActionListener((ActionEvent e) -> abrirAdmin());
    }

    private void abrirAdmin() {
        panelDerecho.removeAll();
        JButton btnClientes = new JButton("Clientes");
        JButton btnEmpleados = new JButton("Empleados");

        panelDerecho.add(btnClientes, BorderLayout.NORTH);
        panelDerecho.add(btnEmpleados, BorderLayout.SOUTH);

        btnClientes.addActionListener(e -> mostrarLista("Clientes"));
        btnEmpleados.addActionListener(e -> mostrarLista("Empleados"));

        panelDerecho.revalidate();
        panelDerecho.repaint();
    }

    private void mostrarLista(String tipo) {
        panelDerecho.removeAll();
        JLabel titulo = new JLabel("Datos de " + tipo);
        panelDerecho.add(titulo, BorderLayout.NORTH);
        // Aquí agregarías el manejo para mostrar la lista específica
        panelDerecho.revalidate();
        panelDerecho.repaint();
    }

    public static void main(String[] args) {
        new Dashboard().setVisible(true);
    }
}
