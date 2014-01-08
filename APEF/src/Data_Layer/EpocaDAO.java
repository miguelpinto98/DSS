package Data_Layer;

import Business_Layer.Epoca;
import Business_Layer.Epoca;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class EpocaDAO implements Map<Integer,Epoca> {
    private HashMap<Integer,Epoca> epocas;
    
    public EpocaDAO() {
        this.epocas = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.epocas.size();
    }

    @Override
    public boolean isEmpty() {
        return this.epocas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.epocas.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.epocas.containsValue(value);
    }

    @Override
    public Epoca get(Object key) {
        return this.epocas.get(key);
    }

    @Override
    public Epoca put(Integer key, Epoca value) {
        return this.epocas.put(key, value);
    }

    @Override
    public Epoca remove(Object key) {
        return this.epocas.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Epoca> m) {
        this.epocas.putAll(m);
    }

    @Override
    public void clear() {
        this.epocas.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.epocas.keySet();
    }

    @Override
    public Collection<Epoca> values() {
        return this.epocas.values();
    }

    @Override
    public Set<Map.Entry<Integer, Epoca>> entrySet() {
        return this.epocas.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
