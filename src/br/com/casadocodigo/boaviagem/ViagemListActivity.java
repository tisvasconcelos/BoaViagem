package br.com.casadocodigo.boaviagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ViagemListActivity extends ListActivity implements OnItemClickListener {

	private List<Map<String, Object>> viagens;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		
		String[] de = {"imagem","destino","data","total"};
		int[] para = {R.id.tipoViagem,R.id.destino,R.id.data,R.id.valor};
		SimpleAdapter adapter = new SimpleAdapter(this,listarViagens(),R.layout.lista_viagem, de, para);
		setListAdapter(adapter);
		
		getListView().setOnItemClickListener(this);		
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
		// TODO Auto-generated method stub
		Map<String, Object> map = viagens.get(position);
		String destino = (String)map.get("destino");
		String mensagem = "Viagem Selecionada: "+destino;
		Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
		startActivity(new Intent(this,GastoListActivity.class));
		
	}

	
	
}
