package com.nevertrouble.demo.aopdebug.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public void print() {
        log.info("lixi");
    }
}
