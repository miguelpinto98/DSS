package Data_Layer;

import Business_Layer.Equipa;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */


public class EquipaDAO implements Map<String,Equipa> {
    private HashMap<String,Equipa> equipas;
    
    public static final String ESCOLA_E = "Escola e";
    public static final int IDEQUIPA = 1;
    public static final int NOME = 2;
    public static final int EMBLEMA = 3;
    public static final int NOMEESCOLA = 4;

    private String nomeEscola;

    
    public EquipaDAO(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    @Override
    public int size() {
        return this.equipas.size();
    }

    @Override
    public boolean isEmpty() {
        return this.equipas.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.equipas.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.equipas.containsValue(value);
    }

    @Override
    public Equipa get(Object key) {
        return this.equipas.get(key);
    }

    @Override
    public Equipa put(String key, Equipa value) {

        try {
            Equipa res = null;
            String sql = "INSERT INTO " + ESCOLA_E + " VALUES (?, ?, null, ?)";
            PreparedStatement stm = ConexaoBD.getConexao()
                    .prepareStatement(sql);
            File f = new File(value.getEmblema().getPath());
            stm.setInt(IDEQUIPA, value.getID());
            stm.setString(NOME, key);
            /**if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                stm.setBlob(EMBLEMA, fis);
                stm.setString(NOMEIMAGEM, value.getEmblema().getNome());
            } else {
                stm.setBlob(EMBLEMA, (Blob) null);
                stm.setString(NOME_IMAGEM, "");
            }*/
            stm.setString(NOMEESCOLA, nomeEscola);
            stm.execute();
                        ConexaoBD.fecharCursor(null, stm);
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }
    
    @Override
    public Equipa remove(Object key) {
        return this.equipas.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Equipa> m) {
        this.equipas.putAll(m);
    }

    @Override
    public void clear() {
        this.equipas.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.equipas.keySet();
    }

    @Override
    public Collection<Equipa> values() {
        return this.equipas.values();
    }

    @Override
    public Set<Map.Entry<String, Equipa>> entrySet() {
        return this.equipas.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}
