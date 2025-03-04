public class Jogo{
    
    private int numJogadores;
    private int [] armadilha;
    private int [] posicao;
    private boolean [] podeJogar;
    private int numArmadilha = 0;
    private int numCasas;
    private int prox;
    private boolean fimDoJogo = false;
    
    public Jogo(int numJogadores, int numCasas){
        this.armadilha = new int[numCasas];
        this.posicao = new int[numJogadores];
        this.podeJogar = new boolean[numJogadores];
        
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;
        for(int i = 0; i<numJogadores; i++){
            this.posicao[i] = 0;
            this.podeJogar[i] = true;
        }
        this.prox = 0;
    }
    
    public void addArmadilha(int t){
        this.armadilha[numArmadilha] = t;
        numArmadilha++;
    }
    
    public void proximo(){
        if(this.prox == this.numJogadores - 1){
                this.prox = 0;
                return;
            }else{
                this.prox++;
        }
    }
    
    public void addMove(int d1, int d2){
        if(this.fimDoJogo == false){
            if(this.podeJogar[this.prox] == false){
                this.podeJogar[this.prox] = true;
                System.out.println("O jogador " + (this.prox + 1) + " passa a vez");
                proximo();
            }
            int casas = d1 + d2;
            this.posicao[this.prox] += casas;
            System.out.println("O jogador "  + (this.prox + 1) + " vai para a casa " + this.posicao[this.prox]);
            
            if(this.posicao[this.prox] > numCasas){
                System.out.println("O jogador " + (this.prox + 1) + " venceu o jogo");
                this.fimDoJogo = true;
            }
            for(int i = 0; i < this.numArmadilha; i++){
                if(this.posicao[this.prox] == this.armadilha[i]){
                    this.podeJogar[this.prox] = false;
                    System.out.println("O jogador " + (this.prox + 1) + " caiu em um armadilha");
                    proximo();
                return;
                }
            }
            proximo();
        }else{
            System.out.println("O jogo acabou");
        }
    }   
    public String toString(){
        String valor = "";
        for(int i = 0; i < this.numJogadores; i++){
            valor = valor + "PosJogador[" + (i+1) + "] = " + this.posicao[i] + "\n";
        }
        return valor;
    }
    
}