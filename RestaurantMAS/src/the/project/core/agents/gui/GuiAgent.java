package the.project.core.agents.gui;

import jade.core.*;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.awt.Container;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import the.project.core.RestaurantCard;
import the.project.core.objects.Request;
import the.project.core.objects.RequestSearch;

public class GuiAgent extends Agent {

    private final JFrame frame;
    
    private JButton btnFind;
    private JComboBox<String> cbType;
    private JComboBox<String> cbScore;
    private JComboBox<String> cbPrice;
//    private JComboBox<String> cbDistrict;
    private JLabel lblType;
    private JLabel lblDistance;
    private JLabel lblPrice;
    private JLabel lblScore;
//    private JLabel lblTo1;
    private JLabel lblTo2;
//    private JLabel lblDistrict;
    private JPanel paneResult;
    private JPanel paneFilter;
    private JScrollPane scroll;
//    private JTextField txtPriceFrom;
//    private JTextField txtPriceTo;
    private JTextField txtDistanceFrom;
    private JTextField txtDistanceTo;
    
    public GuiAgent() {
        super();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {}
        frame = new JFrame();
        frame.setSize(new Dimension(355, 500));
        frame.setTitle("Restaurant MAS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        
        createInterface();
        
        frame.setVisible(true);
    }
    
    @Override
    protected void setup(){

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("Agente de interface craido.");
            }
        });
        
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage rec = myAgent.receive();
                if (rec != null) {
                    try {
                        Request req = (Request) rec.getContentObject();
                        
                        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                        msg.addReceiver(new AID("SearchAgent", AID.ISLOCALNAME));
                        msg.setContentObject(new RequestSearch(req));
                        send(msg);
                        
                    } catch (UnreadableException e) {
                    } catch (IOException e) {
                        System.out.println("Erro ao enviar mensagem: GuiAgent -> AgenteBuscaRestaurante");
                    }
                } else {
                    block();
                }
            }
        });
        
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage msg = myAgent.receive();
                if (msg != null) {
                    try {
                        RequestSearch req = (RequestSearch) msg.getContentObject();
                        
                        req.getRestaurantes().stream().map(r -> {
                            paneResult.add(new RestaurantCard(r));
                            return r;
                        }).map(_item -> {
                            paneResult.revalidate();
                            return _item;
                        }).forEachOrdered(_item -> {
                            paneResult.repaint();
                        });
                        
                    } catch (UnreadableException e) {}
                } else {
                    block();
                }
            }
        });
        
    }
    
    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {
        
        String type = cbType.getSelectedItem().toString();
        String score = cbScore.getSelectedItem().toString();
        String price = cbPrice.getSelectedItem().toString();
//        String district = cbDistrict.getSelectedItem().toString();
        
//        float priceFrom;
//        try { priceFrom = Float.parseFloat(txtPriceFrom.toString()); }
//        catch (NumberFormatException e) { priceFrom = 0; }
//        
//        float priceTo;
//        try { priceTo = Float.parseFloat(txtPriceTo.toString()); }
//        catch (NumberFormatException e) { priceTo = 0; }
        
        float distanceFrom;
        try { distanceFrom = Float.parseFloat(txtDistanceFrom.toString()); }
        catch (NumberFormatException e) { distanceFrom = 0; }
        
        float distanceTo;
        try { distanceTo = Float.parseFloat(txtDistanceTo.toString()); }
        catch (NumberFormatException e) { distanceTo = 0; }
        
        try {
            ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
            msg.addReceiver(new AID("GuiAgent", AID.ISLOCALNAME));
            msg.setContentObject(new Request(type, price, distanceFrom, distanceTo, score));
            send(msg);
        } catch (IOException e) {
            System.out.println("Erro ao enviar mensagem: Usuário -> GuiAgent");
        }
    }
    
    private void createInterface(){

        btnFind = new JButton();
        lblType = new JLabel();
        lblDistance = new JLabel();
        lblPrice = new JLabel();
        lblScore = new JLabel();
//        lblTo1 = new JLabel();
        lblTo2 = new JLabel();
//        lblDistrict = new JLabel();
        cbType = new JComboBox<>();
        cbScore = new JComboBox<>();
//        cbDistrict = new JComboBox<>();
        cbPrice = new JComboBox<>();
//        txtPriceFrom = new JTextField();
//        txtPriceTo = new JTextField();
        txtDistanceFrom = new JTextField();
        txtDistanceTo = new JTextField();
        scroll = new JScrollPane();
        paneResult = new JPanel();
        paneFilter = new JPanel();
        Container framePane = frame.getContentPane();
        
        // pane filtros
        paneFilter.setBorder(new TitledBorder("Selecione as opções para encontrar um restaurante"));
        paneFilter.setLayout(null);
        paneFilter.setBounds(10, 10, 330, 135);
        
        // comida
        lblType.setText("Tipo de comida");
        lblType.setBounds(10, 20, 150, 15);
        paneFilter.add(lblType);
        
        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Árabe", "Brasileira", "Japonesa", "Hambúrguer", "Pizza" }));
        cbType.setBounds(10, 40, 150, 25);
        paneFilter.add(cbType);
        
        // cassificação
        lblScore.setText("Classificação");
        lblScore.setBounds(170, 20, 150, 15);
        paneFilter.add(lblScore);
        
        cbScore.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "⋆⋆⋆⋆⋆", "⋆⋆⋆⋆", "⋆⋆⋆", "⋆⋆", "⋆" }));
        cbScore.setBounds(170, 40, 150, 25);
        paneFilter.add(cbScore);
        
        // price
        lblPrice.setText("Preço");
        lblPrice.setBounds(10, 70, 150, 15);
        paneFilter.add(lblPrice);
        
        cbPrice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "$$$", "$$", "$" }));
        cbPrice.setBounds(10, 90, 150, 25);
        paneFilter.add(cbPrice);
        
//        txtPriceFrom.setBounds(10, 90, 60, 25);
//        paneFilter.add(txtPriceFrom);
//        
//        lblTo1.setText("Até");
//        lblTo1.setBounds(75, 90, 30, 25);
//        paneFilter.add(lblTo1);
//        
//        txtPriceTo.setBounds(100, 90, 60, 25);
//        paneFilter.add(txtPriceTo);
        
        // distance
        lblDistance.setText("Distância");
        lblDistance.setBounds(170, 70, 150, 15);
        paneFilter.add(lblDistance);
        
        txtDistanceFrom.setBounds(170, 90, 60, 25);
        paneFilter.add(txtDistanceFrom);
        
        lblTo2.setText("Até");
        lblTo2.setBounds(235, 90, 30, 25);
        paneFilter.add(lblTo2);
        
        txtDistanceTo.setBounds(260, 90, 60, 25);
        paneFilter.add(txtDistanceTo);
        
//        // bairro
//        lblDistrict.setText("Selecione seu bairro");
//        lblDistrict.setBounds(10, 120, 310, 15);
//        paneFilter.add(lblDistrict);
//        
//        cbDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centro", "São João", "Cidade Nova", "Praia Brava" }));
//        cbDistrict.setBounds(10, 140, 310, 25);
//        paneFilter.add(cbDistrict);
        
        framePane.add(paneFilter);
        
        // botão procurar
        btnFind.setText("Procurar");
        btnFind.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnSendActionPerformed(evt);
        });
        btnFind.setBounds(10, 155, 330, 25);
        framePane.add(btnFind);
        
        // pane resultado
        paneResult.setLayout(new BoxLayout(paneResult, BoxLayout.Y_AXIS));
        scroll.setViewportView(paneResult);
        scroll.setBounds(10, 190, 330, 270);
        framePane.add(scroll);
      
    }

}
