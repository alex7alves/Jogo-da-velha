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
public class Arvore {
    private Mapa raiz;
    
    public Arvore(){
        raiz =null;
    }
    public Arvore(String[][] tabuleiro, int level){
        raiz = new Mapa(tabuleiro,level);
    }
}
