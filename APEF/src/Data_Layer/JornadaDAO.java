package Data_Layer;

import Business_Layer.Calendario;
import Business_Layer.Jornada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author serafim
 */
public class JornadaDAO implements Map<Integer,Jornada> {
    private int idCalendario;
    
    public JornadaDAO() {
        
    }
    
    public JornadaDAO(int id) {
        this.idCalendario = id;
    } 
    @Override
    public int size() {
        int i=0;
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT IDJORNADA FROM Jornada j");
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
        ResultSet rs = stm.executeQuery("SELECT IDJORNADA FROM Jornada j");
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
            String sql = "SELECT IDJORNADA FROM Jornada j WHERE j.IDJORNADA = '"+chave+"'";
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
    public Jornada get(Object key) {
        try {
            Jornada res = null;
            Integer chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM JORNADA j WHERE j.IDJORNADA = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                int idJornada = rs.getInt(1);
                int nrJornada = rs.getInt(2);
                int nrJogosRealizados = rs.getInt(3);
                JogoDAO ag = new JogoDAO(idJornada);
                res = new Jornada(idJornada,nrJornada,nrJogosRealizados,ag);
            }
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }
    
    @Override
    public Jornada put(Integer key, Jornada value) {
        Jornada res = null;
        try {
            boolean existe = this.containsKey(key);
            String sql;
            if (existe) {
                sql = "UPDATE Jornada SET nrJornada = ?, jogosRealizados = ?, idCalendario = ? WHERE idJornada = '"+key+"'";
            }
            else {
                sql = "INSERT INTO Jornada(idJornada,nrJornada,jogosRealizados,idCalendario) VALUES(?, ?, ?, ?)";
            }
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(1, value.getID());
            stm.setInt(2,value.getNrJornada());
            stm.setInt(3,value.getJogosRealizados());
            stm.setInt(4,this.idCalendario);
            stm.executeQuery();
            stm.close();        
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Jornada remove(Object key) {
        throw new NullPointerException("não está implementado!");    
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Jornada> m) {
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
            String sql = "SELECT IDJORNADA FROM JORNADA";
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
    public Collection<Jornada> values() {
        try {
            Collection<Jornada> res = new TreeSet<Jornada>();;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM JORNADA j";
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                Jornada j = null;
                int idJornada = rs.getInt(1);
                int nrJornada = rs.getInt(2);
                int nrJogosRealizados = rs.getInt(3);
                JogoDAO ag = new JogoDAO(idJornada);
                j = new Jornada(idJornada,nrJornada,nrJogosRealizados,ag);
                res.add(j);     
            }
            ConexaoBD.fecharCursor(rs, stm);
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Set<Map.Entry<Integer, Jornada>> entrySet() {
        throw new NullPointerException("não está implementado!");    

    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
