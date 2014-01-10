package Data_Layer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class PalmaresDAO implements Map<String,Integer> {    
    private int idEquipa;
    
    public PalmaresDAO(int id) {
        this.idEquipa = id;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM PALMARES p WHERE p.IDEQUIPA = "+this.idEquipa;
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res++;
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            String chave = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM PALMARES p WHERE p.IDEQUIPA = "+this.idEquipa+" and pp.NOMECOMPETICAO = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer get(Object key) {
        int res = -999;
        try {
            String chave = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT NRVEZES FROM PALMARES p WHERE p.IDEQUIPA = "+this.idEquipa+" and p.NOMECOMPETICAO = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next())
                res = rs.getInt(1);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Integer put(String key, Integer value) {
        int res = -999;
        try {
            boolean existe = this.containsKey(key);
            String sql = "";           
            if(existe) {                
                sql = "UPDATE Palmares SET nrVezes = "+value+", idEquipa = "+this.idEquipa+" WHERE nomeCompeticao = '"+key+"'";
                Statement st = ConexaoBD.getConexao().createStatement();
                ResultSet rse = st.executeQuery(sql);
            } else {
                sql = "INSERT INTO PALMARES(NOMECOMPETICAO, NRVEZES, IDEQUIPA) VALUES ('"+key+"', "+value+", "+this.idEquipa+")";
                Statement stm = ConexaoBD.getConexao().createStatement();
                ResultSet rs = stm.executeQuery(sql);
            }
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Integer remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Integer> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        Set<String> res = new HashSet<>();
        try {
            String sql = "SELECT NRVEZES FROM PALMARES p WHERE p.IDEQUIPA = "+this.idEquipa;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getString(1));
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Integer> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<String, Integer>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
