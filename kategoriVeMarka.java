package kırtasiyeotomasyonuu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pars
 */
public class kategoriVeMarka extends javax.swing.JFrame {

    /**
     * Creates new form kategoriVeMarka
     */
    public kategoriVeMarka() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Ana sayfanın kapatılmasını önlemek için kullandım.

    }
    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    private void kategoriEkle() throws SQLException {
        String kategori = kategori_alani.getText().trim(); // Trim burada boşlukları temizlemek için kullandım.

        // Kategori alanının boş olup olmadığını kontrol ediyorum
        if (kategori.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen Kategori Alanını Doldurunuz!");
            return;
        }
        // Kategori adı için doğrulama: Sadece harflerden oluşmalı, aralarında boşluk bulunmalı, Türkçe karakter içermemeli.

        Pattern pKategori = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)*$");
        Matcher mKategori = pKategori.matcher(kategori_alani.getText());

        if (!mKategori.matches()) {
            JOptionPane.showMessageDialog(this, "Geçersiz kategori girdiniz.Türkçe karakter bulunmamalıdır.");
            return;
        }

        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO kırtasiye.kategori (kategori) VALUES (?)");
            statement.setString(1, kategori);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Kategori eklendi.");

            kategori_alani.setText(""); // `kategori_alani` metin alanını temizler.
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Kategori eklenirken bir hata oluştu.");
        }
    }

    private void markaEkle() throws SQLException {
        String marka = marka_alani.getText().trim(); // Trim burada boşlukları temizlemek için kullandım.

        // Marka alanının boş olup olmadığını kontrol ediyorum
        if (marka.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen Marka Alanını Doldurunuz!");
            return;
        }
        // Marka adı için doğrulama: Sadece harflerden oluşmalı, aralarında boşluk bulunmalı, Türkçe karakter içermemeli.

        Pattern pMarka = Pattern.compile("^[a-zA-Z]+(\\s[a-zA-Z]+)*$");
        Matcher mMarka = pMarka.matcher(marka_alani.getText());

        if (!mMarka.matches()) {
            JOptionPane.showMessageDialog(this, "Geçersiz marka girdiniz.Türkçe karakter bulunmamalıdır.");
            return;
        }

        try {
            connection = dbHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO kırtasiye.marka (marka) VALUES (?)");
            statement.setString(1, marka);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Marka eklendi.");

            marka_alani.setText(""); // `marka_alani` metin alanını temizler.
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Marka eklenirken bir hata oluştu.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        kategori = new javax.swing.JLabel();
        kategori_alani = new javax.swing.JTextField();
        ekle_butonu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        marka = new javax.swing.JLabel();
        ekleButonu = new javax.swing.JButton();
        marka_alani = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kategori.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        kategori.setForeground(new java.awt.Color(255, 255, 255));
        kategori.setText("KATEGORİ :");

        ekle_butonu.setText("EKLE");
        ekle_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekle_butonuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KATEGORİ EKLEME");

        jDesktopPane2.setLayer(kategori, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(kategori_alani, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(ekle_butonu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ekle_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kategori_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kategori)
                    .addComponent(kategori_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(ekle_butonu)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane2)
        );

        jTabbedPane1.addTab("Kategori", jPanel1);

        marka.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        marka.setForeground(new java.awt.Color(255, 255, 255));
        marka.setText("MARKA : ");

        ekleButonu.setText("EKLE");
        ekleButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ekleButonuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MARKA EKLEME");

        jDesktopPane3.setLayer(marka, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(ekleButonu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(marka_alani, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane3.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(ekleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(marka, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(marka_alani, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane3Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel2)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marka)
                    .addComponent(marka_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(ekleButonu)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane3)
        );

        jTabbedPane1.addTab("Marka", jPanel2);

        jDesktopPane1.setLayer(jTabbedPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ekle_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekle_butonuActionPerformed
        // ekle butonuna basıldığında kategoriEkle metodu çalışır.
        try {
            kategoriEkle();

        } catch (SQLException ex) {
            dbHelper.ShowError(ex);
        }


    }//GEN-LAST:event_ekle_butonuActionPerformed

    private void ekleButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ekleButonuActionPerformed
        // ekle butonuna basıldığında markaEkle metodu çalışır.

        try {
            markaEkle();
        } catch (SQLException ex) {
            dbHelper.ShowError(ex);
        }

    }//GEN-LAST:event_ekleButonuActionPerformed

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
            java.util.logging.Logger.getLogger(kategoriVeMarka.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kategoriVeMarka.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kategoriVeMarka.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kategoriVeMarka.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kategoriVeMarka().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ekleButonu;
    private javax.swing.JButton ekle_butonu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel kategori;
    private javax.swing.JTextField kategori_alani;
    private javax.swing.JLabel marka;
    private javax.swing.JTextField marka_alani;
    // End of variables declaration//GEN-END:variables
}
