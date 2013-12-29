package Business_Layer;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

public class EstatisticaCompeticao {
    private TreeSet<DadosEstatisticos> estatistica; //<id equipas, dados estatisticos>

    public EstatisticaCompeticao() {
    	this.estatistica = new TreeSet<DadosEstatisticos>();
    }

    public EstatisticaCompeticao(EstatisticaCompeticao ec){
    	this.estatistica = ec.getEstatistica();
    }

    public TreeSet<DadosEstatisticos> getEstatistica(){
    	TreeSet<DadosEstatisticos> aux = new TreeSet<DadosEstatisticos>();
    	
    	for (DadosEstatisticos i : this.estatistica)
    	{ aux.add(i.clone()); }

    	return aux;
    }

    public void setEstatistica(TreeSet<DadosEstatisticos> h){
    	this.estatistica = h;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.estatistica);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EstatisticaCompeticao other = (EstatisticaCompeticao) obj;
        return (this.estatistica.equals(other.getEstatistica()));
    }

    public EstatisticaCompeticao clone(){
    	return new EstatisticaCompeticao(this);
    }

    public String toString(){
    StringBuilder s = new StringBuilder();
        s.append("Estatistica da Competicao:" + this.getEstatistica());
        for(DadosEstatisticos d : this.estatistica)
			s.append(d.toString());
        return s.toString();
    }
  
    public void atualizaEstatisticaCompeticao(Escalao casa, int golosCasa, Escalao fora, int golosFora) {
        DadosEstatisticos novoCasa;  
        DadosEstatisticos novoFora;
        
        for(DadosEstatisticos dadosCasa : this.estatistica) {
            if(casa.getID() == dadosCasa.getIdEscalao()) {
                dadosCasa.addDadosEstatisticos(golosCasa,golosFora);
                novoCasa = dadosCasa;
                this.estatistica.remove(dadosCasa);
                this.estatistica.add(novoCasa);
            }
        }
        
        for(DadosEstatisticos dadosFora : this.estatistica) {
            if(fora.getID() == dadosFora.getIdEscalao()) {
                dadosFora.addDadosEstatisticos(golosCasa,golosFora);
                novoFora = dadosFora;
                this.estatistica.remove(dadosFora);
                this.estatistica.add(novoFora);
            }
        }
    }
}

  
    
