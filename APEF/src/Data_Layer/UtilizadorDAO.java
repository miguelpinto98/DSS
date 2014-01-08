package Data_Layer;

import Business_Layer.Utilizador;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
        
public class UtilizadorDAO implements Map<String,Utilizador>{
    private HashMap<String,Utilizador> users;

    public UtilizadorDAO() {
        this.users = new HashMap<>();
    }
    
    @Override
    public int size() {
        return this.users.size();
    }

    @Override
    public boolean isEmpty() {
        return this.users.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.users.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.users.containsValue(value);
    }

    @Override
    public Utilizador get(Object key) {
        return this.users.get(key);
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        return this.users.put(key, value);
    }

    @Override
    public Utilizador remove(Object key) {
        return this.users.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
        this.users.putAll(m);
    }

    @Override
    public void clear() {
        this.users.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.users.keySet();
    }

    @Override
    public Collection<Utilizador> values() {
        return this.users.values();
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        return this.users.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
