package Data_Layer;

import Business_Layer.Epoca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class EpocaDAO implements Map<Integer,Epoca> {
    private HashMap<Integer,Epoca> epocas;
    public static final Integer ANO = 1;
    
    public EpocaDAO() {
        this.epocas = new HashMap<>();
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public int size() {
         try {
            int i = 0;
             try (Statement stm = ConexaoBD.getConexao().createStatement(); ResultSet rs = stm.executeQuery("SELECT ano FROM " + ANO)) {
                 for (; rs.next(); i++)
                     ;
             }
            return i;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.epocas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            Integer chave = (Integer) key;
            boolean res;
            try (Statement stm = ConexaoBD.getConexao().createStatement()) {
                String sql = "SELECT ano FROM " + ANO + " WHERE 1.ano = "
                        + chave;
                try (ResultSet rs = stm.executeQuery(sql)) {
                    res = rs.next();
                }
            }
            return res ;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean containsValue(Object value) {
        return this.epocas.containsValue(value);
    }


    @Override
    public void putAll(Map<? extends Integer, ? extends Epoca> m) {
        this.epocas.putAll(m);
    }


    @Override
    public Epoca get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); }
    

    @Override
    public Epoca put(Integer key, Epoca value){        
        Epoca res = null;
        try {
            String sql = "INSERT INTO " + ANO + " VALUES (?)";            
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(ANO, key);
            stm.execute();
            ConexaoBD.fecharCursor(null, stm);
            }
        catch (Exception e){throw new NullPointerException(e.getMessage());}
        return res;}
    
  
    
    @Override
    public Epoca remove(Object key) {
        return this.epocas.remove(key);
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
