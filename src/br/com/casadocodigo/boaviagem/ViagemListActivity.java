package br.com.casadocodigo.boaviagem;

import java.util.Arrays;
import java.util.List;



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ViagemListActivity extends ListActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);		
		this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listarViagens()));
		ListView listView = this.getListView();
		listView.setOnItemClickListener(this);
		
	}
	
	private List<String> listarViagens() {
		return Arrays.asList("São Paulo","Bonito","Maceió");
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
		// TODO Auto-generated method stub		
		TextView textView = (TextView)view;
		String mensagem = "Viagem Selecionada: "+textView.getText();
		Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_LONG).show();
		startActivity(new Intent(this,GastoListActivity.class));
		
	}

	
	
}
