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
public class MiniMax {
    Mapa m, p;
    public MiniMax(String[][] s,int level){
        m = new Mapa(s,level);
        m.setInicio(m);
        p = m.getInicio();
        m.setJogadasParciais(m, "X");
        Controlador();
    }
    public void ShowMapa(Mapa p){
        System.out.println("Da classe MiniMax");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(" "+p.tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
    public void Controlador(){
       ArrayList<Mapa> v = m.setJogadasParciais(p,"O");
    }
}
