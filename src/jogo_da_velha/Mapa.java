/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

import java.util.ArrayList;

/**
 *
 * @author Alex Alves
 */
public class Mapa {
    String[][] tabuleiro = new String[3][3];
    ArrayList<Tabuleiro> jogadas = new ArrayList<Tabuleiro>();
    int valor;
    public Mapa(Tabuleiro t){
        jogadas.add(t);
    }
    public String getPos(int linha, int coluna){
        return tabuleiro[linha][coluna];
    }

    public void setX(int linha, int coluna){
        tabuleiro[linha][coluna] = "X";
    }
    public void setO(int linha, int coluna){
        tabuleiro[linha][coluna] = "O";
    }
    public String[][] getTabuleiro(){
        return tabuleiro;
    }
    
    private boolean DiagonalPrincipal(String jogador){
        return (jogador.equals(tabuleiro[0][0]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[2][2]));
    }

    private boolean DiagonalSecundaria(String jogador){
        return (jogador.equals(tabuleiro[0][2]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[2][0]));
    }
    private boolean Horizontal(int linha, String jogador){
        return (jogador.equals(tabuleiro[linha][0]) && jogador.equals(tabuleiro[linha][1]) && jogador.equals(tabuleiro[linha][2]));
    }

    private boolean Vertical(int coluna,String jogador){
        return (jogador.equals(tabuleiro[0][coluna]) && jogador.equals(tabuleiro[1][coluna]) && jogador.equals(tabuleiro[2][coluna]));
    }

    public boolean isFim(){
        int cont=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tabuleiro[i][j] != null || !("".equals(tabuleiro[i][j])) ){
                    cont++;
                }
            }
            
        }
        if(cont ==9){
            return true;
        }
        return false;
    }
    public boolean Ganhar(String jogador){
        return (Vertical(0,jogador) || Vertical(1,jogador) || Vertical(2,jogador) 
                || Horizontal(0,jogador) ||  Horizontal(1,jogador) || Horizontal(2,jogador)
                || DiagonalPrincipal(jogador) || DiagonalSecundaria(jogador) );
    }

    public boolean Empatar(){
        if(isFim() && Ganhar("X")==false && Ganhar("O")==false){
            return true;
        }
        return false;
    }
    
    public int getValor(){
        return valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public Tabuleiro getMax() {
        Tabuleiro j = new Tabuleiro();
        int melhorValor = -100;

        for(Tabuleiro jogo : jogadas){
            if (jogo.getValor() > melhorValor){
                j = jogo;
                melhorValor = jogo.getValor();

            }
        }
        return j;
    }

    public Tabuleiro getMini() {
        Tabuleiro j = new Tabuleiro();
        int piorValor = 100;

        for(Tabuleiro jogo : jogadas){
            if (jogo.getValor() < piorValor){
                j = jogo;
                piorValor = jogo.getValor();
            }
        }
        return j;
    }
  
}
