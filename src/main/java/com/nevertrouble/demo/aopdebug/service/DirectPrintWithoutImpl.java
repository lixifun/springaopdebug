package com.nevertrouble.demo.aopdebug.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Slf4j
@Service
public class DirectPrintWithoutImpl implements Serializable {

    public void print() {
        log.info(this.toString());
    }
}
