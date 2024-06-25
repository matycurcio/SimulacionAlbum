
package interfaz;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import codigoNegocio.PaqueteDeFigus;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class InterfazSimulacionAlbum {

	private JFrame frame;
	private JTextField inputCantPersonas;
	private JTextField txtFieldResultadoEnFigus;
	private Simulacion0 simulacion0=null;
	private Simulacion1 simulacion1=null;
	private Simulacion2 simulacion2=null; 
	
	private int cantVueltasSimulacion;
	private final JPanel panel = new JPanel();
	private JTextField txtFieldCantFigus;
	private JTextField txtFieldCantVueltasSimu;
	private JTextField txtFieldResultadoEnPesos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazSimulacionAlbum window = new InterfazSimulacionAlbum();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public InterfazSimulacionAlbum() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 13));
		frame.getContentPane().setBackground(new Color(100, 28, 51));
		frame.setBounds(100, 100, 751, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		String[] tiposDeSimulaciones = { "Llenar album solo", "Llenar album regalando figus", "Llenar album intercambiando figus"};
		
		JLabel lblMsgError1 = new JLabel("ERROR! Revise los datos!");
		lblMsgError1.setBackground(new Color(255, 255, 255));
		lblMsgError1.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 14));
		lblMsgError1.setForeground(new Color(255, 0, 0));
		lblMsgError1.setBounds(323, 140, 175, 30);
		frame.getContentPane().add(lblMsgError1);
		lblMsgError1.setVisible(false);
		
		JPanel panelError = new JPanel();
		panelError.setBounds(317, 140, 185, 30);
		frame.getContentPane().add(panelError);
		panelError.setVisible(false);
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox opciones = new JComboBox(tiposDeSimulaciones);
		opciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		opciones.setBounds(237, 60, 256, 26);
		frame.getContentPane().add(opciones);
		
		JLabel lblDecisionSimulacion = new JLabel("Seleccione el tipo de simulaci\u00F3n:");
		lblDecisionSimulacion.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 13));
		lblDecisionSimulacion.setForeground(new Color(255, 255, 255));
		lblDecisionSimulacion.setBounds(10, 67, 217, 19);
		frame.getContentPane().add(lblDecisionSimulacion);
		
		JLabel lblIngreseCantPersonas = new JLabel("Ingrese la cantidad de personas:");
		lblIngreseCantPersonas.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 13));
		lblIngreseCantPersonas.setForeground(new Color(255, 255, 255));
		lblIngreseCantPersonas.setBounds(10, 105, 217, 19);
		frame.getContentPane().add(lblIngreseCantPersonas);
		
		inputCantPersonas = new JTextField();
		inputCantPersonas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputCantPersonas.setEnabled(true);
		inputCantPersonas.setBounds(236, 98, 65, 30);
		frame.getContentPane().add(inputCantPersonas);
		inputCantPersonas.setColumns(10);
		
		txtFieldResultadoEnFigus = new JTextField();
		txtFieldResultadoEnFigus.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldResultadoEnFigus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldResultadoEnFigus.setBounds(243, 339, 140, 26);
		frame.getContentPane().add(txtFieldResultadoEnFigus);
		txtFieldResultadoEnFigus.setColumns(10);
		
		JProgressBar barraProgreso = new JProgressBar();
		barraProgreso.setForeground(new Color(255, 255, 0));
		barraProgreso.setBounds(54, 285, 457, 43);
		frame.getContentPane().add(barraProgreso);
		
		
		
		JLabel lblImagen = new JLabel("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\album.jpg").getImage().getScaledInstance(128,150,Image.SCALE_DEFAULT));
		lblImagen.setIcon(imageIcon);
		lblImagen.setBounds(549, 120, 162, 190);
		frame.getContentPane().add(lblImagen);   
		panel.setBackground(new Color(251, 207, 2));
		panel.setBounds(0, 0, 735, 14);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(251, 207, 2));
		panel_1.setBounds(0, 417, 735, 14);
		frame.getContentPane().add(panel_1);
		
		JLabel lblIngreseCantFigus = new JLabel("Ingrese la cantidad de figuritas:");
		lblIngreseCantFigus.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 13));
		lblIngreseCantFigus.setForeground(Color.WHITE);
		lblIngreseCantFigus.setBounds(10, 146, 217, 19);
		frame.getContentPane().add(lblIngreseCantFigus);
		
		JLabel lblIngreseCantSimulaciones = new JLabel("Ingrese la cant. de simulaciones:");
		lblIngreseCantSimulaciones.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 13));
		lblIngreseCantSimulaciones.setForeground(Color.WHITE);
		lblIngreseCantSimulaciones.setBounds(10, 187, 217, 19);
		frame.getContentPane().add(lblIngreseCantSimulaciones);
		
		txtFieldCantFigus = new JTextField();
		txtFieldCantFigus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldCantFigus.setEnabled(true);
		txtFieldCantFigus.setColumns(10);
		txtFieldCantFigus.setBounds(236, 140, 65, 30);
		frame.getContentPane().add(txtFieldCantFigus);
		txtFieldCantFigus.setText("5");
		
		txtFieldCantVueltasSimu = new JTextField();
		txtFieldCantVueltasSimu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldCantVueltasSimu.setEnabled(true);
		txtFieldCantVueltasSimu.setColumns(10);
		txtFieldCantVueltasSimu.setBounds(236, 180, 65, 30);
		frame.getContentPane().add(txtFieldCantVueltasSimu);
		txtFieldCantVueltasSimu.setText("10000");
		
		JLabel lblResultadoFigus = new JLabel("Resultado en cantidad de figuritas:");
		lblResultadoFigus.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 13));
		lblResultadoFigus.setForeground(Color.WHITE);
		lblResultadoFigus.setBounds(10, 343, 236, 19);
		frame.getContentPane().add(lblResultadoFigus);
		
		JLabel lblResultadoEnPesos = new JLabel("Resultado en pesos $$:");
		lblResultadoEnPesos.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 13));
		lblResultadoEnPesos.setForeground(Color.WHITE);
		lblResultadoEnPesos.setBounds(77, 380, 185, 19);
		frame.getContentPane().add(lblResultadoEnPesos);
		
		txtFieldResultadoEnPesos = new JTextField();
		txtFieldResultadoEnPesos.setHorizontalAlignment(SwingConstants.CENTER);
		txtFieldResultadoEnPesos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFieldResultadoEnPesos.setColumns(10);
		txtFieldResultadoEnPesos.setBounds(243, 376, 140, 26);
		frame.getContentPane().add(txtFieldResultadoEnPesos);
		
		JLabel lblTitle = new JLabel("Simulaci\u00F3n Album del Mundial");
		lblTitle.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 22));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(199, 23, 332, 33);
		frame.getContentPane().add(lblTitle);
		
		JButton btnSimular = new JButton("SIMULAR");
		btnSimular.setBackground(new Color(251, 207, 2));
		btnSimular.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 16));
		btnSimular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						
						lblMsgError1.setVisible(false);
						panelError.setVisible(false);
						
						PaqueteDeFigus.setCantFigus(Integer.parseInt(txtFieldCantFigus.getText()));
						
						cantVueltasSimulacion=Integer.parseInt(txtFieldCantVueltasSimu.getText());
						
						
						if(opciones.getSelectedIndex()==0) {
							txtFieldResultadoEnFigus.setText("");
							simulacion0 = new Simulacion0(txtFieldResultadoEnFigus, txtFieldResultadoEnPesos,
									barraProgreso, cantVueltasSimulacion);
							simulacion0.execute();
						}
						
						if(opciones.getSelectedIndex()==1) {
							txtFieldResultadoEnFigus.setText("");
							simulacion1 = new Simulacion1(txtFieldResultadoEnFigus, txtFieldResultadoEnPesos,
									barraProgreso, Integer.parseInt(inputCantPersonas.getText()), cantVueltasSimulacion);
							simulacion1.execute();
						}
						
						if(opciones.getSelectedIndex()==2) {
							txtFieldResultadoEnFigus.setText("");
							simulacion2 = new Simulacion2(txtFieldResultadoEnFigus, txtFieldResultadoEnPesos,
									barraProgreso, Integer.parseInt(inputCantPersonas.getText()), cantVueltasSimulacion);
							simulacion2.execute();
						}
					}
					catch(Exception ex) {
						lblMsgError1.setVisible(true);
						panelError.setVisible(true);
					}
				
				
			}
		});
		btnSimular.setBounds(129, 230, 117, 44);
		frame.getContentPane().add(btnSimular);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBackground(new Color(251, 207, 2));
		btnCancelar.setFont(new Font("Qatar2022 Arabic Bold", Font.PLAIN, 16));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(simulacion0!=null) {
					simulacion0.cancel(true);
					simulacion0.done();
				}
		
				if(simulacion1!=null){
					simulacion1.cancel(true);
					simulacion1.done();
				}
				
				if(simulacion2!=null){
					simulacion2.cancel(true);
					simulacion2.done();
				}
			}
		});
		btnCancelar.setBounds(320, 230, 117, 44);
		frame.getContentPane().add(btnCancelar);
		
	
		
		
		
	}
}
