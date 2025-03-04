import java.text.*;

public class Time{
    private int hour;
    private int minute;
    private int second;
    private int horaMax;
    private int minMax;
    private int secMax;
    
    public Time(int h, int m, int s){
        this.horaMax = 23;
        this.minMax = 59;
        this.secMax = 59;
        setHour(h);
        setMinute(m);
        setSecond(s);
    }
    
    public String toString(){
        DecimalFormat form = new DecimalFormat("00");
        return form.format(getHour()) + ":" + form.format(getMinute()) + ":" + form.format(getSecond());
    }
    
    public void setHour(int value){
        if(value > this.horaMax){
            System.out.println("fail: hora invalida");
        }else{
            this.hour = value;
        }
    }
    
    public int getHour(){
        return this.hour;
    }
    
    public void setMinute(int value){
        if(value > this.minMax){
            System.out.println("fail: minuto invalido");
        }else{
            this.minute = value;
        }
    }
    
    public int getMinute(){
        return this.minute;
    }
    
    public void setSecond(int value){
        if(value > this.secMax){
            System.out.println("fail: segundo invalido");
        }else{
            this.second = value;
        }
    }
    
    public int getSecond(){
        return this.second;
    }
    
    public void nextSecond(){
        if(this.second >= this.secMax){
            this.second = 0;
            this.minute++;
            if(this.minute >= this.minMax){
                this.minute = 0;
                this.hour++;
                if(this.hour >= this.horaMax){
                    this.hour = 0;
                }
            }else{
                this.minute++;
            }
        }else{
            this.second++;
        }
    }
    
}