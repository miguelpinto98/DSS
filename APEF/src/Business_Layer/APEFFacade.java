package Business_Layer;

import java.util.ArrayList;

public interface APEFFacade {
	
	/**
	 * Arbitro adiciona um resultado de um jogo, depois de realizado
	 * @param Numero de golos do plantel da casa
	 * @param Numero de golos do plantel visitante
	 * @param Golos que cada jogador (ID) marcou
	 */
	public void resultadoJogo(int casa, int fora, ArrayList<Integer> goleadores);
    
}
