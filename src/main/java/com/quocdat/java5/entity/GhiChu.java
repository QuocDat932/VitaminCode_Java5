package com.quocdat.java5.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "project_final_java05", name = "ghi_chu")
public class GhiChu {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "sys_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sysId;

    @Column(name = "ten_ghi_chu")
    private String tenGhiChu;

    @Column(name = "noi_dung")
    private String noiDung;

    @Column(name = "ngay")
    private String ngay;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "sys_id_user")
    private Long sysIdUser;
}
