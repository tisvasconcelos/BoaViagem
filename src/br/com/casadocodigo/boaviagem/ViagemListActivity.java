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
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;

public class ViagemListActivity extends ListActivity implements OnItemClickListener, OnClickListener, ViewBinder {

	private List<Map<String, Object>> viagens;
	private AlertDialog alertDialog;
	private int viagemSelecionada;
	private AlertDialog dialogConfirmacao;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		

		String[] de = {"imagem","destino","data","total","barraProgresso"};
		int[] para = {R.id.tipoViagem,R.id.destino,R.id.data,R.id.valor,R.id.barraProgresso};
		SimpleAdapter adapter = new SimpleAdapter(this,listarViagens(),R.layout.lista_viagem, de, para);
		setListAdapter(adapter);

		getListView().setOnItemClickListener(this);
		adapter.setViewBinder(this);

		this.alertDialog = criaAlertDialog();
		this.dialogConfirmacao = criaDialogConfirmacao();

	}

	private List<Map<String, Object>> listarViagens() {

		viagens = new ArrayList<Map<String,Object>>();

		Map<String, Object> item = new HashMap<String, Object>();
		item.put("imagem", R.drawable.negocios);
		item.put("destino", "São Paulo");
		item.put("data", "27/08/2013 a 31/08/2013");
		item.put("total", "Gasto total: R$ 320,56");
		item.put("barraProgresso", new Double[]{500.0,450.0,320.56});
		viagens.add(item);

		item = new HashMap<String, Object>();
		item.put("imagem", R.drawable.lazer);
		item.put("destino", "Maceió");
		item.put("data", "10/12/2013 a 05/01/2014");
		item.put("total", "Gasto total: R$ 5324,21");
		item.put("barraProgresso", new Double[]{6000.0,5000.0,4324.21});
		viagens.add(item);

		return viagens;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		this.viagemSelecionada = position;
		alertDialog.show();
	}

	@Override
	public void onClick(DialogInterface dialog, int item) {
		switch (item) {
		case 0:
			startActivity(new Intent(this, ViagemActivity.class));
			break;
		case 1:
			startActivity(new Intent(this, GastoActivity.class));
			break;
		case 2:
			startActivity(new Intent(this, GastoListActivity.class));
			break;
		case 3:
			dialogConfirmacao.show();
			break;
		case DialogInterface.BUTTON_POSITIVE:
			viagens.remove(viagemSelecionada);
			getListView().invalidateViews();
			break;
		case DialogInterface.BUTTON_NEGATIVE:
			dialogConfirmacao.dismiss();
			break;
		}
	}

	private AlertDialog criaAlertDialog() {
		final CharSequence[] items = {
				getString(R.string.editar),
				getString(R.string.novo_gasto),
				getString(R.string.gastos_realizados),
				getString(R.string.remover) };
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.opcoes);
		builder.setItems(items, this);
		return builder.create();
	}

	private AlertDialog criaDialogConfirmacao() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.confirmacao_exclusao_viagem);
		builder.setPositiveButton(getString(R.string.sim), this);
		builder.setNegativeButton(getString(R.string.nao), this);
		return builder.create();
	}

	@Override
	public boolean setViewValue(View view, Object data, String textRepresentation) {
		if(view.getId() == R.id.barraProgresso) {
			Double valores[] = (Double[]) data;
			ProgressBar progressBar = (ProgressBar)view;
			progressBar.setMax(valores[0].intValue());
			progressBar.setSecondaryProgress(valores[1].intValue());
			progressBar.setProgress(valores[2].intValue());
			return true;
		}
		return false;
	}

	

	
	
	
}


