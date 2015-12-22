package miniproject3;

import miniproject3.coloring.ColoringAlgorithm;
import miniproject3.coloring.DepthFirstColoringAlgorithm;
import miniproject3.coloring.HeuristicColoringAlgorithm;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MainWindow extends JFrame implements ActionListener{

    private static final String title = "Problème du coloriage";
    private static final int padding = 5;
    private static final String graphText = "Graphe";
    private static final String graphFileButtonText = "Choisir un fichier";
    private static final String calculateText = "Trouver une solution";
    private static final int filePathTextWidth = 15;
    private static final int colorsTextLines = 5;
    private static final String defaultColorsText = "Rouge\nBleu\nVert";
    private static final String colorsText = "Couleurs";
    private static final String depthText = "Profondeur d'abord";
    private static final String heuristicText = "Heuristique";

    private final JLabel graphLabel;
    private final JTextField graphFileTextField;
    private final JButton graphFileButton;
    private final JButton calculateButton;
    private final JTextArea colorsTextArea;
    private final JLabel colorsLabel;
    private final JRadioButton depthRadioButton;
    private final JRadioButton heuristicRadioButton;

    MainWindow(){
        super();
        Box graphBox = Box.createHorizontalBox();
        graphBox.setBorder(BorderFactory.createEmptyBorder(0, 0, padding, 0));
        Box colorsBox = Box.createHorizontalBox();
        Box calculationBox = Box.createHorizontalBox();
        calculationBox.setBorder(BorderFactory.createEmptyBorder(padding, 0, 0, 0));

        graphLabel = new JLabel(graphText);
        graphFileTextField = new JTextField(filePathTextWidth);
        graphFileTextField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        graphFileButton = new JButton(graphFileButtonText);
        graphFileButton.addActionListener(this);
        graphBox.add(graphLabel);
        graphBox.add(Box.createHorizontalStrut(padding));
        graphBox.add(graphFileTextField);
        graphBox.add(Box.createHorizontalStrut(padding));
        graphBox.add(graphFileButton);

        colorsLabel = new JLabel(colorsText);
        colorsTextArea = new JTextArea(defaultColorsText, colorsTextLines, 0);
        colorsTextArea.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        colorsBox.add(colorsLabel);
        colorsBox.add(Box.createHorizontalStrut(padding));
        colorsBox.add(new JScrollPane(colorsTextArea));

        depthRadioButton = new JRadioButton(depthText);
        heuristicRadioButton = new JRadioButton(heuristicText);
        ButtonGroup bg = new ButtonGroup();
        bg.add(depthRadioButton);
        bg.add(heuristicRadioButton);
        depthRadioButton.setSelected(true);
        Box choiceBox = Box.createVerticalBox();
        choiceBox.add(depthRadioButton);
        choiceBox.add(heuristicRadioButton);
        calculateButton = new JButton(calculateText);
        calculateButton.addActionListener(this);
        calculationBox.add(choiceBox);
        calculationBox.add(Box.createHorizontalGlue());
        calculationBox.add(calculateButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        mainBox.add(graphBox);
        mainBox.add(colorsBox);
        mainBox.add(calculationBox);
        add(mainBox);
        setTitle(title);
        getRootPane().setDefaultButton(calculateButton);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (calculateButton.equals(actionEvent.getSource())){
            try {
                enableCalculationButton(false);
                if (depthRadioButton.isSelected()){
                        ColoringAlgorithm deepFirst = new DepthFirstColoringAlgorithm(Main.getFileContent(graphFileTextField.getText()), getColors(), this);
                        deepFirst.start();
                } else {
                    ColoringAlgorithm heuristic = new HeuristicColoringAlgorithm(Main.getFileContent(graphFileTextField.getText()), getColors(), this);
                    heuristic.start();
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(this, "Impossible de lire le fichier !\n"+e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                enableCalculationButton(true);
            } catch (IndexOutOfBoundsException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Fichier invalide !\n"+ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                enableCalculationButton(true);
            }
        } else if (graphFileButton.equals(actionEvent.getSource())){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Textes", "txt"));
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                graphFileTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
    }

    private String[] getColors(){
        String text = colorsTextArea.getText();
        return text.split("\n");
    }

    public void enableCalculationButton(boolean enable){
        calculateButton.setEnabled(enable);
        if (enable) this.setCursor(Cursor.getDefaultCursor());
        else this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }

    public void setDataAndCalculate(String graphFilePath, String colors){
        graphFileTextField.setText(graphFilePath);
        colorsTextArea.setText(colors);
        calculateButton.doClick();
    }

    public String getMethod(){
        if (depthRadioButton.isSelected()) return depthRadioButton.getText();
        else return heuristicRadioButton.getText();
    }
}
