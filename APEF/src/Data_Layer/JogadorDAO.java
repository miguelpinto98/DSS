package Data_Layer;

import Business_Layer.Jogador;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class JogadorDAO implements Map<Integer,Jogador> {
    private HashMap<Integer,Jogador> jogadores;

    public JogadorDAO() {
        this.jogadores = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.jogadores.size();
    }

    @Override
    public boolean isEmpty() {
        return this.jogadores.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.jogadores.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.jogadores.containsValue(value);
    }

    @Override
    public Jogador get(Object key) {
        return this.jogadores.get(key);
    }

    @Override
    public Jogador put(Integer key, Jogador value) {
        return this.jogadores.put(key, value);
    }

    @Override
    public Jogador remove(Object key) {
        return this.jogadores.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Jogador> m) {
        this.jogadores.putAll(m);
    }

    @Override
    public void clear() {
        this.jogadores.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.jogadores.keySet();
    }

    @Override
    public Collection<Jogador> values() {
        return this.jogadores.values();
    }

    @Override
    public Set<Map.Entry<Integer, Jogador>> entrySet() {
        return this.jogadores.entrySet();
    }
    
     public int hashCode() {     
        final int prime = 7;
        int result = 1;
        result = prime * result + ((this.jogadores == null) ? 0 : this.jogadores.hashCode());
        return result;
    }
}

