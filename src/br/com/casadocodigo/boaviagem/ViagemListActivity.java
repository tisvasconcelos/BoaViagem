package br.com.casadocodigo.boaviagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class ViagemListActivity extends ListActivity implements OnItemClickListener, OnClickListener {

	private List<Map<String, Object>> viagens;
	private AlertDialog alertDialog;
	private AlertDialog alertDialogConfirmacao;
	private int viagemSelecionada;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);		

		String[] de = {"imagem","destino","data","total"};
		int[] para = {R.id.tipoViagem,R.id.destino,R.id.data,R.id.valor};
		SimpleAdapter adapter = new SimpleAdapter(this,listarViagens(),R.layout.lista_viagem, de, para);
		setListAdapter(adapter);

		getListView().setOnItemClickListener(this);	
		
		this.alertDialog = criarAlertDialog();
		this.alertDialogConfirmacao = criarDialogConfirmacao();
	}

	private List<Map<String, Object>> listarViagens() {

		viagens = new ArrayList<Map<String,Object>>();

		Map<String, Object> item = new HashMap<String, Object>();
		item.put("imagem", R.drawable.negocios);
		item.put("destino", "São Paulo");
		item.put("data", "27/08/2013 a 31/08/2013");
		item.put("total", "Gasto total: R$ 320,56");
		viagens.add(item);

		item = new HashMap<String, Object>();
		item.put("imagem", R.drawable.lazer);
		item.put("destino", "Maceió");
		item.put("data", "10/12/2013 a 05/01/2014");
		item.put("total", "Gasto total: R$ 5324,21");
		viagens.add(item);

		return viagens;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		
		this.viagemSelecionada = position;
		alertDialog.show();

	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case 0:
			startActivity(new Intent(this,ViagemActivity.class));
			break;		
		case 1:
			startActivity(new Intent(this,GastoActivity.class));
			break;		
		case 2:
			startActivity(new Intent(this,GastoListActivity.class));
			break;
		case 3:
			this.alertDialogConfirmacao.show();
			break;
		case DialogInterface.BUTTON_POSITIVE:
			viagens.remove(this.viagemSelecionada);
			getListView().invalidateViews();
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			this.alertDialogConfirmacao.dismiss();
		}

	}


	private AlertDialog criarAlertDialog() {

		final CharSequence[] items = {
				getString(R.string.editar),
				getString(R.string.novo_gasto),
				getString(R.string.gastos_realizados),
				getString(R.string.remover)};

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.opcoes);
		builder.setItems(items, this);

		return builder.create();
	}
	
	private AlertDialog criarDialogConfirmacao() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.confirmacao_exclusao_viagem);
		builder.setPositiveButton(getString(R.string.sim), this);		
		builder.setNegativeButton(getString(R.string.nao), this);
		
		return builder.create();
	}

}
