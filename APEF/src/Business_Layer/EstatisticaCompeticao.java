package Business_Layer;

import Data_Layer.DadosEstatisticosDAO;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class EstatisticaCompeticao {
    private int idEstatistica;
    private Map<Integer,DadosEstatisticos> estatistica; //<id equipas, dados estatisticos>

    public EstatisticaCompeticao() {
        this.idEstatistica = APEF.getID();
    	this.estatistica = new DadosEstatisticosDAO(idEstatistica);
        APEF.putID();
    }
    
    public EstatisticaCompeticao(int id, Map<Integer,DadosEstatisticos> et) {
        this.idEstatistica = id;
        this.estatistica = et;
    }

    public EstatisticaCompeticao(EstatisticaCompeticao ec){
    	this.estatistica = ec.getEstatistica();
    }

    public Map<Integer,DadosEstatisticos> getEstatistica(){
    	Map<Integer,DadosEstatisticos> aux = new DadosEstatisticosDAO(idEstatistica);
    	
    	for (DadosEstatisticos i : this.estatistica.values())
    	{ aux.put(i.getID(),i); }

    	return aux;
    }

    public void setEstatistica(Map<Integer,DadosEstatisticos> h){
    	this.estatistica = h;
    }
    
    public int getID() {
        return this.idEstatistica;
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
        s.append("Estatistica da Competicao:");
        for(DadosEstatisticos d : this.estatistica.values()) {
			s.append(d);
        }
        return s.toString();
    }
    
    public void inserirDados(DadosEstatisticos d) {
        if (!this.estatistica.containsKey(d.getID()))
            this.estatistica.put(d.getID(),d);
    }
    
    public void actualizaClassificacao(Jogo j) {
        this.atualizaEstatisticaCompeticao(j.getEscalaoCasa(),j.getNumGolosJogoCasa(),j.getEscalaoFora(),j.getNumGolosJogoFora());
    }
    
    public void atualizaEstatisticaCompeticao(Escalao casa, int golosCasa, Escalao fora, int golosFora) {
        DadosEstatisticos novoCasa;  
        DadosEstatisticos novoFora;
        
        for(DadosEstatisticos dadosCasa : this.estatistica.values()) {
            if(casa.getID() == dadosCasa.getIdEscalao()) {
                dadosCasa.addDadosEstatisticos(golosCasa,golosFora);
                novoCasa = dadosCasa;
                this.estatistica.remove(dadosCasa);
                this.estatistica.put(novoCasa.getID(),novoCasa);
            }
        }
        
        for(DadosEstatisticos dadosFora : this.estatistica.values()) {
            if(fora.getID() == dadosFora.getIdEscalao()) {
                dadosFora.addDadosEstatisticos(golosCasa,golosFora);
                novoFora = dadosFora;
                this.estatistica.remove(dadosFora);
                this.estatistica.put(novoFora.getID(),novoFora);
            }
        }
    }
}

  
    
