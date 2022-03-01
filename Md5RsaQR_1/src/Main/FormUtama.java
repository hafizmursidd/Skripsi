/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main;

import Controller.*;
import Controller.FileController;
import Controller.Docx;
import Controller.MD5;
import Controller.RSA;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FormUtama extends javax.swing.JFrame {
    
    public static int panjangArray;
    //pemecahanBlok plainteksBlok[] = new pemecahanBlok [];

    /**
     * Creates new form MainFrame
     */
    public FormUtama() {
        this.setTitle("Digital Signature");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FormUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setLocationRelativeTo(this);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        textField_pathSumberFile = new javax.swing.JTextField();
        button_pathSumber = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        textField_pathSimpanFile = new javax.swing.JTextField();
        button_fileSimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textField_panjangBit = new javax.swing.JTextField();
        button_generateTTD = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        label_nilaiN = new javax.swing.JLabel();
        label_nilaiPublik = new javax.swing.JLabel();
        label_nilaiPrivat = new javax.swing.JLabel();
        label_notifikasi = new javax.swing.JLabel();
        label_valueN = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        label_KPrivate = new javax.swing.JLabel();
        label_kPublik = new javax.swing.JLabel();
        cb_ttd = new javax.swing.JCheckBox();
        label_message = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        textField_pathValidasi = new javax.swing.JTextField();
        button_pathValidasi = new javax.swing.JButton();
        textField_kunciPrivate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textField_nilaiN = new javax.swing.JTextField();
        button_cekValidasi = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        label_notifValidasi = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textField_lastBit = new javax.swing.JTextField();
        cb_validate = new javax.swing.JCheckBox();
        button_Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setBounds(new java.awt.Rectangle(5, 5, 5, 5));

        jTabbedPane1.setBackground(new java.awt.Color(102, 102, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sumber File", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        textField_pathSumberFile.setEditable(false);
        textField_pathSumberFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_pathSumberFileActionPerformed(evt);
            }
        });

        button_pathSumber.setText("Browse");
        button_pathSumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pathSumberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField_pathSumberFile, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(button_pathSumber)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_pathSumberFile, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(button_pathSumber))
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Simpan File Ke...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel5.setPreferredSize(new java.awt.Dimension(463, 110));

        textField_pathSimpanFile.setEditable(false);
        textField_pathSimpanFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_pathSimpanFileActionPerformed(evt);
            }
        });

        button_fileSimpan.setText("Browse");
        button_fileSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_fileSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField_pathSimpanFile, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_fileSimpan)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_pathSimpanFile, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_fileSimpan))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel1.setText("Masukkan panjang bit ");

        textField_panjangBit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField_panjangBit.setText("8");
        textField_panjangBit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_panjangBitActionPerformed(evt);
            }
        });

        button_generateTTD.setText("Generate Tanda Tangan");
        button_generateTTD.setEnabled(false);
        button_generateTTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_generateTTDActionPerformed(evt);
            }
        });

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));
        jPanel6.setForeground(new java.awt.Color(102, 51, 255));

        label_nilaiN.setText("Nilai N                    ");

        label_nilaiPublik.setText("Nilai Kunci Publik  ");

        label_nilaiPrivat.setText("Nilai Kunci Privat   ");

        label_notifikasi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_notifikasi.setForeground(new java.awt.Color(0, 0, 255));
        label_notifikasi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_nilaiN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_nilaiPrivat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_nilaiPublik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_valueN, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(345, 345, 345))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(label_KPrivate, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(label_kPublik))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(label_notifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(label_notifikasi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nilaiN, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_valueN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nilaiPublik, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(label_kPublik))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_nilaiPrivat, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_KPrivate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cb_ttd.setText("Lokasi File dan Destination sudah benar");
        cb_ttd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ttdActionPerformed(evt);
            }
        });

        label_message.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        label_message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(cb_ttd))
                        .addGap(33, 33, 33)
                        .addComponent(textField_panjangBit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(196, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 496, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_generateTTD, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(label_message, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_panjangBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addComponent(cb_ttd)
                .addGap(18, 18, 18)
                .addComponent(button_generateTTD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_message, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Digital Signature", jPanel1);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sumber File", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel7.setPreferredSize(new java.awt.Dimension(464, 111));
        jPanel7.setRequestFocusEnabled(false);

        textField_pathValidasi.setEditable(false);
        textField_pathValidasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_pathValidasiActionPerformed(evt);
            }
        });

        button_pathValidasi.setText("Browse");
        button_pathValidasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_pathValidasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textField_pathValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(button_pathValidasi)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(button_pathValidasi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textField_pathValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        textField_kunciPrivate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_kunciPrivateActionPerformed(evt);
            }
        });

        jLabel2.setText("Masukkan Nilai Kunci Private ");

        jLabel3.setText("Masukkan Nilai N ");

        button_cekValidasi.setText("Periksa Integritas Isi File & Autentikasi Pengirim");
        button_cekValidasi.setEnabled(false);
        button_cekValidasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cekValidasiActionPerformed(evt);
            }
        });

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true));

        label_notifValidasi.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        label_notifValidasi.setForeground(new java.awt.Color(0, 51, 255));
        label_notifValidasi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_notifValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_notifValidasi, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setText("Last Length Plaintext");

        cb_validate.setText("Lokasi File , nilai N, dan nilai Kunci Private sudah benar");
        cb_validate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_validateActionPerformed(evt);
            }
        });

        button_Reset.setText("Reset");
        button_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(button_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(94, 94, 94)
                                        .addComponent(textField_lastBit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cb_validate)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textField_nilaiN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField_kunciPrivate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(button_cekValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_kunciPrivate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_nilaiN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField_lastBit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(cb_validate)
                .addGap(26, 26, 26)
                .addComponent(button_cekValidasi, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(button_Reset)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cek Validasi", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textField_pathSumberFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_pathSumberFileActionPerformed
        // TODO add your handling code here:
        textField_pathSumberFile.setText(null);
    }//GEN-LAST:event_textField_pathSumberFileActionPerformed

    private void textField_pathSimpanFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_pathSimpanFileActionPerformed
        // TODO add your handling code here:
        textField_pathSimpanFile.setText(null);
    }//GEN-LAST:event_textField_pathSimpanFileActionPerformed

    private void button_pathSumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pathSumberActionPerformed
        // TODO add your handling code here:
        FileController file = new FileController();
        String path = file.getFile();
        if (path != "wrongpath") {
            textField_pathSumberFile.setText(path);
        }
    }//GEN-LAST:event_button_pathSumberActionPerformed

    private void button_fileSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_fileSimpanActionPerformed
        // TODO add your handling code here:
        FileController file = new FileController();
        String path = file.saveFile();
        if (path != "wrongpath") {
            textField_pathSimpanFile.setText(path);
        }
    }//GEN-LAST:event_button_fileSimpanActionPerformed

    private void button_generateTTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_generateTTDActionPerformed
        // TODO add your handling code here:

        String message = "";
        String saveAtribut = "";

            String pathSumber = textField_pathSumberFile.getText();
            message = Docx.readText(pathSumber);
            System.out.print("\nPlain Text : " + message); //text word telah didapatkan

            String pathSimpanQR = textField_pathSimpanFile.getText() + ".png";
            String pathSimpanWord = textField_pathSimpanFile.getText() + ".docx";
            String pathSimpanTxt = textField_pathSimpanFile.getText() + ".txt";
            
            String messageDigest = MD5.getMd5(message);
            System.out.print("\n\nDigest : " + messageDigest); //text telah di hash
            //batas 28/12/21
            try {
                int panjangbitprime = Integer.parseInt(textField_panjangBit.getText());
                
                BigInteger valueAtribute[] = RSA.atributRSA(messageDigest, panjangbitprime);
                
                BigInteger e = valueAtribute[0];
                BigInteger valueN = valueAtribute[1];
                BigInteger d = valueAtribute[2];
                System.out.println("Kunci Publik [e] : " + e);
                System.out.println("Nilai N : " + valueN);
                System.out.println("Nilai Privat [d] : " + d + "\n");
                
                String plainteksBlok[] = RSA.pemisahanBlok(messageDigest, valueN);
                int lastBlokLength = plainteksBlok[plainteksBlok.length - 1].length();
                
                String finalEnkripsi = RSA.enkripsi(plainteksBlok, valueN, e);
                
                System.out.println("\n\ndigest md5 : " + messageDigest);
                System.out.println("final Enkripsi : " + finalEnkripsi);
                
                String pathQR = QrCode.buildQR(finalEnkripsi, pathSimpanQR);
                
                Docx.writeText(pathQR, pathSumber, pathSimpanWord); //[String pathGambar, String pathInput, String pathOutput]

                saveAtribut += "\n";
                saveAtribut += "============Atribut Kunci Digital Signature==============\n\n";
                
                saveAtribut += "Kunci Publik [e] : " + e + "\n";
                saveAtribut += "Nilai Kunci Private [d] : " + d + "\n";
                saveAtribut += "Nilai N : " + valueN + "\n";
                saveAtribut += "Panjang Bit Akhir : " + lastBlokLength + "\n\n";
                
                saveAtribut += "===========================================\n";
                
                System.out.println(saveAtribut);
                BufferedWriter wr = new BufferedWriter(new FileWriter(pathSimpanTxt));
                wr.write(saveAtribut);
                wr.close();
                System.out.println("Generate Tanda Tangan Berhasil");
                label_notifikasi.setText("Generate Tanda Tangan Berhasil");
                
                label_valueN.setText("" + valueN);
                label_kPublik.setText("" + e);
                label_KPrivate.setText("" + d);
                
                label_message.setText("Atribut validasi disimpan di file " + pathSimpanTxt);
                
            } catch (Exception E) {
                System.out.println("\n\nGenerate Tanda Tangan Gagal");
                label_notifikasi.setForeground(Color.red);
                label_notifikasi.setText("Generate Tanda Tangan Gagal!!!!");
            }
    }//GEN-LAST:event_button_generateTTDActionPerformed

    private void textField_panjangBitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_panjangBitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_panjangBitActionPerformed

    private void button_pathValidasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_pathValidasiActionPerformed
        // TODO add your handling code here:
        FileController file = new FileController();
        String path = file.getFile();
        if (path != "wrongpath") {
            textField_pathValidasi.setText(path);
        }
    }//GEN-LAST:event_button_pathValidasiActionPerformed

    private void textField_pathValidasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_pathValidasiActionPerformed
        // TODO add your handling code here:
        FileController file = new FileController();
        String path = file.getFile();
        if (path != "wrongpath") {
            textField_pathValidasi.setText(path);
        }
    }//GEN-LAST:event_textField_pathValidasiActionPerformed

    private void button_cekValidasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cekValidasiActionPerformed
        // TODO add your handling code here:
        String readQr = "";
        String readWord = "";
        try {
            String pathValidasi = textField_pathValidasi.getText();
            BigInteger valueD = new BigInteger(textField_kunciPrivate.getText());
            BigInteger valueN = new BigInteger(textField_nilaiN.getText());
            int lastLength = Integer.parseInt(textField_lastBit.getText());
            
            readWord = Docx.readText(pathValidasi);
            String hasilHash = MD5.getMd5(readWord);
            System.out.println("hasil hash " + hasilHash);
            
            readQr = QrCode.readQR(pathValidasi);
            System.out.println("hasil QR : " + readQr);
            
            if (readQr != "failed") {
                String valueBlokQr[] = RSA.pemisahanBlokDes(readQr);
                String valueDekripsi[] = RSA.dekripsi(valueBlokQr, valueN, valueD);
                String finalDekripsi = RSA.finalDekripsi(valueDekripsi, valueN, lastLength);
                System.out.println("hasil hash file : " + hasilHash);
                
                if (hasilHash.equals(finalDekripsi)) {
                    label_notifValidasi.setForeground(Color.blue);
                    System.out.println("Integritas Isi Pesan Telah Terjamin & Autentikasi Pengirim Sukses");
                    label_notifValidasi.setText("Integritas Isi Pesan Telah Terjamin & Autentikasi Pengirim Sukses");
                } else {
                    label_notifValidasi.setForeground(Color.red);
                    System.out.println("Integritas Isi Pesan Tidak Terjamin & Autentikasi Pengiriman Gagal !!!");
                    label_notifValidasi.setText("Integritas Isi Pesan Tidak Terjamin & Autentikasi Pengiriman Gagal !!!");
                }
            } else {
                label_notifValidasi.setForeground(Color.red);
                System.out.println("Tanda Tangan Tidak Terdeteksi !!!");
                label_notifValidasi.setText("Tanda Tangan Tidak Terdeteksi !!!");
            }
            
        } catch (Exception e) {
            label_notifValidasi.setForeground(Color.red);
            label_notifValidasi.setText("Nilai Masukan Tidak Valid !!!");
        }
    }//GEN-LAST:event_button_cekValidasiActionPerformed

    private void cb_ttdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ttdActionPerformed
        // TODO add your handling code here:
        if (cb_ttd.isSelected()) {
            String text1 = textField_pathSumberFile.getText();
            String text2 = textField_pathSimpanFile.getText();
            if (!text1.isEmpty() && !text2.isEmpty()) {
                button_generateTTD.setEnabled(true);
            } else {
                button_generateTTD.setEnabled(false);
            }
        } else {
            button_generateTTD.setEnabled(false);
        }
    }//GEN-LAST:event_cb_ttdActionPerformed

    private void cb_validateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_validateActionPerformed
        // TODO add your handling code here:
        if (cb_validate.isSelected()) {
//            String text1 = source_file2.getText();
            String text2 = textField_pathValidasi.getText();
            String kprivate = textField_kunciPrivate.getText();
            String n = textField_nilaiN.getText();
            String lastBit = textField_lastBit.getText();
            if (!n.isEmpty() && !kprivate.isEmpty() && !lastBit.isEmpty()) {
                button_cekValidasi.setEnabled(true);
                
            } else {
                button_cekValidasi.setEnabled(false);
                
            }
        } else {
            button_cekValidasi.setEnabled(false);
            
        }
    }//GEN-LAST:event_cb_validateActionPerformed

    private void textField_kunciPrivateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_kunciPrivateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_kunciPrivateActionPerformed

    private void button_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ResetActionPerformed
        // TODO add your handling code here:

        textField_kunciPrivate.setText("");
        textField_lastBit.setText("");
        textField_nilaiN.setText("");
        textField_pathValidasi.setText("");
        label_notifValidasi.setText("");
        button_cekValidasi.setEnabled(false);
        cb_validate.setSelected(false);
    }//GEN-LAST:event_button_ResetActionPerformed
    
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
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Reset;
    private javax.swing.JButton button_cekValidasi;
    private javax.swing.JButton button_fileSimpan;
    private javax.swing.JButton button_generateTTD;
    private javax.swing.JButton button_pathSumber;
    private javax.swing.JButton button_pathValidasi;
    private javax.swing.JCheckBox cb_ttd;
    private javax.swing.JCheckBox cb_validate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label_KPrivate;
    private javax.swing.JLabel label_kPublik;
    private javax.swing.JLabel label_message;
    private javax.swing.JLabel label_nilaiN;
    private javax.swing.JLabel label_nilaiPrivat;
    private javax.swing.JLabel label_nilaiPublik;
    private javax.swing.JLabel label_notifValidasi;
    private javax.swing.JLabel label_notifikasi;
    private javax.swing.JLabel label_valueN;
    private javax.swing.JTextField textField_kunciPrivate;
    private javax.swing.JTextField textField_lastBit;
    private javax.swing.JTextField textField_nilaiN;
    private javax.swing.JTextField textField_panjangBit;
    private javax.swing.JTextField textField_pathSimpanFile;
    private javax.swing.JTextField textField_pathSumberFile;
    private javax.swing.JTextField textField_pathValidasi;
    // End of variables declaration//GEN-END:variables
}
