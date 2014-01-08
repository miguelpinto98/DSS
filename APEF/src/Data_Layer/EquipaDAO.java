package Data_Layer;

import Business_Layer.Equipa;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class EquipaDAO implements Map<String,Equipa> {
    private HashMap<String,Equipa> equipas;

    @Override
    public int size() {
        return this.equipas.size();
    }

    @Override
    public boolean isEmpty() {
        return this.equipas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.equipas.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.equipas.containsValue(value);
    }

    @Override
    public Equipa get(Object key) {
        return this.equipas.get(key);
    }

    @Override
    public Equipa put(String key, Equipa value) {
        return this.equipas.put(key, value);
    }

    @Override
    public Equipa remove(Object key) {
        return this.equipas.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Equipa> m) {
        this.equipas.putAll(m);
    }

    @Override
    public void clear() {
        this.equipas.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.equipas.keySet();
    }

    @Override
    public Collection<Equipa> values() {
        return this.equipas.values();
    }

    @Override
    public Set<Map.Entry<String, Equipa>> entrySet() {
        return this.equipas.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
