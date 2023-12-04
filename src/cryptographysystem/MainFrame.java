/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cryptographysystem;
import java.awt.Color;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.nio.file.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setSize(1000, 600);
        Caesar.setBackground(new Color(77,123,196));
        CaesarCipherTextArea.setEditable(false);
        CaesarClearTextArea.setEditable(false);
        SymmetricCipherTextArea.setEditable(false);
        SymmetricClearTextArea.setEditable(false);
        AssymetricPublicKey.setEditable(false);
        AssymetricPrivateKey.setEditable(false);
        AsymmetricClearTextArea.setEditable(false);
        HybridEncryptedTextArea.setEditable(false);
        HybridPublicKey.setEditable(false);
        HybridPrivateKey.setEditable(false);
        HybridClearTextArea.setEditable(false);
    }
    
    public void switchPanels(javax.swing.JPanel panel)
    {
        MainLayeredPane.removeAll();
        MainLayeredPane.add(panel);
        MainLayeredPane.repaint();
        MainLayeredPane.revalidate();
    }
    
     public static void ExportTextFile(String Text) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));
        fileChooser.setDialogTitle("Save File");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();

            // Ensure the file has a .txt extension
            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(Text);
                JOptionPane.showMessageDialog(null, "File saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void ImportTextFile(JTextArea parentTextArea) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a Text File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files (*.txt)", "txt"));

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                StringBuilder fileContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    fileContent.append(line).append("\n");
                }

                // Remove the trailing newline if present
                if (fileContent.length() > 0 && fileContent.charAt(fileContent.length() - 1) == '\n') {
                    fileContent.deleteCharAt(fileContent.length() - 1);
                }

                parentTextArea.setText(fileContent.toString());
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static void ChooseFile(JLabel parentLabel) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a File");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String inputFile = selectedFile.getAbsolutePath();
            parentLabel.setText(inputFile);
        }
    }
    
    public static void ChooseFile(JLabel parentLabel, String ext) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Encrypted Files  (*." + ext + ")", ext));
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String inputFile = selectedFile.getAbsolutePath();
            parentLabel.setText(inputFile);
        }
    }
    
    public static String SIFileEn() {
        String filePath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filePath = selectedFile.getAbsolutePath();
        }
        
        return filePath;
    }
    
    public static String SIFileEn(String ext) {
        String filePath = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save File");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Encrypted Files  (*." + ext + ")", ext));
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Ensure the selected file has the correct extension
            if (!selectedFile.getName().toLowerCase().endsWith(ext)) {
                // Append the extension if it's not already present
                filePath = selectedFile.getAbsolutePath() + "." + ext;
            } else {
                filePath = selectedFile.getAbsolutePath();
            }
        }
        return filePath;
    }
    
    public static String PKS;
    public static byte[] MB;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        SymmetricButtonBroup1 = new javax.swing.ButtonGroup();
        SymmetricButtonBroup2 = new javax.swing.ButtonGroup();
        HybridButtonGroup1 = new javax.swing.ButtonGroup();
        HybridButtonGroup2 = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        Header = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        Caesar = new javax.swing.JButton();
        Symmetric = new javax.swing.JButton();
        Assymetric = new javax.swing.JButton();
        Hybrid = new javax.swing.JButton();
        About = new javax.swing.JButton();
        MainLayeredPane = new javax.swing.JLayeredPane();
        CaesarPanel = new javax.swing.JPanel();
        CaesarTabPanel = new javax.swing.JTabbedPane();
        EncyptionPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CaesarPlainTextArea = new javax.swing.JTextArea();
        EncryptShiftTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CaesarCipherTextArea = new javax.swing.JTextArea();
        EncryptButton1 = new javax.swing.JButton();
        ExportCaesarCipherButton = new javax.swing.JButton();
        ImportCaesarCipherButton = new javax.swing.JButton();
        DecryptionPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        CaesarEncryptedTextArea = new javax.swing.JTextArea();
        DecryptShiftTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        CaesarClearTextArea = new javax.swing.JTextArea();
        DecryptButton1 = new javax.swing.JButton();
        ImportCaesarCipherButton2 = new javax.swing.JButton();
        ExportCaesarCipherButton2 = new javax.swing.JButton();
        AboutPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        SymmetricPanel = new javax.swing.JPanel();
        SymmetricTabPanel = new javax.swing.JTabbedPane();
        EncyptionPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        SymmetricPlainTextArea = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        SymmetricCipherTextArea = new javax.swing.JTextArea();
        EncryptSymmetricButton = new javax.swing.JButton();
        ExportSymmetricCipherButton = new javax.swing.JButton();
        ImportSymmetricCipherButton = new javax.swing.JButton();
        SymmetricKeyPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        SIButton = new javax.swing.JButton();
        SymmetricEncryptFilePlaceHolder = new javax.swing.JLabel();
        DecryptionPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        SymmetricEncryptedTextArea = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        SymmetricClearTextArea = new javax.swing.JTextArea();
        DecryptSymmetricButton2 = new javax.swing.JButton();
        ImportSymmetricCipherButton2 = new javax.swing.JButton();
        ExportSymmetricCipherButton2 = new javax.swing.JButton();
        SymmetricKeyPassword1 = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        SymmetricDecryptFilePlaceHolder = new javax.swing.JLabel();
        SEButton = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        AboutPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        AsymmetricPanel = new javax.swing.JPanel();
        AsymmetricTabPanel = new javax.swing.JTabbedPane();
        EncyptionPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        AsymmetricPlainTextArea = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        AsymmetricPublicKeyField = new javax.swing.JTextArea();
        EncryptAsymmetricButton = new javax.swing.JButton();
        ImportAsymmetricCipherButton = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        GenerateKeyPair = new javax.swing.JButton();
        AssymetricPrivateKey = new javax.swing.JTextField();
        AssymetricPublicKey = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        DecryptionPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        AsymmetricClearTextArea = new javax.swing.JTextArea();
        DecryptAsymmetricButton = new javax.swing.JButton();
        ExportAsymmetricCipherButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        AsymmetricDecryptFilePlaceHolder = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        AsymmetricPrivateKeyField = new javax.swing.JTextArea();
        AboutPanel3 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        HyridPanel = new javax.swing.JPanel();
        HybridTabPanel = new javax.swing.JTabbedPane();
        EncyptionPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        HybridPlainTextArea = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        HybridEncryptedTextArea = new javax.swing.JTextArea();
        EncryptHybridButton = new javax.swing.JButton();
        ExportHybridEnButton = new javax.swing.JButton();
        ImportHybridPlainButton = new javax.swing.JButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        SIButton1 = new javax.swing.JButton();
        HybridEncryptFilePlaceHolder = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        GenerateKeyPair1 = new javax.swing.JButton();
        HybridPrivateKey = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        HybridPublicKey = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        HybridPrivateKeyField = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        ImportHybridWrappedSecretKey = new javax.swing.JButton();
        HybridSecretKeyPlaceHolder = new javax.swing.JLabel();
        ExportHybridWrappedSecretKey = new javax.swing.JButton();
        DecryptionPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        HybridCipherTextArea = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        HybridClearTextArea = new javax.swing.JTextArea();
        DecryptHybridButton = new javax.swing.JButton();
        ExportHybridDeButton = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        SEButton1 = new javax.swing.JButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        HybridSecretKeyPlaceHolder1 = new javax.swing.JLabel();
        ImportHybridWrappedSecretKey1 = new javax.swing.JButton();
        HybridDecryptFilePlaceHolder = new javax.swing.JLabel();
        ImportHybridCipherButton = new javax.swing.JButton();
        HybridPrivateKeyField2 = new javax.swing.JTextField();
        AboutPanel4 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        AboutPanel = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        AuthorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cryptography System");
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        Header.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        Header.setText("Cryptography System");

        Caesar.setBackground(new java.awt.Color(84, 151, 255));
        Caesar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Caesar.setForeground(new java.awt.Color(51, 51, 51));
        Caesar.setText("Caesar Cipher");
        Caesar.setToolTipText("<html>\n<center>\n<p>Caesar cipher is a simple substitution</p>\n<p>cipher where each letter in the plaintext</p>\n<p>is shifted a certain number of places</p>\n<p>down or up the alphabet.</p>\n</center>\n</html>");
        Caesar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Caesar.setName(""); // NOI18N
        Caesar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CaesarMouseClicked(evt);
            }
        });
        Caesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaesarActionPerformed(evt);
            }
        });

        Symmetric.setBackground(new java.awt.Color(84, 151, 255));
        Symmetric.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Symmetric.setForeground(new java.awt.Color(51, 51, 51));
        Symmetric.setText("Symmetric");
        Symmetric.setToolTipText("<html>\n<center>\n<p>Symmetric encryption is a cryptographic</p>\n<p>method where the same key is used for</p>\n<p>both the encryption and decryption of data.</p>\n</center>\n</html>");
        Symmetric.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SymmetricMouseClicked(evt);
            }
        });
        Symmetric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SymmetricActionPerformed(evt);
            }
        });

        Assymetric.setBackground(new java.awt.Color(84, 151, 255));
        Assymetric.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Assymetric.setForeground(new java.awt.Color(51, 51, 51));
        Assymetric.setText("Assymetric");
        Assymetric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssymetricActionPerformed(evt);
            }
        });

        Hybrid.setBackground(new java.awt.Color(84, 151, 255));
        Hybrid.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Hybrid.setForeground(new java.awt.Color(51, 51, 51));
        Hybrid.setText("Hybrid");
        Hybrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridActionPerformed(evt);
            }
        });

        About.setBackground(new java.awt.Color(84, 151, 255));
        About.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        About.setForeground(new java.awt.Color(51, 51, 51));
        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Symmetric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Caesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Assymetric, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Hybrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(About, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Caesar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Symmetric, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Assymetric, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Hybrid, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(About, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        MainLayeredPane.setLayout(new java.awt.CardLayout());

        CaesarPanel.setLayout(new java.awt.CardLayout());

        EncyptionPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Plain Text");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 0, 0);
        EncyptionPanel1.add(jLabel1, gridBagConstraints);

        CaesarPlainTextArea.setColumns(20);
        CaesarPlainTextArea.setLineWrap(true);
        CaesarPlainTextArea.setRows(5);
        jScrollPane1.setViewportView(CaesarPlainTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 276;
        gridBagConstraints.ipady = 282;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 74, 0);
        EncyptionPanel1.add(jScrollPane1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        EncyptionPanel1.add(EncryptShiftTextField, gridBagConstraints);

        jLabel3.setText("Shifts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 130, 0, 0);
        EncyptionPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Encrypted Text");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 64, 0, 0);
        EncyptionPanel1.add(jLabel4, gridBagConstraints);

        CaesarCipherTextArea.setColumns(20);
        CaesarCipherTextArea.setLineWrap(true);
        CaesarCipherTextArea.setRows(5);
        jScrollPane2.setViewportView(CaesarCipherTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 276;
        gridBagConstraints.ipady = 282;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 64, 74, 0);
        EncyptionPanel1.add(jScrollPane2, gridBagConstraints);

        EncryptButton1.setText("Encrypt");
        EncryptButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 40);
        EncyptionPanel1.add(EncryptButton1, gridBagConstraints);

        ExportCaesarCipherButton.setText("Export");
        ExportCaesarCipherButton.setEnabled(false);
        ExportCaesarCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportCaesarCipherButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 40);
        EncyptionPanel1.add(ExportCaesarCipherButton, gridBagConstraints);

        ImportCaesarCipherButton.setText("Import");
        ImportCaesarCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportCaesarCipherButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 40);
        EncyptionPanel1.add(ImportCaesarCipherButton, gridBagConstraints);

        CaesarTabPanel.addTab("Encrypt", EncyptionPanel1);

        DecryptionPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Cipher Text");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 0, 0);
        DecryptionPanel1.add(jLabel2, gridBagConstraints);

        CaesarEncryptedTextArea.setColumns(20);
        CaesarEncryptedTextArea.setLineWrap(true);
        CaesarEncryptedTextArea.setRows(5);
        jScrollPane3.setViewportView(CaesarEncryptedTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 276;
        gridBagConstraints.ipady = 282;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 74, 0);
        DecryptionPanel1.add(jScrollPane3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 0, 0);
        DecryptionPanel1.add(DecryptShiftTextField, gridBagConstraints);

        jLabel5.setText("Shifts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 121, 0, 0);
        DecryptionPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Decrypted Text");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 64, 0, 0);
        DecryptionPanel1.add(jLabel6, gridBagConstraints);

        CaesarClearTextArea.setColumns(20);
        CaesarClearTextArea.setRows(5);
        jScrollPane4.setViewportView(CaesarClearTextArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 276;
        gridBagConstraints.ipady = 282;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 64, 74, 0);
        DecryptionPanel1.add(jScrollPane4, gridBagConstraints);

        DecryptButton1.setText("Decrypt");
        DecryptButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 40);
        DecryptionPanel1.add(DecryptButton1, gridBagConstraints);

        ImportCaesarCipherButton2.setText("Import");
        ImportCaesarCipherButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportCaesarCipherButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 40);
        DecryptionPanel1.add(ImportCaesarCipherButton2, gridBagConstraints);

        ExportCaesarCipherButton2.setText("Export");
        ExportCaesarCipherButton2.setEnabled(false);
        ExportCaesarCipherButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportCaesarCipherButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 40);
        DecryptionPanel1.add(ExportCaesarCipherButton2, gridBagConstraints);

        CaesarTabPanel.addTab("Decrypt", DecryptionPanel1);

        jLabel13.setText("<html>Caesar encryption, also known as the Caesar cipher, is a basic substitution cipher where each letter in the plaintext is shifted a fixed number of positions in the alphabet. Named after Julius Caesar, who is said to have used it for military communication, the method involves a simple shift, such as three positions down or up the alphabet. For instance, 'A' becomes 'D,' 'B' becomes 'E,' and so on. While the Caesar cipher is historically significant, it is not considered secure in modern cryptography due to its vulnerability to brute-force attacks.</hmtl>");

        javax.swing.GroupLayout AboutPanel1Layout = new javax.swing.GroupLayout(AboutPanel1);
        AboutPanel1.setLayout(AboutPanel1Layout);
        AboutPanel1Layout.setHorizontalGroup(
            AboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        AboutPanel1Layout.setVerticalGroup(
            AboutPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(385, Short.MAX_VALUE))
        );

        CaesarTabPanel.addTab("About", AboutPanel1);

        CaesarPanel.add(CaesarTabPanel, "card2");

        MainLayeredPane.add(CaesarPanel, "card3");

        SymmetricPanel.setLayout(new java.awt.CardLayout());

        jLabel7.setText("Plain Text");

        SymmetricPlainTextArea.setColumns(20);
        SymmetricPlainTextArea.setLineWrap(true);
        SymmetricPlainTextArea.setRows(5);
        jScrollPane5.setViewportView(SymmetricPlainTextArea);

        jLabel9.setText("Encrypted Text");

        SymmetricCipherTextArea.setColumns(20);
        SymmetricCipherTextArea.setLineWrap(true);
        SymmetricCipherTextArea.setRows(5);
        jScrollPane6.setViewportView(SymmetricCipherTextArea);

        EncryptSymmetricButton.setText("Encrypt");
        EncryptSymmetricButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptSymmetricButtonActionPerformed(evt);
            }
        });

        ExportSymmetricCipherButton.setText("Export");
        ExportSymmetricCipherButton.setEnabled(false);
        ExportSymmetricCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportSymmetricCipherButtonActionPerformed(evt);
            }
        });

        ImportSymmetricCipherButton.setText("Import");
        ImportSymmetricCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportSymmetricCipherButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Secret Key");

        SymmetricButtonBroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Text");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        SymmetricButtonBroup1.add(jRadioButton2);
        jRadioButton2.setText("File");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        SIButton.setText("Encrypt file");
        SIButton.setEnabled(false);
        SIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIButtonActionPerformed(evt);
            }
        });

        SymmetricEncryptFilePlaceHolder.setText("[File]");

        javax.swing.GroupLayout EncyptionPanel2Layout = new javax.swing.GroupLayout(EncyptionPanel2);
        EncyptionPanel2.setLayout(EncyptionPanel2Layout);
        EncyptionPanel2Layout.setHorizontalGroup(
            EncyptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7)
                .addGap(305, 305, 305)
                .addComponent(jLabel9))
            .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(SymmetricKeyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jRadioButton1)
                .addGap(6, 6, 6)
                .addComponent(jRadioButton2))
            .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                .addGap(694, 694, 694)
                .addComponent(ImportSymmetricCipherButton))
            .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(SIButton)
                .addGap(64, 64, 64)
                .addComponent(SymmetricEncryptFilePlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(ExportSymmetricCipherButton))
            .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                .addGap(694, 694, 694)
                .addComponent(EncryptSymmetricButton))
        );
        EncyptionPanel2Layout.setVerticalGroup(
            EncyptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(EncyptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(EncyptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(EncyptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(SymmetricKeyPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(6, 6, 6)
                .addComponent(ImportSymmetricCipherButton)
                .addGap(18, 18, 18)
                .addGroup(EncyptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SIButton)
                    .addGroup(EncyptionPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(SymmetricEncryptFilePlaceHolder))
                    .addComponent(ExportSymmetricCipherButton))
                .addGap(18, 18, 18)
                .addComponent(EncryptSymmetricButton))
        );

        SymmetricKeyPassword.getAccessibleContext().setAccessibleName("");
        SymmetricKeyPassword.getAccessibleContext().setAccessibleDescription("");

        SymmetricTabPanel.addTab("Encrypt", EncyptionPanel2);

        jLabel10.setText("Cipher Text");

        SymmetricEncryptedTextArea.setColumns(20);
        SymmetricEncryptedTextArea.setLineWrap(true);
        SymmetricEncryptedTextArea.setRows(5);
        SymmetricEncryptedTextArea.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                SymmetricEncryptedTextAreaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane7.setViewportView(SymmetricEncryptedTextArea);

        jLabel12.setText("Decrypted Text");

        SymmetricClearTextArea.setColumns(20);
        SymmetricClearTextArea.setLineWrap(true);
        SymmetricClearTextArea.setRows(5);
        jScrollPane8.setViewportView(SymmetricClearTextArea);

        DecryptSymmetricButton2.setText("Decrypt");
        DecryptSymmetricButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptSymmetricButton2ActionPerformed(evt);
            }
        });

        ImportSymmetricCipherButton2.setText("Import");
        ImportSymmetricCipherButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportSymmetricCipherButton2ActionPerformed(evt);
            }
        });

        ExportSymmetricCipherButton2.setText("Export");
        ExportSymmetricCipherButton2.setEnabled(false);
        ExportSymmetricCipherButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportSymmetricCipherButton2ActionPerformed(evt);
            }
        });

        jLabel11.setText("Secret Key");

        SymmetricDecryptFilePlaceHolder.setText("[File]");

        SEButton.setText("Decrypt file");
        SEButton.setEnabled(false);
        SEButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEButtonActionPerformed(evt);
            }
        });

        SymmetricButtonBroup2.add(jRadioButton3);
        jRadioButton3.setText("File");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        SymmetricButtonBroup2.add(jRadioButton4);
        jRadioButton4.setSelected(true);
        jRadioButton4.setText("Text");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DecryptionPanel2Layout = new javax.swing.GroupLayout(DecryptionPanel2);
        DecryptionPanel2.setLayout(DecryptionPanel2Layout);
        DecryptionPanel2Layout.setHorizontalGroup(
            DecryptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel10)
                .addGap(296, 296, 296)
                .addComponent(jLabel12))
            .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(SymmetricKeyPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jRadioButton4)
                .addGap(6, 6, 6)
                .addComponent(jRadioButton3))
            .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                .addGap(694, 694, 694)
                .addComponent(ImportSymmetricCipherButton2))
            .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(SEButton)
                .addGap(64, 64, 64)
                .addComponent(SymmetricDecryptFilePlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(ExportSymmetricCipherButton2))
            .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                .addGap(694, 694, 694)
                .addComponent(DecryptSymmetricButton2))
        );
        DecryptionPanel2Layout.setVerticalGroup(
            DecryptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(DecryptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(DecryptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(DecryptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel11))
                    .addComponent(SymmetricKeyPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3))
                .addGap(6, 6, 6)
                .addComponent(ImportSymmetricCipherButton2)
                .addGap(18, 18, 18)
                .addGroup(DecryptionPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SEButton)
                    .addGroup(DecryptionPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(SymmetricDecryptFilePlaceHolder))
                    .addComponent(ExportSymmetricCipherButton2))
                .addGap(18, 18, 18)
                .addComponent(DecryptSymmetricButton2))
        );

        SymmetricTabPanel.addTab("Decrypt", DecryptionPanel2);

        jLabel14.setText("<html><p align=\"justify\">Symmetric encryption is a type of encryption where the same key is used for both the encryption and decryption of the data. In other words, a single secret key is shared between the sender and the recipient to secure the communication. The symmetric key is applied to the plaintext to transform it into ciphertext during encryption, and the same key is used to reverse this process during decryption to retrieve the original plaintext.  The challenge in symmetric encryption lies in securely sharing and managing the secret key between the communicating parties. Once the key is compromised, the security of the encrypted communication is at risk. Symmetric encryption algorithms are generally fast and efficient, making them suitable for encrypting large amounts of data.  Common symmetric encryption algorithms include the Advanced Encryption Standard (AES), Data Encryption Standard (DES), and Triple DES (3DES). While symmetric encryption is efficient for secure communication between trusted parties, it may not be the best choice for scenarios where secure key exchange is challenging or when different parties need to communicate securely over an insecure channel. In such cases, asymmetric encryption, or public-key cryptography, is often used.</html>");

        jLabel25.setText("<html><p align=\"justify\">AES, which stands for Advanced Encryption Standard, is a widely used symmetric encryption algorithm. It was established as a standard by the U.S. National Institute of Standards and Technology (NIST) in 2001, replacing the older Data Encryption Standard (DES). AES is a symmetric key algorithm, meaning the same key is used for both encryption and decryption.  AES operates on fixed-size blocks of data and supports key sizes of 128, 192, or 256 bits. The choice of key size affects the strength of the encryption. The algorithm consists of a series of transformations, including substitution (replacing each byte with another), permutation (rearranging the bytes), and mixing operations.  AES is considered highly secure and is widely used for encrypting sensitive information, such as in securing communications over the internet, protecting data on storage devices, and ensuring the confidentiality of information in various applications. Its widespread adoption and strong security features have made it a standard choice for symmetric encryption in a variety of contexts.</html>");

        javax.swing.GroupLayout AboutPanel2Layout = new javax.swing.GroupLayout(AboutPanel2);
        AboutPanel2.setLayout(AboutPanel2Layout);
        AboutPanel2Layout.setHorizontalGroup(
            AboutPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AboutPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        AboutPanel2Layout.setVerticalGroup(
            AboutPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        SymmetricTabPanel.addTab("About", AboutPanel2);

        SymmetricPanel.add(SymmetricTabPanel, "card2");

        MainLayeredPane.add(SymmetricPanel, "card3");

        AsymmetricPanel.setLayout(new java.awt.CardLayout());

        jLabel15.setText("Plain Text");

        AsymmetricPlainTextArea.setColumns(20);
        AsymmetricPlainTextArea.setLineWrap(true);
        AsymmetricPlainTextArea.setRows(5);
        jScrollPane9.setViewportView(AsymmetricPlainTextArea);

        jLabel16.setText("Public Key");

        AsymmetricPublicKeyField.setColumns(20);
        AsymmetricPublicKeyField.setLineWrap(true);
        AsymmetricPublicKeyField.setRows(5);
        jScrollPane10.setViewportView(AsymmetricPublicKeyField);

        EncryptAsymmetricButton.setText("Encrypt");
        EncryptAsymmetricButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptAsymmetricButtonActionPerformed(evt);
            }
        });

        ImportAsymmetricCipherButton.setText("Import");
        ImportAsymmetricCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportAsymmetricCipherButtonActionPerformed(evt);
            }
        });

        jLabel17.setText("Public Key");

        jLabel22.setText("Private Key");

        GenerateKeyPair.setText("Generate Key Pair");
        GenerateKeyPair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateKeyPairActionPerformed(evt);
            }
        });

        AssymetricPublicKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssymetricPublicKeyActionPerformed(evt);
            }
        });

        jButton5.setText("Export Public Key");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Export Private Key");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EncyptionPanel3Layout = new javax.swing.GroupLayout(EncyptionPanel3);
        EncyptionPanel3.setLayout(EncyptionPanel3Layout);
        EncyptionPanel3Layout.setHorizontalGroup(
            EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel22)
                            .addGap(28, 28, 28)
                            .addComponent(AssymetricPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                                    .addComponent(jButton5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                                    .addComponent(GenerateKeyPair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(45, 45, 45)))
                            .addComponent(jButton6)))
                    .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(305, 305, 305)
                                .addComponent(jLabel16))
                            .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(31, 31, 31)
                                    .addComponent(AssymetricPublicKey, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(356, 356, 356))
                                .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(64, 64, 64)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImportAsymmetricCipherButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EncryptAsymmetricButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        EncyptionPanel3Layout.setVerticalGroup(
            EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AssymetricPublicKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17)))
                .addGap(3, 3, 3)
                .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel22))
                    .addGroup(EncyptionPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(AssymetricPrivateKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(GenerateKeyPair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EncyptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncyptionPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImportAsymmetricCipherButton)
                .addGap(18, 18, 18)
                .addComponent(EncryptAsymmetricButton)
                .addContainerGap())
        );

        AsymmetricTabPanel.addTab("Encrypt", EncyptionPanel3);

        jLabel19.setText("Decrypted Text");

        AsymmetricClearTextArea.setColumns(20);
        AsymmetricClearTextArea.setLineWrap(true);
        AsymmetricClearTextArea.setRows(5);
        jScrollPane12.setViewportView(AsymmetricClearTextArea);

        DecryptAsymmetricButton.setText("Decrypt");
        DecryptAsymmetricButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptAsymmetricButtonActionPerformed(evt);
            }
        });

        ExportAsymmetricCipherButton2.setText("Export");
        ExportAsymmetricCipherButton2.setEnabled(false);
        ExportAsymmetricCipherButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportAsymmetricCipherButton2ActionPerformed(evt);
            }
        });

        jLabel20.setText("Private Key");

        AsymmetricDecryptFilePlaceHolder.setText("[File]");

        AsymmetricPrivateKeyField.setColumns(20);
        AsymmetricPrivateKeyField.setLineWrap(true);
        AsymmetricPrivateKeyField.setRows(5);
        jScrollPane13.setViewportView(AsymmetricPrivateKeyField);

        javax.swing.GroupLayout DecryptionPanel3Layout = new javax.swing.GroupLayout(DecryptionPanel3);
        DecryptionPanel3.setLayout(DecryptionPanel3Layout);
        DecryptionPanel3Layout.setHorizontalGroup(
            DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptionPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DecryptionPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addGroup(DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel19)
                    .addGroup(DecryptionPanel3Layout.createSequentialGroup()
                        .addGroup(DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(DecryptAsymmetricButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ExportAsymmetricCipherButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(AsymmetricDecryptFilePlaceHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118))
        );
        DecryptionPanel3Layout.setVerticalGroup(
            DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DecryptionPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jScrollPane13))
                .addGap(18, 18, 18)
                .addGroup(DecryptionPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DecryptAsymmetricButton)
                    .addComponent(AsymmetricDecryptFilePlaceHolder))
                .addGap(18, 18, 18)
                .addComponent(ExportAsymmetricCipherButton2)
                .addContainerGap())
        );

        AsymmetricTabPanel.addTab("Decrypt", DecryptionPanel3);

        jLabel21.setText("<html><p align=\"justify\">Asymmetric encryption, or public-key cryptography, is a cryptographic approach employing a pair of mathematically related keys: a public key for encryption and a private key for decryption. The public key is openly shared and can be used by anyone to encrypt messages, while the private key, kept confidential, is used by the intended recipient to decrypt the messages. This two-key system addresses the key distribution challenge faced by symmetric encryption, allowing secure communication between parties without the need for a pre-shared secret. Asymmetric encryption is utilized for secure key exchange, digital signatures to verify message authenticity, and in protocols like SSL/TLS for securing internet communications. Prominent asymmetric encryption algorithms include RSA and ECC, offering a versatile and widely adopted means of achieving secure data transmission and authentication.</html>");

        jLabel33.setText("<html><p align=\"justify\">The RSA algorithm, named after its inventors Ron Rivest, Adi Shamir, and Leonard Adleman, is a widely used asymmetric encryption algorithm in cryptography. RSA plays a crucial role in securing communications, digital signatures, and other cryptographic applications.  The key feature of RSA is its reliance on the mathematical properties of large prime numbers. The algorithm involves the generation of a public key and a corresponding private key. The public key is freely distributed, while the private key is kept secret.</html>");

        javax.swing.GroupLayout AboutPanel3Layout = new javax.swing.GroupLayout(AboutPanel3);
        AboutPanel3.setLayout(AboutPanel3Layout);
        AboutPanel3Layout.setHorizontalGroup(
            AboutPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AboutPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        AboutPanel3Layout.setVerticalGroup(
            AboutPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        AsymmetricTabPanel.addTab("About", AboutPanel3);

        AsymmetricPanel.add(AsymmetricTabPanel, "card2");

        MainLayeredPane.add(AsymmetricPanel, "card3");

        HyridPanel.setLayout(new java.awt.CardLayout());

        EncyptionPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setText("Plain Text");
        EncyptionPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 36, -1, -1));

        HybridPlainTextArea.setColumns(20);
        HybridPlainTextArea.setLineWrap(true);
        HybridPlainTextArea.setRows(5);
        jScrollPane11.setViewportView(HybridPlainTextArea);

        EncyptionPanel4.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 70, 292, 170));

        jLabel24.setText("Encrypted Text");
        EncyptionPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 36, -1, -1));

        HybridEncryptedTextArea.setColumns(20);
        HybridEncryptedTextArea.setLineWrap(true);
        HybridEncryptedTextArea.setRows(5);
        jScrollPane14.setViewportView(HybridEncryptedTextArea);

        EncyptionPanel4.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 70, 292, 170));

        EncryptHybridButton.setText("Encrypt");
        EncryptHybridButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EncryptHybridButtonActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(EncryptHybridButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 109, 92, -1));

        ExportHybridEnButton.setText("Export");
        ExportHybridEnButton.setEnabled(false);
        ExportHybridEnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportHybridEnButtonActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(ExportHybridEnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 191, 92, -1));

        ImportHybridPlainButton.setText("Import");
        ImportHybridPlainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportHybridPlainButtonActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(ImportHybridPlainButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 325, -1, -1));

        HybridButtonGroup1.add(jRadioButton5);
        jRadioButton5.setSelected(true);
        jRadioButton5.setText("Text");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 70, -1, -1));

        HybridButtonGroup1.add(jRadioButton6);
        jRadioButton6.setText("File");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 70, -1, -1));

        SIButton1.setText("Open File");
        SIButton1.setEnabled(false);
        SIButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIButton1ActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(SIButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 150, 92, -1));

        HybridEncryptFilePlaceHolder.setText("[File]");
        EncyptionPanel4.add(HybridEncryptFilePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 410, -1));

        jButton7.setText("Export Private Key");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 354, -1, -1));

        jButton8.setText("Export Public Key");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 354, -1, -1));

        GenerateKeyPair1.setText("Generate Key Pair");
        GenerateKeyPair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateKeyPair1ActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(GenerateKeyPair1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 325, -1, -1));

        HybridPrivateKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridPrivateKeyActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(HybridPrivateKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 288, 202, -1));

        jLabel30.setText("Private Key");
        EncyptionPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 291, -1, -1));

        HybridPublicKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridPublicKeyActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(HybridPublicKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 258, 202, -1));

        jLabel31.setText("Public Key");
        EncyptionPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 261, -1, -1));

        HybridPrivateKeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridPrivateKeyFieldActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(HybridPrivateKeyField, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 258, 210, -1));

        jLabel32.setText("Private Key");
        jLabel32.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel32AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        EncyptionPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 261, -1, -1));

        ImportHybridWrappedSecretKey.setText("Import Secret Key");
        ImportHybridWrappedSecretKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportHybridWrappedSecretKeyActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(ImportHybridWrappedSecretKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 288, -1, -1));

        HybridSecretKeyPlaceHolder.setText("[Secret Key]");
        EncyptionPanel4.add(HybridSecretKeyPlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 291, 269, -1));

        ExportHybridWrappedSecretKey.setText("Export Secret Key");
        ExportHybridWrappedSecretKey.setEnabled(false);
        ExportHybridWrappedSecretKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportHybridWrappedSecretKeyActionPerformed(evt);
            }
        });
        EncyptionPanel4.add(ExportHybridWrappedSecretKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 325, 125, -1));

        HybridTabPanel.addTab("Encrypt", EncyptionPanel4);

        DecryptionPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setText("Cipher Text");
        DecryptionPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 36, -1, -1));

        HybridCipherTextArea.setColumns(20);
        HybridCipherTextArea.setLineWrap(true);
        HybridCipherTextArea.setRows(5);
        HybridCipherTextArea.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                HybridCipherTextAreaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane15.setViewportView(HybridCipherTextArea);

        DecryptionPanel4.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 70, 292, 170));

        jLabel27.setText("Decrypted Text");
        DecryptionPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 36, -1, -1));

        HybridClearTextArea.setColumns(20);
        HybridClearTextArea.setLineWrap(true);
        HybridClearTextArea.setRows(5);
        jScrollPane16.setViewportView(HybridClearTextArea);

        DecryptionPanel4.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 70, 292, 170));

        DecryptHybridButton.setText("Decrypt");
        DecryptHybridButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptHybridButtonActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(DecryptHybridButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 109, 92, -1));

        ExportHybridDeButton.setText("Export");
        ExportHybridDeButton.setEnabled(false);
        ExportHybridDeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportHybridDeButtonActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(ExportHybridDeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 191, 92, -1));

        jLabel28.setText("Private Key");
        DecryptionPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(362, 261, -1, -1));

        SEButton1.setText("Open File");
        SEButton1.setEnabled(false);
        SEButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SEButton1ActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(SEButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 150, 92, -1));

        HybridButtonGroup2.add(jRadioButton7);
        jRadioButton7.setText("File");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 70, -1, -1));

        HybridButtonGroup2.add(jRadioButton8);
        jRadioButton8.setSelected(true);
        jRadioButton8.setText("Text");
        jRadioButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton8ActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 70, -1, -1));

        HybridSecretKeyPlaceHolder1.setText("[Secret Key]");
        DecryptionPanel4.add(HybridSecretKeyPlaceHolder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 291, 269, -1));

        ImportHybridWrappedSecretKey1.setText("Import Secret Key");
        ImportHybridWrappedSecretKey1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportHybridWrappedSecretKey1ActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(ImportHybridWrappedSecretKey1, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 288, -1, -1));

        HybridDecryptFilePlaceHolder.setText("[File]");
        DecryptionPanel4.add(HybridDecryptFilePlaceHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 410, -1));

        ImportHybridCipherButton.setText("Import");
        ImportHybridCipherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportHybridCipherButtonActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(ImportHybridCipherButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 325, -1, -1));

        HybridPrivateKeyField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HybridPrivateKeyField2ActionPerformed(evt);
            }
        });
        DecryptionPanel4.add(HybridPrivateKeyField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 258, 216, -1));

        HybridTabPanel.addTab("Decrypt", DecryptionPanel4);

        jLabel29.setText("<html><p align=\"justify\">Hybrid encryption is a cryptographic method that combines the efficiency of symmetric encryption with the secure key exchange capabilities of asymmetric encryption. In this approach, two parties use asymmetric encryption to securely exchange a shared secret key. One party generates a random symmetric key, encrypts it with the recipient's public key, and sends it. The recipient, using its private key, decrypts the symmetric key. With the shared symmetric key established, both parties switch to symmetric encryption for the bulk of the data. This hybrid approach addresses the challenges of key distribution in symmetric encryption and the computational intensity of asymmetric encryption, providing a practical and secure solution for various cryptographic applications.</html>");

        jLabel34.setText("<html><p align=\"justify\">In a hybrid encryption setup, the combination of AES (Advanced Encryption Standard) and RSA is a common approach to harness the strengths of both symmetric and asymmetric encryption. The process begins with RSA facilitating the secure exchange of a shared symmetric key. The sender generates a random symmetric key for AES, encrypts it using the recipient's RSA public key, and transmits it. The recipient, holding the corresponding RSA private key, decrypts the received symmetric key, establishing a shared secret between the parties. Subsequently, both sender and recipient transition to AES, a symmetric encryption algorithm known for its efficiency in bulk data encryption. AES is employed to encrypt the actual data, ensuring a balance between the security achieved through RSA's key exchange and the computational efficiency of AES for the encryption of substantial data volumes. This hybrid encryption model is widely utilized in secure communication protocols like SSL/TLS for safeguarding sensitive information during internet transactions.</html>");

        javax.swing.GroupLayout AboutPanel4Layout = new javax.swing.GroupLayout(AboutPanel4);
        AboutPanel4.setLayout(AboutPanel4Layout);
        AboutPanel4Layout.setHorizontalGroup(
            AboutPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AboutPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        AboutPanel4Layout.setVerticalGroup(
            AboutPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        HybridTabPanel.addTab("About", AboutPanel4);

        HyridPanel.add(HybridTabPanel, "card2");

        MainLayeredPane.add(HyridPanel, "card3");

        jLabel35.setText("<html>\n<p>Bestlink College of the Philippines</p>\n<br />\n<p>2023</p>\n<br />\n<p align=\"justify\">This program is dedicated to exploring various encryption techniques for academic purposes, aiming to provide a comprehensive overview of fundamental methods essential for information security. The contents focus on basic approaches such as Caesar encryption, alongside more advanced algorithms like AES (Advanced Encryption Standard) and RSA (Rivest–Shamir–Adleman). The goal is to clarify the basic principles and applications of each encryption type, culminating in the discussion of hybrid encryption systems. This academic section seeks to deepen understanding and appreciation for the role of encryption in safeguarding information integrity, confidentiality, and authenticity within the realm of cybersecurity.</p>\n<br />\n<br />\n<br />\n<p>BSIT 3108</p>\n<br />\n<p>Aron III</p>\n<p>Alde</p>\n<p>Laserna</p>\n<p>Batocabe</p>\n<p>Reyes</p>\n<p>Santos</p>\n</html>");

        javax.swing.GroupLayout AboutPanelLayout = new javax.swing.GroupLayout(AboutPanel);
        AboutPanel.setLayout(AboutPanelLayout);
        AboutPanelLayout.setHorizontalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
                .addContainerGap())
        );
        AboutPanelLayout.setVerticalGroup(
            AboutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AboutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainLayeredPane.add(AboutPanel, "card6");

        AuthorLabel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        AuthorLabel.setText("[ACADEMIC PURPOSES] BCP BSIT-3108 2023");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Header)
                .addGap(302, 302, 302))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AuthorLabel)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(MainLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MainLayeredPane, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(AuthorLabel)
                .addContainerGap())
        );

        getContentPane().add(MainPanel, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CaesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaesarActionPerformed
        // TODO add your handling code here:
        Caesar.setBackground(new Color(77,123,196));
        Symmetric.setBackground(new Color(84,151,255));
        Assymetric.setBackground(new Color(84,151,255));
        Hybrid.setBackground(new Color(84,151,255));
        About.setBackground(new Color(84,151,255));
        switchPanels(CaesarPanel);
    }//GEN-LAST:event_CaesarActionPerformed

    private void EncryptButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptButton1ActionPerformed
        
        String message = CaesarPlainTextArea.getText();
        String shiftText = EncryptShiftTextField.getText();
        
        // Check if message is not empty
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);

            return; // Stop further execution
        }
        
        // Check if shift is a number
        int shift;
        try {
            shift = Integer.parseInt(shiftText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Shift must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further execution
        }
        
        // Check if shift is not empty
        if (shiftText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Shift cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further execution
        }

        
        String cipherText = "";
        try {
            cipherText = CaesarCipher.encrypt(message, shift);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CaesarCipherTextArea.setText(cipherText);
        ExportCaesarCipherButton.setEnabled(true);
    }//GEN-LAST:event_EncryptButton1ActionPerformed

    private void DecryptButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptButton1ActionPerformed
        // TODO add your handling code here:
        String message = CaesarEncryptedTextArea.getText();
        String shiftText = DecryptShiftTextField.getText();
        
        // Check if message is not empty
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);

            return; // Stop further execution
        }
        
        // Check if shift is a number
        int shift;
        try {
            shift = Integer.parseInt(shiftText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Shift must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further execution
        }
        
        // Check if shift is not empty
        if (shiftText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Shift cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop further execution
        }
        String plainText = "";
        try {
            plainText = CaesarCipher.decrypt(message, shift);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CaesarClearTextArea.setText(plainText);
        ExportCaesarCipherButton2.setEnabled(true);
    }//GEN-LAST:event_DecryptButton1ActionPerformed

    private void ExportCaesarCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportCaesarCipherButtonActionPerformed
        // TODO add your handling code here:
        ExportTextFile(CaesarCipherTextArea.getText());
        CaesarCipherTextArea.setText("");
        ExportCaesarCipherButton.setEnabled(false);
    }//GEN-LAST:event_ExportCaesarCipherButtonActionPerformed

    private void ImportCaesarCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportCaesarCipherButtonActionPerformed
        // TODO add your handling code here:
        ImportTextFile(CaesarPlainTextArea);
    }//GEN-LAST:event_ImportCaesarCipherButtonActionPerformed

    private void ImportCaesarCipherButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportCaesarCipherButton2ActionPerformed
        // TODO add your handling code here:
        ImportTextFile(CaesarEncryptedTextArea);
    }//GEN-LAST:event_ImportCaesarCipherButton2ActionPerformed

    private void ExportCaesarCipherButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportCaesarCipherButton2ActionPerformed
        // TODO add your handling code here:
        ExportTextFile(CaesarClearTextArea.getText());
        CaesarClearTextArea.setText("");
        ExportCaesarCipherButton2.setEnabled(false);
    }//GEN-LAST:event_ExportCaesarCipherButton2ActionPerformed

    private void ExportSymmetricCipherButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportSymmetricCipherButton2ActionPerformed
        // TODO add your handling code here:
        ExportTextFile(SymmetricClearTextArea.getText());
        SymmetricClearTextArea.setText("");
        ExportSymmetricCipherButton2.setEnabled(false);
    }//GEN-LAST:event_ExportSymmetricCipherButton2ActionPerformed

    private void ImportSymmetricCipherButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportSymmetricCipherButton2ActionPerformed
        // TODO add your handling code here:
        ImportTextFile(SymmetricEncryptedTextArea);
    }//GEN-LAST:event_ImportSymmetricCipherButton2ActionPerformed

    private void DecryptSymmetricButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptSymmetricButton2ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton4.isSelected())
        {
            String message = SymmetricEncryptedTextArea.getText();
            char[] passwordChars = SymmetricKeyPassword1.getPassword();
            String password = new String(passwordChars);

            // Check if message is not empty
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            // Check if Secret key is not empty
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Secret key is needed.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            try {
                SecretKey secretKey = SymmetricEncryption.deriveKeyFromPassword(password);
                byte[] decodedEncryptedMessage = Base64.getDecoder().decode(message);
                String decryptedMessage = SymmetricEncryption.decrypt(decodedEncryptedMessage, secretKey);

                SymmetricClearTextArea.setText(decryptedMessage);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: Incorrect password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            ExportSymmetricCipherButton.setEnabled(true);
        }
        else if(jRadioButton3.isSelected())
        {
            char[] passwordChars = SymmetricKeyPassword1.getPassword();
            String password = new String(passwordChars);

            // Check if there is no file is selected
            if(SymmetricDecryptFilePlaceHolder.getText().equals("[File]"))
            {
                JOptionPane.showMessageDialog(this, "Error: Please Select file.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            // Check if Secret key is not empty
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Secret key is needed.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            String outputFilePath = SIFileEn();

            // Check if file path is not empty
            if (outputFilePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No file is selected.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further execution
            }
            try {
                SymmetricEncryption.decryptFile(SymmetricDecryptFilePlaceHolder.getText(), outputFilePath, password );
                JOptionPane.showMessageDialog(this, "The File is decrypted successful.", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                Path path = Paths.get(outputFilePath);
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Error: Incorrect password.", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_DecryptSymmetricButton2ActionPerformed

    private void SymmetricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SymmetricActionPerformed
        // TODO add your handling code here:
        Caesar.setBackground(new Color(84,151,255));
        Symmetric.setBackground(new Color(77,123,196));
        Assymetric.setBackground(new Color(84,151,255));
        Hybrid.setBackground(new Color(84,151,255));
        About.setBackground(new Color(84,151,255));
        switchPanels(SymmetricPanel);
    }//GEN-LAST:event_SymmetricActionPerformed

    private void CaesarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CaesarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CaesarMouseClicked

    private void SymmetricMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SymmetricMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_SymmetricMouseClicked

    private void SymmetricEncryptedTextAreaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_SymmetricEncryptedTextAreaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_SymmetricEncryptedTextAreaAncestorAdded

    private void SIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIButtonActionPerformed
        // TODO add your handling code here:
        ChooseFile(SymmetricEncryptFilePlaceHolder);
    }//GEN-LAST:event_SIButtonActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        SymmetricPlainTextArea.setEnabled(false);
        SymmetricCipherTextArea.setEnabled(false);
        ExportSymmetricCipherButton.setEnabled(false);
        ImportSymmetricCipherButton.setEnabled(false);
        SymmetricEncryptFilePlaceHolder.setText("[File]");
        SymmetricKeyPassword.setText("");
        SymmetricPlainTextArea.setText("");
        SymmetricCipherTextArea.setText("");
        SIButton.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        SymmetricPlainTextArea.setEnabled(true);
        SymmetricCipherTextArea.setEnabled(true);
        ImportSymmetricCipherButton.setEnabled(true);
        SymmetricEncryptFilePlaceHolder.setText("[File]");
        SymmetricKeyPassword.setText("");
        SymmetricPlainTextArea.setText("");
        SymmetricCipherTextArea.setText("");
        SIButton.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void ImportSymmetricCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportSymmetricCipherButtonActionPerformed
        // TODO add your handling code here:
        ImportTextFile(SymmetricPlainTextArea);
    }//GEN-LAST:event_ImportSymmetricCipherButtonActionPerformed

    private void ExportSymmetricCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportSymmetricCipherButtonActionPerformed
        // TODO add your handling code here:
        ExportTextFile(SymmetricCipherTextArea.getText());
        SymmetricCipherTextArea.setText("");
        ExportCaesarCipherButton.setEnabled(false);
    }//GEN-LAST:event_ExportSymmetricCipherButtonActionPerformed

    private void EncryptSymmetricButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptSymmetricButtonActionPerformed
        // TODO add your handling code here:
        if(jRadioButton1.isSelected())
        {
            String message = SymmetricPlainTextArea.getText();
            char[] passwordChars = SymmetricKeyPassword.getPassword();
            String password = new String(passwordChars);

            // Check if message is not empty
            if (message.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            // Check if Secret key is not empty
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Secret key is needed.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            try {
                SecretKey secretKey = SymmetricEncryption.deriveKeyFromPassword(password);
                byte[] encryptedMessage = SymmetricEncryption.encrypt(message, secretKey);
                SymmetricCipherTextArea.setText(Base64.getEncoder().encodeToString(encryptedMessage));
            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            ExportSymmetricCipherButton.setEnabled(true);
        }
        else if(jRadioButton2.isSelected())
        {
            char[] passwordChars = SymmetricKeyPassword.getPassword();
            String password = new String(passwordChars);

            // Check if there is no file is selected
            if(SymmetricEncryptFilePlaceHolder.getText().equals("[File]"))
            {
                JOptionPane.showMessageDialog(this, "Error: Please Select file.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            // Check if Secret key is not empty
            if (password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: Secret key is needed.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }

            String inputFilePath = SIFileEn("encaes");

            // Check if file path is not empty
            if (inputFilePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No file is selected.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }
            try {
                SymmetricEncryption.encryptFile(SymmetricEncryptFilePlaceHolder.getText(), inputFilePath, password );
                JOptionPane.showMessageDialog(this, "The File is successfully encrypted.", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_EncryptSymmetricButtonActionPerformed

    private void SEButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEButtonActionPerformed
        // TODO add your handling code here:
        ChooseFile(SymmetricDecryptFilePlaceHolder,"encaes");
    }//GEN-LAST:event_SEButtonActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        SymmetricEncryptedTextArea.setEnabled(false);
        SymmetricClearTextArea.setEnabled(false);
        ExportSymmetricCipherButton2.setEnabled(false);
        ImportSymmetricCipherButton2.setEnabled(false);
        SymmetricDecryptFilePlaceHolder.setText("[File]");
        SymmetricKeyPassword1.setText("");
        SymmetricEncryptedTextArea.setText("");
        SymmetricClearTextArea.setText("");
        SEButton.setEnabled(true);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        SymmetricEncryptedTextArea.setEnabled(true);
        SymmetricClearTextArea.setEnabled(true);
        ImportSymmetricCipherButton2.setEnabled(true);
        SymmetricDecryptFilePlaceHolder.setText("[File]");
        SymmetricKeyPassword1.setText("");
        SymmetricEncryptedTextArea.setText("");
        SymmetricClearTextArea.setText("");
        SEButton.setEnabled(false);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void AssymetricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssymetricActionPerformed
        // TODO add your handling code here:
        Caesar.setBackground(new Color(84,151,255));
        Symmetric.setBackground(new Color(84,151,255));
        Assymetric.setBackground(new Color(77,123,196));
        Hybrid.setBackground(new Color(84,151,255));
        About.setBackground(new Color(84,151,255));
        switchPanels(AsymmetricPanel);
    }//GEN-LAST:event_AssymetricActionPerformed

    private void AssymetricPublicKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssymetricPublicKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AssymetricPublicKeyActionPerformed

    private void GenerateKeyPairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateKeyPairActionPerformed
        KeyPair keyPair;
        // Get public and private keys
        PublicKey publicKey;
        PrivateKey privateKey;
        try {
            // TODO add your handling code here:
            keyPair = AsymmetricEncryption.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
            AssymetricPublicKey.setText(AsymmetricEncryption.getX509FormattedKey(keyPair.getPublic(), "PUBLIC"));
            AssymetricPrivateKey.setText(AsymmetricEncryption.getX509FormattedKey(keyPair.getPrivate(), "PRIVATE"));
            PKS = AssymetricPublicKey.getText();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GenerateKeyPairActionPerformed

    private void ImportAsymmetricCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportAsymmetricCipherButtonActionPerformed
        // TODO add your handling code here:
        ImportTextFile(AsymmetricPlainTextArea);
    }//GEN-LAST:event_ImportAsymmetricCipherButtonActionPerformed

    private void EncryptAsymmetricButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptAsymmetricButtonActionPerformed
        // TODO add your handling code here:
        PublicKey publickey;
        String message = AsymmetricPlainTextArea.getText();
        String pub = AsymmetricPublicKeyField.getText();
        
        // Check if message is not empty
        if (message.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);

            return; // Stop further execution
        }
        
        // Check if pub is not empty
        if (pub.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Public key is needed.", "Error", JOptionPane.ERROR_MESSAGE);

            return; // Stop further execution
        }
        
        String filePath = SIFileEn("encrsa");
            
        try {
            publickey = AsymmetricEncryption.getPublicKeyFromX509String(pub);
            AsymmetricEncryption.encryptAndSaveToFile(message,filePath,publickey);
            JOptionPane.showMessageDialog(this, "The File is successfully encrypted.", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Failed to encrypt the file.", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_EncryptAsymmetricButtonActionPerformed

    private void ExportAsymmetricCipherButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportAsymmetricCipherButton2ActionPerformed
        // TODO add your handling code here:
        ExportTextFile(AsymmetricClearTextArea.getText());
    }//GEN-LAST:event_ExportAsymmetricCipherButton2ActionPerformed

    private void DecryptAsymmetricButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptAsymmetricButtonActionPerformed
        // TODO add your handling code here:
        if (AsymmetricPrivateKeyField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Error: Private key is needed.", "Error", JOptionPane.ERROR_MESSAGE);

            return; // Stop further execution
        }
        
        String filePath = SIFileEn("encrsa");
        AsymmetricDecryptFilePlaceHolder.setText(filePath);
        
        PrivateKey privatekey;
        try {
            privatekey = AsymmetricEncryption.getPrivateKeyFromPKCS8String(AsymmetricPrivateKeyField.getText());
            byte[] encryptedDataFromFile = AsymmetricEncryption.readEncryptedFile(filePath);
            String decryptedData = AsymmetricEncryption.decrypt(encryptedDataFromFile, privatekey);
            
            JOptionPane.showMessageDialog(this, "The file is successfully decrypted.", "Success", JOptionPane.INFORMATION_MESSAGE);
            AsymmetricClearTextArea.setText(decryptedData);
            ExportAsymmetricCipherButton2.setEnabled(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: Failed to decrypt the message.", "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_DecryptAsymmetricButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(AssymetricPublicKey.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Error: Public key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ExportTextFile(AssymetricPublicKey.getText());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(AssymetricPrivateKey.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Error: Please generate a key first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ExportTextFile(AssymetricPrivateKey.getText());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void EncryptHybridButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EncryptHybridButtonActionPerformed
        
        if(jRadioButton5.isSelected())
        {
            String message = HybridPlainTextArea.getText();
            String priv = HybridPrivateKeyField.getText();
            SecretKey secretkey;

            // Check if message is not empty
            if(message.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Error: Message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if priv is not empty
            if(priv.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Error: Private key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(HybridSecretKeyPlaceHolder.getText().isEmpty() || HybridSecretKeyPlaceHolder.getText().equals("[Secret Key]"))
            {
                JOptionPane.showMessageDialog(this, "Error: Secret Key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }    

            try {
                // TODO add your handling code here:
                PrivateKey privatekey = AsymmetricEncryption.getPrivateKeyFromPKCS8String(priv);
                secretkey = HybridEncryption.unwrapKey(HybridEncryption.wrappedSecretKey, privatekey);
                byte[] encryptedMessage = HybridEncryption.encryptData(message,secretkey);
                HybridEncryptedTextArea.setText(Base64.getEncoder().encodeToString(encryptedMessage));
                ExportHybridEnButton.setEnabled(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: Failed to encrypt the message.", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(jRadioButton6.isSelected())
        {
            String priv = HybridPrivateKeyField.getText();
            SecretKey secretkey;

            // Check if priv is not empty
            if(priv.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Error: Private key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(HybridSecretKeyPlaceHolder.getText().isEmpty() || HybridSecretKeyPlaceHolder.getText().equals("[Secret Key]"))
            {
                JOptionPane.showMessageDialog(this, "Error: Secret Key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 

            String inputFilePath = SIFileEn("encaes");

            // Check if file path is not empty
            if (inputFilePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No file is selected.", "Error", JOptionPane.ERROR_MESSAGE);

                return; // Stop further execution
            }
            try {
                PrivateKey privatekey = AsymmetricEncryption.getPrivateKeyFromPKCS8String(priv);
                secretkey = HybridEncryption.unwrapKey(HybridEncryption.wrappedSecretKey, privatekey);
                HybridEncryption.encryptFile(HybridEncryptFilePlaceHolder.getText(), inputFilePath, secretkey);
                JOptionPane.showMessageDialog(this, "The File is successfully encrypted.", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_EncryptHybridButtonActionPerformed

    private void ExportHybridEnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportHybridEnButtonActionPerformed
        // TODO add your handling code here:
        ExportTextFile(HybridEncryptedTextArea.getText());
        HybridEncryptedTextArea.setText("");
        ExportHybridEnButton.setEnabled(false);
    }//GEN-LAST:event_ExportHybridEnButtonActionPerformed

    private void ImportHybridPlainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportHybridPlainButtonActionPerformed
        // TODO add your handling code here:
        ImportTextFile(HybridPlainTextArea);
        
    }//GEN-LAST:event_ImportHybridPlainButtonActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        HybridPlainTextArea.setEnabled(true);
        ImportHybridPlainButton.setEnabled(true);
        SIButton1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        HybridPlainTextArea.setEnabled(false);
        ImportHybridPlainButton.setEnabled(false);
        SIButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void SIButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIButton1ActionPerformed
        // TODO add your handling code here:
        ChooseFile(HybridEncryptFilePlaceHolder);
    }//GEN-LAST:event_SIButton1ActionPerformed

    private void HybridCipherTextAreaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_HybridCipherTextAreaAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_HybridCipherTextAreaAncestorAdded

    private void DecryptHybridButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptHybridButtonActionPerformed
        // TODO add your handling code here:
        if(jRadioButton8.isSelected())
        {
            String message = HybridCipherTextArea.getText();
            String priv = HybridPrivateKeyField2.getText();
            SecretKey secretkey;

            // Check if message is not empty
            if(message.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Error: Message cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if priv is not empty
            if(priv.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Error: Private key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(HybridSecretKeyPlaceHolder1.getText().isEmpty() || HybridSecretKeyPlaceHolder1.getText().equals("[Secret Key]"))
            {
                JOptionPane.showMessageDialog(this, "Error: Secret Key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }   

            try {
                // TODO add your handling code here:
                PrivateKey privatekey = AsymmetricEncryption.getPrivateKeyFromPKCS8String(priv);
                secretkey = HybridEncryption.unwrapKey(HybridEncryption.wrappedSecretKey, privatekey);
                byte [] byteMessage = Base64.getDecoder().decode( message);
                String decryptedMessage = HybridEncryption.decryptData(byteMessage,secretkey);
                HybridClearTextArea.setText(decryptedMessage);
                ExportHybridDeButton.setEnabled(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: Failed to encrypt the message.", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(jRadioButton7.isSelected())
        {
            String priv = HybridPrivateKeyField2.getText();
            SecretKey secretkey;

            // Check if priv is not empty
            if(priv.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "Error: Private key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if(HybridSecretKeyPlaceHolder1.getText().isEmpty() || HybridSecretKeyPlaceHolder1.getText().equals("[Secret Key]"))
            {
                JOptionPane.showMessageDialog(this, "Error: Secret Key is needed.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String outputFilePath = SIFileEn();

            // Check if file path is not empty
            if (outputFilePath.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Error: No file is selected.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further execution
            }
            try {
                PrivateKey privatekey = AsymmetricEncryption.getPrivateKeyFromPKCS8String(priv);
                secretkey = HybridEncryption.unwrapKey(HybridEncryption.wrappedSecretKey, privatekey);
                HybridEncryption.decryptFile(HybridDecryptFilePlaceHolder.getText(), outputFilePath, secretkey);
                JOptionPane.showMessageDialog(this, "The File is decrypted successful.", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (Exception ex) {
                Path path = Paths.get(outputFilePath);
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Error: Incorrect password.", "Error", JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_DecryptHybridButtonActionPerformed

    private void ExportHybridDeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportHybridDeButtonActionPerformed
        // TODO add your handling code here:
        ExportTextFile(HybridClearTextArea.getText());
        HybridClearTextArea.setText("");
        ExportHybridDeButton.setEnabled(false);
    }//GEN-LAST:event_ExportHybridDeButtonActionPerformed

    private void SEButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SEButton1ActionPerformed
        // TODO add your handling code here:
        ChooseFile(HybridDecryptFilePlaceHolder,"encaes");
    }//GEN-LAST:event_SEButton1ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
        HybridCipherTextArea.setEnabled(false);
        ImportHybridCipherButton.setEnabled(false);
        SEButton1.setEnabled(true);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton8ActionPerformed
        // TODO add your handling code here:
        HybridCipherTextArea.setEnabled(true);
        ImportHybridCipherButton.setEnabled(true);
        SEButton1.setEnabled(false);
    }//GEN-LAST:event_jRadioButton8ActionPerformed

    private void HybridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridActionPerformed
        // TODO add your handling code here:
        Caesar.setBackground(new Color(84,151,255));
        Symmetric.setBackground(new Color(84,151,255));
        Assymetric.setBackground(new Color(84,151,255));
        Hybrid.setBackground(new Color(77,123,196));
        About.setBackground(new Color(84,151,255));
        switchPanels(HyridPanel);
    }//GEN-LAST:event_HybridActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        if(HybridPrivateKey.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Error: Please generate a key first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ExportTextFile(HybridPrivateKey.getText());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(HybridPublicKey.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Error: Please generate a key first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ExportTextFile(HybridPublicKey.getText());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void GenerateKeyPair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateKeyPair1ActionPerformed
        // TODO add your handling code here:
        KeyPair keyPair;
        SecretKey secretKey;
        // Get public and private keys
        PublicKey publicKey;
        PrivateKey privateKey;
        
        try {
            keyPair = HybridEncryption.generateKeyPair();
            secretKey = HybridEncryption.generateSecretKey();
            
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();
            
            HybridEncryption.wrappedSecretKey = HybridEncryption.wrapKey(secretKey, publicKey);
            HybridPublicKey.setText(AsymmetricEncryption.getX509FormattedKey(keyPair.getPublic(), "PUBLIC"));
            HybridPrivateKey.setText(AsymmetricEncryption.getX509FormattedKey(keyPair.getPrivate(), "PRIVATE"));
            ExportHybridWrappedSecretKey.setEnabled(true);
            
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GenerateKeyPair1ActionPerformed

    private void HybridPublicKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridPublicKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HybridPublicKeyActionPerformed

    private void HybridPrivateKeyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridPrivateKeyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HybridPrivateKeyFieldActionPerformed

    private void ImportHybridWrappedSecretKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportHybridWrappedSecretKeyActionPerformed
        // TODO add your handling code here:
        String filePath = SIFileEn("scrtky");
        
        if(filePath.isEmpty())
        {    
            return;
        }
        
        try {
            HybridEncryption.wrappedSecretKey = HybridEncryption.loadFileToByteArray(filePath);
            HybridSecretKeyPlaceHolder.setText(filePath);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ImportHybridWrappedSecretKeyActionPerformed

    private void ExportHybridWrappedSecretKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportHybridWrappedSecretKeyActionPerformed
        // TODO add your handling code here:
        String filePath = SIFileEn("scrtky");
        try {
            HybridEncryption.saveByteArrayToFile(HybridEncryption.wrappedSecretKey, filePath);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ExportHybridWrappedSecretKeyActionPerformed

    private void HybridPrivateKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridPrivateKeyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HybridPrivateKeyActionPerformed

    private void ImportHybridWrappedSecretKey1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportHybridWrappedSecretKey1ActionPerformed
        // TODO add your handling code here:
        String filePath = SIFileEn("scrtky");
        
        if(filePath.isEmpty())
        {    
            return;
        }
        
        try {
            HybridEncryption.wrappedSecretKey = HybridEncryption.loadFileToByteArray(filePath);
            HybridSecretKeyPlaceHolder1.setText(filePath);
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ImportHybridWrappedSecretKey1ActionPerformed

    private void ImportHybridCipherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportHybridCipherButtonActionPerformed
        // TODO add your handling code here:
        ImportTextFile(HybridCipherTextArea);
    }//GEN-LAST:event_ImportHybridCipherButtonActionPerformed

    private void jLabel32AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel32AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32AncestorAdded

    private void HybridPrivateKeyField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HybridPrivateKeyField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HybridPrivateKeyField2ActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        // TODO add your handling code here:
        Caesar.setBackground(new Color(84,151,255));
        Symmetric.setBackground(new Color(84,151,255));
        Assymetric.setBackground(new Color(84,151,255));
        Hybrid.setBackground(new Color(84,151,255));
        About.setBackground(new Color(77,123,196));
        switchPanels(AboutPanel);
    }//GEN-LAST:event_AboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton About;
    private javax.swing.JPanel AboutPanel;
    private javax.swing.JPanel AboutPanel1;
    private javax.swing.JPanel AboutPanel2;
    private javax.swing.JPanel AboutPanel3;
    private javax.swing.JPanel AboutPanel4;
    private javax.swing.JButton Assymetric;
    private javax.swing.JTextField AssymetricPrivateKey;
    private javax.swing.JTextField AssymetricPublicKey;
    private javax.swing.JTextArea AsymmetricClearTextArea;
    private javax.swing.JLabel AsymmetricDecryptFilePlaceHolder;
    private javax.swing.JPanel AsymmetricPanel;
    private javax.swing.JTextArea AsymmetricPlainTextArea;
    private javax.swing.JTextArea AsymmetricPrivateKeyField;
    private javax.swing.JTextArea AsymmetricPublicKeyField;
    private javax.swing.JTabbedPane AsymmetricTabPanel;
    private javax.swing.JLabel AuthorLabel;
    private javax.swing.JButton Caesar;
    private javax.swing.JTextArea CaesarCipherTextArea;
    private javax.swing.JTextArea CaesarClearTextArea;
    private javax.swing.JTextArea CaesarEncryptedTextArea;
    private javax.swing.JPanel CaesarPanel;
    private javax.swing.JTextArea CaesarPlainTextArea;
    private javax.swing.JTabbedPane CaesarTabPanel;
    private javax.swing.JButton DecryptAsymmetricButton;
    private javax.swing.JButton DecryptButton1;
    private javax.swing.JButton DecryptHybridButton;
    private javax.swing.JTextField DecryptShiftTextField;
    private javax.swing.JButton DecryptSymmetricButton2;
    private javax.swing.JPanel DecryptionPanel1;
    private javax.swing.JPanel DecryptionPanel2;
    private javax.swing.JPanel DecryptionPanel3;
    private javax.swing.JPanel DecryptionPanel4;
    private javax.swing.JButton EncryptAsymmetricButton;
    private javax.swing.JButton EncryptButton1;
    private javax.swing.JButton EncryptHybridButton;
    private javax.swing.JTextField EncryptShiftTextField;
    private javax.swing.JButton EncryptSymmetricButton;
    private javax.swing.JPanel EncyptionPanel1;
    private javax.swing.JPanel EncyptionPanel2;
    private javax.swing.JPanel EncyptionPanel3;
    private javax.swing.JPanel EncyptionPanel4;
    private javax.swing.JButton ExportAsymmetricCipherButton2;
    private javax.swing.JButton ExportCaesarCipherButton;
    private javax.swing.JButton ExportCaesarCipherButton2;
    private javax.swing.JButton ExportHybridDeButton;
    private javax.swing.JButton ExportHybridEnButton;
    private javax.swing.JButton ExportHybridWrappedSecretKey;
    private javax.swing.JButton ExportSymmetricCipherButton;
    private javax.swing.JButton ExportSymmetricCipherButton2;
    private javax.swing.JButton GenerateKeyPair;
    private javax.swing.JButton GenerateKeyPair1;
    private javax.swing.JLabel Header;
    private javax.swing.JButton Hybrid;
    private javax.swing.ButtonGroup HybridButtonGroup1;
    private javax.swing.ButtonGroup HybridButtonGroup2;
    private javax.swing.JTextArea HybridCipherTextArea;
    private javax.swing.JTextArea HybridClearTextArea;
    private javax.swing.JLabel HybridDecryptFilePlaceHolder;
    private javax.swing.JLabel HybridEncryptFilePlaceHolder;
    private javax.swing.JTextArea HybridEncryptedTextArea;
    private javax.swing.JTextArea HybridPlainTextArea;
    private javax.swing.JTextField HybridPrivateKey;
    private javax.swing.JTextField HybridPrivateKeyField;
    private javax.swing.JTextField HybridPrivateKeyField2;
    private javax.swing.JTextField HybridPublicKey;
    private javax.swing.JLabel HybridSecretKeyPlaceHolder;
    private javax.swing.JLabel HybridSecretKeyPlaceHolder1;
    private javax.swing.JTabbedPane HybridTabPanel;
    private javax.swing.JPanel HyridPanel;
    private javax.swing.JButton ImportAsymmetricCipherButton;
    private javax.swing.JButton ImportCaesarCipherButton;
    private javax.swing.JButton ImportCaesarCipherButton2;
    private javax.swing.JButton ImportHybridCipherButton;
    private javax.swing.JButton ImportHybridPlainButton;
    private javax.swing.JButton ImportHybridWrappedSecretKey;
    private javax.swing.JButton ImportHybridWrappedSecretKey1;
    private javax.swing.JButton ImportSymmetricCipherButton;
    private javax.swing.JButton ImportSymmetricCipherButton2;
    private javax.swing.JLayeredPane MainLayeredPane;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton SEButton;
    private javax.swing.JButton SEButton1;
    private javax.swing.JButton SIButton;
    private javax.swing.JButton SIButton1;
    private javax.swing.JButton Symmetric;
    private javax.swing.ButtonGroup SymmetricButtonBroup1;
    private javax.swing.ButtonGroup SymmetricButtonBroup2;
    private javax.swing.JTextArea SymmetricCipherTextArea;
    private javax.swing.JTextArea SymmetricClearTextArea;
    private javax.swing.JLabel SymmetricDecryptFilePlaceHolder;
    private javax.swing.JLabel SymmetricEncryptFilePlaceHolder;
    private javax.swing.JTextArea SymmetricEncryptedTextArea;
    private javax.swing.JPasswordField SymmetricKeyPassword;
    private javax.swing.JPasswordField SymmetricKeyPassword1;
    private javax.swing.JPanel SymmetricPanel;
    private javax.swing.JTextArea SymmetricPlainTextArea;
    private javax.swing.JTabbedPane SymmetricTabPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
