import java.util.ArrayList;

public class MediaNotas{

    private ArrayList<Double> notas = new ArrayList<Double>();

    public void addNota(double nota){
        notas.add(nota); 
    }

    public void removeNota(int index){
        if(index <= notas.size()){
            notas.remove(index);
        }else{
            System.out.println("falha: indice invalido");
        }
    }

    public void mudaNota(int index, double valor){
        notas.set(index, valor);
    }

    public double maiorNota(){
        if(notas.size() >0){
            double maior = notas.get(0);
            for(double nota : notas){
                if(nota > maior) maior = nota;
            }
            return maior;
        }else{
            System.out.println("falha: quantidade de notas insuficiente");
            return 0;
        }
    }

    public double menorNota(){
        if(notas.size() >0){
            double menor = notas.get(0);
            for(double nota : notas){
                if(nota < menor) menor = nota;
            }
            return menor;
        }else{
            System.out.println("falha: quantidade de notas insuficiente");
            return 0;
        }
    }

    double media(){
        double soma = 0;
        for(double nota : notas){
            soma += nota;
        }
        return soma / notas.size();
    }

    void parametriza(){
        double maior = maiorNota();
        for(int i=0; i<notas.size(); i++){
            notas.set(i, notas.get(i) / maior * 10);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        
        sb.append("[");
        for(int i = 0; i < notas.size(); i++){
            sb.append(String.format("%.2f", notas.get(i)));
            if(i<notas.size()-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}