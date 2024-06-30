@test
  Feature: Otel Arama
    Scenario Outline: Belirli bir konumdaki otelleri arama ve en dusuk fiyattan en yuksege siralama
      Given Anasayfa goruntulenir
      When Üyelik uzerine imlec getirilir
      And Giriş Yap link butonuna tiklanir
      And E-Posta alanina <eposta> girilir
      And Şifre alanina <sifre> girilir
      And GİRİŞ YAP link butonuna tiklanir
      Then Giris yapildigi gorulur
      When Arama cubuguna Bodrum Otelleri yazilir
      And Arama onerilerinden Bodrum Otelleri secilir
      And Giris ve cikis tarihi bugun ve yarin olarak secilir
      And ARA butonuna tiklanir
      Then Bodrum Otelleri sayfasi gorulur
      When Siralama menusune tiklanir
      And Fiyat: Önce En Düşük link butonuna tiklanir
      Then Fiyatlarda en dusukten yukariya dogru artis olduğu gorlur




      Examples:
        | eposta                    | sifre        |
        | alperzorlu1999@gmail.com  | Password.123 |





