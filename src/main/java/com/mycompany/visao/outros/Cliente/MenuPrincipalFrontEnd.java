/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.visao.outros.Cliente;

import com.mycompany.dao.DaoProduto;
import com.mycompany.ferramentas.BancoDeDadosMySql;
import com.mycompany.ferramentas.Constantes;
import com.mycompany.ferramentas.DadosTemporarios;
import com.mycompany.ferramentas.Formularios;
import com.mycompany.modelo.ModProduto;
import com.mycompany.visao.Pessoa.CadPessoa;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexandre.9930
 */
public class MenuPrincipalFrontEnd extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipalCliente
     */
    public MenuPrincipalFrontEnd() {
        initComponents();
        
         
        Formularios.menuPrincipalFrontEnd = this;
        
        setLocationRelativeTo(null);
        
        setExtendedState(MAXIMIZED_BOTH);
        
        if (!BancoDeDadosMySql.conectar()){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados. O sistema será finalizado.");
            System.exit(0);
        }
        
        labelUsuarioLogado.setText("");
    }

    public void listarTodos(){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarTodos();
            
            defaultTableModel.setRowCount(0);
            while (resultSet.next()){
                String nome = resultSet.getString(4);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{nome, preco});
            }
        }catch(Exception e){
            
        }
    }
    
    public void listarPorProduto(String pProduto){
        try{
            //Pega o model da tabela definido no design
            DefaultTableModel defaultTableModel = (DefaultTableModel) tableProduto.getModel();
            
            tableProduto.setModel(defaultTableModel);

            DaoProduto daoProduto = new DaoProduto();

            //Atribui o resultset retornado a uma variável para ser usada.
            ResultSet resultSet = daoProduto.listarPorNome(pProduto);
            
            defaultTableModel.setRowCount(0);
            
            while (resultSet.next()){
                String nome = resultSet.getString(4);
                String preco = resultSet.getString(6);
                
                defaultTableModel.addRow(new Object[]{nome, preco});
            }
        }catch(Exception e){
            
        }
    }
    
    public void verificaUsuarioLogado(){
        if(!DadosTemporarios.usuarioLogado.equals("")){
            labelUsuarioLogado.setText(Constantes.PREFIXO_USUARIO_LOGADO + DadosTemporarios.usuarioLogado);
            
            labelEntrar.setText(Constantes.LABEL_SAIR);
            labelCadastrar.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfPesquisaProduto = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        labelCadastrar = new javax.swing.JLabel();
        labelEntrar = new javax.swing.JLabel();
        labelUsuarioLogado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 153));

        tableProduto.setForeground(new java.awt.Color(0, 0, 0));
        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produto", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProduto);

        tfPesquisaProduto.setColumns(20);
        tfPesquisaProduto.setForeground(new java.awt.Color(0, 0, 0));
        tfPesquisaProduto.setRows(5);
        jScrollPane2.setViewportView(tfPesquisaProduto);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        labelCadastrar.setText("Cadastrar");
        labelCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCadastrarMouseClicked(evt);
            }
        });

        labelEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelEntrar.setForeground(new java.awt.Color(0, 0, 0));
        labelEntrar.setText("Entrar");
        labelEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEntrarMouseClicked(evt);
            }
        });

        labelUsuarioLogado.setForeground(new java.awt.Color(0, 0, 0));
        labelUsuarioLogado.setText("Usuario logado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelUsuarioLogado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(labelEntrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsuarioLogado)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelCadastrar)
                        .addComponent(labelEntrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(DadosTemporarios.usuarioLogado != null){
            if(tfPesquisaProduto.getText().equals(""))
                listarTodos();
            else
                listarPorProduto(tfPesquisaProduto.getText());
        }else{
            JOptionPane.showMessageDialog(null, "Você ainda não está logado. Por favor, realize o login antes de realizar esta operação!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void labelEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEntrarMouseClicked
        if(labelEntrar.getText().equals(Constantes.LABEL_ENTRAR)){
            if (Formularios.telaLogin == null)
                Formularios.telaLogin = new TelaLogin();

            Formularios.telaLogin.setModal(true);
            Formularios.telaLogin.setVisible(true);
        }else{
            int escolha = 
                JOptionPane.showConfirmDialog(
                        null, 
                        Constantes.PERGUNTA_ENCERRAR_SESSAO);
        
            if(escolha == JOptionPane.YES_OPTION){
                DadosTemporarios.idUsuarioLogado = -1;
                DadosTemporarios.usuarioLogado = null;
                labelEntrar.setText(Constantes.LABEL_ENTRAR);
                labelUsuarioLogado.setText("");
                labelCadastrar.setVisible(true);
                
                ((DefaultTableModel) tableProduto.getModel()).setNumRows(0);
            }
        }
    }//GEN-LAST:event_labelEntrarMouseClicked

    private void tableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutoMouseClicked
           try{
            if (evt.getClickCount() == 2){
                ModProduto modProduto = new ModProduto();
                DaoProduto daoProduto = new DaoProduto();
                
                ResultSet resultSet = daoProduto.listarPorNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0)));
                
                resultSet.next();
                
                int id  = resultSet.getInt("ID");
                String categoria = resultSet.getString("CATEGORIA");
                String marca = resultSet.getString("MARCA");
                String descricao = resultSet.getString("DESCRICAO");
                
                System.out.println(categoria);
                System.out.println(marca);
                
                modProduto.setId(id);
                modProduto.setNome(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 0)));
                modProduto.setPreco(Double.parseDouble(String.valueOf(tableProduto.getValueAt(tableProduto.getSelectedRow(), 1))));
                modProduto.setDescricao(descricao);
                
                DadosTemporarios.tempObject = (ModProduto) modProduto;
                DadosTemporarios.categoriaProdutoVenda = categoria;
                DadosTemporarios.marcaProdutoVenda = marca;
                
                if (Formularios.telaVenda == null){
                    Formularios.telaVenda = new TelaVenda();
                    Formularios.telaVenda.setVisible(true);
                }else{
                    int escolha = 
                        JOptionPane.showConfirmDialog(
                            null, 
                            "Existe uma compra em andamento, deseja cancelá-la?");
                    
                    if(escolha == JOptionPane.YES_OPTION){
                        Formularios.telaVenda.dispose();
                        Formularios.telaVenda = null;

                        Formularios.telaVenda = new TelaVenda();
                        Formularios.telaVenda.setVisible(true);
                    }else{
                        Formularios.telaVenda.setVisible(true);
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_tableProdutoMouseClicked

    private void labelCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCadastrarMouseClicked
         if (Formularios.cadPessoa == null)
            Formularios.cadPessoa = new CadPessoa();

        Formularios.cadPessoa.setVisible(true);
    }//GEN-LAST:event_labelCadastrarMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipalFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalFrontEnd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalFrontEnd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelCadastrar;
    private javax.swing.JLabel labelEntrar;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JTable tableProduto;
    private javax.swing.JTextArea tfPesquisaProduto;
    // End of variables declaration//GEN-END:variables
}
