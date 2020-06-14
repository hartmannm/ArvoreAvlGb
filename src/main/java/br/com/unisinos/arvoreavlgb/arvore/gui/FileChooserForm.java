/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unisinos.arvoreavlgb.arvore.gui;

import br.com.unisinos.arvoreavlgb.arvore.gui.facade.FileChooseFormFacade;
import br.com.unisinos.arvoreavlgb.arvore.utils.GuiUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * Componente responsável pela seleção de arquivos
 *
 * @author Marcello Augusto Gava
 * @author Mauricio Hartmann
 */
public class FileChooserForm extends JFrame {

    /** Mensagem de erro - Nenhum arquivo selecionado */
    private static final String ERRO_SELECAO_ARQUIVO = "Por favor, selecione um arquivo para importação";
    /** Service do componente de seleção de arquivos */
    private final FileChooseFormFacade fileChooserFacade;

    /**
     * Creates new form FileChooserForm
     */
    public FileChooserForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fileChooserFacade = new FileChooseFormFacade();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooserPanel = new javax.swing.JPanel();
        fileChooserField = new javax.swing.JTextField();
        fileChooserModalButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fileChooserOkButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleção de arquivo");
        setResizable(false);

        fileChooserPanel.setToolTipText("");

        fileChooserField.setEditable(false);

        fileChooserModalButton.setBackground(new java.awt.Color(255, 255, 255));
        fileChooserModalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/folder-icon.png"))); // NOI18N
        fileChooserModalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserModalButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setText("Selecione um arquivo (.csv) para importação");

        fileChooserOkButton.setBackground(new java.awt.Color(0, 255, 51));
        fileChooserOkButton.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        fileChooserOkButton.setForeground(new java.awt.Color(255, 255, 255));
        fileChooserOkButton.setText("Prosseguir");
        fileChooserOkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserOkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fileChooserPanelLayout = new javax.swing.GroupLayout(fileChooserPanel);
        fileChooserPanel.setLayout(fileChooserPanelLayout);
        fileChooserPanelLayout.setHorizontalGroup(
            fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileChooserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fileChooserPanelLayout.createSequentialGroup()
                        .addComponent(fileChooserField, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileChooserModalButton))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileChooserPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileChooserOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        fileChooserPanelLayout.setVerticalGroup(
            fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileChooserPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fileChooserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileChooserModalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileChooserField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(fileChooserOkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fileChooserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileChooserPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Executa no clique do botão de prosseguir
     *
     * @param evt Evento
     */
    private void fileChooserOkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserOkButtonActionPerformed
        // Se nenhum arquivo foi selecionado
        if (fileChooserField.getText() == null || fileChooserField.getText().isBlank()) {
            GuiUtils.exibeAlerta(this, ERRO_SELECAO_ARQUIVO);
            return;
        }
        try {
            fileChooserFacade.exibeJanelaConsulta(fileChooserField.getText());
            this.dispose();
        } catch (Exception e) {
            GuiUtils.exibeAlerta(this, e.getMessage());
        }
    }//GEN-LAST:event_fileChooserOkButtonActionPerformed

    /**
     * Executa no clique do botão de seleção de arquivo
     *
     * @param evt Evento
     */
    private void fileChooserModalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserModalButtonActionPerformed
        try {
            this.fileChooserField.setText(fileChooserFacade.getCaminhoArquivo());
        } catch (Exception e) {
            Logger.getLogger(FileChooserForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_fileChooserModalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FileChooserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileChooserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileChooserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileChooserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FileChooserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileChooserField;
    private javax.swing.JButton fileChooserModalButton;
    private javax.swing.JButton fileChooserOkButton;
    private javax.swing.JPanel fileChooserPanel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
