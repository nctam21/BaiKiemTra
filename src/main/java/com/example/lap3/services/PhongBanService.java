package com.example.lap3.services;

import com.example.lap3.entity.PhongBan;
import com.example.lap3.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository phongbanRepository;
    public List<PhongBan> getAllPhongBan(){
        return phongbanRepository.findAll();
    }
    public PhongBan getMaPhongBan(String Ma_Phong){
        Optional<PhongBan> optionalPhongBan = phongbanRepository.findById(Ma_Phong);
        if (optionalPhongBan.isPresent()){
            return optionalPhongBan.get();
        }else{
            throw new RuntimeException("Category not found");
        }
    }
    public PhongBan savePhongBan(PhongBan phongban){
        return phongbanRepository.save(phongban);
    }
    public void deletePhongBan(String Ma_Phong){
        phongbanRepository.deleteById(Ma_Phong);
    }
}
