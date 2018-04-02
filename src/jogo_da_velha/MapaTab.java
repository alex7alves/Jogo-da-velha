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
    /*public static final int sem_jogador=0;
    public static final int jogador_X=1;
    public static final int jogador_O=2;
    private int[][] tabuleiro = new int[3][3];
    */
    public static final String sem_jogador=null;
    public static final String jogador_X="X";
    public static final String jogador_O="O";
    private String[][] tabuleiro = new String[3][3];
    public Ponto MovimentoComputador; 
    
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
      /*  if(tabuleiro[p.x][p.y]==sem_jogador){
            return false;
        }*/
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
}
