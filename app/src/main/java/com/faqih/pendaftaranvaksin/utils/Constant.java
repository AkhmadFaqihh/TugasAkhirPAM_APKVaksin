package com.faqih.pendaftaranvaksin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Constant {

    public static String namaRS;

    public static int cekUmurPeserta(String strTanggal) {
        int umurPeserta = 0;
        SimpleDateFormat formatDefault = new SimpleDateFormat("dd-MM-yyyy");
        try {
            int dateNow = Calendar.getInstance().get(Calendar.YEAR);
            Date dateFormat = formatDefault.parse(strTanggal);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateFormat);
            int umurSekarang = calendar.get(Calendar.YEAR);
            umurPeserta = dateNow - umurSekarang;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return umurPeserta;
    }

}
