public class Car{
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem
    
    public Car(){
        this.gas = 0;
        this.gasMax = 100;
        this.passMax = 2;
        this.pass = 0;
        this.km = 0;
    }
    public String toString(){
        return "pass: " + this.pass + ", gas: " + this.gas + ", km: " + this.km;
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
    public void fuel(int gas){
        if(this.gas + gas <= this.gasMax){
            this.gas += gas;
        }else{
            this.gas = this.gasMax;
        }
    }
    public void drive (int km){
        if(this.pass >0){
            if(this.gas > 0){
                if(this.gas >= km){
                    this.gas -= km;
                    this.km += km;
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

    
}

