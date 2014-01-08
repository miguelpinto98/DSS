package Data_Layer;

import Business_Layer.Utilizador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
        
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
        String sql = "SELECT NICKNAME FROM " 
                    + " WHERE u.nickname = '" + chave;
            ResultSet rs = stm.executeQuery(sql);
            boolean res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }    }

    @Override
    public boolean containsValue(Object value) {
        return this.users.containsValue(value);
    }

    @Override
    public Utilizador get(Object key) {
        return this.users.get(key);
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
