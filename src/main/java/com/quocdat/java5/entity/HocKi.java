package com.quocdat.java5.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(schema = "project_final_java05", name = "hoc_ki")
public class HocKi implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ma_hk")
    private String maHk;

    @Column(name = "ten_hoc_ki")
    private String tenHocKi;

    @Column(name = "bat_dau")
    private Date ngayBatDau;

    @Column(name = "ket_thuc")
    private Date ngayKetThuc;

}