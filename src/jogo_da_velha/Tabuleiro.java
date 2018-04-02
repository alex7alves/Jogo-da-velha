/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo_da_velha;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.JButton;

/**
 *
 * @author Alex Alves
 */
public class Tabuleiro extends javax.swing.JFrame {

    /**
     * Creates new form Tabuleiro
     */
    String[][] mapa = new String[3][3];
    boolean vez =false;
    boolean computador =false,facil=false,medio=false,dificil=false;
    Ponto ponto= new Ponto(0,0);
    MapaTab map ;
    public Tabuleiro() {

        initComponents();
        map= new MapaTab();
        
    }
    
    public Tabuleiro(int x, boolean c) {

        initComponents();
        if(x==1) facil =true;
        if(x==2) medio =true;
        if(x==3) dificil =true;
        computador=c;
        map= new MapaTab();
        InitMapa();
        
    }
    public Ponto getPonto(){
        return ponto;
    }
    public void setPonto(int x,int y){
        ponto.x=x;
        ponto.y=y;
    }
    public void getMapa(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(" "+mapa[i][j]);
            }
            System.out.println();
        }
    }
    public void setMapa(int linha, int coluna,String s){
        this.mapa[linha][coluna]= s;
    }
    public boolean isVazio(JButton b) {
        
       String vazio = b.getText();
       if(vazio == null || ("".equals(vazio))) {
            return true;
        }
        return false;
    }
    public void setX(JButton b){
        b.setText("X");
        b.setBackground(Color.red);
    }
    public void setO(JButton b){
        b.setText("O");
        b.setBackground(Color.BLUE);
        
    }
    public void setJogada(JButton b,int linha,int coluna,String s){
        if(isVazio(b)) {
            setX(b);
            setMapa(linha,coluna,s);
            setPonto(linha, coluna);
            jLabel5.setText("");
        }else{
            jLabel5.setText("Posição já foi ocupada");
        }
    }
    
    public void setInterface(int linha,int coluna){
        
        if(linha==0 && coluna ==0) setO(B00);
        if(linha==0 && coluna ==1) setO(B01);
        if(linha==0 && coluna ==2) setO(B02);
        if(linha==1 && coluna ==0) setO(B10);
        if(linha==1 && coluna ==1) setO(B11);
        if(linha==1 && coluna ==2) setO(B12);
        if(linha==2 && coluna ==0) setO(B20);
        if(linha==2 && coluna ==1) setO(B21);
        if(linha==2 && coluna ==2) setO(B22);
     
    }
    public void InitMapa(){
      System.out.println("Ponto "+ponto.x+", "+ponto.y);
        if(computador){
            //Ponto p = new Ponto(random.nextInt(3),random.nextInt(3));
            Ponto p;
            if(facil){
                jLabel6.setText("Fácil");
                p = new Ponto(0,1);
                setInterface(p.x,p.y);
            }else if(medio){
                jLabel6.setText("Médio");
                p = new Ponto(0,0);
                setInterface(p.x,p.y);
            }else {
                // dificil comeca no centro
                jLabel6.setText("Difícil");
                p = new Ponto(1,1);
                setInterface(p.x,p.y);
            }
            
            boolean z =map.isJogou(p, MapaTab.jogador_X);
            map.showMapa();
        }
        if(vez==true){
            
            map.showMapa();
            System.out.println("Ponto "+ponto.x+", "+ponto.y);

            
        
            //while(!(map.isFimJogo())){
                boolean ok=true;

                do {
                    if(!ok){
                        System.out.println("falhou");
                    }
                    if(vez==true){
                       Ponto usuario = getPonto();
                       System.out.println("Ponto "+usuario.toString());
                       ok=map.isJogou(usuario, MapaTab.jogador_O);
                    }
                    vez=false;

                }while(!ok);
                map.showMapa();
                /*if(map.isFimJogo()){
                    break;
                }
                if(map.Venceu(MapaTab.jogador_O)){
                    break;
                }
                if(map.Venceu(MapaTab.jogador_X)){
                    break;
                }*/
                map.MiniMax(0, MapaTab.jogador_X);
                System.out.println("Computador escolheu o ponto "+ map.MovimentoComputador);
                setInterface(map.MovimentoComputador.x,map.MovimentoComputador.y);
                setMapa(map.MovimentoComputador.x,map.MovimentoComputador.y,"X");
                map.isJogou(map.MovimentoComputador, MapaTab.jogador_X);
                map.showMapa();
            }
            if(map.Venceu(MapaTab.jogador_X)){
                System.out.println("Voce perdeu ");
            }else if(map.Venceu(MapaTab.jogador_O)){
                System.out.println("Voce venceu ");
            }else{
                System.out.println("Deu empate ");
            }
       // }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        B00 = new javax.swing.JButton();
        B01 = new javax.swing.JButton();
        B02 = new javax.swing.JButton();
        B12 = new javax.swing.JButton();
        B10 = new javax.swing.JButton();
        B11 = new javax.swing.JButton();
        B22 = new javax.swing.JButton();
        B20 = new javax.swing.JButton();
        B21 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Jogo da velha");

        jButton4.setText("Reiniciar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Resultado :");

        jLabel3.setText("jLabel3");

        B00.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B00.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B00ActionPerformed(evt);
            }
        });

        B01.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B01ActionPerformed(evt);
            }
        });

        B02.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B02ActionPerformed(evt);
            }
        });

        B12.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B12ActionPerformed(evt);
            }
        });

        B10.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B10ActionPerformed(evt);
            }
        });

        B11.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B11ActionPerformed(evt);
            }
        });

        B22.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B22ActionPerformed(evt);
            }
        });

        B20.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B20ActionPerformed(evt);
            }
        });

        B21.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        B21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B21ActionPerformed(evt);
            }
        });

        jLabel4.setText("Dificuldade: ");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B20, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B21, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B22, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B00, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B01, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(B02, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B02, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(B01, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B00, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(B11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(B10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(B20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(B21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(B22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B00ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B00ActionPerformed
        setJogada(B00,0,0,"X");
        vez=true;
        InitMapa();
    }//GEN-LAST:event_B00ActionPerformed

    private void B01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B01ActionPerformed
        setJogada(B01,0,1,"X");
        vez=true;
        InitMapa();
    }//GEN-LAST:event_B01ActionPerformed

    private void B02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B02ActionPerformed
       setJogada(B02,0,2,"X");
       vez=true;
       InitMapa();
    }//GEN-LAST:event_B02ActionPerformed

    private void B10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B10ActionPerformed
        setJogada(B10,1,0,"X");
        vez=true;
        InitMapa();
    }//GEN-LAST:event_B10ActionPerformed

    private void B11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B11ActionPerformed
        setJogada(B11,1,1,"X");
        vez=true;
        InitMapa();
    }//GEN-LAST:event_B11ActionPerformed

    private void B12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B12ActionPerformed
        setJogada(B12,1,2,"X");
        vez=true;
        InitMapa();

    }//GEN-LAST:event_B12ActionPerformed

    private void B20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B20ActionPerformed
        setJogada(B20,2,0,"X");
        vez=true;
        InitMapa();
 
    }//GEN-LAST:event_B20ActionPerformed

    private void B21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B21ActionPerformed
       setJogada(B21,2,1,"X");
       vez=true;
       InitMapa();

    }//GEN-LAST:event_B21ActionPerformed

    private void B22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B22ActionPerformed
       setJogada(B22,2,2,"X");
       vez=true;
       InitMapa();
    }//GEN-LAST:event_B22ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Reiniciar
        Inicio init =new Inicio();
        init.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabuleiro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B00;
    private javax.swing.JButton B01;
    private javax.swing.JButton B02;
    private javax.swing.JButton B10;
    private javax.swing.JButton B11;
    private javax.swing.JButton B12;
    private javax.swing.JButton B20;
    private javax.swing.JButton B21;
    private javax.swing.JButton B22;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

}
