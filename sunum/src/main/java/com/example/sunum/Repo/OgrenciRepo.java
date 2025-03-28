package com.example.sunum.Repo;
import com.example.sunum.Veri.Ogrenci;
        import org.springframework.data.jpa.repository.JpaRepository;
public interface OgrenciRepo extends JpaRepository<Ogrenci , Long>{
}
//veritabanına gidecek arayüzdür,
//Ogrenci entity sınıfı yerine , long ise primary key olarak belirlenen değişkenin tipi