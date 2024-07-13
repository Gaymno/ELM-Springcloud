package org.example.controller;


import org.example.po.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {
    @PostMapping("/fallback")
    public Result fallback(){
        String message = "系统繁忙,请稍后再试";
        Result result = new Result(400,message);
        return result;
    }
}
