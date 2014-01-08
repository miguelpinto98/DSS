package Data_Layer;

import Business_Layer.Calendario;
import Business_Layer.Jornada;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class CalendarioDAO implements Map<Integer,Jornada> {
    private HashMap<Integer,Jornada> jornadas;
    
    @Override
    public int size() {
        return this.jornadas.size();
    }

    @Override
    public boolean isEmpty() {
        return this.jornadas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.jornadas.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.jornadas.containsValue(value);
    }

    @Override
    public Jornada get(Object key) {
        return this.jornadas.get(key);
    }

    @Override
    public Jornada put(Integer key, Jornada value) {
        return this.jornadas.put(key, value);
    }

    @Override
    public Jornada remove(Object key) {
        return this.jornadas.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Jornada> m) {
        this.jornadas.putAll(m);
    }

    @Override
    public void clear() {
        this.jornadas.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.jornadas.keySet();
    }

    @Override
    public Collection<Jornada> values() {
        return this.jornadas.values();
    }

    @Override
    public Set<Map.Entry<Integer, Jornada>> entrySet() {
        return this.jornadas.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
