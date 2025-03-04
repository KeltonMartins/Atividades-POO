public class Pet{
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, clean;
    private int diamonds;
    private int age;
    private boolean alive;
    
    public Pet(int energy, int hungry, int clean) {
        this.energyMax = energy;
        this.hungryMax = hungry;
        this.cleanMax = clean;
        this.energy = energy;
        this.clean = clean;
        this.hungry = hungry;
        this.diamonds = 0;
        this.age = 0;
        this.alive = true;
    }
    
    public void setEnergy(int value){
        if(value <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        }else if(value > this.energyMax){
            this.energy = this.energyMax;
        }else{
            this.energy = value;
        }
    }
    public int getEnergy() {
        return this.energy;
    }
    
    public void setHungry(int value) {
        if(value <= 0){
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
            
        }else if(value > this.hungryMax){
            this.hungry = this.hungryMax;
            
        }else{
            this.hungry = value;
        }
    }
    public int getHungry() {
        return this.hungry;
    }
    
    public void setClean(int value) {
        if(value <= 0){
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        }else if(value > this.cleanMax){
            this.clean = this.cleanMax;
        }else{
            this.clean = value;
        }
    }
    public int getClean() {
        return this.clean;
    }
    
    public int getEnergyMax() {
        return this.energyMax;
    }
    public int getCleanMax() {
        return this.cleanMax;
    }
    public int getHungryMax() {
        return this.hungryMax;
    }
    
    private boolean testAlive() {
        if(this.alive == true){
            return true;
        }else{
            return false;
        }
    }
    
    public void play(){
        if(!testAlive()){
            System.out.println("fail: pet esta morto");
            return;
        }else{
            setEnergy(getEnergy() - 2);
            setHungry(getHungry() - 1);
            setClean(getClean() - 3);
            this.diamonds++;
            this.age++;
        }
    }
    public void clean() {
        if(!testAlive()){
            System.out.println("fail: pet esta morto");
            return;
        }else{
            setEnergy(getEnergy() - 3);
            setHungry(getHungry() - 1);
            setClean(this.cleanMax);
            this.age += 2;
        }
    }
    public void eat() {
        if(!testAlive()){
            System.out.println("fail: pet esta morto");
        }else{
            setEnergy(getEnergy() - 1);
            setHungry(getHungry() + 4);
            setClean(getClean() - 2);
            this.age++;
        }
    }
    public void sleep() {
        if(!testAlive()){
            System.out.println("fail: pet esta morto");
            return;
        }
        if(energy > energyMax - 5){
            System.out.println("fail: nao esta com sono");
        }else{    
            this.age += energyMax - energy;
            setEnergy(this.energyMax);
            setHungry(getHungry() - 1);
        }
    }
    
    
    public String toString() {
        return "E:" + this.energy + "/" + this.energyMax + ", " +
               "S:" + this.hungry + "/" + this.hungryMax + ", " +
               "L:" + this.clean + "/" + this.cleanMax + ", " +
               "D:" + this.diamonds + ", " +
               "I:" + this.age;
    }
}