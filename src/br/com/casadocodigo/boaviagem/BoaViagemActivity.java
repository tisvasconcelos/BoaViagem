package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BoaViagemActivity extends Activity {

	private EditText usuario;
	private EditText senha;
	
	public void entrarOnClick(View v) {
		
		String usuario_informado = usuario.getText().toString();
		String senha_informada = senha.getText().toString();
		
		if("leitor".equals(usuario_informado) && "123".equals(senha_informada)) {
			//vai para outra activity
			startActivity(new Intent(this,DashBoardActivity.class));
		} else {
			//mostra mensagem de erro
			String mensagemErro = getString(R.string.erro_autenticacao);
			Toast toast = Toast.makeText(this, mensagemErro, Toast.LENGTH_SHORT);
			toast.show();
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		usuario = (EditText)findViewById(R.id.usuario);
		senha = (EditText)findViewById(R.id.senha);		
	}
	
}
