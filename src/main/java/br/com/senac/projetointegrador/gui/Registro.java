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
import br.com.projetointegrador.model.DadosMemoria;
import br.com.projetointegrador.model.Bolsista;
import br.com.projetointegrador.model.Responsavel;
import br.com.projetointegrador.dao.UserDAO;
/**
 *
 * @author heitor
 */


public class Registro extends javax.swing.JFrame implements MouseListener {
    
    UserDAO userDAO = new UserDAO();

    /**
     * Creates new form Registro
     */
    
    JFrame frame = new JFrame("Registro");
   
    JLayeredPane layeredPane = new JLayeredPane();
    
    JButton button = new JButton("Registrar");
    
    JLabel login = new JLabel("<html><font size='3'>Já é registrado? </font><font size='4'>Login</font></html>");
    
    JLabel titulo = new JLabel("<html><font size='5'>Registro</font></html>");
    
    JTextField email;
    
    JTextField nome;
    
    JTextField cpf;
    
    JTextField nascimento;
    
    JTextField telefone;
    
    JPasswordField senha;
    
    JCheckBox check;
    
    public Registro() {
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
    roundedPanel.setBounds(0, 0, 500, 500);

    // Use GridBagLayout to center components
    roundedPanel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10); // spacing around components
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.CENTER;

    nome = new PlaceholderTextField("Informe o seu Nome");
    nome.setColumns(20);
    email = new PlaceholderTextField("Informe o seu e-mail");
    email.setColumns(20);
    cpf = new PlaceholderTextField("Informe o seu cpf");
    cpf.setColumns(20);
    nascimento = new PlaceholderTextField("Informe a data do Nascimento");
    nascimento.setColumns(20);
    telefone = new PlaceholderTextField("Informe o seu telefone");
    telefone.setColumns(20);
    
    senha = new  PlaceholderPasswordTextField("Digite sua senha...");
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
    login.addMouseListener(this);

    gbc.anchor = GridBagConstraints.SOUTHWEST;
    roundedPanel.add(titulo,gbc);
    
    gbc.gridy = 1; // move down one row
    roundedPanel.add(nome, gbc);
    
    gbc.gridy = 2; 
    roundedPanel.add(email, gbc);
    
    gbc.gridy = 3; 
    roundedPanel.add(cpf, gbc);
    
    gbc.gridy = 4; 
    roundedPanel.add(nascimento, gbc);
    
    gbc.gridy = 5; 
    roundedPanel.add(telefone, gbc);
    
    gbc.gridy = 6; 
    roundedPanel.add(senha, gbc);
    
    gbc.gridy = 10;
    gbc.anchor = GridBagConstraints.EAST;
    roundedPanel.add(check, gbc);
    
    gbc.gridy = 50; // move down one row
    gbc.anchor = GridBagConstraints.CENTER;
    roundedPanel.add(button, gbc);

    gbc.gridy = 100; // move down one row
    gbc.anchor = GridBagConstraints.CENTER;
    roundedPanel.add(login, gbc);
    
    
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
    
    
    public boolean verificaCPF(String cpf){
    
        boolean cpfverificado = cpf.matches("[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}");
        
        if(!cpfverificado){
        
            return true;
        }
        
        
        return false;
    }
    
    
   public boolean verificaTelefone(String telefone) {
    return telefone.matches("^(\\(?\\d{2}\\)?\\s*)?(9\\d{4}-?\\d{4})$");
}
   
   public boolean verificaNascimento(String nascimento){
   
        boolean nascimentoVerificado = nascimento.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}");
        
        if(!nascimentoVerificado){
        
            return true;
        }
       
        return false;
   }
    
    
    @Override
      public void mouseClicked(MouseEvent e) {
          if(e.getSource() == button) {
              
              if(confereCampos(nome.getText()) || confereCampos(email.getText()) || confereCampos(cpf.getText()) || confereCampos(nascimento.getText()) || confereCampos(telefone.getText()) || confereCampos(String.valueOf(senha.getPassword())) ){
              
                  JOptionPane.showMessageDialog(null, "Informe todos os campos");
              }
             
              else{
              
                  if(verificaEmail(email.getText())){
                  
                      JOptionPane.showMessageDialog(null, "E-mail precisa ser no formato nome@dominio.com.br");
                  }
                  
                  else if(verificaCPF(cpf.getText())){
                  
                      JOptionPane.showMessageDialog(null, "Cpf precisa se no formato xxx.xxx.xxx-xx");
                  }
                  
                  else if(!verificaTelefone(telefone.getText())){
                  
                      JOptionPane.showMessageDialog(null, "Coloque o telefone no seguinte formado: 11987654321");
                  }
                  
                  else if(verificaNascimento(nascimento.getText())){
                  
                      JOptionPane.showMessageDialog(null, "Data precisa ser no formato dd/mm/aaaa");
                  }
                  
                  else{
                      
                      if(check.isSelected()){
                      
                            Responsavel res = new Responsavel(nome.getText(),email.getText(),cpf.getText(),nascimento.getText(),telefone.getText(),String.valueOf(senha.getPassword()));
                     
                            userDAO.inserirResponsavel(res);
                            nome.setText("");
                            email.setText("");
                            cpf.setText("");
                            nascimento.setText("");
                            telefone.setText("");
                            senha.setText("");
                      }
                      else{
                          
                          Bolsista bol = new Bolsista(nome.getText(),email.getText(),cpf.getText(),nascimento.getText(),telefone.getText(),String.valueOf(senha.getPassword()));
                     
                          userDAO.inserirBolsista(bol);
                          nome.setText("");
                          email.setText("");
                          cpf.setText("");
                          nascimento.setText("");
                          telefone.setText("");
                          senha.setText("");
                         
                          
                      }
                      
                      JOptionPane.showMessageDialog(null, "Cadastro de Usuário salvo.");
                  }
              
              }
              
          }
          
          else if(e.getSource() == login) {
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
