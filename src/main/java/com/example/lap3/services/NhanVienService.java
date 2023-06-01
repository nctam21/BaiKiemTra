package com.example.lap3.services;

import com.example.lap3.entity.NhanVien;
import com.example.lap3.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired

    private INhanVienRepository nhanvienRepository;
    public List<NhanVien> getAllNhanVien () {
        return nhanvienRepository.findAll();
    }
    public NhanVien getMaNhanVien(String Ma_NV) {
        Optional<NhanVien> optional = nhanvienRepository.findById(Ma_NV);
        return optional.orElse(null);
    }
    public void addNhanVien (NhanVien nhanvien) {
        nhanvienRepository.save(nhanvien);
    }
    public void updateNhanVien (NhanVien nhanvien) {
        nhanvienRepository.save(nhanvien);
    }
    public void editNhanVien (NhanVien nhanvien){ nhanvienRepository.save(nhanvien);}
    public void deleteNhanVien (String Ma_NV) {nhanvienRepository.deleteById(Ma_NV);}
}
