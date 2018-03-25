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
    Mapa m;
    public MiniMax(String[][] s,int level){
        m = new Mapa(s,level);
        m.ShowTabuleiro();
    }
    
}
