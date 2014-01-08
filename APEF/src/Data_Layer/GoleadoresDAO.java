package Data_Layer;

import Business_Layer.Campeonato;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class GoleadoresDAO implements Map<Integer,Integer> {
    private HashMap<Integer,Integer> goleadores;
    
    public GoleadoresDAO() {
        this.goleadores = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.goleadores.size();
    }

    @Override
    public boolean isEmpty() {
        return this.goleadores.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.goleadores.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.goleadores.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return this.goleadores.get(key);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return this.goleadores.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return this.goleadores.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Integer> m) {
        this.goleadores.putAll(m);
    }

    @Override
    public void clear() {
        this.goleadores.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.goleadores.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return this.goleadores.values();
    }

    @Override
    public Set<Map.Entry<Integer, Integer>> entrySet() {
        return this.goleadores.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


