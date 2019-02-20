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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Controller
public class satisGrafikController {

    @RequestMapping(value = "/satisGrafikVer" , produces = {MediaType.TEXT_HTML_VALUE})
    public  String  satisGrafik(){
        veriIslem veri=new veriIslem();
        veri.initialize();

        try {

            JasperPrint print = JasperFillManager.fillReport("SatisSutun.jasper", null,veri.con);
            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Satis";
    }
    @RequestMapping(value = "/xurunuGrafikVer" , produces = {MediaType.TEXT_HTML_VALUE})
    public String XUrunuSatisi(@RequestParam String urun) {

        veriIslem baglanti=new veriIslem();
        baglanti.initialize();

        try {
            HashMap param=new HashMap();
            param.put("urunAdi", urun);

            JasperPrint print =JasperFillManager.fillReport("XUrunSatis.jasper", param,baglanti.con);

            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Satis";
    }

    @RequestMapping(value = "/tariheGoreSatis",produces = {MediaType.TEXT_HTML_VALUE})
    public String tarihGoreSatis(@RequestParam String tarih){
        veriIslem baglanti=new veriIslem();
        baglanti.initialize();
        Date gun= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            gun= sdf.parse(tarih);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            HashMap param=new HashMap();
            param.put("secilenTarih", gun);

            JasperPrint print =JasperFillManager.fillReport("TariheGoreSatis.jasper", param,baglanti.con);

            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            return "Satis";
    }
    @GetMapping(value = "/Satis",produces = {MediaType.TEXT_HTML_VALUE})
    public String SatisPage(){
        return "Satis";
    }


}
