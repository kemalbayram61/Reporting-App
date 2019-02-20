package com.steam.demosite;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;

@Controller
public class kasaGrafikController {

    @RequestMapping(value = "/kasaGrafikVer" , produces = {MediaType.TEXT_HTML_VALUE})
    public  String  kasaGrafik(){
        veriIslem veri=new veriIslem();
        veri.initialize();

        try {

            JasperPrint print =JasperFillManager.fillReport("Kasa.jasper", null,veri.con);
            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Kasa";
    }

    @GetMapping(value = "/Kasa",produces = {MediaType.TEXT_HTML_VALUE})
    public String kasaPage(){
        return "Kasa";
    }
}
