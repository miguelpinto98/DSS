package Data_Layer;

import Business_Layer.Escalao;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class EscalaoDAO implements Map<Integer,Escalao> {
    private HashMap<Integer,Escalao> escaloes;
    
    public EscalaoDAO() {
        this.escaloes = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.escaloes.size();
    }

    @Override
    public boolean isEmpty() {
        return this.escaloes.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.escaloes.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.escaloes.containsValue(value);
    }

    @Override
    public Escalao get(Object key) {
        return this.escaloes.get(key);
    }

    @Override
    public Escalao put(Integer key, Escalao value) {
        return this.escaloes.put(key, value);
    }

    @Override
    public Escalao remove(Object key) {
        return this.escaloes.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Escalao> m) {
        this.escaloes.putAll(m);
    }

    @Override
    public void clear() {
        this.escaloes.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.escaloes.keySet();
    }

    @Override
    public Collection<Escalao> values() {
        return this.escaloes.values();
    }

    @Override
    public Set<Map.Entry<Integer, Escalao>> entrySet() {
        return this.escaloes.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}

