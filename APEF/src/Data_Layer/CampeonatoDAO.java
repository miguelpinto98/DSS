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
public class CampeonatoDAO implements Map<Integer,Campeonato> {
    private HashMap<Integer,Campeonato> campeonatos;
    
    public CampeonatoDAO() {
        this.campeonatos = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.campeonatos.size();
    }

    @Override
    public boolean isEmpty() {
        return this.campeonatos.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.campeonatos.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.campeonatos.containsValue(value);
    }

    @Override
    public Campeonato get(Object key) {
        return this.campeonatos.get(key);
    }

    @Override
    public Campeonato put(Integer key, Campeonato value) {
        return this.campeonatos.put(key, value);
    }

    @Override
    public Campeonato remove(Object key) {
        return this.campeonatos.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Campeonato> m) {
        this.campeonatos.putAll(m);
    }

    @Override
    public void clear() {
        this.campeonatos.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.campeonatos.keySet();
    }

    @Override
    public Collection<Campeonato> values() {
        return this.campeonatos.values();
    }

    @Override
    public Set<Map.Entry<Integer, Campeonato>> entrySet() {
        return this.campeonatos.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


