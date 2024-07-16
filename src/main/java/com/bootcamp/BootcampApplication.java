package com.bootcamp;

import com.bootcamp.service.BootcampService;
import com.bootcamp.util.JOptionPaneUtil;

public class BootcampApplication {
    public static void main(String[] args) {
        BootcampService bootcampService = new BootcampService();
        bootcampService.start();
        JOptionPaneUtil.showMessage("Application Finished");
    }
}
