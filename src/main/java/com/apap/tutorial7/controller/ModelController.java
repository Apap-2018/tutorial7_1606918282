package com.apap.tutorial7.controller;

import com.apap.tutorial7.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Calendar;

@RestController
@RequestMapping("/model")
public class ModelController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping()
    private Object daftarModel(@RequestParam ("factory") String namaProdusen) throws Exception {
    	String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));

    	String path = Setting.queryUrl + "/?cmd=getModels&make=" + namaProdusen + "&year=" + year;
    	
    	HttpHeaders connection = new HttpHeaders();
    	connection.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	connection.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    	HttpEntity<String> entity = new HttpEntity<String>("parameters", connection);
    	Object out = restTemplate.exchange(path, HttpMethod.GET, entity, Object.class);
    	
    	return out;
   }
}