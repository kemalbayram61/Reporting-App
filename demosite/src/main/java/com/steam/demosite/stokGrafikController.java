package com.steam.demosite;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.HashMap;

@Controller
public class stokGrafikController {

    @RequestMapping(value = "/stokGrafikVer" , produces = {MediaType.TEXT_HTML_VALUE})
    public  String  stokGrafik(){
        veriIslem veri=new veriIslem();
        veri.initialize();

        try {

            JasperPrint print =JasperFillManager.fillReport("StokPieC.jasper", null,veri.con);
            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Stok";
    }
    @RequestMapping(value = "/karsilastirGrafikVer" , produces = {MediaType.TEXT_HTML_VALUE})
    public String UrunKarsilastirma(@RequestParam String urun1,@RequestParam String urun2) {

        veriIslem veri=new veriIslem();
        veri.initialize();

        try {
            HashMap param=new HashMap();
            param.put("urun1", urun1);
            param.put("urun2", urun2);
            JasperPrint print =JasperFillManager.fillReport("UrunKarsilastirma.jasper", param,veri.con);

            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Stok";
    }
    @GetMapping(value = "/Stok",produces = {MediaType.TEXT_HTML_VALUE})
    public String kasaPage(){
        return "Stok";
    }
}
