class Motorcycle{
    private Person person;
    private int power;
    private int time;
    
    public Motorcycle(int power){
        this.power = power;
        this.time = 0;
        this.person = null;
    }
    
    public boolean insertPerson(Person person){
        if(this.person == null){
            this.person = person;
            return true;
        }else{
            System.out.println("fail: busy motorcycle");
            return false;
        }
    }
    
    public Person remove(){
        if(this.person != null){
            System.out.println(this.person);
            return this.person = null;
        }else{
            System.out.println("fail: empty motorcycle");
            System.out.println("---");
            return null;
        }
    }
    
    public void buyTime(int time){
        this.time += time;
    }
    
    public void drive(int time){
        if (this.time == 0) {
            System.out.println("fail: buy time first");
            return;
        }

        if (this.person == null) {
            System.out.println("fail: empty motorcycle");
            return;
        }

        if (this.person.getAge() > 10) {
            System.out.println("fail: too old to drive");
            return;
        }

        this.time -= time;

        if (this.time < 0) {
            int timeFinish = this.time + time;
            System.out.println("fail: time finished after " + timeFinish + " minutes");
            this.time = 0;
        }
    }
    
    public void honk(){
        String buzina = "P";
        for(int i = 0; i < getPower(); i++){
            buzina += "e";
        }
        buzina += "m";
        System.out.println(buzina);
    }
    
    public Person getPerson(){
        return this.person;
    }
    
    public int getPower(){
        return this.power;
    }
    
    public int getTime(){
        return this.time;
    }
    
    public String toString(){
        if(this.person == null){
            return "power:" + getPower() + ", time:" + getTime() + ", person:" + "(empty)";
        }
        return "power:" + getPower() + ", time:" + getTime() + ", person:" + "(" + this.person + ")";
    }
}