package jogando.acoes;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import fonte.Fonte;
import menu.Jogador;

public class Ranking implements Comparator<Jogador>{
	private FimDeJogo dadosJogador;
	private Fonte fonte = new Fonte();
	private Font fonteGeral = fonte.getFont(2);
	public int altura;
	
	public Ranking() {}
	
	public Ranking(FimDeJogo dados) {
		this.dadosJogador = dados;
		
		File diretorio = new File("./src/arqRanking/ranking");
        if (!diretorio.isDirectory()){
            diretorio.mkdirs();
        }
        BufferedWriter writer = null;
        try {
            if (dadosJogador.getDificuldade() == 1){
                writer = new BufferedWriter(new FileWriter("./src/arqRanking/ranking/Facil.txt", true));
            } else if (dadosJogador.getDificuldade() == 2) {
                writer = new BufferedWriter(new FileWriter("./src/arqRanking/ranking/Medio.txt", true));
            } else {
                writer = new BufferedWriter(new FileWriter("./src/arqRanking/ranking/Dificil.txt", true));
            }
            writer.write(dadosJogador.getNomeRanking() + "," + dadosJogador.getTempoRanking());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
        }
	}
	
	 public void ordenaRanking(int difRanking){
	        BufferedReader reader = null;
	        try{
	            if (difRanking == 1){
	                reader = new BufferedReader(new FileReader("./src/arqRanking/ranking/Facil.txt"));
	            } else if (difRanking == 2) {
	                reader = new BufferedReader(new FileReader("./src/arqRanking/ranking/Medio.txt"));
	            } else {
	                reader = new BufferedReader(new FileReader("./src/arqRanking/ranking/Dificil.txt"));
	            }
	            ArrayList<Jogador> novoJogador = new ArrayList<Jogador>();
	            String linhaAtual = reader.readLine();
	            while(linhaAtual != null){
	                String[] jogRecursos = linhaAtual.split(",");
	                String nome = jogRecursos[0];
	                int tempo = Integer.valueOf(jogRecursos[1]);
	                novoJogador.add(new Jogador(nome,tempo));
	                linhaAtual = reader.readLine();
	            }
	            Collections.sort(novoJogador, this);
	            BufferedWriter writer = null;
	            if (difRanking == 1){
	                writer = new BufferedWriter(new FileWriter("./src/arqRanking/ranking/Facil.txt", false));
	            } else if (difRanking == 2) {
	                writer = new BufferedWriter(new FileWriter("./src/arqRanking/ranking/Medio.txt", false));
	            } else {
	                writer = new BufferedWriter(new FileWriter("./src/arqRanking/ranking/Dificil.txt", false));
	            }
	            int i = 1;
	            for (Jogador jogador : novoJogador){
	            	writer.write(jogador.getNome());
	                writer.write(","+ jogador.getTempo());
	                writer.newLine();
	                i++;
	                if(i>10){
	                    break;
	                }
	            }
	            writer.close();
	            reader.close();
	        }catch (FileNotFoundException e){
	        }catch (IOException e) {
	        }
	 }
	 
	 
	 public int compare(Jogador j1, Jogador j2) {
	        return (int) (j1.getTempo() - j2.getTempo());
	 }
	 
	 public int getAltura() {
		 return this.altura;
	 }
	 
	 public void showTable(JPanel painelMeio, int difRanking){
	        BufferedReader reader = null;
	        try {
	            if (difRanking == 1){
	                reader = new BufferedReader(new FileReader("./src/arqRanking/ranking/Facil.txt"));
	            } else if (difRanking == 2) {
	                reader = new BufferedReader(new FileReader("./src/arqRanking/ranking/Medio.txt"));
	            } else {
	                reader = new BufferedReader(new FileReader("./src/arqRanking/ranking/Dificil.txt"));
	            }

	            String linhaAtual = reader.readLine();

	            DefaultTableModel tableModel = new DefaultTableModel(){

	                public boolean isCellEditable(int row, int column) {
	                    return false;
	                }

	            };
	            
	            tableModel.addColumn("Posição");
	            tableModel.addColumn("Jogador");
	            tableModel.addColumn("Tempo(sec)");
	            int i = 0;

	            while(linhaAtual != null && i < 10){
	                String[] usuarioDetalhe = linhaAtual.split(",");
	                String nome = usuarioDetalhe[0];
	                int tempo = Integer.valueOf(usuarioDetalhe[1]);
	                Object[] linha = {i+1,nome,tempo};
	                tableModel.insertRow(i, linha);
	                linhaAtual = reader.readLine();
	                i++;
	            }

	            JTable table = new JTable(tableModel);
	            table.setFocusable(false);
	            table.setRowSelectionAllowed(false);
	            table.setFont(fonteGeral);
	            table.setRowHeight(40);
	            table.setBackground(new Color(50, 0, 50));
	            table.setForeground(Color.WHITE);
	            

	            JTableHeader tableHeader = table.getTableHeader();
	            tableHeader.setBackground(new Color(50, 0, 50));
	            tableHeader.setFont(fonteGeral);
	            tableHeader.setForeground(Color.WHITE);
	            tableHeader.setReorderingAllowed(false);

	            TableColumnModel columnModel = table.getColumnModel();
	            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	            for(i = 0; i < 3 ; i++){
	                TableColumn tableColumn = columnModel.getColumn(i);
		            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		            tableColumn.setCellRenderer(centerRenderer);
	                tableColumn.setResizable(false);
	            }
	            
	            JScrollPane ranking = new JScrollPane(table);
	            this.altura = table.getRowHeight() * table.getRowCount();
	            painelMeio.setBounds(100, 40, 370, altura + 25);
	            painelMeio.add(ranking);
	            reader.close();

	        } catch (FileNotFoundException e) {
	        } catch (IOException e) {
	        }

	    }

}
