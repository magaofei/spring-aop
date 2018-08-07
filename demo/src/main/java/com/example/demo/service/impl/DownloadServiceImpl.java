package com.example.demo.service.impl;

import com.example.demo.service.DownloadService;
import org.springframework.stereotype.Service;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Override
    public void download() {
        System.out.println("download()");
    }
}
