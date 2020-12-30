package com.gloryh.controller;

import com.gloryh.entity.Address;
import com.gloryh.entity.Area;
import com.gloryh.entity.City;
import com.gloryh.entity.Province;
import com.gloryh.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * address controller
 *
 * @author 黄光辉
 * @since 2020/11/21
 **/
@RestController
@RequestMapping("/address")
public class AddressHandler {
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/findByVipId/{v_id}")
    public List<Address> findByVipId(@PathVariable int v_id){
        return addressRepository.findAllByVip(v_id);
    }
    @GetMapping("/getProvinces")
    public List<Province> getProvinces(){
        return addressRepository.getProvinces();
    }
    @GetMapping("/getCitiesByProvinceId/{province_id}")
    public List<City> getCitiesByProvinceId(@PathVariable String province_id){
        return addressRepository.getCitiesByProvinceId(province_id);
    }
    @GetMapping("/getAreasByCityId/{city_id}")
    public List<Area> getAreasByCityId(@PathVariable String city_id){
        return addressRepository.getAreasByCityId(city_id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Address address){
        addressRepository.save(address);
    }
    @GetMapping("/findById/{id}")
    public Address findById(@PathVariable int id){
        return addressRepository.findById(id);
    }
}
