/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

/**
 *
 * @author Alex Alves
 */
public class MiniMax {
    String[][] tabuleiro = new String[3][3];
    
    public String getXY(int linha, int coluna){
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
    
    private boolean DiagonalPrincipal(String jogador) {
        return (jogador.equals(tabuleiro[0][0]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[2][2]));
    }

    private boolean DiagonalSecundaria(String jogador) {
        return (jogador.equals(tabuleiro[0][2]) && jogador.equals(tabuleiro[1][1]) && jogador.equals(tabuleiro[2][0]));
    }
    private boolean Horizontal(int linha, String jogador) {
        return (jogador.equals(tabuleiro[linha][0]) && jogador.equals(tabuleiro[linha][1]) && jogador.equals(tabuleiro[linha][2]));
    }

    private boolean Vertical(int coluna,String jogador) {
        return (jogador.equals(tabuleiro[0][coluna]) && jogador.equals(tabuleiro[1][coluna]) && jogador.equals(tabuleiro[2][coluna]));
    }

}
