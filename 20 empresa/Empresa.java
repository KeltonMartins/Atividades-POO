import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Empresa{
    ArrayList<Empregado> empregados;
    
    public Empresa(){
        empregados = new ArrayList<Empregado>();
    }

    public void adicionaEmpregado(Empregado e){
        empregados.add(e);
    }

    public void mostraEmpregado(){
        System.out.println("Empresa: ");
        for(Empregado empregado : empregados){
            System.out.println(empregado);
        }
    }

    public double calculaFolha(){
        double soma = 0.0;
        for(Empregado empregado : empregados){
            soma += empregado.pagamento();
        }
        return soma;
    }



}