/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package kırtasiyeotomasyonuu;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pars
 */
public class ürünListele extends javax.swing.JFrame {

    Connection connection = null;
    DbHelper dbHelper = new DbHelper();
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public ürünListele() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Ana sayfanın kapatılmasını önlemek için

    }

    private void ürünListeleme() throws SQLException {
        connection = dbHelper.getConnection();

        // Tablo modelini almasını ve ürünler tablosundan veri çekerek doldurmasını sağladım.
        DefaultTableModel model = (DefaultTableModel) ürünTable.getModel();
        model.setRowCount(0); //Tekrarlanan verilerin önüne geçilmesini sağlamak için kullandım.
        try {
            // Veritabanından tüm ürünleri seçen SQL sorgusunu hazırladım ve çalıştırmasını sağladım.
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM kırtasiye.ürünler");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Her bir satırı tabloya eklemek için bir nesne dizisi oluşturdum.
                Object[] row = new Object[ürünTable.getColumnCount()];

                // Satırdaki her sütunu veritabanından alınan değerle doldurdum.
                row[0] = resultSet.getString("id");
                row[1] = resultSet.getString("barkod_no");
                row[2] = resultSet.getString("kategori");
                row[3] = resultSet.getString("marka_adi");
                row[4] = resultSet.getString("ürün_adi");
                row[5] = resultSet.getInt("fiyat");
                row[6] = resultSet.getInt("stok_adedi");

                // Oluşturulan satırı tabloya eklemesini sağladım.
                model.addRow(row);
            }
        } catch (SQLException ex) {
            //Sql istisnasını konsola yazdırmasını sağladım.
            ex.printStackTrace();

        }

    }

    private void KategoriGetir() {
        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement("SELECT * FROM kırtasiye.kategori");
            resultSet = statement.executeQuery();
            kategoriComboBox.removeAllItems();//veritabanındaki verileri tekrar tekrar göstermesin diye bunu kullandım
            // veritabanındaki kategori satırlarını dönen döngü oluşturdum.
            while (resultSet.next()) {
                //Her bir kategori adını kategoriComboBox'a eklemeli.
                kategoriComboBox.addItem(resultSet.getString("kategori"));
            }
        } catch (SQLException ex) {
            dbHelper.ShowError(ex);
        }

    }

    private void MarkaGetir() {
        try {
            connection = dbHelper.getConnection();
            statement = connection.prepareStatement("SELECT * FROM kırtasiye.marka");
            resultSet = statement.executeQuery();
            markaComboBox.removeAllItems();//veritabanındaki verileri tekrar tekrar göstermesin diye bunu kullandım.

            // veritabanındaki marka satırlarını dönen döngü oluşturdum.
            while (resultSet.next()) {
                //Her bir marka adını kategoriComboBox'a eklemeli.
                markaComboBox.addItem(resultSet.getString("marka"));
            }
        } catch (SQLException ex) {
            dbHelper.ShowError(ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ürünAdiAlani = new javax.swing.JTextField();
        barkodAlani = new javax.swing.JTextField();
        fiyatAlani = new javax.swing.JTextField();
        stokAlani = new javax.swing.JTextField();
        güncelleButonu = new javax.swing.JButton();
        silButonu = new javax.swing.JButton();
        listeleButonu = new javax.swing.JButton();
        kategoriComboBox = new javax.swing.JComboBox<>();
        markaComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ürünTable = new javax.swing.JTable();
        ürünlisteleme = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Barkod No :");

        jLabel2.setText("Kategori : ");

        jLabel3.setText("Marka : ");

        jLabel4.setText("Fiyat : ");

        jLabel5.setText("Ürün Adı : ");

        jLabel6.setText("Stok Adedi : ");

        güncelleButonu.setText("Güncelle");
        güncelleButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                güncelleButonuActionPerformed(evt);
            }
        });

        silButonu.setText("Sil");
        silButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silButonuActionPerformed(evt);
            }
        });

        listeleButonu.setText("Listele");
        listeleButonu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeleButonuActionPerformed(evt);
            }
        });

        kategoriComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        kategoriComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kategoriComboBoxMouseClicked(evt);
            }
        });
        kategoriComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriComboBoxActionPerformed(evt);
            }
        });

        markaComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                markaComboBoxMouseClicked(evt);
            }
        });
        markaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markaComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fiyatAlani))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stokAlani, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ürünAdiAlani)
                            .addComponent(barkodAlani)
                            .addComponent(markaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kategoriComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(silButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(güncelleButonu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listeleButonu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(barkodAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(kategoriComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(markaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ürünAdiAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fiyatAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(stokAlani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(silButonu)
                    .addComponent(güncelleButonu))
                .addGap(18, 18, 18)
                .addComponent(listeleButonu)
                .addGap(27, 27, 27))
        );

        ürünTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Barkod No", "Kategori", "Marka", "Ürün Adi", "Fiyat ", "Stok Adedi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ürünTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ürünTableMouseClicked(evt);
            }
        });
        ürünTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ürünTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(ürünTable);

        ürünlisteleme.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ürünlisteleme.setForeground(new java.awt.Color(255, 255, 255));
        ürünlisteleme.setText("ÜRÜN LİSTELEME ");

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(ürünlisteleme, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(ürünlisteleme)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(ürünlisteleme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeleButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeleButonuActionPerformed
        try {
            ürünListeleme();
        } catch (SQLException ex) {
            ex.printStackTrace();


        }    }//GEN-LAST:event_listeleButonuActionPerformed
    private void guncelle() {

        // Kullanıcı tarafından girilen yeni ürün bilgilerini alır.
        String yeniBarkod, yeniKategori, yeniMarka, yeniÜrünAdi, yeniFiyat, yeniStokAdedi;
        yeniBarkod = barkodAlani.getText();
        // Kategori ComboBox'ından seçilen kategoriyi almasını sağladımç
        yeniKategori = (String) kategoriComboBox.getSelectedItem();
        // Marka ComboBox'ından seçilen markayı almasını sağladım.
        yeniMarka = (String) markaComboBox.getSelectedItem();
        yeniÜrünAdi = ürünAdiAlani.getText();
        yeniFiyat = fiyatAlani.getText();
        yeniStokAdedi = stokAlani.getText();

        try {
            connection = dbHelper.getConnection();

            // Yeni fiyat ve stok adedini integer'a dönüştür
            int yeniFiyatt = Integer.parseInt(yeniFiyat);
            int yeniStokAdedii = Integer.parseInt(yeniStokAdedi);

            // Tablo modelini al ve seçilen satırın indeksini bulması için oluşturdum.
            DefaultTableModel model = (DefaultTableModel) ürünTable.getModel();
            int selectedIndex = ürünTable.getSelectedRow();

            // Seçilen satırdaki ürünün ID'sini almasını sağladım.
            int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            // Veritabanında ilgili ürünün bilgilerini güncellemek için SQL sorgusunu hazırladım.
            statement = connection.prepareStatement("update kırtasiye.ürünler set barkod_no=?, kategori=?, marka_adi=?, ürün_adi=?, fiyat=?, stok_adedi=? where id=?");

            // SQL sorgusundaki soru işaretlerine gerçek değerleri atadım.
            statement.setString(1, yeniBarkod);
            statement.setString(2, yeniKategori);
            statement.setString(3, yeniMarka);
            statement.setString(4, yeniÜrünAdi);
            statement.setInt(5, yeniFiyatt);
            statement.setInt(6, yeniStokAdedii);
            statement.setInt(7, id);
            statement.executeUpdate();

            // Güncellenmiş veriyi tabloya yansıtmak için ilgili satırı doğrudan güncelleyebilmek için kullandığım yöntemdir.
            model.setValueAt(yeniBarkod, selectedIndex, 1);
            model.setValueAt(yeniKategori, selectedIndex, 2);
            model.setValueAt(yeniMarka, selectedIndex, 3);
            model.setValueAt(yeniÜrünAdi, selectedIndex, 4);
            model.setValueAt(yeniFiyat, selectedIndex, 5);
            model.setValueAt(yeniStokAdedi, selectedIndex, 6);
            JOptionPane.showMessageDialog(this, "Ürün Güncellendi.");

            barkodAlani.setText("");
            ürünAdiAlani.setText("");
            fiyatAlani.setText("");
            stokAlani.setText("");
            kategoriComboBox.removeAllItems();
            markaComboBox.removeAllItems();

        } catch (SQLException ex) {
            dbHelper.ShowError(ex);
        }

    }
    private void güncelleButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_güncelleButonuActionPerformed
        // Metin alanlarının boş olup olmadığını kontrol ettim.
        if (barkodAlani.getText().trim().isEmpty() || ürünAdiAlani.getText().trim().isEmpty() || fiyatAlani.getText().trim().isEmpty() || stokAlani.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen Boş Alanları Doldurunuz!");
        } else {

            // Barkod numarası için doğrulama: 6 haneli bir rakam olmalı.
            Pattern pbarkod = Pattern.compile("[0-9]{6}+");
            Matcher mbarkod = pbarkod.matcher(barkodAlani.getText());

            // Ürün adı için doğrulama: Sadece harflerden oluşmalı, aralarında boşluk bulunmalı, Türkçe karakter içermemeli.
            Pattern purunAdi = Pattern.compile("[a-zA-Z]+\\s+[a-zA-Z]+");
            Matcher murunAdi = purunAdi.matcher(ürünAdiAlani.getText());

            // Fiyat için doğrulama: Sadece sayı olmalı
            Pattern pFiyat = Pattern.compile("\\d+");
            Matcher mFiyat = pFiyat.matcher(fiyatAlani.getText());

            // Stok adedi için doğrulama: sadece sayı olmalı
            Pattern pStok = Pattern.compile("\\d+");
            Matcher mStok = pStok.matcher(stokAlani.getText());

            if (!mbarkod.matches()) {
                // Barkod numarası geçerli değilse, kullanıcıya uyarı vermeli
                JOptionPane.showMessageDialog(this, "Geçersiz barkod numarası girdiniz..");

            } else if (!murunAdi.matches()) {
                // Ürün adı geçerli değilse, kullanıcıya uyarı vermeli
                JOptionPane.showMessageDialog(this, "Geçersiz ürün adı girdiniz .  Türkçe karakter kullanmayınız....");

            } else if (!mFiyat.matches()) {
                // Fiyat geçerli değilse, kullanıcıya uyarı vermeli
                JOptionPane.showMessageDialog(this, "Geçersiz fiyat  girdiniz . ");

            } else if (!mStok.matches()) {
                // Stok adedi geçerli değilse, kullanıcıya uyarı vermeli
                JOptionPane.showMessageDialog(this, "Geçersiz stok adedi girdiniz.");
            } else {
                // Tüm girdiler geçerli ise, güncelleme işlemini gerçekleştirir.
                guncelle();

            }

        }
    }//GEN-LAST:event_güncelleButonuActionPerformed

    private void silButonuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silButonuActionPerformed

        if (barkodAlani.getText().trim().isEmpty() || ürünAdiAlani.getText().trim().isEmpty() || fiyatAlani.getText().trim().isEmpty() || stokAlani.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Lütfen Tablodan Listeleme Yapıp Belirli Bir Satır Seçip Öyle Silme İşlemi Yapın");
        } else {
            try {
                connection = dbHelper.getConnection();

                DefaultTableModel model = (DefaultTableModel) ürünTable.getModel();
                int selectedIndex = ürünTable.getSelectedRow();

                // Seçilen satırdaki ürünün ID'sini almalı.
                int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

                statement = connection.prepareStatement("DELETE FROM kırtasiye.ürünler WHERE id=?");
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Ürün Silindi.");

                // Tablodan seçilen satırı kaldırmalı.
                model.removeRow(selectedIndex);

                // Metin alanlarını temizlemeli.
                barkodAlani.setText("");
                ürünAdiAlani.setText("");
                fiyatAlani.setText("");
                stokAlani.setText("");

            } catch (SQLException ex) {
                dbHelper.ShowError(ex);
            }
        }
    }//GEN-LAST:event_silButonuActionPerformed

    private void ürünTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ürünTableMouseClicked
        // Ürün tablosundan seçilen satırın bilgilerini almak için kullanılan tablo modeli oluşturdum.
        DefaultTableModel model = (DefaultTableModel) ürünTable.getModel();
        // Tablodan seçilen satırın indeksini aldım.
        int selectedIndex = ürünTable.getSelectedRow();

        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        barkodAlani.setText(model.getValueAt(selectedIndex, 1).toString());
        kategoriComboBox.setSelectedItem(model.getValueAt(selectedIndex, 2).toString().trim());//  başında ve sonunda olabilecek boşlukları temizlemek için trim() fonksiyonunu kullandım.
        markaComboBox.setSelectedItem(model.getValueAt(selectedIndex, 3).toString().trim());//  başında ve sonunda olabilecek boşlukları temizlemek için trim() fonksiyonunu kullandım.
        ürünAdiAlani.setText(model.getValueAt(selectedIndex, 4).toString());
        fiyatAlani.setText(model.getValueAt(selectedIndex, 5).toString());
        stokAlani.setText(model.getValueAt(selectedIndex, 6).toString());

    }//GEN-LAST:event_ürünTableMouseClicked

    private void kategoriComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategoriComboBoxActionPerformed

    private void markaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_markaComboBoxActionPerformed

    private void ürünTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ürünTableKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ürünTableKeyReleased

    private void kategoriComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kategoriComboBoxMouseClicked
// Seçilen kategoriye göre ilgili işlevi gerçekleştirmek üzere KategoriGetir metodunu çağırır.
        KategoriGetir();
    }//GEN-LAST:event_kategoriComboBoxMouseClicked

    private void markaComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markaComboBoxMouseClicked
        MarkaGetir();    }//GEN-LAST:event_markaComboBoxMouseClicked

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
            java.util.logging.Logger.getLogger(ürünListele.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ürünListele.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ürünListele.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ürünListele.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ürünListele().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barkodAlani;
    private javax.swing.JTextField fiyatAlani;
    private javax.swing.JButton güncelleButonu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> kategoriComboBox;
    private javax.swing.JButton listeleButonu;
    private javax.swing.JComboBox<String> markaComboBox;
    private javax.swing.JButton silButonu;
    private javax.swing.JTextField stokAlani;
    private javax.swing.JTextField ürünAdiAlani;
    private javax.swing.JTable ürünTable;
    private javax.swing.JLabel ürünlisteleme;
    // End of variables declaration//GEN-END:variables
}
