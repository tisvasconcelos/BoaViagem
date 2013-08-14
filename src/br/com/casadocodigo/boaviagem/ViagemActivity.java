package br.com.casadocodigo.boaviagem;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


public class ViagemActivity extends Activity{

	private int ano;
	private int mes;
	private int dia;
	private Button dataChegada,dataSaida;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nova_viagem);

		Calendar calendar = Calendar.getInstance();

		ano = calendar.get(Calendar.YEAR); 
		mes = calendar.get(Calendar.MONTH);
		dia = calendar.get(Calendar.DAY_OF_MONTH);

		dataChegada = (Button)findViewById(R.id.dataChegada);
		dataChegada.setText(dia+"/"+(mes+1)+"/"+ano);

		dataSaida = (Button)findViewById(R.id.dataSaida);
		dataSaida.setText(dia+"/"+(mes+1)+"/"+ano);
	}

	private OnDateSetListener listenerDataChegada = new OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
			ano = year;
			mes = monthOfYear;
			dia = dayOfMonth;		
			dataChegada.setText(dia+"/"+(mes+1)+"/"+ano);			
		}

	};
	
	private OnDateSetListener listenerDataSaida = new OnDateSetListener() {

		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
			ano = year;
			mes = monthOfYear;
			dia = dayOfMonth;
			dataSaida.setText(dia+"/"+(mes+1)+"/"+ano);
		}

	};

	public void selecionarData(View v) {
		showDialog(v.getId());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.viagem_menu, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {		
		switch (item.getItemId()) {
		case R.id.novo_gasto:
			startActivity(new Intent(this, GastoActivity.class));
			return true;			
		case R.id.remover:
			return true;			
		default:
			return super.onMenuItemSelected(featureId, item);
		}
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		if(R.id.dataChegada == id) {
			return new DatePickerDialog(this,listenerDataChegada,ano,mes,dia);			
		} else if(R.id.dataSaida == id) {
			return new DatePickerDialog(this,listenerDataSaida,ano,mes,dia);
		}
		return null;
	}

}
