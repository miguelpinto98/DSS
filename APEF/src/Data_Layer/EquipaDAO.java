package Data_Layer;

import Business_Layer.Equipa;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import oracle.sql.BLOB;

/**
 *
 * @author serafim
 */


public class EquipaDAO implements Map<String,Equipa> {
    
    public static final String EQUIPA_E = "Equipa e";
    public static final int IDEQUIPA = 1;
    public static final int NOME = 2;
    public static final int EMBLEMA = 3;
    public static final int NOME_ESCOLA = 4;
    public static final int REMOVIDO = 5;

    private final String nomeEscola;

    public EquipaDAO(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    @Override
    public int size() {
        int i=0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery("SELECT NOME FROM ESCOLA");
            
            while(rs.next())
                i++;
            ConexaoBD.fecharCursor(rs, stm);            
            return i;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean isEmpty() {
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public boolean containsKey(Object key) {
        try {
            String chave = (String) key;
            //String chave = c.toUpperCase();
            
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT NOME FROM EQUIPA e WHERE e.NOME = '"+chave+"'";
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
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public Equipa get(Object key) {
        Equipa eq = null;
        
        try {
            String chave = (String) key;
            //String chave = c.toUpperCase();
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM "+EQUIPA_E+" WHERE e.NOME = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int id = rs.getInt(IDEQUIPA);
                String nome = rs.getString(NOME);
                Blob emblema = rs.getBlob(EMBLEMA);
                String nEsc = rs.getString(NOME_ESCOLA);
                int rem = rs.getInt(REMOVIDO);
                
                System.out.println("ASDHJASDHAHJSFGHJASFGHJHGJ");
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
        Equipa res = null;
        try {
            String sql = "INSERT INTO Equipa(idEquipa, nome, emblema, nomeEscola, removido) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            
            File f = new File(value.getEmblema().getPath());
            
            stm.setInt(IDEQUIPA, value.getID());
            stm.setString(NOME, value.getNome());
            stm.setString(EMBLEMA, null);
            stm.setString(NOME_ESCOLA, this.nomeEscola);
            stm.setInt(REMOVIDO, 0);
            stm.execute();
            
            /**if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                stm.setBlob(EMBLEMA, fis);
                stm.setString(NOMEIMAGEM, value.getEmblema().getNome());
            } else {
                stm.setBlob(EMBLEMA, (Blob) null);
                stm.setString(NOME_IMAGEM, "");
            }*/
            ConexaoBD.fecharCursor(null, stm);
            res = value;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }
    
    @Override
    public Equipa remove(Object key) {
        try {
			Equipa res = null;
			String chave = (String) key;
			String sql = "DELETE FROM " + EQUIPA_E
					+ " WHERE e.nome = '"+chave+"'";
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
    public void putAll(Map<? extends String, ? extends Equipa> m){
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public void clear() {
        throw new NullPointerException("não está implementado!");
        }

    @Override
    public Set<String> keySet() {
        Set<String> res = new HashSet<>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT NOME FROM EQUIPA e WHERE e.NOMEESCOLA ='"+this.nomeEscola+"'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next())
                res.add(rs.getString(1));
          
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Collection<Equipa> values() {
        throw new NullPointerException("não está implementado!");
        }


    @Override
    public Set<Map.Entry<String, Equipa>> entrySet() {
        throw new NullPointerException("não está implementado!");
        }

    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
