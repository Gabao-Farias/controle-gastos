package model.registros;

import controller.BD_Registros;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class RegistroTableModel extends AbstractTableModel{
    private ArrayList<Registro> registrosMostrados = new ArrayList<>();
    private String[] colunas = {"IDRegistro", "Responsavel", "Valor", "Descrição", "Data Vencimento", "Data Operação", "Tipo", "Forma Operação", "Condições Operação"};

    private BD_Registros bd = new BD_Registros();

    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }

    @Override
    public int getRowCount() {
        return(registrosMostrados.size());
    }

    @Override
    public int getColumnCount() {
        return(colunas.length);
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return registrosMostrados.get(linha).getIdRegistro();
            case 1:
                return registrosMostrados.get(linha).getResponsavel();
            case 2:
                return registrosMostrados.get(linha).getValor();
            case 3:
                return registrosMostrados.get(linha).getDescricao();
            case 4:
                return registrosMostrados.get(linha).getDataVencimentoFormatada();
            case 5:
                return registrosMostrados.get(linha).getDataOperacaoFormatada();
            case 6:
                return registrosMostrados.get(linha).getTipo();
            case 7:
                return registrosMostrados.get(linha).getFormaOperacao();
            case 8:
                return registrosMostrados.get(linha).getCondicoesOperacao();
        }
        return(null);
    }
    
    public ArrayList<Registro> getRegistrosMostrados(){
        return(this.registrosMostrados);
    }
    
    public void iniciarDados(String id){        
        this.registrosMostrados = bd.getRegistrosUsuario(id);
    }
    
    public void addRow(Registro r){
        this.registrosMostrados.add(r);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int index){
        this.registrosMostrados.remove(index);
        this.fireTableRowsDeleted(index, index);
    }    
    
    public void setData(ArrayList<Registro> lista){
        this.registrosMostrados = lista;
        this.fireTableDataChanged();
    }
}
