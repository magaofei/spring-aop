package com.example.demo.controller;

import com.example.demo.service.DownloadService;
import com.example.demo.utils.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mark
 */
@RestController
public class DownloadController {
    @Autowired
    private DownloadService downloadService;

    @RequestMapping("/download")
    @Timer
    public String download() throws Exception {
        downloadService.download();
        return "ok";
    }


}
