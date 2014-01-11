package Data_Layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class IDENTIFICADORDAO implements Map<Integer, Integer>{

    private int id;
    
    public IDENTIFICADORDAO(int i) {
        this.id = i;
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer get(Object key) {
        int res = 0;
        try {
            Integer chave = (Integer) key;
            String sql = "SELECT COUNT FROM IDENTIFICADOR i WHERE i.ID = "+chave;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next())
                res = rs.getInt(1);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }   
        return res;
    }

    @Override
    public Integer put(Integer key, Integer value) {
        int res = 0;
        try {
            String sql = "UPDATE IDENTIFICADOR SET COUNT = "+value;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = value;
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Integer remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Integer> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Integer> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Integer>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
