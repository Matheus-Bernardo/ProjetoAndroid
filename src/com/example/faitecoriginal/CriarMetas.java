package com.example.faitecoriginal;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.faitecoriginal.Alert.AlertType;

public class CriarMetas extends Activity implements OnClickListener {

	// http://aeloy.blogspot.com/2012/04/adicionando-conteudo-em-um-listview.html
	// https://tecmaicon.wordpress.com/2013/04/15/alertdialogs-dinamicos/
	// https://tecmaicon.wordpress.com/2013/04/18/alertdialog-com-entrada-de-dados-edittext/
	//https://www.luiztools.com.br/post/criando-listviews-personalizadas-em-android/

	private List<String> series = new ArrayList<String>();
	private ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// define o layout como o criado em main.xml
		setContentView(R.layout.activity_criar_metas);

		// recuperando a listview declarada em main.xml para poder definir o adapter
		ListView listaSeries = (ListView) findViewById(R.id.listaSeries);

		// definindo a implementação ArrayAdapter como ListAdapter da ListView
		// series é a lista de séries de treino definida como um ArrayList através de
		// uma variável de instância
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, series);
		listaSeries.setAdapter(adapter);

		// adicionando comportamento para o evento click do botão adicionar
		Button btAdicionar = (Button) findViewById(R.id.btAdicionar);

		btAdicionar.setOnClickListener(this);

		listaSeries.setOnItemClickListener(new ListView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, final int position, long id) {

				Alert.showConfirmDialog("Meta Cumprida?", CriarMetas.this, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface t, int b) {
						series.remove(position);
						adapter.notifyDataSetChanged();
					}
				}, null);

			}
		});
	}

	@Override
	public void onClick(View arg0) {
		final EditText edt = new EditText(CriarMetas.this);
		Alert.showInputDialog("Digite a meta", CriarMetas.this, edt, AlertType.INFO,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						String meta = edt.getText().toString();
						if (meta.length() > 0) {

							series.add(meta);
							adapter.notifyDataSetChanged();
						} else {
							Toast.makeText(CriarMetas.this, "Digite o nome da série", Toast.LENGTH_SHORT).show();
						}

					}
				});
	}
}