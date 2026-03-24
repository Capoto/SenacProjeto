/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.senac.projetointegrador.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import br.com.projetointegrador.model.DadosMemoria;
import br.com.projetointegrador.dao.PatrimonioDAO;
import br.com.projetointegrador.dao.UserDAO;
/**
 *
 * @author heitor
 */


public class Menu extends javax.swing.JFrame implements MouseListener{

    PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
    UserDAO userDAO = new UserDAO();
    
    JFrame frame = new JFrame("Menu");    
    
    JLayeredPane layeredPane = new JLayeredPane();
    
    ImageIcon icon = new ImageIcon(getClass().getResource("/img/add.png"));

    // Redimensiona a imagem para 40x40
    Image scaled = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

    JButton button = new JButton(new ImageIcon(scaled));
    
    ImageIcon icon2 = new ImageIcon(getClass().getResource("/img/verify.png"));

    // Redimensiona a imagem para 40x40
    Image scaled2 = icon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

    JButton button2 = new JButton(new ImageIcon(scaled2));
    
    ImageIcon icon3 = new ImageIcon(getClass().getResource("/img/logout.png"));

    // Redimensiona a imagem para 40x40
    Image scaled3 = icon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

    JButton button3 = new JButton(new ImageIcon(scaled3));
    
    int menuid;
    
    public Menu(int id){
    
        menuid = id;
        // Criando dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        
        
        dataset.addValue(patrimonioDAO.count(), "Patrimônios", "Quantidade");
        dataset.addValue(userDAO.countBolsista(), "Bolsistas", "Quantidade");
        dataset.addValue(userDAO.countResponsavel(), "Responsavel", "Quantidade");

        // Criando gráfico
        JFreeChart chart = ChartFactory.createBarChart(
                "Quantidade de Registros", // título
                "",                 // eixo X
                "Quantidade",               // eixo Y
                dataset
        );

        // Criando painel do gráfico
        ChartPanel panel = new ChartPanel(chart);
      
        panel.setPreferredSize(new java.awt.Dimension(300, 300));
        
        
        layeredPane.setBounds(0, 0, 500, 500);

    // Custom rounded panel
    JPanel roundedPanel = new JPanel() {
        
        
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(255, 255, 255));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Rounded corners
        }

        @Override
        public boolean isOpaque() {
            return false;
        }
    };
    
    
    roundedPanel.setBounds(0, 00, 500, 500);

    // Use GridBagLayout to center components
    roundedPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(0, 20, 20, 20); // spacing around components
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;
    
    roundedPanel.add(panel,gbc);
    
    
    
    
    gbc.gridy = 0; // move down one row
    gbc.anchor = GridBagConstraints.SOUTHWEST;
    gbc.weightx = 1;
    gbc.weighty = 1;

    roundedPanel.add(button,gbc);
    
    
    
    
    
    
    gbc.gridy = 0; // move down one row
    gbc.anchor = GridBagConstraints.SOUTH;
    gbc.weightx = 1;
    gbc.weighty = 1;

    roundedPanel.add(button2,gbc);
    
    
    gbc.gridy = 0; // move down one row
    gbc.anchor = GridBagConstraints.SOUTHEAST;
    gbc.weightx = 1;
    gbc.weighty = 1;

    roundedPanel.add(button3,gbc);
    
     // Add to the layered pane
    layeredPane.add(roundedPanel, JLayeredPane.DEFAULT_LAYER);
    
    button.addMouseListener(this);
    button2.addMouseListener(this);
    button3.addMouseListener(this);
    
    frame.setContentPane(layeredPane);
    frame.setSize(500, 500);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
    @Override
      public void mouseClicked(MouseEvent e) {
          if(e.getSource() == button) {
              Cadastro ca = new Cadastro(menuid);
              frame.setVisible(false);
          }
          
          else if(e.getSource() == button2) {
              Listagem lista = new Listagem(menuid);
              frame.setVisible(false);
              
          }
          
          else if(e.getSource() == button3) {
              Login lo = new Login();
              frame.setVisible(false);
              
          }
      }
      
      @Override
      public void mousePressed(MouseEvent e) {
          if(e.getSource() == button) {
              System.out.println("Você pressionou com o mouse.");
          }
      }
  
      @Override
      public void mouseEntered(MouseEvent e) {
          if(e.getSource() == button) {
              System.out.println("Você está sobre o botão com o mouse.");
          }
      }
  
      
      @Override
      public void mouseExited(MouseEvent e) {
          
      }
      
      @Override
      public void mouseReleased(MouseEvent e) {
          
      }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
