/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.registros.Registro;

/**
 *
 * @author Gabriel
 */
public class CSVGerador extends CSV{
    private File file;
    
    private BufferedWriter bufferedWriter;    

    public CSVGerador() {
    }    
    
    public void gerarCsv(String path, ArrayList<Registro> listaRegistros){
        int i = 0;
        
        if(!(path.substring(path.length() - 4, path.length()).equals(".csv"))){
            path = path + ".csv";
        }
        
        try{
            this.file = new File(path);
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            
            this.bufferedWriter.write("ID;IDRegistro;Responsavel;Valor;Descrição;Data Vencimento;Data Operação;Tipo;Forma Operação;Condições Operação");
            this.bufferedWriter.newLine();
            
            while(i < listaRegistros.size()){
                this.bufferedWriter.write(listaRegistros.get(i).getRegistroFormatadoCSV());
                
                if(!(i == listaRegistros.size() - 1)){
                    this.bufferedWriter.newLine();
                }
                
                i++;
            }
            
            bufferedWriter.close();
            
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Operação interrompida!\n" + e);
        }
    }
}
