/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Alves
 */
public class MapaTab {
   
    public static final String sem_jogador=null;
    public static final String jogador_X="X";
    public static final String jogador_O="O";
    private String[][] tabuleiro = new String[3][3];
    public Ponto MovimentoComputador; 
    
    private int tabuleiroInt[][] = new int[3][3];
    private int contMin=0,contMax=0;
    
    int facil=0,medio=0;
    int x;
    
    public MapaTab(){
        
    }
    public MapaTab(int x){
        this.x=x;
    }
    public boolean isFimJogo(){
        return Venceu(jogador_X) || Venceu(jogador_O) || getGerar().isEmpty(); 
           
    }

    boolean Venceu(String jogador) {
        // venceu nas diagonais
       if(DiagonalPrincipal(jogador) || DiagonalSecundaria(jogador)){
           return true;
       }
       // venceu nas horiznontais ou verticais
       for(int i=0;i<3;i++){
           if(Horizontal(i,jogador) || Vertical(i,jogador)){
               return true;
           }
       }
       return false;
    }
    
    private boolean DiagonalPrincipal(String jogador){
        return (tabuleiro[0][0]==tabuleiro[1][1] && tabuleiro[0][0]==tabuleiro[2][2] && tabuleiro[0][0]==jogador);
    }
    private boolean DiagonalSecundaria(String jogador){
        return (tabuleiro[0][2]==tabuleiro[1][1] && tabuleiro[0][2]==tabuleiro[2][0] && tabuleiro[0][2]==jogador);
    }
    public boolean Horizontal(int i,String jogador){
        return (tabuleiro[i][0]==tabuleiro[i][1] && tabuleiro[i][0]==tabuleiro[i][2] && tabuleiro[i][0]==jogador);
    }
    public boolean Vertical(int i,String jogador){
        return (tabuleiro[0][i]==tabuleiro[1][i] && tabuleiro[0][i]==tabuleiro[2][i] && tabuleiro[0][i]==jogador);
    }
    /******************Metodos em inteiro *************/
    
     private boolean DiagonalPrincipal(int jogador){
        return (tabuleiroInt[0][0]==tabuleiroInt[1][1] && tabuleiroInt[0][0]==tabuleiroInt[2][2] && tabuleiroInt[0][0]==jogador);
    }
    private boolean DiagonalSecundaria(int jogador){
        return (tabuleiroInt[0][2]==tabuleiroInt[1][1] && tabuleiroInt[0][2]==tabuleiroInt[2][0] && tabuleiroInt[0][2]==jogador);
    }
    public boolean Horizontal(int i,int jogador){
        return (tabuleiroInt[i][0]==tabuleiroInt[i][1] && tabuleiroInt[i][0]==tabuleiroInt[i][2] && tabuleiroInt[i][0]==jogador);
    }
    public boolean Vertical(int i,int jogador){
        return (tabuleiroInt[0][i]==tabuleiroInt[1][i] && tabuleiroInt[0][i]==tabuleiroInt[2][i] && tabuleiroInt[0][i]==jogador);
    }
    
    public void setContador(int jogador) {

        int aux=0;
        
        if(DiagonalPrincipal(jogador)){
           aux ++;
        }
        if(DiagonalSecundaria(jogador)){
           aux ++;
        }
        // venceu nas horiznontais ou verticais
        for(int i=0;i<3;i++){
            if(Horizontal(i,jogador)){
               aux++;
            }
            if(Vertical(i,jogador)){
               aux++;
            }
        }
        if(jogador==1){
            contMax=aux;
        }else if(jogador== -1){
            contMin = (-1*aux);
        }
    }
    
    // Gerar o mapa
    public List<Ponto> getGerar(){
        List<Ponto> gerar = new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tabuleiro[i][j]==sem_jogador){
                    gerar.add(new Ponto(i,j));
                }
            }
            
        }
        return gerar;
    }
    
    public boolean isJogou(Ponto p, String jogador){
        tabuleiro[p.x][p.y]=jogador;
        return true;
    }
    
    public void showMapa(){
        System.out.println();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(" "+tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
    public int getContMax(){
        return contMax;
    }
    public int getContMin(){
        return contMin;
    }
    
    public void setTabInt(int jogador)
    {
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               
                if("X".equals(tabuleiro[i][j])){
                    tabuleiroInt[i][j]=1;
                }else if("O".equals(tabuleiro[i][j])){
                    tabuleiroInt[i][j]=-1;
                }else{
                    if(jogador==1){
                        tabuleiroInt[i][j]=1;
                    }else{
                        tabuleiroInt[i][j]=-1;
                    }
                }
            }
        }
    }
  
    
     public int minimax(int profundidade,int jogador){
        int valor;
        
        if(profundidade==0){
            // inicializa a matriz de inteiros e conta as chances de vitoria
            setTabInt(jogador);
            setContador(jogador);
            // faz o mesmo para o outro jogador
            setTabInt(-1*jogador);
            setContador(-1*jogador);
            
            valor = getContMax() - getContMin();
            return valor;
        }
       
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
            
        if(jogador==1){
            
            List<Ponto> gerar = getGerar();
            // guardara o melhor ponto do max
            Ponto melhorPonto = new Ponto(1,1) ; // necessario instanciar
            for(int i=0;i<gerar.size();i++){  
                Ponto ponto = gerar.get(i);
                isJogou(ponto,jogador_X); // joga no ponto 

                int v = minimax(profundidade-1,-1);
                if(v >= max){
                    max= v;
                    melhorPonto = ponto;
                }  
                tabuleiro[ponto.x][ponto.y]=sem_jogador;
            }
            MovimentoComputador=melhorPonto;
                  
        }else if(jogador==-1){
            List<Ponto> gerar = getGerar();
            for(int i=0;i<gerar.size();i++){  
                Ponto ponto = gerar.get(i);
                isJogou(ponto,jogador_O); // joga no ponto 
                int v= minimax(profundidade-1,1);
                min = Math.min(v,min);
                    
                tabuleiro[ponto.x][ponto.y]=sem_jogador;
            }    
        } 
        return jogador==1 ? max:min;
    }

    public int MiniMax(int profundidade, String turno){
        if(Venceu(jogador_X)){
            return 1;
        }
        if(Venceu(jogador_O)){
            return -1;
        }
        List<Ponto> gerar = getGerar();
        if(gerar.isEmpty()){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<gerar.size();i++){
            Ponto ponto = gerar.get(i);
            if(turno==jogador_X){
                           
                isJogou(ponto,jogador_X); // joga no ponto 
                int valor= MiniMax(profundidade+1,jogador_O);
                max = Math.max(valor,max);
                if(profundidade==0){
                    System.out.println(" Valor do resultado do pc para a posicao "+ ponto+" = " +valor );
                }
                if(valor >=0){
                    if(profundidade ==0){
                        MovimentoComputador=ponto;
                    }
                }
                if(valor ==1){
                    tabuleiro[ponto.x][ponto.y]=sem_jogador;
                    break;
                }
                if(i==gerar.size()-1 && max<0){
                    if(profundidade ==0){
                        MovimentoComputador=ponto;
                    }
                }
            }else if(turno ==jogador_O){
                isJogou(ponto,jogador_O); // joga no ponto 
                int valor= MiniMax(profundidade+1,jogador_X);
                min = Math.min(valor,min);
                if(valor ==-1){
                    tabuleiro[ponto.x][ponto.y]=sem_jogador;
                    break;
                }
            }
            tabuleiro[ponto.x][ponto.y]=sem_jogador;
        }
        return turno ==jogador_X ? max:min;
    }
    // Função para forçar a facilitar o jogo
    public void setRRules(){
     
    for(int i=0;i<3;i++){
            if(tabuleiro[i][0]==tabuleiro[i][1] && tabuleiro[i][0]=="O" ){
                if(tabuleiro[i][2]==sem_jogador){
                    MovimentoComputador = new Ponto(i,2);
                }
               
            }else if(tabuleiro[i][2]==tabuleiro[i][1] && tabuleiro[i][2]=="O" ){
                if(tabuleiro[i][0]==sem_jogador){
                    MovimentoComputador = new Ponto(i,0);
                }
               
            }
            else if(tabuleiro[i][0]==tabuleiro[i][2] && tabuleiro[i][2]=="O" ){
                if(tabuleiro[i][1]==sem_jogador){
                    MovimentoComputador = new Ponto(i,1);
                }
               
            }
        }
    }
}
