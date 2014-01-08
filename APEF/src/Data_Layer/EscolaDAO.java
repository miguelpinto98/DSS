package Data_Layer;

import Business_Layer.Escola;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class EscolaDAO implements Map<String,Escola> {
    private HashMap<String,Escola> escolas;

    @Override
    public int size() {
        return this.escolas.size();
    }

    @Override
    public boolean isEmpty() {
        return this.escolas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.escolas.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.escolas.containsValue(value);
    }

    @Override
    public Escola get(Object key) {
        return this.escolas.get(key);
    }

    @Override
    public Escola put(String key, Escola value) {
        return this.escolas.put(key, value);
    }

    @Override
    public Escola remove(Object key) {
        return this.escolas.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Escola> m) {
        this.escolas.putAll(m);
    }

    @Override
    public void clear() {
        this.escolas.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.escolas.keySet();
    }

    @Override
    public Collection<Escola> values() {
        return this.escolas.values();
    }

    @Override
    public Set<Map.Entry<String, Escola>> entrySet() {
        return this.escolas.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
