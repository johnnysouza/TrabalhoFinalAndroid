package edu.furb.coletalogistica;

public class ValidadorSenha {
	
	public boolean validaSenha(String usuario, String senha){
		if (usuario.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("123456")){
			return true;
		}
		return false;
	}

}
