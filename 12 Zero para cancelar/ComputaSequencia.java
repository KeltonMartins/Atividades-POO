import java.util.ArrayList;

public class ComputaSequencia{
    ArrayList<Integer> num = new ArrayList<Integer>();
    
    public void cadastra(int valor){
        if(valor != 0){
            num.add(valor);
        }else{
            num.remove(num.size() - 1);
        }
    }

    public int computa(){
        int soma = 0;
        for(int n : num){
            soma += n;
        }
        return soma;
    }

    public String toString(){
        return "valores = " + num.toString();
    }

}