package the.project.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App extends javax.swing.JFrame {

    public App() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSend = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbScore = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paneCards = new javax.swing.JPanel();
        txtPriceFrom = new javax.swing.JTextField();
        cbPriceTo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDistanceFrom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDistanceTo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Restaurant");
        setName("frame"); // NOI18N
        setPreferredSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(326, 400));
        getContentPane().setLayout(null);

        btnSend.setText("Procurar");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        getContentPane().add(btnSend);
        btnSend.setBounds(10, 140, 280, 23);
        btnSend.getAccessibleContext().setAccessibleName("btnSend");

        jLabel2.setText("Olá! Selecione as opções para encontrar um restaurante");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 10, 280, 14);
        jLabel2.getAccessibleContext().setAccessibleName("lblMessage");

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Árabe", "Japonesa", "Brasileira", "Italiana", "Americana" }));
        getContentPane().add(cbType);
        cbType.setBounds(10, 60, 130, 20);

        jLabel3.setText("Tipo de comida");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 40, 71, 14);

        jLabel4.setText("Distância");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 40, 43, 14);

        cbScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 estrela", "2 estrelas", "3 estrelas", "4 estrelas", "5 estrelas" }));
        getContentPane().add(cbScore);
        cbScore.setBounds(160, 110, 130, 20);

        jLabel5.setText("Preço");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 90, 27, 14);

        jLabel6.setText("Classificação");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(160, 90, 61, 14);

        paneCards.setLayout(new javax.swing.BoxLayout(paneCards, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(paneCards);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 280, 232);
        getContentPane().add(txtPriceFrom);
        txtPriceFrom.setBounds(10, 110, 48, 20);
        getContentPane().add(cbPriceTo);
        cbPriceTo.setBounds(90, 110, 48, 20);

        jLabel7.setText("Até");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(65, 112, 17, 14);
        getContentPane().add(txtDistanceFrom);
        txtDistanceFrom.setBounds(160, 60, 48, 20);

        jLabel8.setText("Até");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(215, 62, 17, 14);
        getContentPane().add(txtDistanceTo);
        txtDistanceTo.setBounds(240, 60, 48, 20);

        getAccessibleContext().setAccessibleName("");

        setBounds(0, 0, 309, 444);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        System.out.println("pressionou");
                
        paneCards.add(new RestaurantCard());
        paneCards.repaint();
        repaint();
    }//GEN-LAST:event_btnSendActionPerformed

    public static void main(String args[]) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}

        // coloquei os argumentos em código para facilitar na inicialização
        // o seguindo argumento é para a criação do agente inicial
        String [] a = { "-gui", "GuiAgent:the.project.main.agents.gui.GuiAgent" };
        jade.Boot.main(a);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                App app = new App();
                app.setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JTextField cbPriceTo;
    private javax.swing.JComboBox<String> cbScore;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel paneCards;
    private javax.swing.JTextField txtDistanceFrom;
    private javax.swing.JTextField txtDistanceTo;
    private javax.swing.JTextField txtPriceFrom;
    // End of variables declaration//GEN-END:variables
}
