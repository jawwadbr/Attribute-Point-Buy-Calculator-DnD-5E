package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Menu extends JFrame implements ActionListener {
	
	// JPANEL
	private JPanel contentPane;
	private JLabel nome,restante,raca;
	
	// JTEXTFIELD
	private JTextField pRestante;
	private JTextField rForca;
	private JTextField rDest;
	private JTextField rConst;
	private JTextField rInt;
	private JTextField rSab;
	private JTextField rCar;
	private JTextField tFor;
	private JTextField tDest;
	private JTextField tCar;
	private JTextField tSab;
	private JTextField tInt;
	private JTextField tConst;
	private JTextField modFor;
	private JTextField modDest;
	private JTextField modConst;
	private JTextField modInt;
	private JTextField modSab;
	private JTextField modCar;
	private JTextField cFor;
	private JTextField cDest;
	private JTextField cConst;
	private JTextField cInt;
	private JTextField cSab;
	private JTextField cCar;
	
	// JLABEL
	private JLabel forca, destreza, constituicao, inteligencia, sabedoria, carisma;
	private JLabel label,label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9,label_10,label_11;
	private JLabel lblBase;
	private JLabel lblRacial;
	private JLabel lblNewLabel;
	private JLabel lblMod;
	private JLabel lblCusto,labelMeioElfo;
	
	// JCOMBOBOX
	private JComboBox<String> racas;
	
	// JSPINNER
	private JSpinner pForca;
	private JSpinner pDest;
	private JSpinner pSab;
	private JSpinner pConst;
	private JSpinner pInt;
	private JSpinner pCar;
	
	// JCHECKBOX
	private JCheckBox chckbxFor,chckbxDest,chckbxConst,chckbxInt,chckbxSab;
	private JCheckBox lastSelected;
	
	// ATRIBUTOS aux
	private int numOfSelectedCheckBox = 0;
	
	public Menu() {
		setResizable(false);
		setTitle("Calculador de Atributos D&D 5E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome = new JLabel("Calculador de Atributos D&D 5E");
		nome.setFont(new Font("Tahoma", Font.ITALIC, 20));
		nome.setBounds(53, 11, 300, 40);
		contentPane.add(nome);
		
		restante = new JLabel("Pontos Usados:");
		restante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		restante.setBounds(10, 62, 119, 25);
		contentPane.add(restante);
		
		pRestante = new JTextField();
		pRestante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pRestante.setForeground(Color.BLACK);
		pRestante.setText("0");
		pRestante.setBounds(108, 65, 46, 20);
		pRestante.setHorizontalAlignment(SwingConstants.CENTER);
		pRestante.setEditable(false);
		contentPane.add(pRestante);
		pRestante.setColumns(10);
		
		racas = new JComboBox<>();
		racas.setModel(new DefaultComboBoxModel<>(new String[] {"Anão da Colina", "Anão da Montanha", "Alto Elfo", "Elfo da Floresta", "Elfo Negro", "Halfling Pés Leves", "Halfling Robusto", "Humano", "Draconato", "Gnomo da Floresta", "Gnomo das Rochas", "Meio-Elfo", "Meio-Orc", "Tiefling"}));
		racas.setSelectedIndex(7);
		racas.setBounds(49, 401, 156, 20);
		racas.addActionListener(this);
		contentPane.add(racas);
		contentPane.add(pRestante);
		pRestante.setColumns(10);
		
		raca = new JLabel("Raça:");
		raca.setBounds(10, 404, 51, 15);
		contentPane.add(raca);
		
		forca = new JLabel("Força");
		forca.setBounds(10, 130, 71, 35);
		contentPane.add(forca);
		
		destreza = new JLabel("Destreza");
		destreza.setBounds(10, 170, 71, 35);
		contentPane.add(destreza);
		
		constituicao = new JLabel("Constituição");
		constituicao.setBounds(10, 210, 71, 35);
		contentPane.add(constituicao);
		
		inteligencia = new JLabel("Inteligência");
		inteligencia.setBounds(10, 250, 71, 35);
		contentPane.add(inteligencia);
		
		sabedoria = new JLabel("Sabedoria");
		sabedoria.setBounds(10, 290, 71, 35);
		contentPane.add(sabedoria);
		
		carisma = new JLabel("Carisma");
		carisma.setBounds(10, 330, 71, 35);
		contentPane.add(carisma);
		
		pForca = new JSpinner();
		pForca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pForca.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculaValores();
				calculaModCusto();
				calculaPontosUsados();
				trocaCorPontosUsados();
			}
		});
		pForca.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		pForca.setBounds(91, 130, 35, 35);
		contentPane.add(pForca);
		
		pDest = new JSpinner();
		pDest.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pDest.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculaValores();
				calculaModCusto();
				calculaPontosUsados();
				trocaCorPontosUsados();
			}
		});
		pDest.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		pDest.setBounds(91, 170, 35, 35);
		contentPane.add(pDest);
		
		pSab = new JSpinner();
		pSab.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pSab.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculaValores();
				calculaModCusto();
				calculaPontosUsados();
				trocaCorPontosUsados();
			}
		});
		pSab.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		pSab.setBounds(91, 290, 35, 35);
		contentPane.add(pSab);
		
		pConst = new JSpinner();
		pConst.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pConst.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculaValores();
				calculaModCusto();
				calculaPontosUsados();
				trocaCorPontosUsados();
			}
		});
		pConst.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		pConst.setBounds(91, 210, 35, 35);
		contentPane.add(pConst);
		
		pInt = new JSpinner();
		pInt.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pInt.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculaValores();
				calculaModCusto();
				calculaPontosUsados();
				trocaCorPontosUsados();
			}
		});
		pInt.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		pInt.setBounds(91, 250, 35, 35);
		contentPane.add(pInt);
		
		pCar = new JSpinner();
		pCar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pCar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculaValores();
				calculaModCusto();
				calculaPontosUsados();
				trocaCorPontosUsados();
			}
		});
		pCar.setModel(new SpinnerNumberModel(8, 8, 15, 1));
		pCar.setBounds(91, 330, 35, 35);
		contentPane.add(pCar);
		
		label = new JLabel("+");
		label.setBounds(136, 140, 46, 14);
		contentPane.add(label);
		
		label_1 = new JLabel("+");
		label_1.setBounds(136, 180, 50, 14);
		contentPane.add(label_1);
		
		label_2 = new JLabel("+");
		label_2.setBounds(136, 220, 46, 14);
		contentPane.add(label_2);
		
		label_3 = new JLabel("+");
		label_3.setBounds(136, 260, 46, 14);
		contentPane.add(label_3);
		
		label_4 = new JLabel("+");
		label_4.setBounds(136, 300, 46, 14);
		contentPane.add(label_4);
		
		label_5 = new JLabel("+");
		label_5.setBounds(136, 340, 46, 14);
		contentPane.add(label_5);
		
		rForca = new JTextField();
		rForca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rForca.setHorizontalAlignment(SwingConstants.CENTER);
		rForca.setEditable(false);
		rForca.setBounds(155, 130, 50, 35);
		contentPane.add(rForca);
		rForca.setColumns(10);
		
		rDest = new JTextField();
		rDest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rDest.setHorizontalAlignment(SwingConstants.CENTER);
		rDest.setEditable(false);
		rDest.setBounds(155, 170, 50, 35);
		contentPane.add(rDest);
		rDest.setColumns(10);
		
		rConst = new JTextField();
		rConst.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rConst.setHorizontalAlignment(SwingConstants.CENTER);
		rConst.setEditable(false);
		rConst.setBounds(155, 210, 50, 35);
		contentPane.add(rConst);
		rConst.setColumns(10);
		
		rInt = new JTextField();
		rInt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rInt.setHorizontalAlignment(SwingConstants.CENTER);
		rInt.setEditable(false);
		rInt.setBounds(155, 250, 50, 35);
		contentPane.add(rInt);
		rInt.setColumns(10);
		
		rSab = new JTextField();
		rSab.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rSab.setHorizontalAlignment(SwingConstants.CENTER);
		rSab.setEditable(false);
		rSab.setBounds(155, 290, 50, 35);
		contentPane.add(rSab);
		rSab.setColumns(10);
		
		rCar = new JTextField();
		rCar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rCar.setHorizontalAlignment(SwingConstants.CENTER);
		rCar.setEditable(false);
		rCar.setBounds(155, 330, 50, 35);
		contentPane.add(rCar);
		rCar.setColumns(10);
		
		label_6 = new JLabel("=");
		label_6.setBounds(209, 140, 46, 14);
		contentPane.add(label_6);
		
		label_7 = new JLabel("=");
		label_7.setBounds(209, 180, 46, 14);
		contentPane.add(label_7);
		
		label_8 = new JLabel("=");
		label_8.setBounds(209, 220, 46, 14);
		contentPane.add(label_8);
		
		label_9 = new JLabel("=");
		label_9.setBounds(209, 260, 46, 14);
		contentPane.add(label_9);
		
		label_10 = new JLabel("=");
		label_10.setBounds(209, 300, 46, 14);
		contentPane.add(label_10);
		
		label_11 = new JLabel("=");
		label_11.setBounds(209, 340, 46, 14);
		contentPane.add(label_11);
		
		lblBase = new JLabel("Base");
		lblBase.setBounds(91, 105, 46, 14);
		contentPane.add(lblBase);
		
		lblRacial = new JLabel("Racial");
		lblRacial.setBounds(159, 105, 46, 14);
		contentPane.add(lblRacial);
		
		tFor = new JTextField();
		tFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tFor.setHorizontalAlignment(SwingConstants.CENTER);
		tFor.setEditable(false);
		tFor.setBounds(225, 130, 50, 35);
		contentPane.add(tFor);
		tFor.setColumns(10);
		
		tDest = new JTextField();
		tDest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tDest.setHorizontalAlignment(SwingConstants.CENTER);
		tDest.setEditable(false);
		tDest.setBounds(225, 170, 50, 35);
		contentPane.add(tDest);
		tDest.setColumns(10);
		
		tCar = new JTextField();
		tCar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tCar.setHorizontalAlignment(SwingConstants.CENTER);
		tCar.setEditable(false);
		tCar.setBounds(225, 330, 50, 35);
		contentPane.add(tCar);
		tCar.setColumns(10);
		
		tSab = new JTextField();
		tSab.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tSab.setHorizontalAlignment(SwingConstants.CENTER);
		tSab.setEditable(false);
		tSab.setBounds(225, 290, 50, 35);
		contentPane.add(tSab);
		tSab.setColumns(10);
		
		tInt = new JTextField();
		tInt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tInt.setHorizontalAlignment(SwingConstants.CENTER);
		tInt.setEditable(false);
		tInt.setBounds(225, 250, 50, 35);
		contentPane.add(tInt);
		tInt.setColumns(10);
		
		tConst = new JTextField();
		tConst.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tConst.setHorizontalAlignment(SwingConstants.CENTER);
		tConst.setEditable(false);
		tConst.setBounds(225, 210, 50, 35);
		contentPane.add(tConst);
		tConst.setColumns(10);
		
		lblNewLabel = new JLabel("Total");
		lblNewLabel.setBounds(225, 105, 46, 14);
		contentPane.add(lblNewLabel);
		
		modFor = new JTextField();
		modFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modFor.setHorizontalAlignment(SwingConstants.CENTER);
		modFor.setEditable(false);
		modFor.setBounds(285, 130, 50, 35);
		contentPane.add(modFor);
		modFor.setColumns(10);
		
		modDest = new JTextField();
		modDest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modDest.setHorizontalAlignment(SwingConstants.CENTER);
		modDest.setEditable(false);
		modDest.setBounds(285, 170, 50, 35);
		contentPane.add(modDest);
		modDest.setColumns(10);
		
		modConst = new JTextField();
		modConst.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modConst.setHorizontalAlignment(SwingConstants.CENTER);
		modConst.setEditable(false);
		modConst.setBounds(285, 210, 50, 35);
		contentPane.add(modConst);
		modConst.setColumns(10);
		
		modInt = new JTextField();
		modInt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modInt.setHorizontalAlignment(SwingConstants.CENTER);
		modInt.setEditable(false);
		modInt.setBounds(285, 250, 50, 35);
		contentPane.add(modInt);
		modInt.setColumns(10);
		
		modSab = new JTextField();
		modSab.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modSab.setHorizontalAlignment(SwingConstants.CENTER);
		modSab.setEditable(false);
		modSab.setBounds(285, 290, 50, 35);
		contentPane.add(modSab);
		modSab.setColumns(10);
		
		modCar = new JTextField();
		modCar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modCar.setHorizontalAlignment(SwingConstants.CENTER);
		modCar.setEditable(false);
		modCar.setBounds(285, 330, 50, 35);
		contentPane.add(modCar);
		modCar.setColumns(10);
		
		lblMod = new JLabel("Mod.");
		lblMod.setBounds(285, 105, 46, 14);
		contentPane.add(lblMod);
		
		cFor = new JTextField();
		cFor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cFor.setHorizontalAlignment(SwingConstants.CENTER);
		cFor.setText("0");
		cFor.setEditable(false);
		cFor.setBounds(365, 130, 50, 35);
		contentPane.add(cFor);
		cFor.setColumns(10);
		
		cDest = new JTextField();
		cDest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cDest.setText("0");
		cDest.setHorizontalAlignment(SwingConstants.CENTER);
		cDest.setEditable(false);
		cDest.setBounds(365, 170, 50, 35);
		contentPane.add(cDest);
		cDest.setColumns(10);
		
		cConst = new JTextField();
		cConst.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cConst.setText("0");
		cConst.setHorizontalAlignment(SwingConstants.CENTER);
		cConst.setEditable(false);
		cConst.setBounds(365, 210, 50, 35);
		contentPane.add(cConst);
		cConst.setColumns(10);
		
		cInt = new JTextField();
		cInt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cInt.setText("0");
		cInt.setHorizontalAlignment(SwingConstants.CENTER);
		cInt.setEditable(false);
		cInt.setBounds(365, 250, 50, 35);
		contentPane.add(cInt);
		cInt.setColumns(10);
		
		cSab = new JTextField();
		cSab.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cSab.setText("0");
		cSab.setHorizontalAlignment(SwingConstants.CENTER);
		cSab.setEditable(false);
		cSab.setBounds(365, 290, 50, 35);
		contentPane.add(cSab);
		cSab.setColumns(10);
		
		cCar = new JTextField();
		cCar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cCar.setText("0");
		cCar.setHorizontalAlignment(SwingConstants.CENTER);
		cCar.setEditable(false);
		cCar.setBounds(365, 330, 50, 35);
		contentPane.add(cCar);
		cCar.setColumns(10);
		
		lblCusto = new JLabel("Custo");
		lblCusto.setBounds(369, 105, 46, 14);
		contentPane.add(lblCusto);
		
		
		labelMeioElfo = new JLabel("Selecione qualquer um destes dois Atributos:");
		labelMeioElfo.setBounds(10, 426, 307, 14);
		contentPane.add(labelMeioElfo);
		
		chckbxFor = new JCheckBox("For");
		chckbxFor.setBounds(10, 447, 97, 23);
		chckbxFor.addActionListener(this);
		contentPane.add(chckbxFor);
		
		chckbxDest = new JCheckBox("Dest");
		chckbxDest.setBounds(10, 477, 97, 23);
		chckbxDest.addActionListener(this);
		contentPane.add(chckbxDest);
		
		chckbxConst = new JCheckBox("Const");
		chckbxConst.setBounds(10, 503, 97, 23);
		chckbxConst.addActionListener(this);
		contentPane.add(chckbxConst);
		
		chckbxInt = new JCheckBox("Int");
		chckbxInt.setBounds(108, 447, 97, 23);
		chckbxInt.addActionListener(this);
		contentPane.add(chckbxInt);
		
		chckbxSab = new JCheckBox("Sab");
		chckbxSab.setBounds(108, 477, 97, 23);
		chckbxSab.addActionListener(this);
		contentPane.add(chckbxSab);
		
		JLabel lblByJawwadbr = new JLabel("By Jawwadbr");
		lblByJawwadbr.setBounds(10, 533, 97, 14);
		contentPane.add(lblByJawwadbr);
		
		JLabel lblV = new JLabel("V 1.1");
		lblV.setBounds(10, 546, 71, 14);
		contentPane.add(lblV);
		
		JButton btnSobre = new JButton("Sobre");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Este programa contém apenas as raças do \"Livro do Jogador D&D 5E\", não tem nenhuma outra raça além delas.\nNo futuro talvez seja implementado"
						+ " raças de Homebrew, Unearthed Arcana e outras versões.", "Sobre", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSobre.setBounds(335, 537, 89, 20);
		contentPane.add(btnSobre);
		
		padronizaCheckBox();
		
		setValoresPadraoTextos();
		contentPane.revalidate();
		contentPane.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == racas) {
			String raca = (String) racas.getSelectedItem();
			switch (raca) {
			case "Anão da Colina":
				rForca.setText("0");
				rDest.setText("0");
				rConst.setText("2");
				rInt.setText("0");
				rSab.setText("1");
				rCar.setText("0");
				break;
			case "Anão da Montanha":
				rForca.setText("2");
				rDest.setText("0");
				rConst.setText("2");
				rInt.setText("0");
				rSab.setText("0");
				rCar.setText("0");
				break;
			case "Alto Elfo":
				rForca.setText("0");
				rDest.setText("2");
				rConst.setText("0");
				rInt.setText("1");
				rSab.setText("0");
				rCar.setText("0");
				break;
			case "Elfo da Floresta":
				rForca.setText("0");
				rDest.setText("2");
				rConst.setText("0");
				rInt.setText("0");
				rSab.setText("1");
				rCar.setText("0");
				break;
			case "Elfo Negro":
				rForca.setText("0");
				rDest.setText("2");
				rConst.setText("0");
				rInt.setText("0");
				rSab.setText("0");
				rCar.setText("1");
				break;
			case "Halfling Pés Leves":
				rForca.setText("0");
				rDest.setText("2");
				rConst.setText("0");
				rInt.setText("0");
				rSab.setText("0");
				rCar.setText("1");
				break;
			case "Halfling Robusto":
				rForca.setText("0");
				rDest.setText("2");
				rConst.setText("1");
				rInt.setText("0");
				rSab.setText("0");
				rCar.setText("0");
				break;
			case "Humano":
				rForca.setText("1");
				rDest.setText("1");
				rConst.setText("1");
				rInt.setText("1");
				rSab.setText("1");
				rCar.setText("1");
				break;
			case "Draconato":
				rForca.setText("2");
				rDest.setText("0");
				rConst.setText("0");
				rInt.setText("0");
				rSab.setText("0");
				rCar.setText("1");
				break;
			case "Gnomo da Floresta":
				rForca.setText("0");
				rDest.setText("1");
				rConst.setText("0");
				rInt.setText("2");
				rSab.setText("0");
				rCar.setText("0");
				break;
			case "Gnomo das Rochas":
				rForca.setText("0");
				rDest.setText("0");
				rConst.setText("1");
				rInt.setText("2");
				rSab.setText("0");
				rCar.setText("0");
				break;
			case "Meio-Elfo":
				rForca.setText("0");
				rDest.setText("0");
				rConst.setText("0");
				rInt.setText("0");
				rSab.setText("0");
				rCar.setText("2");
				labelMeioElfo.setVisible(true);
				chckbxFor.setVisible(true);
				chckbxDest.setVisible(true);
				chckbxConst.setVisible(true);
				chckbxInt.setVisible(true);
				chckbxSab.setVisible(true);
				break;
			case "Meio-Orc":
				rForca.setText("2");
				rDest.setText("0");
				rConst.setText("1");
				rInt.setText("0");
				rSab.setText("0");
				rCar.setText("0");
				break;
			case "Tiefling":
				rForca.setText("0");
				rDest.setText("0");
				rConst.setText("0");
				rInt.setText("1");
				rSab.setText("0");
				rCar.setText("2");
				break;
			default:
				break;
			}
		}
		else if(e.getSource() == chckbxFor) {
			if(numOfSelectedCheckBox == 2 && chckbxFor.isSelected()) {
				numOfSelectedCheckBox++;
				lastSelected.doClick();
				rForca.setText("1");
				lastSelected = chckbxFor;
			}
			else if(chckbxFor.isSelected()) {
				rForca.setText("1");
				lastSelected = chckbxFor;
				numOfSelectedCheckBox++;
			}
			else if(!chckbxFor.isSelected()) {
				rForca.setText("0");
				numOfSelectedCheckBox--;
			}
		}
		////////////////////////////////////////////////////
		else if(e.getSource() == chckbxDest) {
			if(numOfSelectedCheckBox == 2 && chckbxDest.isSelected()) {
				numOfSelectedCheckBox++;
				lastSelected.doClick();
				rDest.setText("1");
				lastSelected = chckbxDest;
			}
			else if(chckbxDest.isSelected()) {
				rDest.setText("1");
				lastSelected = chckbxDest;
				numOfSelectedCheckBox++;
			}
			else {
				rDest.setText("0");
				numOfSelectedCheckBox--;
			}
		}
		////////////////////////////////////////////////////
		else if(e.getSource() == chckbxConst) {
			if(numOfSelectedCheckBox == 2 && chckbxConst.isSelected()) {
				numOfSelectedCheckBox++;
				lastSelected.doClick();
				rConst.setText("1");
				lastSelected = chckbxConst;
			}
			else if(chckbxConst.isSelected()) {
				rConst.setText("1");
				lastSelected = chckbxConst;
				numOfSelectedCheckBox++;
			}
			else {
				rConst.setText("0");
				numOfSelectedCheckBox--;
			}
		}
		////////////////////////////////////////////////////
		else if(e.getSource() == chckbxInt) {
			if(numOfSelectedCheckBox == 2 && chckbxInt.isSelected()) {
				numOfSelectedCheckBox++;
				lastSelected.doClick();
				rInt.setText("1");
				lastSelected = chckbxInt;
			}
			else if(chckbxInt.isSelected()) {
				rInt.setText("1");
				lastSelected = chckbxInt;
				numOfSelectedCheckBox++;
			}
			else {
				rInt.setText("0");
				numOfSelectedCheckBox--;
			}
		}
		///////////////////////////////////////////////////
		else if(e.getSource() == chckbxSab) {
			if(numOfSelectedCheckBox == 2 && chckbxSab.isSelected()) {
				numOfSelectedCheckBox++;
				lastSelected.doClick();
				rSab.setText("1");
				lastSelected = chckbxSab;
			}
			else if(chckbxSab.isSelected()) {
				rSab.setText("1");
				lastSelected = chckbxSab;
				numOfSelectedCheckBox++;
			}
			else {
				rSab.setText("0");
				numOfSelectedCheckBox--;
			}
		}
		padronizaCheckBox();
		calculaValores();
		calculaModCusto();
	}

	
	public void setValoresPadraoTextos() {
		pForca.setValue(8);
		pDest.setValue(8);
		pConst.setValue(8);
		pInt.setValue(8);
		pSab.setValue(8);
		pCar.setValue(8);
		rForca.setText("1");
		rDest.setText("1");
		rConst.setText("1");
		rInt.setText("1");
		rSab.setText("1");
		rCar.setText("1");
		int forc = Integer.valueOf(rForca.getText()) + (int) pForca.getValue();
		int dest = Integer.valueOf(rDest.getText()) + (int) pDest.getValue();
		int cons = Integer.valueOf(rConst.getText()) + (int) pConst.getValue();
		int inte = Integer.valueOf(rInt.getText()) + (int) pInt.getValue();
		int sabe = Integer.valueOf(rSab.getText()) + (int) pSab.getValue();
		int caris = Integer.valueOf(rCar.getText()) + (int) pCar.getValue();
		tFor.setText(String.valueOf(forc));
		tDest.setText(String.valueOf(dest));
		tConst.setText(String.valueOf(cons));
		tInt.setText(String.valueOf(inte));
		tSab.setText(String.valueOf(sabe));
		tCar.setText(String.valueOf(caris));
		modFor.setText("-1");
		modDest.setText("-1");
		modConst.setText("-1");
		modInt.setText("-1");
		modSab.setText("-1");
		modCar.setText("-1");
		calculaValores();
	}
	
	public void calculaValores() {
		int forc = Integer.valueOf(rForca.getText()) + (int) pForca.getValue();
		int dest = Integer.valueOf(rDest.getText()) + (int) pDest.getValue();
		int cons = Integer.valueOf(rConst.getText()) + (int) pConst.getValue();
		int inte = Integer.valueOf(rInt.getText()) + (int) pInt.getValue();
		int sabe = Integer.valueOf(rSab.getText()) + (int) pSab.getValue();
		int caris = Integer.valueOf(rCar.getText()) + (int) pCar.getValue();
		tFor.setText(String.valueOf(forc));
		tDest.setText(String.valueOf(dest));
		tConst.setText(String.valueOf(cons));
		tInt.setText(String.valueOf(inte));
		tSab.setText(String.valueOf(sabe));
		tCar.setText(String.valueOf(caris));
	}
	
	public void calculaModCusto() {
		int forc = (int) pForca.getValue();
		int dest = (int) pDest.getValue();
		int cons = (int) pConst.getValue();
		int inte = (int) pInt.getValue();
		int sabe = (int) pSab.getValue();
		int caris = (int) pCar.getValue();
		
		cFor.setText(String.valueOf(retornaCusto(forc)));
		cDest.setText(String.valueOf(retornaCusto(dest)));
		cConst.setText(String.valueOf(retornaCusto(cons)));
		cInt.setText(String.valueOf(retornaCusto(inte)));
		cSab.setText(String.valueOf(retornaCusto(sabe)));
		cCar.setText(String.valueOf(retornaCusto(caris)));
		
		/////// /\ Custo /\ ///////
		/////// \/ Modif \/ ///////
		
		modFor.setText(String.valueOf(retornaMod(Integer.valueOf(tFor.getText()))));
		modDest.setText(String.valueOf(retornaMod(Integer.valueOf(tDest.getText()))));
		modConst.setText(String.valueOf(retornaMod(Integer.valueOf(tConst.getText()))));
		modInt.setText(String.valueOf(retornaMod(Integer.valueOf(tInt.getText()))));
		modSab.setText(String.valueOf(retornaMod(Integer.valueOf(tSab.getText()))));
		modCar.setText(String.valueOf(retornaMod(Integer.valueOf(tCar.getText()))));
	}
	
	public void padronizaCheckBox() {
		labelMeioElfo.setVisible(false);
		chckbxFor.setVisible(false);
		chckbxDest.setVisible(false);
		chckbxConst.setVisible(false);
		chckbxInt.setVisible(false);
		chckbxSab.setVisible(false);
		chckbxFor.setSelected(false);
		chckbxDest.setSelected(false);
		chckbxConst.setSelected(false);
		chckbxInt.setSelected(false);
		chckbxSab.setSelected(false);
		lastSelected = null;
		numOfSelectedCheckBox = 0;
		
	}
	
	public int retornaCusto(int a) {
		if(a == 8) 
			return 0;
		else if(a == 9) 
			return 1;
		else if(a == 10)
			return 2;
		else if(a == 11)
			return 3;
		else if(a == 12) 
			return 4;
		else if(a == 13)
			return 5;
		else if(a == 14)
			return 7;
		else if(a == 15)
			return 9;
		return 0;
	}
	
	public int retornaMod(int a) {
		return (a/2)-5;
	}
	
	public void calculaPontosUsados() {
		int pontosUsados = Integer.valueOf(cFor.getText()) + Integer.valueOf(cDest.getText()) + Integer.valueOf(cConst.getText()) + Integer.valueOf(cInt.getText()) + Integer.valueOf(cSab.getText()) + Integer.valueOf(cCar.getText());
		
		pRestante.setText(String.valueOf(pontosUsados));
	}
	
	public void trocaCorPontosUsados() {
		if(Integer.valueOf(pRestante.getText()) < 27) 
			pRestante.setForeground(Color.RED);
		else if(Integer.valueOf(pRestante.getText()) == 27)
			pRestante.setForeground(Color.GREEN);
		else
			pRestante.setForeground(Color.BLACK);
	}
}
