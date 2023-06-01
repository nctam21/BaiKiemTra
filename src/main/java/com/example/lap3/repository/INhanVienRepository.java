package com.example.lap3.repository;

import com.example.lap3.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INhanVienRepository extends JpaRepository<NhanVien, String> {
}