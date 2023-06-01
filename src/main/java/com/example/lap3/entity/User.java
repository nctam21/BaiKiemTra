//package com.example.lap3.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.*;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "user")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
//    @Column(name = "username", length = 50, nullable = false, unique = true) @NotBlank(message = "Tên đăng nhập không được để trống")
//    @Size(max = 50, message = "Tên không được quá 50 kí tự")
//    //@ValidUsername
//    private String username;
//
//    @Column(name = "password", length = 250, nullable = false) @NotBlank(message = "Mật khẩu không được để trống")
//    private String password;
//
//    @Column(name = "email", length = 50)
//    @Size(max = 50, message = "Email không được quá 50 kí tự") @NotBlank(message = "Email không được để trống")
//    private String email;
//
//    @Column(name = "name", length = 50, nullable = false)
//    @Size(max = 50, message = "Tên đăng nhập không được quá 50 kí tự") @NotBlank(message = "Tên đăng nhập không được để trống")
//    private String name;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<NhanVien> books = new ArrayList<>(); }
//
