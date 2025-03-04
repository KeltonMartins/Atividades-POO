import java.text.*;
import java.util.ArrayList;

public class Pencil{
    private float thickness;
    private Lead tip;
    ArrayList<Lead> barrel = new ArrayList<Lead>();
    
    public Pencil(float thickness){
        this.thickness = thickness;
        this.tip = null;
    }
    
    public boolean hasGrafite(){
        if(this.tip != null){
            return true;
        }
        return false;
    }
    
    public boolean insert(Lead lead){
        if(this.thickness == lead.getThickness()){
            barrel.add(lead);
            return true;
        }
            System.out.println("fail: calibre incompatível");
            return false;
        
    }
    
    public Lead remove(){
        if(hasGrafite()){
            this.tip = null;
            return this.tip;
        }else{
            System.out.println("fail: nao existe grafite");
            return null;
        }
    }
    
    public boolean pull(){
        if(!hasGrafite()){
            tip = barrel.get(0);
            if(this.thickness == tip.getThickness()){
                tip = barrel.remove(0);
                return  true;
            }else{
                System.out.println("fail: calibre incompatível");
                return false;
            }
        }else{
            System.out.println("fail: ja existe grafite no bico");
            return false;
        }
    }
    
    public void writePage(){
        if(hasGrafite()){
            if(tip.getSize() > 10){
                if(tip.getSize() - tip.usagePerSheet() >= 10){
                    tip.setSize(tip.getSize() - tip.usagePerSheet());
                }else{
                    tip.setSize(10);
                    System.out.println("fail: folha incompleta"); 
                }
            }else{
                System.out.println("fail: tamanho insuficiente");
            }  
        }else{
            System.out.println("fail: nao existe grafite no bico");
        }
    }
    
    public String toString(){
        DecimalFormat form = new DecimalFormat("0.0");
        String finals = " <";
        for(int i = 0; i<barrel.size(); i++){
            finals += barrel.get(i);
        }
        finals += ">";
        if(this.tip == null){
            return "calibre: " + form.format(this.thickness) + ", bico: [], tambor:" + finals;
        }else
        return "calibre: " + form.format(this.thickness) + ", bico: " + this.tip
        +", tambor:" + finals;
    }
}