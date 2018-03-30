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
public class Arvore {
    private Mapa raiz;
    
    public Arvore(){
        raiz =null;
    }
    public Arvore(String[][] tabuleiro, int level){
        raiz = new Mapa(tabuleiro,level);
    }
    public void setRaiz(Mapa raiz){
        this.raiz = raiz;
    }
    
    public Mapa getRaiz(){
        return raiz;
    }
    public void setInserir(Mapa m,String jogador,int level){
        if(raiz==null){return ;}
        int cont=0;
        String QuemJoga =jogador ;
        ArrayList<Mapa> mapas;
        mapas = raiz.setJogadasParciais(m,jogador);
        raiz.setInicio(m);
       
        for(Mapa map : mapas){    
            for(int i=0;i<level;i++){ // profundidade da arvore
                QuemJoga = setTrocarJoador(jogador);
                setInserir(map,QuemJoga, level);
            }
            cont++;
        }
         
    }
    
    
    public String setTrocarJoador(String jogador){
        String QuemJoga;
        if("X".equals(jogador)){
            QuemJoga = "X";
        }else {
            QuemJoga = "O";
        }
        return QuemJoga;
    }
}
