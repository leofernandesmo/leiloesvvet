package br.org.leofernandesmo.leiloesvvet.model;

public class Avaliador {
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;

	public void avalia(Leilao leilao) {
		// lançando a exceção
//		if (leilao.getLances().size() == 0)
//			throw new RuntimeException("Não é possível avaliar um leilão sem lances");
		for (Lance lance : leilao.getLances()) {
			if (lance.getValor() > maiorDeTodos) {
				maiorDeTodos = lance.getValor();
			} else if (lance.getValor() < menorDeTodos) {
				menorDeTodos = lance.getValor();
			}
		}
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}

	public double getMenorLance() {
		return menorDeTodos;
	}

}
