import java.util.ArrayList;
import java.util.LinkedList;

public class Mercantil {
    LinkedList<Pessoa> pessoa = new LinkedList<Pessoa>();
    ArrayList<String> caixas = new ArrayList<String>();
    public int cont = 0;
    
    Mercantil(int qtdCaixas){
        cont = qtdCaixas;
        for(int i=0; i<qtdCaixas; i++){
            caixas.add("-----");
        }
    }

    public void chegar(Pessoa p){
        pessoa.addLast(p);
    }

    public boolean chamarNoCaixa(int indice){
        if(pessoa.isEmpty()){
            System.out.println("fail: fila vazia");
            return false;
        }
        Pessoa p = pessoa.removeFirst();
        caixas.set(indice, p.toString());
        return true;
    }

    public void finalizarAtendimento(int indice){
        caixas.set(indice, "-----");
    }

    public String toString(){
        String stringfinal = "|";
        for(int i=0; i<cont; i++){
            stringfinal += i + ":" + caixas.get(i) + "|";
        }
        stringfinal += "\nEspera: [";
        for(int i=0; i<pessoa.size(); i++){
            if(i==pessoa.size()-1){
                stringfinal += pessoa.get(i);
            }else
            stringfinal += pessoa.get(i) + ", ";
        }
        stringfinal += "]";
        return stringfinal;
    }


}
