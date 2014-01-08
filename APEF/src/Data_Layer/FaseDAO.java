package Data_Layer;

import Business_Layer.Fase;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class FaseDAO implements Map<Integer,Fase> {
    private HashMap<Integer,Fase> fases;
    
    public FaseDAO() {
        this.fases = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.fases.size();
    }

    @Override
    public boolean isEmpty() {
        return this.fases.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.fases.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.fases.containsValue(value);
    }

    @Override
    public Fase get(Object key) {
        return this.fases.get(key);
    }

    @Override
    public Fase put(Integer key, Fase value) {
        return this.fases.put(key, value);
    }

    @Override
    public Fase remove(Object key) {
        return this.fases.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Fase> m) {
        this.fases.putAll(m);
    }

    @Override
    public void clear() {
        this.fases.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.fases.keySet();
    }

    @Override
    public Collection<Fase> values() {
        return this.fases.values();
    }

    @Override
    public Set<Map.Entry<Integer, Fase>> entrySet() {
        return this.fases.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


