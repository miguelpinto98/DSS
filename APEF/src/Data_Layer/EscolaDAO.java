package Data_Layer;

import Business_Layer.Campo;
import Business_Layer.Escola;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public static final int NOME = 1;
    public static final int LOCAL = 2;
    public static final int IDCAMPO = 3;
    
    public static final int ID_CAMPO = 1;
    public static final int NOME_CAMPO = 2;

    public EscolaDAO() {
        this.escolas = new HashMap<>();
    }
    
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
        try {
            String c = (String) key;
            String chave = c.toUpperCase();
            
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT "+1+" FROM ESCOLA e WHERE e.NOME = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            boolean res = rs.next();
            
            rs.close();
            stm.close(); 
            return res; 
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean containsValue(Object value) {
        return this.escolas.containsValue(value);
    }

    @Override
    public Escola get(Object key) {
        Escola esc = null;
        
        try {
            String c = (String) key;
            String chave = c.toUpperCase();
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM ESCOLA e WHERE e.NOME = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String sNome = rs.getString(NOME);
                String sLocal = rs.getString(LOCAL);
                int nidCampo = rs.getInt(IDCAMPO);
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM CAMPO c where c.IDCAMPO = "+nidCampo;
                rs = stm.executeQuery(sql);

                if(rs.next()) {
                    String sCampo = rs.getString(NOME_CAMPO);
                    Campo campo = new Campo(nidCampo, sCampo);
  
                esc = new Escola(sNome,sLocal,campo);
                }
            }
                
        rs.close();
        stm.close();
        } catch (Exception e) {
        }        
        return esc;
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
    
    @Override
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
