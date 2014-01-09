package Data_Layer;

import Business_Layer.Calendario;
import Business_Layer.Jornada;
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
public class JornadaDAO implements Map<Integer,Jornada> {
    private int idCalendario;
    private HashMap<Integer,Jornada> jornadas;
    
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
            String sql = "SELECT IDJORNADA FROM Jornada j WHERE j.IDJORNADA = " +chave+"";
            ResultSet rs = stm.executeQuery(sql);
            boolean res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);
            return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }    }

    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("não está implementado!");
    }

    @Override
    public Jornada get(Object key) {
        try {
            Jornada res = null;
            String chave = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM JORNADA j WHERE j.IDJORNADA = "+chave+"";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                int idJornada = rs.getInt(1);
                int nrJornada = rs.getInt(2);
                int nrJogosRealizados = rs.getInt(3);
                AgendaDAO ag = new AgendaDAO(idJornada);
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
        return this.jornadas.put(key, value);
        
    }

    @Override
    public Jornada remove(Object key) {
        return this.jornadas.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Jornada> m) {
        this.jornadas.putAll(m);
    }

    @Override
    public void clear() {
        this.jornadas.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.jornadas.keySet();
    }

    @Override
    public Collection<Jornada> values() {
        return this.jornadas.values();
    }

    @Override
    public Set<Map.Entry<Integer, Jornada>> entrySet() {
        return this.jornadas.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
