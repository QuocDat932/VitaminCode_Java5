package com.quocdat.java5.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "project_final_java05", name = "sinh_vien")
public class SinhVien implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "mssv")
    private String mssv;

    @Column(name = "ho_va_ten")
    private String hoVaTen;

    @Column(name = "gioi_tinh")
    private boolean gioi_tinh;

    @Column(name = "chuyen_nganh")
    private String chuyenNganh;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ma_hk", referencedColumnName = "ma_hk")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private HocKi hocKi;
}