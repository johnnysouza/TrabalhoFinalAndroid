package edu.furb.coletalogistica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ColetorApp extends Activity {

	ListView lista_contatos;
	private String arr[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_coletor_app);

		lista_contatos = (ListView) findViewById(R.id.lista_contatos);

		arr = populaArray();
		lista_contatos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , arr));
		lista_contatos
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
						Intent i = new Intent(ColetorApp.this, RotaColetaActivity.class);
						i.putExtra("latitudeP1", -26.8986537);
						i.putExtra("longitudeP1", -49.0847701);
						i.putExtra("latitudeP2", -26.9057913);
						i.putExtra("longitudeP2", -49.0867013);
						startActivity(i);
					}
				});
	}
	
	public String[] populaArray(){
		String listPopulada[] = new String[]{"produto1", "produto2"};
		
		return listPopulada;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.coletor_app, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
