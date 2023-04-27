//package com.example.springbootdemo.dao;
//
//import com.example.springbootdemo.bean.Symptom;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//public interface MedicalFacilitiesRepository {
//}


package com.example.springbootdemo.dao;


        import com.example.springbootdemo.bean.Admin;
        import com.example.springbootdemo.bean.MedicalFacilities;

        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.stereotype.Repository;
        import javax.transaction.Transactional;
        import java.util.Optional;

@Repository
public interface MedicalFacilitiesRepository extends JpaRepository<MedicalFacilities, Integer> {
    void deleteById(Integer id);
}
