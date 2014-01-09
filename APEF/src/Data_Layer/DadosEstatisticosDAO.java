package Data_Layer;

import Business_Layer.DadosEstatisticos;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class DadosEstatisticosDAO implements Map<Integer,DadosEstatisticos> {
    private HashMap<Integer,DadosEstatisticos> dadosestatisticos;
    
    public DadosEstatisticosDAO() {
    }
    
    @Override
    public int size() {
        return this.dadosestatisticos.size();
    }

    @Override
    public boolean isEmpty() {
        return this.dadosestatisticos.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.dadosestatisticos.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.dadosestatisticos.containsValue(value);
    }

    @Override
    public DadosEstatisticos get(Object key) {
        return this.dadosestatisticos.get(key);
    }

    @Override
    public DadosEstatisticos put(Integer key, DadosEstatisticos value) {
        return this.dadosestatisticos.put(key, value);
    }

    @Override
    public DadosEstatisticos remove(Object key) {
        return this.dadosestatisticos.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends DadosEstatisticos> m) {
        this.dadosestatisticos.putAll(m);
    }

    @Override
    public void clear() {
        this.dadosestatisticos.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.dadosestatisticos.keySet();
    }

    @Override
    public Collection<DadosEstatisticos> values() {
        return this.dadosestatisticos.values();
    }

    @Override
    public Set<Map.Entry<Integer, DadosEstatisticos>> entrySet() {
        return this.dadosestatisticos.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


