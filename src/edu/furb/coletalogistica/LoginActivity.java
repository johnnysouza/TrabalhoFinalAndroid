package edu.furb.coletalogistica;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(View arg0) {
		String usuario = txtUsuario.getEditableText().toString();
		String senha = txtSenha.getEditableText().toString();

		if (validadorSenha.validaSenha(usuario, senha)) {
			Intent intent = new Intent(this, ColetorApp.class);
			startActivity(intent);
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
