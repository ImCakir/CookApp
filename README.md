# CookApp

Proje Hakkında

CookApp, kullanıcıların yemek tariflerini arayabileceği ve favorilerine ekleyebileceği REST API tabanlı bir yemek tarifi uygulamasıdır.
Uygulama, Spring Boot, Spring Data JPA, PostgreSQL ve RESTful servis mimarisi kullanılarak geliştirilmiştir.

⚡ Özellikler
	•	🔍 Meal Arama: İsim ile yemek arama
	•	⭐ Favorilere Ekleme: Kullanıcılar tarifleri favorilerine ekleyebilir
	•	🗄 Veritabanı Yönetimi: PostgreSQL ile kullanıcı ve tarif bilgileri saklanır
	•	🌐 REST API: GET ve POST endpoint’leri ile servis etkileşimi
	•	🔗 Harici API Entegrasyonu: TheMealDB
	•	🛠 DTO & Mapper Kullanımı: Veriyi kullanıcıya özel formatta döndürme

 🛠 Teknolojiler

| Katman          | Teknoloji/Kitaplık        |
|-----------------|---------------------------|
| Backend         | Java 22, Spring Boot 3    |
| Veri Erişimi    | Spring Data JPA, PostgreSQL |
| API İletişimi   | REST, RestTemplate        |
| Mapper          | MapStruct                 |
| Build & Bağımlılık | Maven                  |
| Test (Planlanan) | JUnit 5                  |

🗂 Proje Yapısı

CookApp/
│
├─ CookerApplication/      # Ana uygulama modülü (Controller)
├─ CookerService/          # Business logic (Service Layer)
├─ CookerRepository/       # Repository ve Helper sınıflar
├─ CookerTheMealService/   # TheMealDB API entegrasyonu
└─ pom.xml                 # Maven bağımlılıkları

🚀 Kurulum ve Çalıştırma

1.	Projeyi klonlayın
 
   git clone https://github.com/ImCakir/CookApp.git
   cd CookApp/CookerApplication

2.	Bağımlılıkları yükleyin
   
   mvn clean install 

3.	Uygulamayı çalıştırın

   mvn spring-boot:run 

4.	PostgreSQL bağlantısı
application.properties veya application.yml içinde veritabanı bilgilerinizi güncelleyin:

  spring.datasource.url=jdbc:postgresql://localhost:5432/cookdb
  spring.datasource.username=postgres
  spring.datasource.password=12345
  spring.jpa.hibernate.ddl-auto=update


📌 API Endpoints

| Method | Endpoint                     | Açıklama          | Parametreler                     |
|--------|------------------------------|-------------------|----------------------------------|
| GET    | /dev/api/meal                | Meal arama        | meal (isim)                      |
| POST   | /dev/api/meal/favorites      | Favori ekleme     | meal, customerName, isFavorite   |

--> Örnek GET isteği
    http://localhost:4555/dev/api/meal?meal=Arrabiata

--> Örnek POST isteği
    http://localhost:4555/dev/api/meal/favorites?meal=Arrabiata&customerName=Cagla&isFavorite=true


🧪 Testler
	•	Testler henüz eklenmedi.
	•	Plan: JUnit 5 kullanılarak servis ve controller testleri yazılacak.
	•	Testler, API’nin doğru şekilde veri çekip dönmesini doğrulayacak.


 📈 Öğrenilenler
	•	Spring Boot ile katmanlı mimari tasarımı
	•	REST API geliştirme ve test etme
	•	DTO ve Mapper kullanımı
	•	Repository ve Service bağımlılık yönetimi
	•	Harici API entegrasyonu (TheMealDB)
	•	Git ve GitHub workflow kullanımı


 💡 Gelecek Planlar
	•	Daha gelişmiş kullanıcı yönetimi (login, authentication)
	•	Swagger/OpenAPI entegrasyonu
	•	Frontend entegrasyonu
	•	Daha kapsamlı unit ve integration testler
	•	Docker ile containerize edip deploy


 📄 Lisans

MIT License © 2025


















    




















  





















