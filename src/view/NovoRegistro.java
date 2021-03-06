package view;

import controller.BD_Registros;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.registros.Registro;
import model.usuario.UsuarioComum;

public class NovoRegistro extends javax.swing.JFrame {
    UsuarioComum uc;
    
    public NovoRegistro(UsuarioComum u) {
        uc = u;
        initComponents();
        
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        valor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        responsavel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        dataVencimento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dataOperacao = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxFormaOperacao = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxCondicoesOperacao = new javax.swing.JComboBox<>();
        voltar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Novo Registro");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Preencha todos os campos para criar um novo registro");

        jPanel3.setBackground(new java.awt.Color(49, 49, 49));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(230, 230, 230));
        jLabel2.setText("Valor");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(230, 230, 230));
        jLabel4.setText("Nome Responsável");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(230, 230, 230));
        jLabel5.setText("Descrição");

        dataVencimento.setText("dd/MM/aaaa");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(230, 230, 230));
        jLabel6.setText("Data Vencimento");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(230, 230, 230));
        jLabel7.setText("Data Operação");

        dataOperacao.setText("dd/MM/aaaa");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudo", "Rancho", "Higiene", "Conveniência", "Lazer", "Lucro", "Saúde", "Casa", "Manutenção", "Rendimento" }));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(230, 230, 230));
        jLabel8.setText("Tipo");

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(230, 230, 230));
        jLabel9.setText("Forma Operação");

        jComboBoxFormaOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cartão de Crédito", "Cartão de Débito", "Cheque", "Dinheiro", "Transferência Bancária" }));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(230, 230, 230));
        jLabel10.setText("Condições Operação");

        jComboBoxCondicoesOperacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "À Prazo", "À Vista" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(dataOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxFormaOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCondicoesOperacao, 0, 215, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(valor))
                                    .addComponent(jLabel4))
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(responsavel)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(descricao)))))
                        .addGap(31, 31, 31))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxCondicoesOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxFormaOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        voltar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        cadastrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cadastrar.setText("Cadastrar");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 973, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean camposVazios(){
        if(
            this.responsavel.getText().equals("") ||
            this.valor.getText().equals("") ||
            this.descricao.getText().equals("") ||
            this.dataVencimento.getText().equals("") ||
            this.dataOperacao.getText().equals("")
            ){
            return(true);
        }
        return(false);
    }
    
    private void apagarCampos(){
        this.responsavel.setText("");
        this.valor.setText("");
        this.descricao.setText("");
        this.dataVencimento.setText("dd/MM/aaaa");
        this.dataOperacao.setText("dd/MM/aaaa");
    }
    
    private boolean caracteresImpossiveis(){
        if(
            this.responsavel.getText().contains(";") ||
            this.valor.getText().contains(";") ||
            this.descricao.getText().contains(";") ||
            this.dataVencimento.getText().contains(";") ||
            this.dataOperacao.getText().contains(";")
            ){
            return(true);
        }
        return(false);
    }
    
    private double formatarValor(double valor, String tipo){
        if((tipo.equals("Lucro") || tipo.equals("Rendimento")) && valor < 0){
            return(valor * (-1));
        }else{
            if(!(tipo.equals("Lucro") || tipo.equals("Rendimento")) && valor > 0){
                return(valor * (-1));
            }
        }
        return(valor);
    }
    
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.dispose();
        new Main(uc);
    }//GEN-LAST:event_voltarActionPerformed

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        Date dataVencimento, dataOperacao;
        String id, responsavel, descricao, tipo, formaOperacao, CondicoesOperacao;
        double valor = 0;
        
        id = this.uc.getId();
        responsavel = descricao = tipo = formaOperacao = CondicoesOperacao = "";
        
        if(camposVazios()){
            JOptionPane.showMessageDialog(null, "Certifique-se de que todos os dados foram preencchidos");
        }else{
            if(caracteresImpossiveis()){
                JOptionPane.showMessageDialog(null, "Certifique-se que não tenha colocado nenhum ; em nenhum campo");
            }else{
                try{
                    responsavel = this.responsavel.getText();
                    valor = Double.parseDouble(this.valor.getText());
                    descricao = this.descricao.getText();
                    dataVencimento = formato.parse(this.dataVencimento.getText());
                    dataOperacao = formato.parse(this.dataOperacao.getText());
                    tipo = this.jComboBoxTipo.getSelectedItem().toString();
                    formaOperacao = this.jComboBoxFormaOperacao.getSelectedItem().toString();
                    CondicoesOperacao = this.jComboBoxCondicoesOperacao.getSelectedItem().toString();
                    
                    valor = this.formatarValor(valor, tipo);
                    
                    Registro r = new Registro(id, responsavel, valor, descricao, dataVencimento, dataOperacao, tipo, formaOperacao, CondicoesOperacao);
                    
                    BD_Registros bd = new BD_Registros();
                    
                    bd.novoRegistro(r.getRegistroFormatadoCSV());
                    
                    JOptionPane.showMessageDialog(null, "Registro criado com sucesso!");
                    
                    this.apagarCampos();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Operação negada!\n" + e);
                }
            }   
        }
    }//GEN-LAST:event_cadastrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrar;
    private javax.swing.JTextField dataOperacao;
    private javax.swing.JTextField dataVencimento;
    private javax.swing.JTextField descricao;
    private javax.swing.JComboBox<String> jComboBoxCondicoesOperacao;
    private javax.swing.JComboBox<String> jComboBoxFormaOperacao;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField responsavel;
    private javax.swing.JTextField valor;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
