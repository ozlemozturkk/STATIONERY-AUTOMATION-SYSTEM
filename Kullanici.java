/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kırtasiyeotomasyonuu;

public class Kullanici {

    private String kullanici_adi;
    private String parola;
    
// Constructor (Yapıcı Metot)
    // Kullanıcı adı ve parolayı parametre olarak alarak yeni bir Kullanici nesnesi oluşturdum.

    public Kullanici(String kullanici_adi, String parola) {
        this.kullanici_adi = kullanici_adi;
        this.parola = parola;
    }
// Getter metodu: Kullanıcı adını döndürür.

    public String getKullanici_adi() {
        return kullanici_adi;
    }
    // Setter metodu: Kullanıcı adını değiştirir.

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }
    // Getter metodu: Parolayı döndürür.

    public String getParola() {
        return parola;
    }
    // Setter metodu: Parolayı değiştirir.

    public void setParola(String parola) {
        this.parola = parola;
    }

}
