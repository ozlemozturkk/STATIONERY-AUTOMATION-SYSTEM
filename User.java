/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kırtasiyeotomasyonuu;
// Kullanici sınıfını genişleten User sınıfı.

public class User extends Kullanici {

    private String advesoyad;
    private String email;

    // Constructor (Yapıcı Metot)
    // Ad ve soyad, email, kullanıcı adı ve parolayı parametre olarak alarak yeni bir User nesnesi oluşturdum.
    public User(String advesoyad, String email, String kullanici_adi, String parola) {
        // Kullanici sınıfının constructor'ını çağırır ve kullanıcı adı ile parolayı başlatır.
        super(kullanici_adi, parola);

        // Daha sonra Ad ve soyad ile email alanlarını başlatır.
        this.advesoyad = advesoyad;
        this.email = email;
    }

    // Getter metodu: Ad ve soyadı döndürür.
    public String getAdvesoyad() {
        return advesoyad;
    }

    // Setter metodu: Ad ve soyadı değiştirir.
    public void setAdvesoyad(String advesoyad) {
        this.advesoyad = advesoyad;
    }

    // Getter metodu: Email adresini döndürür.
    public String getEmail() {
        return email;
    }

    // Setter metodu: Email adresini değiştirir.
    public void setEmail(String email) {
        this.email = email;
    }
}
