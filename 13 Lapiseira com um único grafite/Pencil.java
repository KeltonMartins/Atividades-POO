import java.text.DecimalFormat;

public class Pencil{
    private float thickness;
    private Lead tip;
    
    public Pencil(float thickness){
        this.thickness = thickness;
        this.tip = null;
    }
    
    public boolean hasGrafite(){
        if(this.tip != null){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean insert(Lead lead){
        if(!hasGrafite()){
            if(this.thickness == lead.getThickness()){
                this.tip = lead;
                return  true;
            }else{
                System.out.println("fail: calibre incompatível");
                return false;
            }
        }else{
            System.out.println("fail: ja existe grafite");
            return false;
        }
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
                System.out.println("warning: grafite com tamanho insuficiente para escrever");
            }  
        }else{
            System.out.println("fail: nao existe grafite");
        }
    }
    
    public String toString(){
        DecimalFormat form = new DecimalFormat("0.0");
        return "calibre: " + form.format(this.thickness) + ", grafite: " + this.tip;
    }
}
