class Car{
    int pass;
    int passMax;
    int gas;
    int gasMax;
    int km;
    
    public Car(){
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }
    
    public void enter(){
        if(this.pass < this.passMax){
            this.pass++;
        }else{
            System.out.println("fail: limite de pessoas atingido");
        }
    }
    
    public void leave(){
        if(this.pass > 0){
            this.pass--;
        }else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
    
    public void drive(int value){
        if(this.pass > 0){
            if(this.gas > 0){
                if(this.gas >= value){
                    this.gas -= value;
                    this.km += value;
                }else{
                    this.km += this.gas;
                    System.out.println("fail: tanque vazio apos andar " + this.gas + " km");
                    this.gas = 0;
                }
            }else{
                System.out.println("fail: tanque vazio");
            }
        }else{
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
    
    public void fuel(int value){
        if(this.gas + value <= this.gasMax){
            this.gas += value;
        }else{
            this.gas = this.gasMax;
        }
    }
    
    public String toString(){
        return "pass: " + this.pass + ", gas: " + this.gas + ", km: " + this.km;
    }
};