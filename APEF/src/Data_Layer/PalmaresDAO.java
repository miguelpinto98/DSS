package Data_Layer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class PalmaresDAO implements Map<String,Integer> {
    private HashMap<String,Integer> palmares;

    @Override
    public int size() {
        return this.palmares.size();
    }

    @Override
    public boolean isEmpty() {
        return this.palmares.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.palmares.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.palmares.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return this.palmares.get(key);
    }

    @Override
    public Integer put(String key, Integer value) {
        return this.palmares.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return this.palmares.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Integer> m) {
        this.palmares.putAll(m);
    }

    @Override
    public void clear() {
        this.palmares.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.palmares.keySet();
    }

    @Override
    public Collection<Integer> values() {
        return this.palmares.values();
    }

    @Override
    public Set<Map.Entry<String, Integer>> entrySet() {
        return this.palmares.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
