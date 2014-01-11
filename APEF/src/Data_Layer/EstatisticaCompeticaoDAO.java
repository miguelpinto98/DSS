/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data_Layer;

import Business_Layer.EstatisticaCompeticao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author miguelpinto
 */
public class EstatisticaCompeticaoDAO implements Map<Integer,EstatisticaCompeticao> {
    private int idCamp;
    
    public EstatisticaCompeticaoDAO(int id) {
        this.idCamp = id;
    }

    @Override
    public int size() {
        int i=0;
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT id FROM ESTATISTICACOMPETICAO d ");
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
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT id FROM ESTATISTICACOMPETICAO d");
        boolean res = !rs.next();
        ConexaoBD.fecharCursor(rs, stm);        
        return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            Integer chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT id FROM ESTATISTICACOMPETICAO d WHERE d.id = " +chave+"";
            ResultSet rs = stm.executeQuery(sql);
            boolean res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);
            return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }    
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EstatisticaCompeticao get(Object key) {
        try {
            EstatisticaCompeticao res = null;
            Integer chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM ESTATISTICACOMPETICAO d WHERE d.ID = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                int id = rs.getInt(1);
                res = new EstatisticaCompeticao(id);
            }
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public EstatisticaCompeticao put(Integer key, EstatisticaCompeticao value) {
        EstatisticaCompeticao res = null;
        try {
            boolean existe = this.containsKey(key);
            String sql;
            if (existe) {
                sql = "UPDATE ESTATISTICACAOMPETICAO SET id = ? WHERE id = "+key;
            }
            else {
                sql = "INSERT INTO ESTATISTICACOMPETICAO(id) VALUES(?)";
            }
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(1, value.getID());
            stm.executeQuery();
            stm.close();
            res = value;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public EstatisticaCompeticao remove(Object key) {
        try {
            Integer chave = (Integer) key;
            EstatisticaCompeticao res = null;
            String sql = "DELETE FROM ESTATISTICACOMPETICAO d WHERE d.id = "+chave;
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.execute();
            stm.close();
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends EstatisticaCompeticao> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT ID FROM ESTATISTICACOMPETICAO";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
           
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Collection<EstatisticaCompeticao> values() {
        try {
            Collection<EstatisticaCompeticao> res = new TreeSet<EstatisticaCompeticao>();;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM ESTATISTICACOMPETICAO d";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                EstatisticaCompeticao d = null;
                int id = rs.getInt(1);
                d = new EstatisticaCompeticao(id);
                res.add(d);     
            }
            ConexaoBD.fecharCursor(rs, stm);
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Set<Entry<Integer, EstatisticaCompeticao>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
