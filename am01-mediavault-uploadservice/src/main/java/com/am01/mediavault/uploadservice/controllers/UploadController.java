package com.am01.mediavault.uploadservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadController {


    @GetMapping("/get")
    public String get() throws Exception {
        return "Hello from Upload1";

    }
}
