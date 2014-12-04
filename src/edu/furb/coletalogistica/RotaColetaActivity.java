package edu.furb.coletalogistica;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class RotaColetaActivity extends Activity {

	private WebView mapa;
	private double latitudeP1;
	private double longitudeP1;
	private double latitudeP2;
	private double longitudeP2;
	LocationManager locationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rota_coleta);
		
		latitudeP1 = getIntent().getExtras().getDouble("latitudeP1");
		longitudeP1 = getIntent().getExtras().getDouble("longitudeP1");
		latitudeP2 = getIntent().getExtras().getDouble("latitudeP2");
		longitudeP2 = getIntent().getExtras().getDouble("longitudeP2");

		mapa = (WebView) findViewById(R.id.webView1);

		String url = "http://maps.googleapis.com/maps/api/staticmap?size=400x400&path=color:0x0000ff|weight:3|%s,%s|%s,%s";
		mapa.loadUrl(String.format(url, latitudeP1, longitudeP1, latitudeP2, longitudeP2));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.rota_coleta, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.finalizar) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
