package edu.furb.coletalogistica;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity implements OnClickListener{
	
	private TextView txtUsuario;
	private TextView txtSenha;
	private Button btnEntrar;
	
	ValidadorSenha validadorSenha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		validadorSenha = new ValidadorSenha();
		
		btnEntrar = (Button) findViewById(R.id.btnEntrar);
		txtUsuario = (TextView) findViewById(R.id.txtUsuario);
		txtSenha = (TextView) findViewById(R.id.txtSenha);
		
		btnEntrar.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		String usuario = txtUsuario.getEditableText().toString();
		String senha = txtSenha.getEditableText().toString();

		if (validadorSenha.validaSenha(usuario, senha)) {
			Intent i = new Intent(this, ColetorApp.class);
			startActivity(i);
			finish();
		} else {
			AlertDialog.Builder dialogo = new AlertDialog.Builder(
					LoginActivity.this);
			dialogo.setTitle("Validação dos dados");
			dialogo.setMessage("Usuário ou senha inválidos!");
			dialogo.setNeutralButton("OK", null);
			dialogo.show();
		}
	}
}
