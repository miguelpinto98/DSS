package Data_Layer;

import Business_Layer.Admin;
import Business_Layer.Agenda;
import Business_Layer.Arbitro;
import Business_Layer.Escola;
import Business_Layer.Utilizador;
import Business_Layer.Imagem;
import Business_Layer.Jogo;
import Business_Layer.ResponsavelEscola;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class UtilizadorDAO implements Map<String,Utilizador>{
    private HashMap<String,Utilizador> users;

    public static final String USER = "Utilizador u";
    public static final int ID = 1;
    public static final int AVATAR = 2;
    public static final int NICKNAME = 3;
    public static final int EMAIL = 4;
    public static final int PASSWORD = 5;
    public static final int MORADA = 6;
    public static final int TELEMOVEL = 7;
    public static final int CODPOSTAL = 8;
    public static final int DATANASC = 9;
    public static final int ATIVO = 10;
    public static final int CAMPOSPREENCHIDOS = 11;
    public static final int TIPO = 12;
    public static final int REMOVIDO = 13;
    public static final int NOME = 14;
    //arbitro
    public static int IDAGENDA = 3;
    //r.escola
    public static int NOMESCOLA = 2;    
            public UtilizadorDAO() {
        this.users = new HashMap<>();
    }
    
    @Override
    public int size() {
        int i=0;
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT NICKNAME FROM " + USER);
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
        ResultSet rs = stm.executeQuery("SELECT NICKNAME FROM " +USER);
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
        String chave = (String) key;
        Statement stm = ConexaoBD.getConexao().createStatement();
        String sql = "SELECT NICKNAME FROM "+USER+" WHERE u.NICKNAME = '" + chave+"'";
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
        return this.users.containsValue(value);
    }
    
    public boolean converte(int a) {
        if(a==0)
            return false;
        else return true;
    }

    @Override
    public Utilizador get(Object key) {
        try {
            Utilizador res = null;
            String chave = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM UTILIZADOR u WHERE u.NICKNAME = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                int id = rs.getInt(ID);
                Imagem avatar = null;
                if(rs.getBlob(AVATAR) == null)
                    avatar = new Imagem();
                int tipo = rs.getInt(TIPO);
                String nick = rs.getString(NICKNAME);
                String nome = rs.getString(NOME);
                String email = rs.getString(EMAIL);
                String pw = rs.getString(PASSWORD);
                String morada = rs.getString(MORADA);
                String tlmvl = rs.getString(TELEMOVEL);
                String codPostal = rs.getString(CODPOSTAL);
                GregorianCalendar dataNasc = new GregorianCalendar();
                rs.getTimestamp(DATANASC, dataNasc);
                int ativo = rs.getInt(ATIVO); 
                int camposPreenchidos = rs.getInt(CAMPOSPREENCHIDOS);  
                int removido = rs.getInt(REMOVIDO);                
                if(tipo == 2) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ARBITRO u where u.IDUTILIZADOR = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    int idAgenda = rs.getInt(IDAGENDA);
                                        
                    AgendaDAO ag = new AgendaDAO(idAgenda);
                    Agenda agenda = new Agenda(idAgenda,ag);
                    res = new Arbitro(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),
                            agenda,converte(removido));
                    }
                }
                if(tipo == 1) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM RESPONSAVELESCOLA a where a.IDUTILIZADOR = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    String nomeEscola = rs.getString(NOMESCOLA);
                    EscolaDAO x = new EscolaDAO();
                    Escola y = x.get(nomeEscola);
                    res = new ResponsavelEscola(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),converte(removido),y);
                    }
                }
                if(tipo == 0) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ADMIN a where a.IDUTILIZADOR = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    res = new Admin(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),converte(removido));
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
    public Utilizador put(String key, Utilizador value) {
        return this.users.put(key, value);
    }

    @Override
    public Utilizador remove(Object key) {
        return this.users.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
        this.users.putAll(m);
    }

    @Override
    public void clear() {
        this.users.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.users.keySet();
    }

    @Override
    public Collection<Utilizador> values() {
        return this.users.values();
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        return this.users.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
