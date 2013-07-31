package br.com.casadocodigo.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
		switch(view.getId()) {
		case R.id.nova_viagem:
			startActivity(new Intent(this,ViagemActivity.class));
			break;
		}
	}
}
