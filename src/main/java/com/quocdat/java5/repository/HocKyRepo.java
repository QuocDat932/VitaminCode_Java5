package com.quocdat.java5.repository;

import com.quocdat.java5.data.dto.request.HocKiDto;
import com.quocdat.java5.data.entity.HocKiE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HocKyRepo extends JpaRepository<HocKiE, String> {
    @Transactional
    @Modifying
    @Query(value = "Delete from hoc_ki h where h.ma_hk = ?1",nativeQuery = true)
    int deleteHocKy(String maHocKi);

    HocKiE save(HocKiDto hocKiDto);
}
