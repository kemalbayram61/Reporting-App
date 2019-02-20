package com.steam.demosite;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.HashMap;

@Controller
public class kasaJQueryController {

    @GetMapping(value = "/kasaJquery",produces = {MediaType.TEXT_HTML_VALUE})
    public String indexPage(){
        return "kasaJquery";
    }


    private String remove(String cumle){
        String sonuc="";
        for(int i=0;i<cumle.length();i++){
            if(cumle.charAt(i)!='|')sonuc+=cumle.charAt(i);
            else sonuc=sonuc+"\"";
        }
        sonuc="select * from tblkasa where "+sonuc;
        return sonuc;
    }

    @PostMapping(value = "/sorguyaGoreKasa")
    public String sorgu(@RequestParam String sql, RedirectAttributes redir){

        String sorgu=remove(sql.toString());
        System.out.println(sql.toString());

        veriIslem baglanti=new veriIslem();
        baglanti.initialize();
        try {
            HashMap param=new HashMap();
            param.put("sorgu", sorgu);

            JasperPrint print =JasperFillManager.fillReport("kasaJquery.jasper", param,baglanti.con);

            JasperViewer.viewReport(print,false);

        } catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "redirect:/kasaJquery";
    }
}
