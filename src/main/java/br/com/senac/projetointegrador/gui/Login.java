/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.senac.projetointegrador.gui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import br.com.projetointegrador.model.Bolsista;
import br.com.projetointegrador.model.Responsavel;
import br.com.projetointegrador.dao.UserDAO;
/**
 *
 * @author heitor
 */


class PlaceholderTextField extends JTextField{
    
    private String placeholder;
    
    public PlaceholderTextField(String placeholder){
        
        this.placeholder = placeholder;
    }
        
    @Override
    protected void paintComponent(Graphics g){
            
            
        super.paintComponent(g);

        if (getText().isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            Insets insets = getInsets();
            g2.drawString(placeholder, insets.left + 5, 
                          getHeight()/2 + g.getFontMetrics().getAscent()/2 - 2);
            g2.dispose();
        }
            
        }}

class PlaceholderPasswordTextField extends JPasswordField{
    
    private String placeholder;
    
    public PlaceholderPasswordTextField(String placeholder){
        
        this.placeholder = placeholder;
    }
        
    @Override
    protected void paintComponent(Graphics g){
            
            
        super.paintComponent(g);

        
        if (getPassword().length == 0 && (FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() != this)) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(Color.GRAY);
            Insets insets = getInsets();
            g2.drawString(placeholder, insets.left + 5, 
                          getHeight()/2 + g.getFontMetrics().getAscent()/2 - 2);
            g2.dispose();
        }
        
            
        }}

public class Login extends javax.swing.JFrame implements MouseListener {

    /**
     * Creates new form Login
     */
    
    UserDAO userDao = new UserDAO();
    JFrame frame = new JFrame("Login");
   
    JLayeredPane layeredPane = new JLayeredPane();
    JLabel titulo = new JLabel("<html><font size='5'>Login</font></html>");
    JButton button = new JButton("Logar");
    JLabel registrar = new JLabel("<html><font size='3'>Novo Usuário? </font><font size='4'>Registrar</font></html>");
    JTextField email;
    JPasswordField senha;
    JCheckBox check;
    
    public Login() {
        
        
       
        
        
       layeredPane.setBounds(50, 50, 400, 400);

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
    
    
    
        
        
    
    roundedPanel.setBounds(50, 50, 400, 400);

    // Use GridBagLayout to center components
    roundedPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); // spacing around components
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;

    
    email = new PlaceholderTextField("Informe o seu e-mail");
    email.setColumns(20);
    senha = new  PlaceholderPasswordTextField("Digite sua senha...");
    // mostra o texto ao invés dos asteriscos
    senha.setEchoChar((char) 0); 
    senha.setForeground(Color.GRAY);
    senha.setColumns(20);
    
    senha.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (!String.valueOf(senha.getPassword()).equals("Digite sua senha...") && senha.getPassword().length>=0) {
                    
                    senha.setForeground(Color.BLACK);
                    senha.setEchoChar('•'); // volta a usar asterisco ao digitar
                }
                
            else{
                    senha.setText("");
                    senha.setForeground(Color.BLACK);
                    senha.setEchoChar('•');
                
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(senha.getPassword()).isEmpty()) {
                    //senha.setText("Digite sua senha...");
                    senha.setForeground(Color.GRAY);
                    senha.setEchoChar((char) 0); // mostra o texto placeholder
                }
                
            else{
                    senha.setForeground(Color.BLACK);
                    senha.setEchoChar('•');
                }
            }
        });
    
    
    
    button.setPreferredSize(new Dimension(228, 30));
    button.setBackground(new Color(0, 22, 223));
    button.setForeground(Color.WHITE);
    button.addMouseListener(this);
    check = new JCheckBox("Admin");
    
    
    registrar.addMouseListener(this);
    gbc.anchor = GridBagConstraints.SOUTHWEST;
    roundedPanel.add(titulo,gbc);
    gbc.gridy = 1; // move down one row
    
    roundedPanel.add(email, gbc);
    
    gbc.gridy = 2; // move down one row
    roundedPanel.add(senha, gbc);
    
    gbc.gridy = 4; // move down one row
    gbc.anchor = GridBagConstraints.EAST;
    roundedPanel.add(check, gbc);
    
    gbc.gridy = 5; // move down one row
    gbc.anchor = GridBagConstraints.CENTER;
    roundedPanel.add(button, gbc);

    gbc.gridy = 50; // move down one row
    gbc.anchor = GridBagConstraints.CENTER;
    roundedPanel.add(registrar, gbc);
    
    
    // Add to the layered pane
    layeredPane.add(roundedPanel, JLayeredPane.DEFAULT_LAYER);

    frame.setContentPane(layeredPane);
    frame.setSize(500, 500);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
     public boolean confereCampos(String campo){
    
        if(campo.trim().isEmpty() || campo.trim()==""){
        
            return true;
        }
        return false;
    }
    
    public boolean verificaEmail(String email){
    
        boolean emailverificado = email.matches("\\w+@\\w+\\.\\w{2,3}\\.\\w{2,3}");
    
        if(!emailverificado){
        
            return true;
        }
        
        
        
        return false;
    }
    
    
    
    @Override
      public void mouseClicked(MouseEvent e) {
          if(e.getSource() == button) {
              
              if(confereCampos(email.getText()) || confereCampos(String.valueOf(senha.getPassword()))){
              
                  JOptionPane.showMessageDialog(null, "Informe todos os campos");
              }
              else if(verificaEmail(email.getText())){
              
                  JOptionPane.showMessageDialog(null, "E-mail precisa ser no formato nome@dominio.com.br");
              }
              else{
                 
                  if(check.isSelected()){
                  
                       var x = userDao.logarResponsavel(email.getText(), String.valueOf(senha.getPassword()));
                      
                      if(x!=null){
                          Menu  me = new Menu(x.getId());
              
                          frame.setVisible(false);
                      }else{
                          
                          JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                      }
                      
                  }
                  else{
                  
                      var x = userDao.logarBolsista(email.getText(), String.valueOf(senha.getPassword()));
                      
                      if(x!=null){
                          
                          Menu  me = new Menu(x.getId());
              
                          frame.setVisible(false);
                      }else{
                          
                          JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                      }
                      
                     
                  }
              
              
              
              
              }
          }
          
          else if(e.getSource() == registrar) {
             Registro re = new Registro();
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
