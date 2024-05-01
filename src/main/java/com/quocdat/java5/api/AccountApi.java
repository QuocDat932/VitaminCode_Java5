package com.quocdat.java5.api;

import com.quocdat.java5.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/java05/account-api")
public class AccountApi {
    @Autowired
    private AccountService accServ;
    @GetMapping("/getAllAccount")
    public ResponseEntity<?> doGetAllAccount(){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", accServ.getAllAccount());
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getAllAccount ", e);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/login")
    public ResponseEntity<?> doGetLogin(@RequestParam("tk") String tk,
                                        @RequestParam("mk") String mk){
        Map<String, Object> result = new HashMap<>();
        try {
            var data = accServ.getAccountByTkAndMk(tk, mk);
            if(!data.isEmpty()){
                result.put("status", true);
                result.put("message", "Login Success");
                result.put("data", data);
            } else {
                result.put("status", false);
                result.put("message", "Login Fail");
            }
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Login Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/login ", e);
        }
        return ResponseEntity.ok(result);
    }

}