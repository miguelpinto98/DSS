package Data_Layer;

import Business_Layer.Campo;
import Business_Layer.Escola;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EscolaDAO implements Map<String,Escola> {
    
    public static final String ESCOLA = "Escola e";
    
    public static final int NOME = 1;
    public static final int LOCAL = 2;
    public static final int IDCAMPO = 3;
    public static final int REMOVIDO = 4;
    
    public static final int ID_CAMPO = 1;
    public static final int NOME_CAMPO = 2;

    public EscolaDAO() {
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM ESCOLA";
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
        throw new NullPointerException("Não Definido");
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            String chave = (String) key;
            //String chave = c.toUpperCase();
            
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT NOME FROM ESCOLA e WHERE e.NOME = '"+chave+"'";
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
        throw new NullPointerException("Não Definido");
    }

    public Escola get(Object key) {
        Escola esc = null;
        
        try {
            String chave = (String) key;
            //String chave = c.toUpperCase();
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM ESCOLA e WHERE e.NOME = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String sNome = rs.getString(NOME);
                String sLocal = rs.getString(LOCAL);
                int nidCampo = rs.getInt(IDCAMPO);
                int isRem = rs.getInt(REMOVIDO);
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM CAMPO c where c.IDCAMPO = "+nidCampo;
                rs = stm.executeQuery(sql);

                if(rs.next()) {
                    String sCampo = rs.getString(NOME_CAMPO);
                    Campo campo = new Campo(nidCampo, sCampo);
  
                    esc = new Escola(sNome,sLocal,campo,isRem);
                }
            }
                
        ConexaoBD.fecharCursor(rs, stm);
        } catch (Exception e) {
        }        
        return esc;
    }

    @Override
    public Escola put(String key, Escola value) {
        Escola res = null;
        try {
            Escola e = (Escola) value;
            String c = (String) key;
            boolean existe = this.containsKey(key);
            String sql="";
            if (existe){
                sql = "UPDATE CAMPO ca SET NOME = '"+value.getCampo().getNome()+"' WHERE ca.IDCAMPO = "+value.getCampo().getID();
                Statement st = ConexaoBD.getConexao().createStatement();
                ResultSet rse = st.executeQuery(sql);
                ConexaoBD.fecharCursor(rse, st);
                
                sql = "UPDATE ESCOLA e SET LOCAL = '"+value.getLocal()+"' WHERE e.NOME = '"+value.getNome()+"'";
                Statement s = ConexaoBD.getConexao().createStatement();
                ResultSet rs = s.executeQuery(sql);
                ConexaoBD.fecharCursor(rs, s);}
            else{
                //String chave = c.toUpperCase();
                
                Campo campo = value.getCampo();
                
                if(campo != null) {
                    sql = "INSERT INTO Campo(idCampo, nome) VALUES (?, ?)";
                    PreparedStatement stm1 = ConexaoBD.getConexao().prepareStatement(sql);
                    stm1.setInt(ID_CAMPO, campo.getID());
                    stm1.setString(NOME_CAMPO, campo.getNome());
                    stm1.execute();
                    stm1.close();
                
                    sql = "INSERT INTO Escola(nome, local, idCampo, removido) VALUES (?, ?, ?, ?)";
                    PreparedStatement stm2 = ConexaoBD.getConexao().prepareStatement(sql);
                    stm2.setString(NOME, value.getNome());
                    stm2.setString(LOCAL, value.getLocal());
                    stm2.setInt(IDCAMPO, value.getCampo().getID());
                    stm2.setInt(REMOVIDO, value.getRemovida());
                    stm2.execute();
                    stm2.close();
                    
                    res = value;
                }
            }
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Escola remove(Object key) {
        Escola res = null;
        try {            
            String chave = (String) key;
            String sql = "DELETE FROM ESCOLA WHERE ESCOLA.IDESCOLA = "+chave;
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.execute();
            ConexaoBD.fecharCursor(null, stm);
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }}

    @Override
    public void putAll(Map<? extends String, ? extends Escola> m) {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public void clear() {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public Set<String> keySet() {
        Set<String> res = new HashSet<>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT NOME FROM ESCOLA";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getString(NOME));
           
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Escola> values() {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public Set<Map.Entry<String, Escola>> entrySet() {
        throw new NullPointerException("Não Definido");
    }
    
    @Override
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
