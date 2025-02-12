/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kırtasiyeotomasyonuu;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pars
 */
//kullanıcıları saklamak için :
public class kırtasiye_giris extends javax.swing.JFrame {

    private Kullanici kullanici;

    public kırtasiye_giris() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void ekle() throws SQLException {
        Connection connect = null; // Veritabanı bağlantısı için Connection nesnesi oluşturdum
        DbHelper db = new DbHelper();// Veritabanında yardımcı sınıfa ulaşılsın diye kullandım.
        connect = db.getConnection();// Veritabanına bağlantı oluşturdum.
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (kullaniciadi_alani.getText().trim().isEmpty() || sifre_alani.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");
        } else {

            try {

                statement = connect.prepareStatement("SELECT * FROM kırtasiye.giris WHERE Kullanici_adi=? AND Sifre=?");

                // İlk yer tutucusu (1. sıradaki '?') 'kullanici_adi' değişkeniyle doldurmasını sağladım.
                statement.setString(1, kullanici.getKullanici_adi());
                // İkinci yer tutucusu (2. sıradaki '?') 'sifre' değişkeniyle doldurmasını sağladım.
                statement.setString(2, kullanici.getParola());
                // Hazırlanan sorgu çalıştırılarak sonuçlar resultSet adlı değişkene atanmasını sağladım.
                resultSet = statement.executeQuery();

                //Daha değer kaldı mı ?
                if (resultSet.next()) {
                    anaSayfa ana = new anaSayfa();
                    ana.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Hatalı Kullanıcı Adı veya Parola!");
                }

            } catch (SQLException ex) {
                db.ShowError(ex);//Sql istisna durumu oluştuğunda hata mesajı göndermesi için oluşturdum.

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerlogin_panel = new javax.swing.JPanel();
        kayıtOl_butonu = new javax.swing.JButton();
        giriş_butonu = new javax.swing.JButton();
        login_panel = new javax.swing.JPanel();
        kullanici_adi = new javax.swing.JLabel();
        Şifre = new javax.swing.JLabel();
        kullaniciadi_alani = new javax.swing.JTextField();
        sifre_alani = new javax.swing.JPasswordField();
        sifreyi_göster = new javax.swing.JCheckBox();
        girişEkrani = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kayıtOl_butonu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kayıtOl_butonu.setForeground(new java.awt.Color(204, 0, 51));
        kayıtOl_butonu.setText("KAYIT OL");
        kayıtOl_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kayıtOl_butonuActionPerformed(evt);
            }
        });

        giriş_butonu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        giriş_butonu.setForeground(new java.awt.Color(204, 0, 51));
        giriş_butonu.setText("GİRİŞ ");
        giriş_butonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giriş_butonuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registerlogin_panelLayout = new javax.swing.GroupLayout(registerlogin_panel);
        registerlogin_panel.setLayout(registerlogin_panelLayout);
        registerlogin_panelLayout.setHorizontalGroup(
            registerlogin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerlogin_panelLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(kayıtOl_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(giriş_butonu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        registerlogin_panelLayout.setVerticalGroup(
            registerlogin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerlogin_panelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(registerlogin_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kayıtOl_butonu)
                    .addComponent(giriş_butonu))
                .addGap(68, 68, 68))
        );

        kullanici_adi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        kullanici_adi.setText("Kullanıcı Adı :");

        Şifre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Şifre.setText("Şifre:");

        sifreyi_göster.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sifreyi_göster.setText("Şifreyi Göster");
        sifreyi_göster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sifreyi_gösterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout login_panelLayout = new javax.swing.GroupLayout(login_panel);
        login_panel.setLayout(login_panelLayout);
        login_panelLayout.setHorizontalGroup(
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kullanici_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Şifre, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kullaniciadi_alani)
                    .addComponent(sifre_alani, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(sifreyi_göster, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        login_panelLayout.setVerticalGroup(
            login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(login_panelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kullanici_adi)
                    .addComponent(kullaniciadi_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(login_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Şifre)
                    .addComponent(sifre_alani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sifreyi_göster))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        girişEkrani.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        girişEkrani.setForeground(new java.awt.Color(204, 0, 0));
        girişEkrani.setText("GİRİŞ EKRANI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(login_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(registerlogin_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(girişEkrani, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(girişEkrani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerlogin_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kayıtOl_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kayıtOl_butonuActionPerformed
        // frameler arası geçiş sağladım :
        kayıtOl kayitOlEkrani = new kayıtOl();

        // register ekranının ekranda gözükmesi için kullandım.
        kayitOlEkrani.setVisible(true);
    }//GEN-LAST:event_kayıtOl_butonuActionPerformed

    private void giriş_butonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giriş_butonuActionPerformed
        try {
            // Kullanıcı adı ve şifreyi alarak kullanici sınıfından bir nesne oluşturdum.
            kullanici = new Kullanici(kullaniciadi_alani.getText(), sifre_alani.getText());
            //  ekle metodu çağırılıyor.
            ekle();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Veritabanı hatası oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_giriş_butonuActionPerformed

    private void sifreyi_gösterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sifreyi_gösterActionPerformed
        if (sifreyi_göster.isSelected()) {
            // Şifre alanının karakter gizleme özelliği kaldırılır.
            sifre_alani.setEchoChar((char) 0);

        } else {
            // Şifre alanı tekrar karakter gizleme özelliğiyle ayarlanır.
            sifre_alani.setEchoChar('*');
        }
    }//GEN-LAST:event_sifreyi_gösterActionPerformed

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
            java.util.logging.Logger.getLogger(kırtasiye_giris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kırtasiye_giris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kırtasiye_giris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kırtasiye_giris.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kırtasiye_giris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel girişEkrani;
    private javax.swing.JButton giriş_butonu;
    private javax.swing.JButton kayıtOl_butonu;
    private javax.swing.JLabel kullanici_adi;
    private javax.swing.JTextField kullaniciadi_alani;
    private javax.swing.JPanel login_panel;
    private javax.swing.JPanel registerlogin_panel;
    private javax.swing.JPasswordField sifre_alani;
    private javax.swing.JCheckBox sifreyi_göster;
    private javax.swing.JLabel Şifre;
    // End of variables declaration//GEN-END:variables
}
