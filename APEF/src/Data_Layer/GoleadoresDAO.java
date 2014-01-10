package Data_Layer;

import Business_Layer.Campeonato;
import java.sql.PreparedStatement;
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
public class GoleadoresDAO implements Map<Integer,Integer> {
    
    public static final int IDPESSOA = 1;
    public static final int IDJOGO = 2;
    public static final int NGOLOS = 3;

    private static int idJogo;
    
    public GoleadoresDAO() {
    }
    
    public GoleadoresDAO(int idJogo){
        this.idJogo = idJogo;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM GOLEADORES";
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
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            int chave = (Integer) key;
            //String chave = c.toUpperCase();
            
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM GOLEADORES e WHERE e.IDPESSOA = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);   
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("não está implementado!");
        }

    @Override
    public Integer get(Object key) {
        Integer res = null;
        
        try {
            int chave = (Integer) key;
            //String chave = c.toUpperCase();
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM GOLEADORES e WHERE e.IDPESSOA = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int idPessoa = rs.getInt(IDPESSOA);
                int idJ = rs.getInt(IDJOGO);
                int nGolos = rs.getInt(NGOLOS);
                res = nGolos;
            }
                
        ConexaoBD.fecharCursor(rs, stm);
        } catch (Exception e) {
        }        
        return res;
    }

    @Override
    public Integer put(Integer key, Integer value) {
        Integer res = null;
        try {
            int c = (Integer) key;
            boolean existe = this.containsKey(key);
            
            if(!existe) {
                //String chave = c.toUpperCase();
                    String sql = "";
                    sql = "INSERT INTO GOLEADORES (idPessoa, idCompeticao, nGolos) VALUES (?, ?, ?)";
                    PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
                    stm.setInt(IDPESSOA, key);
                    stm.setInt(IDJOGO, this.idJogo);
                    stm.setInt(NGOLOS, value);
                    stm.execute();
                    stm.close();
                    res = value;
            }
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Integer remove(Object key) {
        try {
			Integer res = null;
			int chave = (Integer) key;
			String sql = "DELETE FROM GOLEADORES j WHERE j.IDPESSOA = "+chave;
			PreparedStatement stm = ConexaoBD.getConexao()
					.prepareStatement(sql);
			stm.execute();
                        ConexaoBD.fecharCursor(null, stm);
			return res;
		} catch (Exception e) {
			throw new NullPointerException(e.getMessage());
		}
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Integer> m) {
        throw new NullPointerException("não está implementado!");
        }

    @Override
    public void clear() {
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public Set<Integer> keySet() {
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public Collection<Integer> values() {
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public Set<Map.Entry<Integer, Integer>> entrySet() {
        throw new NullPointerException("não está implementado!");
        }

    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


