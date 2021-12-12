package com.example.smartdelivery.ui.main.single;

public class SingleItem {

   int invoice_image; //송장이미지
    String invoice_num; //송장번호
    String arrive_time; //도착시간

    public SingleItem(int invoice_image,String invoice_num,String arrive_time){
        this.invoice_image=invoice_image;
        this.invoice_num=invoice_num;
        this.arrive_time=arrive_time;
    }

    public int getInvoice_image() {
        return invoice_image;
    }

    public void setInvoice_image(int invoice_image) {
        this.invoice_image = invoice_image;
    }

    public String getInvoice_num() {
        return invoice_num;
    }

    public void setInvoice_num(String invoice_num) {
        this.invoice_num = invoice_num;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }


}
