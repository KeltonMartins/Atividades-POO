public class Lead{
    private float thickness;
    private String hardness;
    private int size;
    
    public Lead(float thickness, String hardness, int size){
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }
    
    public int usagePerSheet(){
        if(this.hardness.equals("HB")){
            return 1;
        }else if(this.hardness.equals("2B")){
            return 2;
        }else if(this.hardness.equals("4B")){
            return 4;
        }else if(this.hardness.equals("6B")){
            return 6;
        }
        return 0;
    }
    
    public float getThickness(){
        return this.thickness;
    }
    
    public String getHardness(){
        return this.hardness;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void setSize(int size){
        this.size = size;
    }
    
    public String toString(){
        return "[" + getThickness() + ":" + getHardness() + ":" + getSize() + "]";
    }
}
