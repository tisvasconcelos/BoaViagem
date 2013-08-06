package br.com.casadocodigo.boaviagem;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GastoListActivity extends ListActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listarGastos()));
		ListView listView = this.getListView();
		listView.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		TextView textView = (TextView)view;
		String mensagem = "Gasto selecionado: "+textView.getText();
		Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
	}
	
	private List<String> listarGastos() {
		return Arrays.asList("Sanduíche - R$ 19,00","Táxi Aeroporto - Hotel - R$ 34,00", "Revista - R$ 12,00");
	}

	
	
}
