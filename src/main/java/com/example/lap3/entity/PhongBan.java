package com.example.lap3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @Column(name = "Ma_Phong")
    @Size(max = 2, min = 1, message = "Mã phòng phải có 2 kí tự")
    private String Ma_Phong;
    @Column(name = "Ten_Phong")
    @Size(max = 30, min = 1, message = "Tên phòng phải có 30 kí tự")
    private String Ten_Phong;
    @OneToMany(mappedBy = "PhongBan", cascade = CascadeType.ALL)
    private List<NhanVien> nhanViens;
}