package Data_Layer;

import Business_Layer.Agenda;
import Business_Layer.Jogo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class AgendaDAO implements Map<Integer,Jogo> {
    private HashMap<Integer,Jogo> jogos;
    
    public AgendaDAO() {
        this.jogos = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.jogos.size();
    }

    @Override
    public boolean isEmpty() {
        return this.jogos.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.jogos.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.jogos.containsValue(value);
    }

    @Override
    public Jogo get(Object key) {
        return this.jogos.get(key);
    }

    @Override
    public Jogo put(Integer key, Jogo value) {
        return this.jogos.put(key, value);
    }

    @Override
    public Jogo remove(Object key) {
        return this.jogos.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Jogo> m) {
        this.jogos.putAll(m);
    }

    @Override
    public void clear() {
        this.jogos.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.jogos.keySet();
    }

    @Override
    public Collection<Jogo> values() {
        return this.jogos.values();
    }

    @Override
    public Set<Map.Entry<Integer, Jogo>> entrySet() {
        return this.jogos.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
