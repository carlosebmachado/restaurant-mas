package the.project.main.agents.gui;

import javax.swing.*;

import jade.core.*;
import jade.core.behaviours.OneShotBehaviour;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class GuiAgent extends Agent {

//    private JFrame frame;
//    
//    private javax.swing.JButton btnFind;
//    private javax.swing.JComboBox<String> cbType;
//    private javax.swing.JComboBox<String> cbScore;
//    private javax.swing.JLabel lblMessage;
//    private javax.swing.JLabel lblType;
//    private javax.swing.JLabel lblDistance;
//    private javax.swing.JLabel lblPrice;
//    private javax.swing.JLabel lblScore;
//    private javax.swing.JLabel lblTo1;
//    private javax.swing.JLabel lblTo2;
//    private javax.swing.JPanel paneResult;
//    private javax.swing.JScrollPane scroll;
//    private javax.swing.JTextField txtPriceFrom;
//    private javax.swing.JTextField txtPriceTo;
//    private javax.swing.JTextField txtDistanceFrom;
//    private javax.swing.JTextField txtDistanceTo;

    @Override
    protected void setup(){
//        frame = new JFrame();
//        frame.setSize(new Dimension(350, 666));
////        frame.setPreferredSize(new Dimension(333, 500));
//        frame.setTitle("Restaurant MAS");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        
//        createInterface();
//
//        paneResult.add(new RestaurantCard());
//        paneResult.add(new RestaurantCard());
//        paneResult.add(new RestaurantCard());
//        paneResult.add(new RestaurantCard());
//        paneResult.add(new RestaurantCard());
//        paneResult.add(new RestaurantCard());
//        paneResult.add(new RestaurantCard());
//        
//        frame.setVisible(true);
////        frame.pack();
    }
    
//    private void createInterface(){
//
//        btnFind = new javax.swing.JButton();
//        lblMessage = new javax.swing.JLabel();
//        lblType = new javax.swing.JLabel();
//        lblDistance = new javax.swing.JLabel();
//        lblPrice = new javax.swing.JLabel();
//        lblScore = new javax.swing.JLabel();
//        lblTo1 = new javax.swing.JLabel();
//        lblTo2 = new javax.swing.JLabel();
//        cbType = new javax.swing.JComboBox<>();
//        cbScore = new javax.swing.JComboBox<>();
//        txtPriceFrom = new javax.swing.JTextField();
//        txtPriceTo = new javax.swing.JTextField();
//        txtDistanceFrom = new javax.swing.JTextField();
//        txtDistanceTo = new javax.swing.JTextField();
//        scroll = new javax.swing.JScrollPane();
//        paneResult = new javax.swing.JPanel();
//        
//        btnFind.setText("Procurar");
//        lblMessage.setText("Olá! Selecione as opções para encontrar um restaurante");
//        lblType.setText("Tipo de comida");
//        lblDistance.setText("Distância");
//        lblPrice.setText("Preço");
//        lblScore.setText("Classificação");
//        lblTo1.setText("Até");
//        lblTo2.setText("Até");
//        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Árabe", "Brasileira", "Japonesa", "Hambúrguer", "Pizza", "Hamburguer" }));
//        cbScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 estrela", "2 estrelas", "3 estrelas", "4 estrelas", "5 estrelas" }));
////        txtPriceFrom.setText("price from");
////        txtPriceTo.setText("price to");
////        txtDistanceFrom.setText("distance from");
////        txtDistanceTo.setText("distance to");
//
////        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(paneResult);
////        paneResult.setLayout(jPanel1Layout);
////        jPanel1Layout.setHorizontalGroup(
////            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////            .addGap(0, 270, Short.MAX_VALUE)
////        );
////        jPanel1Layout.setVerticalGroup(
////            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
////            .addGap(0, 230, Short.MAX_VALUE)
////        );
//        
//
//        paneResult.setLayout(new BoxLayout(paneResult, BoxLayout.Y_AXIS));
//
//        scroll.setViewportView(paneResult);
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
//        frame.getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addContainerGap()
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
//                    .addComponent(btnFind, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(lblType)
//                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addGap(30, 30, 30)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(lblDistance)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(txtDistanceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(lblTo2)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(txtDistanceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                        .addGap(0, 0, Short.MAX_VALUE))
//                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(lblPrice)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(txtPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(lblTo1)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                .addComponent(txtPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
//                        .addGap(37, 37, 37)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(cbScore, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(lblScore)
//                                .addGap(0, 0, Short.MAX_VALUE)))))
//                .addContainerGap())
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap()
//                .addComponent(lblMessage)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addComponent(lblType)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                .addComponent(txtDistanceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addComponent(txtDistanceTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                .addComponent(lblTo2))))
//                    .addComponent(lblDistance))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(lblPrice)
//                    .addComponent(lblScore))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(txtPriceFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(txtPriceTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(cbScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(lblTo1))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(btnFind)
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                .addComponent(scroll)
//                .addContainerGap())
//        );
//    }
//
//    public JFrame getFrame() {
//        return frame;
//    }
//
//    public JLabel getLblMessage() {
//        return lblMessage;
//    }
    
}
