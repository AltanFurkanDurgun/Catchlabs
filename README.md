Cucumber BDD framework kullanıldı.
Java version 17
Maven version 3.9.9
Test framework olarak Junit kullanıldı. Soft assert için testNG de kullanıldı
Page object model yapısı mevcut.
Driver`da singleton design pattern kullanıldı.
Pages dosyası içerisinde her sayfanın ayrı ayrı elementleri tanımlı. Bu elementlerin kullanılabilmesi için home page içerisinde pageFactory kullanıldı.
Runner dosyası içerisinden testimizi çalıştırdığımız cucumber runner var.Cucumber options`da feature dosyası, step definitions path`leri ve pluginler mevcut.Buradaki tag alanından koşmayı istediğiniz testlerin tag ini kullanarak koşum sağlayabilirsiniz.
Step Definitions dosyası içerisinde feature`da yazdığımız senaryoların kod karşılığı var. Senaryolar buradaki kodlar ile çalışıyor
Hooks class`ı tüm test senaryolarından önce ve sonra çalışması gereken kodları barındırır
Utilities içerisinde 3 farklı class var. Driver class ı chrome ve firefox için tanımlanan webDriverın tanımlı olduğu ve driver ı sonlandırdığı yerdir.
Browser utils içerisinde wait methodları mevcut
Configuration Reader içerisinde configuration.properties dosyasını okumaya yarayan kod mevcut
Features dosyası içerisinde gherkin dili kullanılarak yazılan test senaryoları mevcut
Configuration.properties içerisinde test için kullandığımız datalar, browser ve url bilgileri mevcut
pom.xml içerisinde dependencyies ve rapor için tanımlanan plugin mevcut
mvn clean verify -Dcucumber.filter.tags="@test" komutunu kullanarak tüm testlerin koşumunu sağlayabiliriz.
Test raporu yukarıdaki komut çalıştırdığı takdirde oluşacaktır. Aksi halde test raporu oluşmuyor.
Test raporu target dosyası içinde cucumber-html-reports > overview-features browserda açılarak görüntülenebilir.
Test raporu matrixlerden, yüzde kaç fail yüzde kaç pass bilgileri, hangi adımda hata verdiği bilgisi gibi birçok detay barındırıyor
Target > cucumber-html-reports > embeddings dosyası içerisinden hata alınan testlerin ekran görüntülerini barındırır

