package UserInterface;

import BusinessLogic.Entities.*;
import BusinessLogic.aaIABOT;
import DataAccess.aaDataFileHelper;
import Infrastructure.aaCMD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class aaExoTrooperForm extends JFrame {
    private JComboBox<String> aaCbxTipoExobot;
    private JTable aaTable;
    private DefaultTableModel aaTableModel;
    private JButton aaBtnAgregar;
    private JButton aaBtnBuscar;
    private JButton aaBtnEntrenar;
    private JButton aaBtnAccion;
    
    private List<aaExobot> aaExobotList;
    private TableRowSorter<DefaultTableModel> aaSorter;

    public aaExoTrooperForm() {
        aaExobotList = new ArrayList<>();
        
        setTitle("ExoTrooper");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel aaTopPanel = new JPanel();
        aaTopPanel.setLayout(new BoxLayout(aaTopPanel, BoxLayout.Y_AXIS));
        aaTopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        JLabel aaLblHeader = new JLabel("Alumno(s):");
        aaLblHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        aaTopPanel.add(aaLblHeader);

        JPanel aaStudentInfoPanel = new JPanel(new GridLayout(2, 2));
        aaStudentInfoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        aaStudentInfoPanel.setBackground(Color.WHITE);
        aaStudentInfoPanel.add(new JLabel("  1754918637")); 
        aaStudentInfoPanel.add(new JLabel("Alan Alcivar"));
        aaStudentInfoPanel.add(new JLabel("")); 
        aaStudentInfoPanel.add(new JLabel(""));
        aaTopPanel.add(aaStudentInfoPanel);
        
        add(aaTopPanel, BorderLayout.NORTH);

        JPanel aaCenterPanel = new JPanel(new BorderLayout(5, 5));
        aaCenterPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JPanel aaControlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        aaCbxTipoExobot = new JComboBox<>(new String[]{
            "ExoAsalto", "ExoExplorador", "ExoInfanteria", "ExoMedico", "ExoComando"
        });
        aaCbxTipoExobot.setPreferredSize(new Dimension(120, 30));
        
        aaBtnAgregar = new JButton("Agregar");
        aaBtnAgregar.setBackground(new Color(220, 220, 220));
        
        aaBtnBuscar = new JButton("Buscar");
        aaBtnBuscar.setBackground(Color.WHITE);
        
        aaControlPanel.add(aaCbxTipoExobot);
        aaControlPanel.add(aaBtnAgregar);
        aaControlPanel.add(aaBtnBuscar);
        
        aaCenterPanel.add(aaControlPanel, BorderLayout.NORTH);

        String[] aaColNames = {"IdExobot", "TipoExobot", "Entreno", "No. Accion"};
        aaTableModel = new DefaultTableModel(aaColNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        aaTable = new JTable(aaTableModel);
        aaTable.setRowHeight(25);
        
        JTableHeader aaHeader = aaTable.getTableHeader();
        aaHeader.setBackground(new Color(154, 205, 50));
        aaHeader.setForeground(Color.WHITE);
        aaHeader.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        aaSorter = new TableRowSorter<>(aaTableModel);
        aaTable.setRowSorter(aaSorter);

        aaCenterPanel.add(new JScrollPane(aaTable), BorderLayout.CENTER);
        
        add(aaCenterPanel, BorderLayout.CENTER);

        JPanel aaBottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        aaBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        aaBtnEntrenar = new JButton("Entrenar \"AcciónArma\"");
        aaBtnAccion = new JButton("\"Acción_TipoArma\"");
        
        aaBottomPanel.add(aaBtnEntrenar);
        aaBottomPanel.add(aaBtnAccion);
        
        add(aaBottomPanel, BorderLayout.SOUTH);

        aaBtnAgregar.addActionListener(e -> aaHandleAgregar());
        aaBtnEntrenar.addActionListener(e -> aaHandleEntrenar());
        aaBtnAccion.addActionListener(e -> aaHandleAccion());
        aaBtnBuscar.addActionListener(e -> aaHandleBuscar());
    }

    private void aaHandleAgregar() {
        String aaSelected = (String) aaCbxTipoExobot.getSelectedItem();
        aaExobot aaNewBot;
        
        switch (aaSelected) {
            case "ExoAsalto": aaNewBot = new aaExoAsalto(); break;
            case "ExoExplorador": aaNewBot = new aaExoExplorador(); break;
            case "ExoInfanteria": aaNewBot = new aaExoInfanteria(); break;
            case "ExoMedico": aaNewBot = new aaExoMedico(); break;
            case "ExoComando": aaNewBot = new aaExoComando(); break;
            default: aaNewBot = new aaExoAsalto();
        }
        
        aaNewBot.aaSetIdExobot(aaExobotList.size() + 1);
        aaExobotList.add(aaNewBot);
        
        aaTableModel.addRow(new Object[]{
            aaNewBot.aaGetIdExobot(),
            aaNewBot.aaGetTipoExobot(),
            "NO",
            "0"
        });
    }

    private aaExobot aaGetSelectedBot() {
        int aaRow = aaTable.getSelectedRow();
        if (aaRow != -1) {
            int aaModelRow = aaTable.convertRowIndexToModel(aaRow);
            int aaId = (int) aaTableModel.getValueAt(aaModelRow, 0);
            return aaExobotList.stream().filter(b -> b.aaGetIdExobot() == aaId).findFirst().orElse(null);
        }
        return null;
    }

    private void aaHandleEntrenar() {
        aaExobot aaCurrentBot = aaGetSelectedBot();
        if (aaCurrentBot != null) {
            aaSoldadoExperto aaSoldado = new aaSoldadoExperto("SoldadoExperto-" + aaCurrentBot.aaGetArmaNombre().split("/")[0]);
            new aaIABOT().aaEntrenar(aaCurrentBot, aaSoldado);
            
            aaUpdateTableRow(aaCurrentBot);

            String aaLog = "GOOD : " + aaSoldado.aaGetNombre() + " " + aaCurrentBot.aaGetArmaNombre() + " " + aaCurrentBot.aaRealizarAccion(); 
            aaCMD.aaImprimir(aaLog);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void aaHandleAccion() {
        aaExobot aaCurrentBot = aaGetSelectedBot();
        
        if (aaCurrentBot != null) {
            if (aaCurrentBot.aaIsEntrenado()) {
                String aaMunicion = aaDataFileHelper.aaBuscarMunicion(aaCurrentBot.aaGetArmaNombre());
                aaCurrentBot.aaIncrementarAccion();
                
                aaUpdateTableRow(aaCurrentBot);

                String aaLog = "GOOD : " + aaCurrentBot.aaGetArmaNombre() + " " + aaCurrentBot.aaRealizarAccion() + " " + (aaMunicion != null ? aaMunicion : "No Municion");
                aaCMD.aaImprimir(aaLog);
            } else {
                String aaLog = "ERROR: " + aaCurrentBot.aaGetTipoExobot() + " No Entrenado.";
                aaCMD.aaImprimir(aaLog);
                JOptionPane.showMessageDialog(this, "El Exobot no está entrenado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un Exobot de la tabla.");
        }
    }

    private void aaUpdateTableRow(aaExobot aaBot) {
        for (int i = 0; i < aaTableModel.getRowCount(); i++) {
            int aaId = (int) aaTableModel.getValueAt(i, 0);
            if (aaId == aaBot.aaGetIdExobot()) {
                aaTableModel.setValueAt(aaBot.aaIsEntrenado() ? "SI" : "NO", i, 2);
                aaTableModel.setValueAt(aaBot.aaGetNumeroAccion(), i, 3);
                break;
            }
        }
    }

    private void aaHandleBuscar() {
        String aaSelected = (String) aaCbxTipoExobot.getSelectedItem();
        if (aaSelected != null && !aaSelected.isEmpty()) {
            aaSorter.setRowFilter(RowFilter.regexFilter(aaSelected, 1));
        } else {
            aaSorter.setRowFilter(null);
        }
    }
}
