package com.gerenciamento.api.apis;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dataApi", url = "http://localhost:8081/api")
public interface DateApi {
    @GetMapping("/date")
    String buscarData();
}
