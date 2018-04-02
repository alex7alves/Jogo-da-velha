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
public class Ponto {
    
    public int x,y;
    
    public Ponto(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public String toString(){
        return "["+x+","+y+"]";
    }
    
}
