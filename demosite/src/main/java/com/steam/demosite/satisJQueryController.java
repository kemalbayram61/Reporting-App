package com.steam.demosite;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class satisJQueryController {

    private String remove(String cumle){
        String sonuc="";
        for(int i=0;i<cumle.length();i++){
            if(cumle.charAt(i)!='|')sonuc+=cumle.charAt(i);
            else sonuc=sonuc+"\"";
        }
        sonuc="select * from tblsatis where "+sonuc;
        return sonuc;
    }
    @GetMapping(value = "/satisJquery",produces = {MediaType.TEXT_HTML_VALUE})
    public String indexPage(){
        return "satisJquery";
    }



    @PostMapping(value = "/sorguyaGoreSatis")
    public String sorgu(@RequestParam String sql, RedirectAttributes redir){

        String sorgu=remove(sql.toString());
        System.out.println(sql.toString());

        veriIslem baglanti=new veriIslem();
        baglanti.initialize();


        String query=remove(sql.toString());
        System.out.println(sorgu);
        try {
            HashMap param=new HashMap();
            param.put("sorgu", query);

            JasperPrint print =JasperFillManager.fillReport("satisJquery.jasper", param,baglanti.con);

            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "redirect:/satisJquery";
    }

}
