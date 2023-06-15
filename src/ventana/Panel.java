package ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Panel extends JFrame implements ActionListener {
	private JTextField nombre;
	private JTextField apellido;
	private JTextField edad;
	private JTextField telefono;
	private JTextField tipo;
	private JTextField nombreProducto;
	private JTextField valorUnitario;
	private JTextField cantidad;
	private JLabel descuentoLabel;
	private JLabel valorUnitarioLabel;
	private JLabel nombreProductoLabel;

	public Panel() {
		setTitle("DON APARATO");
		setSize(435, 500);
		setLocationRelativeTo(null);
		iniciarComponentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void iniciarComponentes() {

		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setBounds(30, 30, 100, 20);
		add(nombreLabel);

		nombre = new JTextField();
		nombre.setBounds(140, 30, 200, 20);
		add(nombre);

		JLabel apellidoLabel = new JLabel("Apellido:");
		apellidoLabel.setBounds(30, 60, 100, 20);
		add(apellidoLabel);

		apellido = new JTextField();
		apellido.setBounds(140, 60, 200, 20);
		add(apellido);

		JLabel edadLabel = new JLabel("Edad:");
		edadLabel.setBounds(30, 90, 100, 20);
		add(edadLabel);

		edad = new JTextField();
		edad.setBounds(140, 90, 200, 20);
		add(edad);

		JLabel telefonoLabel = new JLabel("Teléfono:");
		telefonoLabel.setBounds(30, 120, 100, 20);
		add(telefonoLabel);

		telefono = new JTextField();
		telefono.setBounds(140, 120, 200, 20);
		add(telefono);

		JLabel tipoLabel = new JLabel("Tipo: (A, B, C)");
		tipoLabel.setBounds(30, 150, 100, 20);
		add(tipoLabel);

		tipo = new JTextField();
		tipo.setBounds(140, 150, 200, 20);
		add(tipo);

		nombreProductoLabel = new JLabel("Nombre del producto:");
		nombreProductoLabel.setBounds(30, 200, 150, 20);
		add(nombreProductoLabel);

		nombreProducto = new JTextField();
		nombreProducto.setBounds(190, 200, 150, 20);
		add(nombreProducto);

	    valorUnitarioLabel = new JLabel("Valor unitario:");
		valorUnitarioLabel.setBounds(30, 230, 100, 20);
		add(valorUnitarioLabel);

		valorUnitario = new JTextField();
		valorUnitario.setBounds(140, 230, 200, 20);
		add(valorUnitario);

		JLabel cantidadLabel = new JLabel("Cantidad:");
		cantidadLabel.setBounds(30, 260, 100, 20);
		add(cantidadLabel);

		cantidad = new JTextField();
		cantidad.setBounds(140, 260, 200, 20);
		add(cantidad);

		JLabel descuentoTitleLabel = new JLabel("Descuento:");
		descuentoTitleLabel.setBounds(30, 310, 100, 20);
		add(descuentoTitleLabel);

		descuentoLabel = new JLabel();
		descuentoLabel.setBounds(140, 310, 200, 20);
		add(descuentoLabel);

		JButton realizarCompraButton = new JButton("Realizar Compra");
		realizarCompraButton.setBounds(30, 350, 150, 30);
		realizarCompraButton.addActionListener(this);
		add(realizarCompraButton);

		JButton mostrarDatosButton = new JButton("Mostrar Datos del Usuario");
		mostrarDatosButton.setBounds(200, 350, 200, 30);
		mostrarDatosButton.addActionListener(this);
		add(mostrarDatosButton);

		JButton limpiarButton = new JButton("Limpiar");
		limpiarButton.setBounds(140, 400, 100, 30);
		limpiarButton.addActionListener(this);
		add(limpiarButton);

		setLayout(null);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Realizar Compra")) {
			realizarCompra();
		} else if (e.getActionCommand().equals("Mostrar Datos del Usuario")) {
			mostrarDatosUsuario();
		} else if (e.getActionCommand().equals("Limpiar")) {
			limpiarCampos();
		}
	}

	private void realizarCompra() {
		String nombreUsuario = nombre.getText();
		String tipoUsuario = tipo.getText();
		String nombreProducto = nombreProductoLabel.getText();
		double valorUnitario1 = Double.parseDouble(valorUnitario.getText());
		int cantidad = Integer.parseInt(this.cantidad.getText());

		double total = valorUnitario1 * cantidad;
		double descuento = 0.0;

		if (tipoUsuario.equalsIgnoreCase("A")) {
		    descuento = total * 0.4;
		} else if (tipoUsuario.equalsIgnoreCase("B")) {
		    descuento = total * 0.2;
		} else if (tipoUsuario.equalsIgnoreCase("C")) {
		    descuento = total * 0.1;
		}

		double precioFinal = total - descuento;

		String mensaje = "Nombre: " + nombreUsuario + "\n" + "Tipo: " + tipoUsuario + "\n"
				+ "Precio total de la compra: $" + total + "\n" +"Producto: "+nombreProducto;

		if (descuento > 0) {
			mensaje += "Descuento: $" + descuento + "\n";
		} else {
			mensaje += "No se le realiza descuento\n";
		}

		mensaje += "Precio real de la compra: $" + precioFinal;

		JOptionPane.showMessageDialog(this, mensaje, "Información de la Compra", JOptionPane.INFORMATION_MESSAGE);
	}

	private void mostrarDatosUsuario() {
		String nombreUsuario = nombre.getText();
		String apellidoUsuario = apellido.getText();
		String edadUsuario = edad.getText();
		String telefonoUsuario = telefono.getText();
		String tipoUsuario = tipo.getText();

		if (nombreUsuario.isEmpty() || apellidoUsuario.isEmpty() || edadUsuario.isEmpty() || telefonoUsuario.isEmpty()
				|| tipoUsuario.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Los campos están vacíos", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			String mensaje = "Nombre: " + nombreUsuario + "\n" + "Apellido: " + apellidoUsuario + "\n" + "Edad: "
					+ edadUsuario + "\n" + "Teléfono: " + telefonoUsuario + "\n" + "Tipo: " + tipoUsuario;

			JOptionPane.showMessageDialog(this, mensaje, "Datos del Usuario", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void limpiarCampos() {
		nombre.setText("");
		apellido.setText("");
		edad.setText("");
		telefono.setText("");
		tipo.setText("");
		nombreProducto.setText("");
		valorUnitario.setText("");
		cantidad.setText("");
		descuentoLabel.setText("");
	}
}
