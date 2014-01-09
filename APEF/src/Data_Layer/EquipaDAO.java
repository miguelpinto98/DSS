package Data_Layer;

import Business_Layer.Equipa;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
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


public class EquipaDAO implements Map<String,Equipa> {
    private HashMap<String,Equipa> equipas;
    
    public static final String EQUIPA_E = "Equipa e";
    public static final int IDEQUIPA = 1;
    public static final int NOME = 2;
    public static final int EMBLEMA = 3;

    private String nomeEscola;

    
    public EquipaDAO(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    @Override
    public int size() {
        int i=0;
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT NOME FROM " + EQUIPA_E);
            for (; rs.next(); i++)
                              ;
            ConexaoBD.fecharCursor(rs, stm);            
             return i;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.equipas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            String c = (String) key;
            String chave = c.toUpperCase();
            
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT "+2+" FROM "+EQUIPA_E+" WHERE e.NOME = '"+chave+"'";
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
        return this.equipas.containsValue(value);
    }

    @Override
    public Equipa get(Object key) {
        Equipa eq = null;
        
        try {
            String c = (String) key;
            String chave = c.toUpperCase();
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM"+EQUIPA_E+"WHERE e.NOME = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int id = rs.getInt(IDEQUIPA);
                String nome = rs.getString(NOME);
  
                eq = new Equipa(id,nome);
                }
            
        rs.close();
        stm.close();
        } catch (Exception e) {
        }        
        return eq;
    }

    @Override
    public Equipa put(String key, Equipa value) {

        try {
            Equipa res = null;
            String sql = "INSERT INTO " + EQUIPA_E + " VALUES (?, ?, null, ?)";
            PreparedStatement stm = ConexaoBD.getConexao()
                    .prepareStatement(sql);
            File f = new File(value.getEmblema().getPath());
            stm.setInt(IDEQUIPA, value.getID());
            stm.setString(NOME, key);
            /**if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                stm.setBlob(EMBLEMA, fis);
                stm.setString(NOMEIMAGEM, value.getEmblema().getNome());
            } else {
                stm.setBlob(EMBLEMA, (Blob) null);
                stm.setString(NOME_IMAGEM, "");
            }*/
            stm.execute();
                        ConexaoBD.fecharCursor(null, stm);
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }
    
    @Override
    public Equipa remove(Object key) {
        try {
			Equipa res = null;
			String chave = (String) key;
			String sql = "DELETE FROM " + EQUIPA_E
					+ " WHERE e.nome = ?";
			PreparedStatement stm = ConexaoBD.getConexao()
					.prepareStatement(sql);
			stm.setInt(1, IDEQUIPA);
			stm.setString(2, chave);
			stm.execute();
                        ConexaoBD.fecharCursor(null, stm);
			return res;
		} catch (Exception e) {
			throw new NullPointerException(e.getMessage());
		}
    }

    @Override
    public void putAll(Map<? extends String, ? extends Equipa> m) {
        this.equipas.putAll(m);
    }

    @Override
    public void clear() {
        this.equipas.clear();
    }

    @Override
    public Set<String> keySet() {
        Set<String> res = new HashSet<String>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT NOME FROM EQUIPA";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                res.add(rs.getString(NOME));
            }
            rs.close() ;
            stm.close() ;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Collection<Equipa> values() {
        return this.equipas.values();
    }

    @Override
    public Set<Map.Entry<String, Equipa>> entrySet() {
        return this.equipas.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
