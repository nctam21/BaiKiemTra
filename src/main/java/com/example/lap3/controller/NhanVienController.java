package com.example.lap3.controller;

import com.example.lap3.entity.NhanVien;
import com.example.lap3.services.NhanVienService;
import com.example.lap3.services.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/NhanVien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanvienService;
    @Autowired
    private PhongBanService phongbanService;

    @GetMapping
    public String showAllNhanVien(Model model) {
        List<NhanVien> nhanViens= nhanvienService.getAllNhanVien();
        model.addAttribute("NhanVien", nhanViens);
        return "NhanVien/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("NhanVien", new NhanVien());
        model.addAttribute("PhongBan", phongbanService.getAllPhongBan());
        return "NhanVien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid NhanVien nhanvien) {
        nhanvienService.addNhanVien(nhanvien);
        return "redirect:/NhanVien";
    }

    @GetMapping("/delete/{Ma_NV}")
    public String deleteNhanVien(@PathVariable("Ma_NV") String Ma_NV) {
        Iterator<NhanVien> iterator = nhanvienService.getAllNhanVien().iterator();
        while (iterator.hasNext()) {
            NhanVien nhanvien = nhanvienService.getMaNhanVien(Ma_NV);
            if (nhanvien.getMa_NV() == Ma_NV) {
                nhanvienService.deleteNhanVien(Ma_NV);
                break;
            }
        }
        return "redirect:/NhanVien";
    }

    @GetMapping("/edit/{Ma_NV}")
    public String editNhanVienForm(@PathVariable("Ma_NV") String Ma_NV, Model model) {
        Optional<NhanVien> editNhanVien = nhanvienService.getAllNhanVien().stream()
                .filter(nhanVien -> nhanVien.getMa_NV().equals(Ma_NV))
                .findFirst();
        if (editNhanVien.isPresent()) {
            model.addAttribute("NhanVien", editNhanVien);
            return "NhanVien/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editNhanVien(NhanVien nhanvien) {
        nhanvienService.editNhanVien(nhanvien);
        return "redirect:/NhanVien";
    }

    @GetMapping("/search")
    public String search(@RequestParam("searchText") String searchText,Model model) {
        List<NhanVien> nhanViens = nhanvienService.getAllNhanVien();
        List<NhanVien> filteredNhanViens = new ArrayList<>();

        if (searchText != null && !searchText.isEmpty()) {
            filteredNhanViens = nhanViens.stream()
                    .filter(nhanVien -> nhanVien.getTen_NV().contains(searchText))
                    .collect(Collectors.toList());
        }
        model.addAttribute("NhanVien", filteredNhanViens);
        return "NhanVien/list";
    }

}

