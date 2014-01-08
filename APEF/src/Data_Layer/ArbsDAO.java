package Data_Layer;

import Business_Layer.Utilizador;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class ArbsDAO implements Map<Integer,Utilizador> {
    private HashMap<Integer,Utilizador> arbs;
    
    public ArbsDAO() {
        this.arbs = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.arbs.size();
    }

    @Override
    public boolean isEmpty() {
        return this.arbs.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.arbs.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.arbs.containsValue(value);
    }

    @Override
    public Utilizador get(Object key) {
        return this.arbs.get(key);
    }

    @Override
    public Utilizador put(Integer key, Utilizador value) {
        return this.arbs.put(key, value);
    }

    @Override
    public Utilizador remove(Object key) {
        return this.arbs.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Utilizador> m) {
        this.arbs.putAll(m);
    }

    @Override
    public void clear() {
        this.arbs.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.arbs.keySet();
    }

    @Override
    public Collection<Utilizador> values() {
        return this.arbs.values();
    }

    @Override
    public Set<Map.Entry<Integer, Utilizador>> entrySet() {
        return this.arbs.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}



