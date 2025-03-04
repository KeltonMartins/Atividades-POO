import java.text.*;

public class Calculator {
    private int battery;
    private int batteryMax;
    private float display;
    
    public Calculator(int batteryMax){
        this.display = 0;
        this.battery = 0;
        this.batteryMax = batteryMax; 
    }
    
    public void charge(int value){
        if(this.battery + value <= this.batteryMax){
            this.battery += value;
        }else{
            this.battery = this.batteryMax;
        }
    }
    public boolean batteryLimit(){
        if(this.battery>0){
            return true;
        }else{
            return false;
        }
    }
    
    public void sum(int a, int b){
        if(batteryLimit()){
            this.battery--;
            this.display = (float) a + b;
        }else{
            System.out.println("fail: bateria insuficiente");
        }
    }
    
    public void div(int num, int den){
        if(batteryLimit()){
                this.battery--;
            if(den > 0){
                this.display = (float) num / den;
            }else{
                System.out.println("fail: divisao por zero");
            }
        }else{
            System.out.println("fail: bateria insuficiente");
        }
    }
    
    public String toString(){
        DecimalFormat form = new DecimalFormat("0.00");
        return "display = " + form.format(this.display) + ", battery = " + this.battery;
    }
}