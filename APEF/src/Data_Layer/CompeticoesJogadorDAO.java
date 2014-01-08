package Data_Layer;

import Business_Layer.Jogador;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class CompeticoesJogadorDAO implements Map<Integer,Integer> {
    private HashMap<Integer,Integer> competicoes;

    @Override
    public int size() {
        return this.competicoes.size();
    }

    @Override
    public boolean isEmpty() {
        return this.competicoes.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.competicoes.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.competicoes.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return this.competicoes.get(key);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return this.competicoes.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return this.competicoes.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Integer> m) {
        this.competicoes.putAll(m);
    }

    @Override
    public void clear() {
        this.competicoes.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.competicoes.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return this.competicoes.values();
    }

    @Override
    public Set<Map.Entry<Integer, Integer>> entrySet() {
        return this.competicoes.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}

