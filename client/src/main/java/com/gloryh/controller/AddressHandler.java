package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.entity.Address;
import com.gloryh.entity.Area;
import com.gloryh.entity.City;
import com.gloryh.entity.Province;
import com.gloryh.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * address controller
 *
 * @author 黄光辉
 * @since 2020/11/22
 **/
@Controller
@RequestMapping("/address")
public class AddressHandler {
    @Autowired
    private OrderFeign orderFeign;
    @GetMapping("/getProvinces")
    @ResponseBody
    public String getProvinces(){
        List<Province> provinces=orderFeign.getProvinces();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("provinces",provinces);
        return jsonObject.toJSONString();
    }
    @GetMapping("/getCitiesByProvinceId/{province_id}")
    @ResponseBody
    public String getCitiesByProvinceId(@PathVariable String province_id){
        List<City> cities=orderFeign.getCitiesByProvinceId(province_id);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("cities",cities);
        return jsonObject.toJSONString();
    }
    @GetMapping("/getAreasByCityId/{city_id}")
    @ResponseBody
    public String getAreasByCityId(@PathVariable String city_id){
        List<Area> areas =orderFeign.getAreasByCityId(city_id);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("areas",areas);
        return jsonObject.toJSONString();
    }
    @PostMapping("/save")
    @ResponseBody
    public String saveAddress(@RequestBody Address address){
        orderFeign.saveAddress(address);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",1);
        return jsonObject.toJSONString();
    }
}
