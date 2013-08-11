package br.com.casadocodigo.boaviagem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class GastoListActivity extends ListActivity implements OnItemClickListener {

	private List<Map<String, Object>> gastos;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		String[] de = {"data","descricao","valor","categoria"};
		int[] para = {R.id.data,R.id.descricao,R.id.valor,R.id.categoria};
		SimpleAdapter adapter = new SimpleAdapter(this,listarGastos(),R.layout.lista_gasto,de,para);
		
		adapter.setViewBinder(new GastoViewBinder());
		
		setListAdapter(adapter);
		ListView listView = this.getListView();
		listView.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		Map<String, Object> map = gastos.get(position);
		String descricao = (String)map.get("descricao");		
		String mensagem = "Gasto selecionado: "+descricao;
		Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
	}
	
	private List<Map<String, Object>> listarGastos() {
		gastos = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("data", "04/02/2012");
		item.put("descricao", "Diária Hotel");
		item.put("valor", "R$ 260,00");
		item.put("categoria", R.color.categoria_hospedagem);
		gastos.add(item);
		
		item = new HashMap<String, Object>();
		item.put("data", "04/02/2012");
		item.put("descricao", "Wi-fi");
		item.put("valor", "R$ 5,00");
		item.put("categoria", R.color.categoria_outros);
		gastos.add(item);
		
		item = new HashMap<String, Object>();
		item.put("data", "04/02/2012");
		item.put("descricao", "Taxi");
		item.put("valor", "R$ 50,00");
		item.put("categoria", R.color.categoria_transporte);
		gastos.add(item);
		
		item = new HashMap<String, Object>();
		item.put("data", "05/02/2012");
		item.put("descricao", "Almoço");
		item.put("valor", "R$ 35,00");
		item.put("categoria", R.color.categoria_alimentacao);
		gastos.add(item);
		
		item = new HashMap<String, Object>();
		item.put("data", "06/02/2012");
		item.put("descricao", "Presente");
		item.put("valor", "R$ 350,00");
		item.put("categoria", R.color.categoria_outros);
		gastos.add(item);
		
		
		
		return gastos;
	}
	
	private String dataAnterior = "";
	
	private class GastoViewBinder implements android.widget.SimpleAdapter.ViewBinder {

		@Override
		public boolean setViewValue(View view, Object data,String textRepresentation) {
			
			if(view.getId() == R.id.data) {
				if(!dataAnterior.equals(data)) {
					TextView textView = (TextView)view;
					textView.setText(textRepresentation);
					dataAnterior = textRepresentation;
					view.setVisibility(View.VISIBLE);
				} else {
					view.setVisibility(View.GONE);
				}
				return true;
			}
			
			
			if(view.getId() == R.id.categoria) {
				Integer id = (Integer) data;
				view.setBackgroundColor(getResources().getColor(id));
				return true;
			}
			return false;
		}				
	}

	
	
}
