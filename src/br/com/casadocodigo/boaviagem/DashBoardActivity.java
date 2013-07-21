package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DashBoardActivity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
	}
	
	public void selecionaOpcao(View view) {
		/**
		 * com base na opção que foi clicada iremos tomar uma ação
		 */		
		TextView textView = (TextView)view;		
		String opcao = "Opcao: "+textView.getText().toString();
		Toast.makeText(this, opcao, Toast.LENGTH_LONG).show();
	}
}
