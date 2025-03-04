import java.util.Arrays;
import java.util.Comparator;
class ComparaEquipe implements Comparator<Equipe> {
    public int compare(Equipe t1, Equipe t2) {
        if(t1.totalPontos != t2.totalPontos){
            return Integer.compare(t2.totalPontos, t1.totalPontos);
        }
        if(t1.totalVitorias != t2.totalVitorias){
            return Integer.compare(t2.totalVitorias, t1.totalVitorias);
        }
        if(t1.saldoGols != t2.saldoGols){
            return Integer.compare(t2.saldoGols, t1.saldoGols);
        }
        return Integer.compare(t2.golsPro, t1.golsPro);
    }
}
