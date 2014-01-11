package Data_Layer;

import Business_Layer.DadosEstatisticos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author serafim
 */
public class DadosEstatisticosDAO implements Map<Integer,DadosEstatisticos> {
    private int idEstatisticaCompeticao;

    public DadosEstatisticosDAO(int idDadosEst) {
        this.idEstatisticaCompeticao = idDadosEst;
    }

    public DadosEstatisticosDAO(int id, String nomeEquipa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int size() {
        int i=0;
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT idDadosEstatisticos FROM DadosEstatisticos d ");
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
        ResultSet rs = stm.executeQuery("SELECT idDadosEstatisticos FROM DadosEstatisticos d");
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
            String sql = "SELECT idDadosEstatisticos FROM DadosEstatisticos d WHERE d.idDadosEstatisticos = " +chave+"";
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
        throw new NullPointerException("não está implementado!");

    }

    @Override
    public DadosEstatisticos get(Object key) {
        try {
            DadosEstatisticos res = null;
            Integer chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM DADOSESTATISTICOS d WHERE d.IDDADOSESTATISTICOS = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                int idDados = rs.getInt(1);
                int v = rs.getInt(2);
                int d = rs.getInt(3);
                int e = rs.getInt(4);
                int gm = rs.getInt(5);
                int gs = rs.getInt(6);
                int idEscalao = rs.getInt(8);
                res = new DadosEstatisticos(idDados,v,d,e,gm,gs,idEscalao);
            }
            ConexaoBD.fecharCursor(rs, stm);
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public DadosEstatisticos put(Integer key, DadosEstatisticos value) {
        DadosEstatisticos res = null;
        try {
            boolean existe = this.containsKey(key);
            String sql;
            if (existe) {
                sql = "UPDATE DadosEstatisticos SET idDadosEstatisticos = ?, vitorias = ?, derrotas = ?, empates = ?, gmarcados = ?, gsofridos = ?, EstatisticaCompeticaoid = ?, idEscalao = ? WHERE idDadosEstatisticos = '"+key+"'";
            }
            else {
                sql = "INSERT INTO DadosEstatisticos(idDadosEstatisticos,vitorias,derrotas,empates,gmarcados,gsofridos,EstatisticaCompeticaoid,idEscalao) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            }
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(1, value.getID());
            stm.setInt(2,value.getVitorias());
            stm.setInt(3,value.getDerrotas());
            stm.setInt(4,value.getEmpates());
            stm.setInt(5,value.getGmarcados());
            stm.setInt(6,value.getGsofridos());
            stm.setInt(7,this.idEstatisticaCompeticao);
            stm.setInt(8,value.getIdEscalao());
            stm.executeQuery();
            stm.close();        
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public DadosEstatisticos remove(Object key) {
        try {
            Integer chave = (Integer) key;
            DadosEstatisticos res = null;
            String sql = "DELETE FROM DadosEstatisticos d WHERE d.idDadosEstatisticos = '"+chave+"'";
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.execute();
            stm.close();
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends DadosEstatisticos> m) {
        throw new NullPointerException("não está implementado!");
    }

    @Override
    public void clear() {
        throw new NullPointerException("não está implementado!");
    }

    @Override
    public Set<Integer> keySet() {
    Set<Integer> res = new TreeSet<>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT IDDADOSESTATISTICOS FROM DADOSESTATISTICOS";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
           
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;    }

    @Override
    public Collection<DadosEstatisticos> values() {
        try {
            Collection<DadosEstatisticos> res = new TreeSet<DadosEstatisticos>();;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM DADOSESTATISTICOS d";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                DadosEstatisticos d = null;
                int idDados = rs.getInt(1);
                int v = rs.getInt(2);
                int dS = rs.getInt(3);
                int e = rs.getInt(4);
                int gm = rs.getInt(5);
                int gs = rs.getInt(6);
                int idEscalao = rs.getInt(8);
                d = new DadosEstatisticos(idDados,v,dS,e,gm,gs,idEscalao);
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
    public Set<Map.Entry<Integer, DadosEstatisticos>> entrySet() {
        throw new NullPointerException("não está implementado!");
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


