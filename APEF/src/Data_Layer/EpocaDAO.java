package Data_Layer;

import Business_Layer.Epoca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class EpocaDAO implements Map<Integer,Epoca> {
    private static final int ANO = 1;
    
    public EpocaDAO() { }
    
    @Override
    public int size() {
        int i=0;
         try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM EPOCA");
                 while (rs.next()) i++;
                 ConexaoBD.fecharCursor(rs, stm);}
         catch(Exception e) {throw new NullPointerException(e.getMessage());}
         return i;} 
    
    @Override
    public boolean isEmpty() {throw new NullPointerException("Não Definido");}

    @Override
    public boolean containsKey(Object key) {throw new NullPointerException("Não Definido");}
    
    @Override
    public boolean containsValue(Object value) {throw new NullPointerException("Não Definido");}

    @Override
    public void putAll(Map<? extends Integer, ? extends Epoca> m) {throw new NullPointerException("Não Definido");}
    
    @Override
    public Epoca remove(Object key) {
        Epoca res = null;
        try {            
            Integer chave = (Integer) key;
            String sql = "DELETE FROM EPOCA WHERE EPOCA.ANO = ?";
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(ANO, chave);
            stm.execute();
            ConexaoBD.fecharCursor(null, stm);
            return res;}
        catch (Exception e){throw new NullPointerException(e.getMessage());}
    }

    @Override
    public void clear() {throw new NullPointerException("Não Definido");}
    
    @Override
    public Set<Map.Entry<Integer, Epoca>> entrySet() {throw new NullPointerException("Não Definido");}

    @Override
    public Epoca get(Object key) {
        Epoca ep = null;
        
        try {
            String chave = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM EPOCA WHERE EPOCA.ANO = "+chave+"";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) { int ano = rs.getInt(ANO); ep= new Epoca(ano);}
            
            rs.close();
            stm.close();}
        catch (Exception e) {}        
     return ep;}

    @Override
    public Epoca put(Integer key, Epoca value){        
        Epoca res = null;
        try {
            String sql = "INSERT INTO Epoca(key) VALUES (?)";            
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(ANO, key);
            stm.execute();
            ConexaoBD.fecharCursor(null, stm);
            }
        catch (Exception e){throw new NullPointerException(e.getMessage());}
        return res;}
    
   @Override
    public Set<Integer> keySet() {throw new NullPointerException("Não Definido");}

    @Override
    public Collection<Epoca> values() {throw new NullPointerException("Não Definido");}

    @Override
    public int hashCode() {throw new NullPointerException("Não Definido");}
}
