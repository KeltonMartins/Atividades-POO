import java.text.*;

public class Conta {
    private String titular;
    private int numero;
    private double saldo;
    private static int totalContas = 0;
    
    public Conta(String titular){
        this.titular = titular;
        this.numero = totalContas++;
        this.saldo = 0;
    }

    void deposita(double valor){
        this.saldo += valor;
    }

    static void deposita(Conta c, double valor){
        c.deposita(valor);
    }

    boolean saca(double valor){
        DecimalFormat df = new DecimalFormat("0.00");
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }else{
            System.out.println("Conta ficou zerada após o saque " + df.format(this.saldo) + " reais");
            this.saldo = 0;
            return false;
        }
    }

    static void saca(Conta c, double valor){
        c.saca(valor);
    }

    boolean transfere(Conta c, double valor){
        if(this.saldo >= valor){
            c.saca(valor);
            return true;
        }else{
            return false;
        }
    }

    static boolean transfere(Conta origem, Conta destino, double valor){
        if(origem.saldo >= valor){
            origem.transfere(origem, valor);
            destino.deposita(valor);
            return true;
        }else{
            return false;
        }
    }
    


    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return "Nro da conta: " + this.numero + ", Titular: " + this.titular + ", Saldo: " + df.format(this.saldo);
    }

}