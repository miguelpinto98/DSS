package Data_Layer;

import Business_Layer.Calendario;
import Business_Layer.DadosEstatisticos;
import Business_Layer.Eliminatoria;
import Business_Layer.EstatisticaCompeticao;
import Business_Layer.Fase;
import Business_Layer.Grupo;
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
public class FaseDAO implements Map<Integer,Fase> {
    private int idTorneio;
    
    public FaseDAO(int id) {
        this.idTorneio = id;
    }
    
    @Override
    public int size() {
        int i=0;
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT IDFASE FROM Fase f");
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
            ResultSet rs = stm.executeQuery("SELECT IDFASE FROM Fase f");
            boolean res = !rs.next();
            ConexaoBD.fecharCursor(rs, stm);        
            return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }    }

    @Override
    public boolean containsKey(Object key) {
        try {
        Integer chave = (Integer) key;
        Statement stm = ConexaoBD.getConexao().createStatement();
        String sql = "SELECT NICKNAME FROM Fase f WHERE u.NICKNAME = '"+chave+"'";
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
    public Fase get(Object key) {
        try {
            Fase res = null;
            Integer chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM FASE j WHERE j.NFASE = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                EscalaoDAO es = new EscalaoDAO(id);
                int idCalendario = rs.getInt(4);             
                JornadaDAO jo = new JornadaDAO(idCalendario);
                Calendario calendario = new Calendario(idCalendario,jo);
                int tipo = rs.getInt(5);
                int nfase = rs.getInt(6);
                if(tipo == 0) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM GRUPO u where u.IDFASE = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    int idEstatistica = rs.getInt(2);
                    DadosEstatisticosDAO ds = new DadosEstatisticosDAO(idEstatistica);
                    EstatisticaCompeticao ec = new EstatisticaCompeticao(idEstatistica,ds);
                    res = new Grupo(id,nome,es,calendario,tipo,ec,nfase);
                    }
                }
                if(tipo == 1) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ELIMINATORIA u where u.IDFASE = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                        res = new Eliminatoria(id,nome,es,calendario,tipo,nfase);
                    }
                }
                
            }
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Fase put(Integer key, Fase value) {
        Fase res = null;
        try {
            boolean existe = this.containsKey(key);
            String sql;
            if (existe) {
                sql = "UPDATE Fase f SET f.idFase = ?, f.nome = ?, f.idTorneio = ?, f.idCalendario = ?, f.tipo = ?, f.nfase = ? WHERE f.nfase = '"+key+"'";
            }
            else {
                sql = "INSERT INTO Fase(idFase,idTorneio,idCalendario,tipo,nfase) VALUES (?, ?, ?, ?, ?, ?)";
            }
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(1, value.getID());
            stm.setString(2,value.getNome());
            stm.setInt(3, this.idTorneio);
            stm.setInt(4, value.getCalendario().getID());
            stm.setInt(5, value.getNFase());
            stm.executeQuery();
            stm.close();
             if (value.getTipo() == 0) {
                 Grupo g = (Grupo) value;
                 int i = g.getClassificacao().getID();
                  String sql2 = "INSERT INTO Grupo(idFase,EstatisticaCompeticaoid) VALUES ("+value.getID()+",'"+i+"')";
                  PreparedStatement stm2 = ConexaoBD.getConexao().prepareStatement(sql2);
                  stm2.execute();
                  stm2.close();
             }
             if(value.getTipo() == 1) {
                 String sql3 = "INSERT INTO Eliminatoria(idFase) VALUES ("+value.getID()+")";
                 PreparedStatement stm3 = ConexaoBD.getConexao().prepareStatement(sql3);
                 stm3.execute();
                 stm3.close();
             }
             
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Fase remove(Object key) {
        throw new NullPointerException("não está implementado!");
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Fase> m) {
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
            String sql = "SELECT IDFASE FROM FASE";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
           
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;    
    }

    @Override
    public Collection<Fase> values() {
        try {
            Collection<Fase> res = new ArrayList<Fase>();
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql  = "SELECT * FROM FASE f";
            ResultSet rsCiclo = stm.executeQuery(sql);
            while(rsCiclo.next()) {
                int id = rsCiclo.getInt(1);
                String nome = rsCiclo.getString(2);
                EscalaoDAO es = new EscalaoDAO(id);
                int idCalendario = rsCiclo.getInt(4);             
                JornadaDAO jo = new JornadaDAO(idCalendario);
                Calendario calendario = new Calendario(idCalendario,jo);
                int tipo = rsCiclo.getInt(5);
                int nfase = rsCiclo.getInt(6);
                if(tipo == 0) {
                    Grupo g = null;
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM GRUPO g where g.IDFASE = '"+id+"'";
                    ResultSet rs = stm.executeQuery(sql);
                    if(rs.next()) {
                        int idEstatistica = rs.getInt(2);
                        DadosEstatisticosDAO ds = new DadosEstatisticosDAO(idEstatistica);
                        EstatisticaCompeticao ec = new EstatisticaCompeticao(idEstatistica,ds);
                        g = new Grupo(id,nome,es,calendario,tipo,ec,nfase);
                        res.add(g); 
                    }
                }
                if(tipo == 1) {
                    Eliminatoria e = null;
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ELIMINATORIA e where e.IDFASE = '"+id+"'";
                    ResultSet rs = stm.executeQuery(sql);
                    if(rs.next()) {
                        e = new Eliminatoria(id,nome,es,calendario,tipo,nfase);
                        res.add(e);
                    }
                }
            }
            return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Set<Map.Entry<Integer, Fase>> entrySet() {
         throw new NullPointerException("não está implementado!");
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


